package com.msm.exception;

/**
 * Business exception.
 *
 * @version 1.0
 */
public class MsmBusinessException extends Exception {

    /**
     *
     * @param message
     */
    public MsmBusinessException(String message) {
        super(message);
    }
}
