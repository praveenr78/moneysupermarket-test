package com.msm.peeler;

/**
 * Basic peeler.
 *
 * @version 1.0
 */
public class BasicPeeler implements IPeeler {


    /**
     * see {@link IPeeler#peel()}
     */
    @Override
    public void peel() {
        System.out.println("Peel apple with basic peeler");
    }
}
