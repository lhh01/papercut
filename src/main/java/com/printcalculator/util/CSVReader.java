/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiH
 */
public class CSVReader {

    private static final String DEFAULT_CSV_SEPARATOR = ",";
    private BufferedReader reader;
    private String csvSeparator;

    public CSVReader(Reader reader) {
        this(reader, DEFAULT_CSV_SEPARATOR);
    }

    public CSVReader(Reader reader, String csvSeparator) {
        this.reader = (reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader));

        this.csvSeparator = csvSeparator;
    }

    public List<String[]> readAll() throws IOException {
        String line;
        ArrayList<String[]> entries = new ArrayList<>();

        while ((line = reader.readLine()) != null) {

            String[] entry = line.split(csvSeparator);

            entries.add(entry);

        }

        return entries;
    }

    public void close() throws IOException {
        reader.close();
    }
}
