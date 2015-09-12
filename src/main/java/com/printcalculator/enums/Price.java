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
public enum Price {

    A4SingleSide_BLACK("0.15"),
    A4SingleSide_COLOUR("0.25"),
    A4DoubleSide_BLACK("0.10"),
    A4DoubleSide_COLOUR("0.20");

    Price(String cost) {
        this.cost = cost;
    }

    private final String cost;

    public String getCost() {
        return this.cost;
    }

}
