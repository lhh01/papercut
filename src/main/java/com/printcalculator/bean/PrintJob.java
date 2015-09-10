/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.bean;

import com.printcalculator.enums.PrintJobName;
import com.printcalculator.enums.PrintJobType;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author LiH
 */
public abstract class PrintJob implements Serializable {

    private static final long serialVersionUID = 6019011034372588061L;

    private final String id = UUID.randomUUID().toString();
    private final PrintJobType jobType;
    private final PrintJobName jobName;
    private final int numberOfTotalPages;
    private final int numberOfColourPages;

    public PrintJob(int totalPages, int colourPages, PrintJobType jobType, PrintJobName jobName) {

        this.numberOfTotalPages = totalPages;
        this.numberOfColourPages = colourPages;
        this.jobType = jobType;
        this.jobName = jobName;
    }

    public PrintJobName getJobName() {
        return jobName;
    }

    public int getNumberOfTotalPages() {
        return numberOfTotalPages;
    }

    public int getNumberOfColourPages() {
        return numberOfColourPages;
    }

    public PrintJobType getJobType() {
        return jobType;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (id == null) {
            return false;
        }

        final PrintJob other = (PrintJob) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName()).append("[id=").append(id).append("]");
        return builder.toString();
    }

}
