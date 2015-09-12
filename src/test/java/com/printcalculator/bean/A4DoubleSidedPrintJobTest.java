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
        instance = new A4DoubleSidedPrintJob(totalPages, colourPages, jobName);
    }

    @Test
    @Override
    public void testConstructor() {

        super.testConstructor();

        PrintJobType type = instance.getJobType();

        assertEquals(PrintJobType.A4DoubleSide, type);

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

    @Test
    public void testConstructA4DoubleSidedPrintJobWithTwoArguments() {
        logger.log(Level.FINE, "testConstructA4DoubleSidedPrintJobWithTwoArguments...");
        A4DoubleSidedPrintJob job = new A4DoubleSidedPrintJob(100, 30);

        PrintJobType type = job.getJobType();
        PrintJobName name = job.getJobName();
        int totalPageNumber = job.getNumberOfTotalPages();
        int colourPageNumber = job.getNumberOfColourPages();

        assertEquals(PrintJobType.A4DoubleSide, type);
        assertEquals(PrintJobName.A4DoubleSide, name);
        assertEquals(100, totalPageNumber);
        assertEquals(30, colourPageNumber);
    }

    @Test
    public void testConstructA4DoubleSidedPrintJobWithThreeArguments() {
        logger.log(Level.FINE, "testConstructA4DoubleSidedPrintJobWithThreeArguments...");
        A4DoubleSidedPrintJob job = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);

        PrintJobType type = job.getJobType();
        PrintJobName name = job.getJobName();
        int totalPageNumber = job.getNumberOfTotalPages();
        int colourPageNumber = job.getNumberOfColourPages();

        assertEquals(PrintJobType.A4DoubleSide, type);
        assertEquals(PrintJobName.A4DoubleSide, name);
        assertEquals(100, totalPageNumber);
        assertEquals(30, colourPageNumber);
    }

    @Test
    public void testGetDetails() {
        logger.log(Level.FINE, "testGetDetails...");
        A4DoubleSidedPrintJob job = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);

        String result = job.getDetails();
        StringBuilder builder = new StringBuilder();
        String line = System.getProperty("line.separator");
        
        builder.append("Job Name:").append(PrintJobName.A4DoubleSide.getName()).append(line)
                .append("Total pages number:").append(100).append(line)
                .append("Colour pages number:").append(30);
        

        assertEquals(builder.toString(), result);
    }

    @Test
    public void testToString() {
        logger.log(Level.FINE, "testToString...");
        A4DoubleSidedPrintJob job = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);

        String result = job.toString();
        assertTrue(result.startsWith("com.printcalculator.bean.A4DoubleSidedPrintJob[id="));

    }

    @Test
    public void testEqualsAndHashCode() {
        logger.log(Level.FINE, "testEqualsAndHashCode...");
        A4DoubleSidedPrintJob job1 = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);
        A4DoubleSidedPrintJob job2 = new A4DoubleSidedPrintJob(100, 30, PrintJobName.A4DoubleSide);
        assertFalse(job1.equals(job2));
        assertFalse(job1.hashCode() == job2.hashCode());

    }

}
