package com.msm.main;

import com.msm.exception.MsmBusinessException;

/**
 * Class to represent weight of apple.
 *
 * @version 1.0
 */
public class Weight {

    private static final Double MIN = 10.0;
    private static final Double MAX = 100.0;

    private Double value;

    /**
     * Constructor
     *
     * @param value - the weight value.
     * @throws MsmBusinessException
     */
    public Weight(Double value) throws MsmBusinessException {
        if (value == null) {
            throw new MsmBusinessException("Requires value ");
        }
        if (value < MIN || value > MAX) {
            throw new MsmBusinessException("Weight to be in range of 10gm - 100gm. ");
        }
        setValue(value);
    }

    public Double getValue() {
        return value;
    }

    private void setValue(Double value) {
        this.value = value;
    }

}
