/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.core;

import com.printcalculator.bean.PrintJob;
import java.util.List;

/**
 *
 * @author LiH
 */
public class A4PrintJobProcessor extends PrintJobProcessor{

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
