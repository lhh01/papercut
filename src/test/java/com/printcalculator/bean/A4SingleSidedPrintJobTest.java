/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.bean;

import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
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
public class A4SingleSidedPrintJobTest extends PrintJobTest {

    public A4SingleSidedPrintJobTest() {
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
        instance = new A4SingleSidedPrintJob(totalPages, colourPages, jobType, jobName);
    }

    @Test
    public void testConstructA4SingleSidedPrintJobWithoutArguments() {
        A4SingleSidedPrintJob job = new A4SingleSidedPrintJob();

        PrintJobType type = job.getJobType();
        PrintJobName name = job.getJobName();
        int totalPageNumber = job.getNumberOfTotalPages();
        int colourPageNumber = job.getNumberOfColourPages();

        assertEquals(PrintJobType.A4SingleSide, type);
        assertEquals(PrintJobName.A4SingleSide, name);
        assertEquals(0, totalPageNumber);
        assertEquals(0, colourPageNumber);

    }
    
    
    
      @Test
    public void testConstructA4SingleSidedPrintJobWithTwoArguments() {
        A4SingleSidedPrintJob job = new A4SingleSidedPrintJob(100, 30);

        PrintJobType type = job.getJobType();
        PrintJobName name = job.getJobName();
        int totalPageNumber = job.getNumberOfTotalPages();
        int colourPageNumber = job.getNumberOfColourPages();

        assertEquals(PrintJobType.A4SingleSide, type);
        assertEquals(PrintJobName.A4SingleSide, name);
        assertEquals(100, totalPageNumber);
        assertEquals(30, colourPageNumber);
    }

}
