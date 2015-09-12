/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import com.printcalculator.bean.A4DoubleSidedPrintJob;
import com.printcalculator.bean.A4SingleSidedPrintJob;
import com.printcalculator.bean.PrintJob;
import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
import com.printcalculator.exception.UnexpectedException;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author LiH
 */
public class A4PrintJobProcessorTest extends PrintJobProcessorTest {

    private static final String FILE_SEPARATOR = File.separator;

    private static final String CSV_FILE_NAME = "printjobs.csv";

    private File csvFile;

    private A4DoubleSidedPrintJob a4DoubleSidedPrintJob;
    private A4SingleSidedPrintJob a4SingleSidedPrintJob;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public A4PrintJobProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {
        super.setUp();
        String sampleFolderPath = Paths.get("sample_data").toAbsolutePath().toString();
        csvFile = new File(sampleFolderPath + FILE_SEPARATOR + CSV_FILE_NAME);

        a4DoubleSidedPrintJob = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);
        a4SingleSidedPrintJob = new A4SingleSidedPrintJob(100, 0, PrintJobName.A4SingleSide);
    }

    @After
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Override
    protected void setInstance() {
        instance = new A4PrintJobProcessor(csvFile);
    }

    @Test
    public void testParseCsvToPrintJobList() {

        List<String[]> entries = new ArrayList<>();
        String[] row1 = {"100", "30", "true"};
        String[] row2 = {"100", "0", "false"};
        entries.add(row1);
        entries.add(row2);

        A4PrintJobProcessor jobProcessor = new A4PrintJobProcessor(csvFile);

        List<PrintJob> result = jobProcessor.parseCsvToPrintJobList(entries);
        assertTrue(result.size() == 2);
        PrintJob firstJob = result.get(0);
        PrintJob secondJob = result.get(1);

        PrintJobType firstType = firstJob.getJobType();
        PrintJobName firstName = firstJob.getJobName();
        int firstTotalPageNumber = firstJob.getNumberOfTotalPages();
        int firstColourPageNumber = firstJob.getNumberOfColourPages();

        assertTrue(a4DoubleSidedPrintJob.getJobType() == firstType);
        assertTrue(PrintJobName.A4DoubleSide == firstName);
        assertEquals(100, firstTotalPageNumber);
        assertEquals(30, firstColourPageNumber);

        PrintJobType secondType = secondJob.getJobType();
        PrintJobName secondName = secondJob.getJobName();
        int secondTotalPageNumber = secondJob.getNumberOfTotalPages();
        int secondColourPageNumber = secondJob.getNumberOfColourPages();

        assertTrue(a4SingleSidedPrintJob.getJobType() == secondType);
        assertTrue(PrintJobName.A4SingleSide == secondName);
        assertEquals(100, secondTotalPageNumber);
        assertEquals(0, secondColourPageNumber);

    }

    @Test
    public void testParseCsvToPrintJobListWithInvalidValueException() {
        thrown.expect(UnexpectedException.class);
        thrown.expectMessage("Invalid value at line:1");
        List<String[]> entries = new ArrayList<>();
        String[] row1 = {"100", "-1", "true"};

        entries.add(row1);

        A4PrintJobProcessor jobProcessor = new A4PrintJobProcessor(csvFile);

        List<PrintJob> result = jobProcessor.parseCsvToPrintJobList(entries);

    }

    @Test
    public void testParseCsvToPrintJobListWithParsingErrorException() {
        thrown.expect(UnexpectedException.class);
        thrown.expectMessage("Parsing csv error at line:1");
        List<String[]> entries = new ArrayList<>();
        String[] row1 = {"100", "10k", "true"};

        entries.add(row1);

        A4PrintJobProcessor jobProcessor = new A4PrintJobProcessor(csvFile);

        List<PrintJob> result = jobProcessor.parseCsvToPrintJobList(entries);

    }

}
