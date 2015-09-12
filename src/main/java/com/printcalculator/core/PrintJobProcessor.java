/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import com.printcalculator.bean.PrintJob;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LiH
 */
public abstract class PrintJobProcessor {

    public abstract void processPrintJob() throws Exception;

    protected abstract void outputPrintJobResult(List<PrintJob> jobs);

    protected abstract List<PrintJob> parseCsvToPrintJobList(List<String[]> entries);

    protected void printJobCost(BigDecimal jobCost) {
        StringBuilder builder = new StringBuilder();

        builder.append("Print cost:").append(jobCost.toString());
        System.out.println(builder.toString());

    }

    protected void printTotalJobCost(BigDecimal totalCost) {
        StringBuilder builder = new StringBuilder();

        builder.append("Total print cost:").append(totalCost.toString());
        System.out.println(builder.toString());

    }

    protected void printJobDetails(String jobDetails) {
        System.out.println(jobDetails);
    }

}
