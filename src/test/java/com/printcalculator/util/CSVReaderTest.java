/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
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

    private FileInputStream fileInputStream;
    private InputStreamReader inputStreamReader;
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
    public void setUp() throws FileNotFoundException, UnsupportedEncodingException {

        String sampleFolderPath = Paths.get("sample_data").toAbsolutePath().toString();

        File inputFile = new File(sampleFolderPath + FILE_SEPARATOR + CSV_FILE_NAME);

        fileInputStream = new FileInputStream(inputFile);
        inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

        csvReader = new CSVReader(inputStreamReader);
    }

    @After
    public void tearDown() {

        if (csvReader != null) {
            try {
                csvReader.close();
            } catch (IOException e) {
                logger.log(Level.FINE, "cannot close csvReader");
            }
        }

        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                logger.log(Level.FINE, "cannot close inputStreamReader");
            }
        }

        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                logger.log(Level.FINE, "cannot close fileInputStream");
            }
        }
    }

    @Test
    public void testReadAll() throws Exception {

        logger.log(Level.FINE, "testReadAll...");
        List<String[]> entries = csvReader.readAll();

        assertEquals(4, entries.size());
    }

}
