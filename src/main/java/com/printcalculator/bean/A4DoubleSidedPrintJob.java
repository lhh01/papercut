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
public class A4DoubleSidedPrintJob extends PrintJob{

    public A4DoubleSidedPrintJob(int totalPages, int colourPages, PrintJobType jobType, PrintJobName jobName) {
        super(totalPages, colourPages, jobType, jobName);
    }
    
}
