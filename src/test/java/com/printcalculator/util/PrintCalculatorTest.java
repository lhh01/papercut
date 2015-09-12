/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import com.printcalculator.bean.A4SingleSidedPrintJob;
import com.printcalculator.bean.PrintJob;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class PrintCalculatorTest {

    private static final Logger logger = Logger.getLogger(PrintCalculatorTest.class.getName());
    private PrintJob a4SingleSidedPrintJob;

    private Calculator printCalculator;
    private List<BigDecimal> jobResults;

    public PrintCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        a4SingleSidedPrintJob = new A4SingleSidedPrintJob(25, 10);

        printCalculator = new PrintCalculator();
        jobResults = new ArrayList<>();
        jobResults.add(new BigDecimal("4.75"));
        jobResults.add(new BigDecimal("6.80"));
        jobResults.add(new BigDecimal("52.40"));
        jobResults.add(new BigDecimal("0.15"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCalcaulteSingleJobCost_singleSide() {
        logger.log(Level.FINE, "testCalcaulteSingleJobCost_singleSide...");

        BigDecimal expResult = new BigDecimal("4.75");
        BigDecimal result = printCalculator.calcaulteSingleJobCost(a4SingleSidedPrintJob);
        assertEquals(expResult, result);

    }

    @Test
    public void testCalcaulteAllJobCost() {
        logger.log(Level.FINE, "testCalcaulteAllJobCost...");

        BigDecimal expResult = new BigDecimal("64.10");
        BigDecimal result = printCalculator.calcaulteAllJobCost(jobResults);
        assertEquals(expResult, result);

    }

}
