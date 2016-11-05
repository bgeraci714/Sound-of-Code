package src;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.meta.Tempo;
import com.leff.midi.event.meta.TimeSignature;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.sound.midi.*;


public class Sound_of_code 
{
    public static File buildMidi(FileReader in) throws IOException 
    {   
        ArrayList<String> stringArr;
        try(BufferedReader br = new BufferedReader(in)) {
            stringArr = new ArrayList(1000);
            String line = br.readLine();

            while (line != null) {
                stringArr.add(line);
                stringArr.add(System.lineSeparator());
                line = br.readLine();
        }
            for(int i = 0; i < stringArr.size(); i++)
            {
                System.out.println(stringArr.get(i).length());
            }
        
    }
            
        
        // 1. Create some MidiTracks
        MidiTrack tempoTrack = new MidiTrack();
        MidiTrack noteTrack = new MidiTrack();

        // 2. Add events to the tracks
        // Track 0 is the tempo map
        TimeSignature ts = new TimeSignature();
        ts.setTimeSignature(4, 4, TimeSignature.DEFAULT_METER, TimeSignature.DEFAULT_DIVISION);

        Tempo tempo = new Tempo();
        tempo.setBpm(228);

        tempoTrack.insertEvent(ts);
        tempoTrack.insertEvent(tempo);

        // Track 1 will have some notes in it
        final int NOTE_COUNT = stringArr.size();
        final int OFFSET = 20;
        final int MAXNOTE = 126;
        
        int curNote = 0;
               
        int[] arrayForFile = new int[NOTE_COUNT];
        
        for(int i = 0; i < NOTE_COUNT; i++)
        {
            int channel = 0;
            int velocity = 135;
            long tick = i * 480;
            long duration = 120;
            int pitch = stringArr.get(i).length() + OFFSET;
            if (pitch > MAXNOTE)
                pitch = MAXNOTE;
            
            arrayForFile[i] = pitch;

            noteTrack.insertNote(channel, pitch, velocity, tick, duration);
        }
        
        GenerateAndSaveFile(arrayForFile);

        // 3. Create a MidiFile with the tracks we created
        ArrayList<MidiTrack> tracks = new ArrayList<>();
        tracks.add(tempoTrack);
        tracks.add(noteTrack);

        MidiFile midi = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);

        // 4. Write the MIDI data to a file
        File output = new File("exampleout4.mid");
        //try
        //{
            midi.writeToFile(output);
        //}
        //catch(IOException e)
        //{
          //  System.err.println(e);
          //  throw e;
       // }
        return output;
    
    }
    
    private static void GenerateAndSaveFile(int[] array) {
        try {
            PrintWriter writer = new PrintWriter("/tempPitch.txt", "UTF-8");
            for(int i = 0; i < array.length; i++) {
                writer.println(array[i]);               
            }
            writer.close();
        } catch(Exception ex) {
            System.out.println(ex);
            //cry
        }
    }
 

}
