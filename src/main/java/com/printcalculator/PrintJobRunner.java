/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator;

import com.printcalculator.core.A4PrintJobProcessor;
import com.printcalculator.core.PrintJobProcessor;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author LiH
 */
public class PrintJobRunner {

    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties");
        LogManager logManager = LogManager.getLogManager();
        boolean configFileLoadFail = false;
        try {
            logManager.readConfiguration(inputStream);
        } catch (Exception ex) {
            configFileLoadFail = true;
            StringBuilder builder = new StringBuilder();
            builder.append("LogManager cannot read log.properites. ").append(ex.getMessage());          
            System.err.println(builder.toString());
          
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception ex) {
                    System.err.println("Cannot close log.properites input stream");
                }

            }
        }

        if (configFileLoadFail == true) {
            System.exit(1);
        }
    }

    private static final Logger logger = Logger.getLogger(PrintJobRunner.class.getName());

    public static void main(String[] args) {

        try {

            logger.log(Level.INFO, "Print job runner starting");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your input print job file path:");

            String printJobFilePath = scanner.nextLine();

            File printJobFile = new File(printJobFilePath);

            // assuming only process A4 print job due to time limit
            // to extend system to support other size print job, need to input another job type argument
            // then check job type argument to create different PrintJobProcessor from factory class
            PrintJobProcessor printJobProcessor = new A4PrintJobProcessor(printJobFile);

            printJobProcessor.processPrintJob();

            logger.log(Level.INFO, "Print job runner finished");

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

}
