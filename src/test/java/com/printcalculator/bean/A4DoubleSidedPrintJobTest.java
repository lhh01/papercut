/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.bean;

import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
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
public class A4DoubleSidedPrintJobTest extends PrintJobTest {

    private static final Logger logger = Logger.getLogger(A4DoubleSidedPrintJobTest.class.getName());

    public A4DoubleSidedPrintJobTest() {
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

    @Override
    protected void setInstance(int totalPages, int colourPages, PrintJobType jobType, PrintJobName jobName) {
        instance = new A4DoubleSidedPrintJob(totalPages, colourPages, jobType, jobName);
    }

    @Test
    public void testConstructA4DoubleSidedPrintJobWithoutArguments() {
        logger.log(Level.FINE, "testConstructA4DoubleSidedPrintJobWithoutArguments...");
        A4DoubleSidedPrintJob job = new A4DoubleSidedPrintJob();

        PrintJobType type = job.getJobType();
        PrintJobName name = job.getJobName();
        int totalPageNumber = job.getNumberOfTotalPages();
        int colourPageNumber = job.getNumberOfColourPages();

        assertEquals(PrintJobType.A4DoubleSide, type);
        assertEquals(PrintJobName.A4DoubleSide, name);
        assertEquals(0, totalPageNumber);
        assertEquals(0, colourPageNumber);

    }

}
