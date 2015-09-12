/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import com.printcalculator.bean.A4DoubleSidedPrintJob;
import com.printcalculator.bean.A4SingleSidedPrintJob;
import com.printcalculator.bean.PrintJob;
import com.printcalculator.enums.PrintJobType;
import com.printcalculator.exception.UnexpectedException;

/**
 *
 * @author LiH
 */
public class PrintJobFactory {

    public static PrintJob getA4PrintJob(PrintJobType jobType, int totalPageNumber, int colourPageNumber) {
        PrintJob printJob = null;
        switch (jobType) {
            case A4SingleSide:
                printJob = new A4SingleSidedPrintJob(totalPageNumber, colourPageNumber);
                break;

            case A4DoubleSide:
                printJob = new A4DoubleSidedPrintJob(totalPageNumber, colourPageNumber);
                break;

            default:

                break;
        }

        if (printJob == null) {
            throw new UnexpectedException("Cannot create a print job ojbect. Unknow print job type");
        }

        return printJob;
    }
}
