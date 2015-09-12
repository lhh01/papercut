/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import com.printcalculator.bean.PrintJob;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author LiH
 */
public class A4PrintJobProcessor extends PrintJobProcessor {

    private static final Logger logger = Logger.getLogger(A4PrintJobProcessor.class.getName());

    private final File a4PrintJobFile;

    public A4PrintJobProcessor(File printJobFile) {
        this.a4PrintJobFile = printJobFile;
    }

    @Override
    public void processPrintJob() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void outputPrintJobResult(List<PrintJob> jobs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<PrintJob> parseCsvToPrintJobList(List<String[]> entries) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
