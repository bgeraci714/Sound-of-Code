/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leff.midi;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bgspiral
 */
public class MidiFileTest {
    
    public MidiFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setType method, of class MidiFile.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        MidiFile instance = new MidiFile();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class MidiFile.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        MidiFile instance = new MidiFile();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrackCount method, of class MidiFile.
     */
    @Test
    public void testGetTrackCount() {
        System.out.println("getTrackCount");
        MidiFile instance = new MidiFile();
        int expResult = 0;
        int result = instance.getTrackCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResolution method, of class MidiFile.
     */
    @Test
    public void testSetResolution() {
        System.out.println("setResolution");
        int res = 0;
        MidiFile instance = new MidiFile();
        instance.setResolution(res);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResolution method, of class MidiFile.
     */
    @Test
    public void testGetResolution() {
        System.out.println("getResolution");
        MidiFile instance = new MidiFile();
        int expResult = 0;
        int result = instance.getResolution();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLengthInTicks method, of class MidiFile.
     */
    @Test
    public void testGetLengthInTicks() {
        System.out.println("getLengthInTicks");
        MidiFile instance = new MidiFile();
        long expResult = 0L;
        long result = instance.getLengthInTicks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTracks method, of class MidiFile.
     */
    @Test
    public void testGetTracks() {
        System.out.println("getTracks");
        MidiFile instance = new MidiFile();
        ArrayList<MidiTrack> expResult = null;
        ArrayList<MidiTrack> result = instance.getTracks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTrack method, of class MidiFile.
     */
    @Test
    public void testAddTrack_MidiTrack() {
        System.out.println("addTrack");
        MidiTrack T = null;
        MidiFile instance = new MidiFile();
        instance.addTrack(T);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTrack method, of class MidiFile.
     */
    @Test
    public void testAddTrack_MidiTrack_int() {
        System.out.println("addTrack");
        MidiTrack T = null;
        int pos = 0;
        MidiFile instance = new MidiFile();
        instance.addTrack(T, pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTrack method, of class MidiFile.
     */
    @Test
    public void testRemoveTrack() {
        System.out.println("removeTrack");
        int pos = 0;
        MidiFile instance = new MidiFile();
        instance.removeTrack(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToFile method, of class MidiFile.
     */
    @Test
    public void testWriteToFile() throws Exception {
        System.out.println("writeToFile");
        File outFile = null;
        MidiFile instance = new MidiFile();
        instance.writeToFile(outFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
