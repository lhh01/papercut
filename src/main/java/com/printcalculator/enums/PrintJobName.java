/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.enums;

/**
 *
 * @author LiH
 */
public enum PrintJobName {

    Unknown("Unknown"),
    A4SingleSide("A4 Single Sided Print Job"),
    A4DoubleSide("A4 Double Sided Print Job");

    PrintJobName(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
