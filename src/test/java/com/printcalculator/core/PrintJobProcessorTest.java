/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

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
public abstract class PrintJobProcessorTest {

    protected static final String LINE_BREAK = System.getProperty("line.separator");
    protected PrintJobProcessor instance;

    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public PrintJobProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    protected abstract void setInstance();

    @Test
    public void testPrintJobCost() {
        StringBuilder builder = new StringBuilder();
        setInstance();

        instance.printJobCost(new BigDecimal("3.10"));
        builder.append("Print cost:3.10").append(LINE_BREAK);
        assertEquals(builder.toString(), outContent.toString());
    }

    @Test
    public void testPrintTotalJobCost() {

        StringBuilder builder = new StringBuilder();
        setInstance();

        instance.printTotalJobCost(new BigDecimal("50.00"));
        builder.append("Total print cost:50.00").append(LINE_BREAK);
        assertEquals(builder.toString(), outContent.toString());
    }

    @Test
    public void testPrintJobDetails() {
        StringBuilder builder = new StringBuilder();
        setInstance();
        instance.printJobDetails("This is the first print job.");
        builder.append("This is the first print job.").append(LINE_BREAK);
        assertEquals(builder.toString(), outContent.toString());
    }

}
