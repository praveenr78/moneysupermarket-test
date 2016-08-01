package com.msm.enums;

/**
 * List of taste levels.
 *
 * @version 1.0
 */
public enum TasteLevel {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);


    private Integer value;

    TasteLevel(Integer value) {
        setValue(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
