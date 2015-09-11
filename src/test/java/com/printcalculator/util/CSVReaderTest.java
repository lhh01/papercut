/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LiH
 */
public class CSVReaderTest {

    private static final Logger logger = Logger.getLogger(CSVReaderTest.class.getName());
    private static final String FILE_SEPARATOR = File.separator;
    
    private static final String CSV_FILE_NAME = "printjobs.csv";

    private CSVReader csvReader;
    public CSVReaderTest() {
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

    @Test
    public void testReadAll() throws Exception {

        logger.log(Level.FINE, "testReadAll...");
        List<String[]> entries = csvReader.readAll();

        assertEquals(4, entries.size());
    }

}
