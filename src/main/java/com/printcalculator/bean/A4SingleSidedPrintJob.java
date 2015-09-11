/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.bean;

import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;

/**
 *
 * @author LiH
 */
public class A4SingleSidedPrintJob extends PrintJob {

    private static final long serialVersionUID = -8712677774857083228L;

    public A4SingleSidedPrintJob() {
        this(0, 0, PrintJobType.A4SingleSide, PrintJobName.A4SingleSide);
    }

    public A4SingleSidedPrintJob(int totalPages, int colourPages) {
        this(totalPages, colourPages, PrintJobType.A4SingleSide, PrintJobName.A4SingleSide);
    }

    public A4SingleSidedPrintJob(int totalPages, int colourPages, PrintJobType jobType, PrintJobName jobName) {
        super(totalPages, colourPages, jobType, jobName);
    }

}
