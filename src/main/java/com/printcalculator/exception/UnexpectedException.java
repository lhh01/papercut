/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printcalculator.exception;

/**
 *
 * @author LiH
 */
public class UnexpectedException extends RuntimeException {

    private static final long serialVersionUID = 8310493621826013599L;

    public UnexpectedException() {
        super();
    }

    public UnexpectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedException(String message) {
        super(message);
    }

    public UnexpectedException(Throwable cause) {
        super(cause);
    }
}
