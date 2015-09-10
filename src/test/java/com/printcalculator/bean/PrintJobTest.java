/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.bean;

import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author LiH
 */
public abstract class PrintJobTest {

    protected PrintJob instance;

    protected abstract void setInstance(int totalPages, int colourPages, PrintJobType jobType, PrintJobName jobName);

    @Test
    public void testConstructor() {

        setInstance(0, 0, PrintJobType.Unknown, PrintJobName.Unknown);

        PrintJobType type = instance.getJobType();
        PrintJobName name = instance.getJobName();
        int totalPageNumber = instance.getNumberOfTotalPages();
        int colourPageNumber = instance.getNumberOfColourPages();
        assertEquals(PrintJobType.Unknown, type);
        assertEquals(PrintJobName.Unknown, name);
        assertEquals(0, totalPageNumber);
        assertEquals(0, colourPageNumber);

    }

}
