import src.midi_utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.*;
import static java.lang.System.in;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class socApp 
{
    static File midiFile;
	
    private static void createGUI() throws IOException {
            final JFrame f = new JFrame("THE SOUND OF CODE");
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            JButton playButton = new JButton("Play");
            playButton.setFont(new Font("Georgia",Font.PLAIN,13));
            playButton.addActionListener(new  ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        playSound();
                    } catch(InvalidMidiDataException exx) {
                        JOptionPane.showMessageDialog(f,
                                                "INVALID MIDI DATA");
                    } catch (IOException ex){
                        JOptionPane.showMessageDialog(f,
                                                "FILE ERROR WITH MUSIC"); 
                    }
                    catch (MidiUnavailableException ex){
                        JOptionPane.showMessageDialog(f,
                                                "MIDI FILE UNAVALIABLE"); 
                    }
                }
            });
            

                      
            JButton readButton = new JButton("Select your file to upload");
            readButton.setFont(new Font("Georgia",Font.PLAIN,13));

            readButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                            
                    JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
                    if (chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) 
                    {
                        File txtFile = chooser.getSelectedFile();
                        try {
                                FileReader file = new FileReader(txtFile);
                                midiFile = midi_utilities.buildMidi(file); //txtFile
                                
                        } catch (Exception exc) {
                                JOptionPane.showMessageDialog(f,
                                                "INVALID FILE TYPE.");
                        }
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            //buttonPanel.add(text);
            buttonPanel.add(readButton);
            buttonPanel.add(playButton);
            


            Container c = f.getContentPane();
            buttonPanel.setBackground(new Color(200,200,240));
            buttonPanel.setOpaque(true);
            
            c.add(buttonPanel, BorderLayout.SOUTH);
            
            JPanel titlePanel = new JPanel(new BorderLayout());
            JLabel text = new JLabel("Sound of Code: Translate your Code into Sound!", SwingConstants.CENTER);
            text.setFont(new Font("Georgia",1,15)); 
            JLabel subtitle = new JLabel("Choose a file for upload and click \"Play\" to hear an audio representation of your code.", SwingConstants.CENTER);
            subtitle.setFont(new Font("Geogia", Font.ITALIC, 13));
            titlePanel.add(text, BorderLayout.NORTH);
            titlePanel.add(subtitle, BorderLayout.SOUTH);
            titlePanel.setBackground(new Color(200,240,200));
            titlePanel.setOpaque(true);
            titlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
            
            c.add(titlePanel, BorderLayout.NORTH);
            
            
            
            //ADDING A PICTURE
            File image = makeImage();
            BufferedImage mainImg = ImageIO.read(image);
            JLabel picLabel = new JLabel(new ImageIcon(mainImg));
            c.add(picLabel, BorderLayout.CENTER);
            
            f.pack();
            f.setVisible(true);
    }
    
    public static File makeImage() throws IOException
    {
        int width = 600;
        int height = 80;
        //create buffered image object img
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        FileReader pitchesBeCray = null;
        try {
            pitchesBeCray = new FileReader("/Users/bgspiral/Documents/Programming/sound_of_code/tempPitch.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        ArrayList<Integer> intArr;
        try(BufferedReader br = new BufferedReader(pitchesBeCray)) {
            intArr = new ArrayList(1000);
            //Integer line = Integer.parseInt(br.readLine());
            String textLine= br.readLine();
            
            while (textLine != null) {
                    System.out.println(textLine);
                    int line = Integer.parseInt(textLine);
                    intArr.add(line);
                    textLine = br.readLine();
            }
            
        }
        
        //file object
        File f = null;
        //create random image pixel by pixel
        
        int a = 0, r = 0, g = 0, b = 0;
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                    a = 100;//(int)(Math.random()*256); //alpha  
                    r = (int)(Math.random()*256); //red 
                    g = 0;//(int)(Math.random()*256); //green 
                    b = (int)(Math.random()*256); //blue 
                
                
                int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

                img.setRGB(x, y, p);
            }
        }
            
        
        
        //write image
        try{
            f = new File("pixels.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
         
         return f;
    }

    public static void playSound() throws InvalidMidiDataException, IOException, MidiUnavailableException
    {
        
        Sequence sequence = MidiSystem.getSequence(midiFile);

        // Create a sequencer for the sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);

        // Start playing
        sequencer.start();
    }
  
    public static void main(String[] args) throws IOException {
            createGUI();
    }
}

