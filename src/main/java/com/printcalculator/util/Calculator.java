/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.util;

import com.printcalculator.bean.PrintJob;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LiH
 */
public interface Calculator {

    BigDecimal calcaulteSingleJobCost(PrintJob job);

    BigDecimal calcaulteAllJobCost(List<BigDecimal> jobResults);
    
}
