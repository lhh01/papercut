/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import com.printcalculator.bean.PrintJob;
import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
import com.printcalculator.exception.UnexpectedException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PrintJobFactoryTest {

    private static final Logger logger = Logger.getLogger(PrintJobFactoryTest.class.getName());

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public PrintJobFactoryTest() {
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
    public void testGetA4SingleSidedPrintJob() {
        logger.log(Level.FINE, "testGetA4SingleSidedPrintJob...");
        PrintJobType jobType = PrintJobType.A4SingleSide;
        PrintJobName jobName = PrintJobName.A4SingleSide;

        PrintJob result = PrintJobFactory.getA4PrintJob(jobType, 25, 10);
        PrintJobType jobTypeofGeneratedJob = result.getJobType();
        PrintJobName jobNameofGeneratedJob = result.getJobName();
        int totalPageNumberOfGeneratedJob = result.getNumberOfTotalPages();
        int colourPageNumberOfGeneratedJob = result.getNumberOfColourPages();
        assertEquals(jobType, jobTypeofGeneratedJob);
        assertEquals(jobName, jobNameofGeneratedJob);
        assertEquals(25, totalPageNumberOfGeneratedJob);
        assertEquals(10, colourPageNumberOfGeneratedJob);

    }

    @Test
    public void testGetA4DoubleSidedPrintJob() {
        logger.log(Level.FINE, "testGetA4DoubleSidedPrintJob...");
        PrintJobType jobType = PrintJobType.A4DoubleSide;
        PrintJobName jobName = PrintJobName.A4DoubleSide;

        PrintJob result = PrintJobFactory.getA4PrintJob(jobType, 55, 13);
        PrintJobType jobTypeofGeneratedJob = result.getJobType();
        PrintJobName jobNameofGeneratedJob = result.getJobName();
        int totalPageNumberOfGeneratedJob = result.getNumberOfTotalPages();
        int colourPageNumberOfGeneratedJob = result.getNumberOfColourPages();
        assertEquals(jobType, jobTypeofGeneratedJob);
        assertEquals(jobName, jobNameofGeneratedJob);
        assertEquals(55, totalPageNumberOfGeneratedJob);
        assertEquals(13, colourPageNumberOfGeneratedJob);

    }

    @Test
    public void testGetA4PrintJobWithUnknownTypeException() {
        logger.log(Level.FINE, "testGetA4PrintJobWithUnknownTypeException...");

        thrown.expect(UnexpectedException.class);
        thrown.expectMessage("Cannot create a print job ojbect. Unknown print job type");

        PrintJobType jobType = PrintJobType.Unknown;

        PrintJob result = PrintJobFactory.getA4PrintJob(jobType, 55, 13);

    }

}
