/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import com.printcalculator.bean.PrintJob;
import com.printcalculator.enums.Price;
import com.printcalculator.enums.PrintJobType;
import com.printcalculator.exception.UnexpectedException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LiH
 */
public class PrintCalculator implements Calculator {

    @Override
    public BigDecimal calcaulteSingleJobCost(PrintJob job) {
        BigDecimal cost = BigDecimal.ZERO;
        PrintJobType jobType = job.getJobType();
        int totalPages = job.getNumberOfTotalPages();
        int colourPages = job.getNumberOfColourPages();
        int blackPages = totalPages - colourPages;

        if (jobType == PrintJobType.A4SingleSide) {

            BigDecimal colourPrice = new BigDecimal(Price.A4SingleSide_COLOUR.getCost());
            BigDecimal blackPrice = new BigDecimal(Price.A4SingleSide_BLACK.getCost());

            BigDecimal colourCost = colourPrice.multiply(new BigDecimal(colourPages));
            BigDecimal blackCost = blackPrice.multiply(new BigDecimal(blackPages));

            cost = colourCost.add(blackCost);

        } else if (jobType == PrintJobType.A4DoubleSide) {

            BigDecimal colourPrice = new BigDecimal(Price.A4DoubleSide_COLOUR.getCost());
            BigDecimal blackPrice = new BigDecimal(Price.A4DoubleSide_BLACK.getCost());

            BigDecimal colourCost = colourPrice.multiply(new BigDecimal(colourPages));
            BigDecimal blackCost = blackPrice.multiply(new BigDecimal(blackPages));

            cost = colourCost.add(blackCost);

        } else {
            throw new UnexpectedException("Cannot calculate print job cost. Unknow print job type.");

        }

        return cost;
        
    }

    @Override
    public BigDecimal calcaulteAllJobCost(List<BigDecimal> jobResults) {
        BigDecimal totalCost = BigDecimal.ZERO;

        for (BigDecimal result : jobResults) {
            totalCost = totalCost.add(result);
        }

        return totalCost;

    }

}
