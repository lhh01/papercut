/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import com.printcalculator.bean.PrintJob;
import com.printcalculator.enums.PrintJobType;
import com.printcalculator.exception.UnexpectedException;
import com.printcalculator.util.PrintJobFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
        ArrayList<PrintJob> printJobList = new ArrayList<>();
        int lineCounter = 1;
        StringBuilder stringBuilder = new StringBuilder();
        
        for (String[] entry : entries) {
            PrintJob printJob = null;
            String totalNumberTemp = entry[0].trim();
            String colourNumberTemp = entry[1].trim();
            String doubleSideTemp = entry[2].trim();
            int totalPageNumber = -1;
            int colourPageNumber = -1;
            boolean doubleSide = false;

            try {
                totalPageNumber = Integer.parseInt(totalNumberTemp);
                colourPageNumber = Integer.parseInt(colourNumberTemp);
                doubleSide = Boolean.parseBoolean(doubleSideTemp);
            } catch (Exception e) {
                stringBuilder.append("Parsing csv error at line:").append(lineCounter);
                logger.log(Level.FINE, stringBuilder.toString());
                throw new UnexpectedException(stringBuilder.toString(), e);
            }

            if (totalPageNumber < 1 || colourPageNumber < 0 || totalPageNumber < colourPageNumber) {
                stringBuilder.setLength(0);
                stringBuilder.append("Invalid value at line:").append(lineCounter);
                logger.log(Level.FINE, stringBuilder.toString());
                throw new UnexpectedException(stringBuilder.toString());

            }

            if (doubleSide) {
                printJob = PrintJobFactory.getA4PrintJob(PrintJobType.A4DoubleSide, totalPageNumber, colourPageNumber);
            } else {
                printJob = PrintJobFactory.getA4PrintJob(PrintJobType.A4SingleSide, totalPageNumber, colourPageNumber);
            }

            printJobList.add(printJob);
            lineCounter++;
        }

        return printJobList;
    }

}
