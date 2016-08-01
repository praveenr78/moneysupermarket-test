package com.msm.peeler;

import com.msm.peeler.IPeeler;

/**
 *  Peeler interface.
 *
 * @version 1.0
 */
public class ValyrianPeeler implements IPeeler {

    @Override
    public void peel() {
        System.out.println("Peel apple with valyrian peeler...");
    }
}
