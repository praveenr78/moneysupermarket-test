package com.msm.peeler;

import com.msm.exception.MsmBusinessException;
import com.msm.main.Apple;

/**
 * Peeler interface.
 *
 * @version 1.0
 */
public interface IPeeler {

    /**
     *
     * @return
     */
    void peel() throws MsmBusinessException;
}
