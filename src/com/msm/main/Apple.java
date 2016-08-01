package com.msm.main;

import com.apple.eawt.AppEvent;
import com.msm.enums.Color;
import com.msm.enums.TasteLevel;
import com.msm.exception.MsmBusinessException;
import com.msm.peeler.BasicPeeler;
import com.msm.peeler.IPeeler;
import com.msm.peeler.ValyrianPeeler;

/**
 * Class to represent apple.
 *
 * @version 1.0
 */
public class Apple {

    /**
     * Color of the apple.
     */
    private Color color;
    /**
     * weight of the apple.
     */
    private Weight weight;
    /**
     * taste level of the apple.
     */
    private TasteLevel tasteLevel;
    /**
     * If apple has worm.
     */
    private Boolean hasWorm;
    /**
     * Peeler to use.
     */
    private IPeeler peeler;


    /**
     * Peeled
     */
    private boolean peeled;

    /**
     * Constructor
     *
     * @param color
     * @param weight
     * @param level
     * @param hasWorm
     */

    public Apple(Color color, Double weight, TasteLevel level, Boolean hasWorm) throws MsmBusinessException {
        setColor(color);
        setWeight(new Weight(weight));
        setTasteLevel(level);
        setHasWorm(hasWorm);

        if (color.equals(Color.BLUE))
            setPeeler(new ValyrianPeeler());
        else
            setPeeler(new BasicPeeler());
    }

    /**
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color
     */
    private void setColor(Color color) throws MsmBusinessException {
        if (color == null) throw new MsmBusinessException("Color is empty.");
        this.color = color;

    }

    /**
     * @return
     */
    public Weight getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    public TasteLevel getTasteLevel() {
        return tasteLevel;
    }

    /**
     * @param tasteLevel
     */
    public void setTasteLevel(TasteLevel tasteLevel) throws MsmBusinessException {
        if (tasteLevel == null) throw new MsmBusinessException("Taste level is empty.");
        this.tasteLevel = tasteLevel;
    }

    /**
     * @return
     */
    public Boolean hasWorm() {
        return hasWorm;
    }

    /**
     * @param hasWorm
     */
    public void setHasWorm(Boolean hasWorm) {
        this.hasWorm = hasWorm;
    }

    /**
     * @return
     */
    public IPeeler getPeeler() {
        return peeler;
    }

    /**
     * @param peeler
     */
    private void setPeeler(IPeeler peeler) {
        this.peeler = peeler;
    }

    /**
     *
     * @return
     */
    private boolean isPeeled() {
        return peeled; }

    /**
     *
     * @param peeled
     */
    private void setPeeled(boolean peeled) {
        this.peeled = peeled;
    }

    /**
     * @throws MsmBusinessException
     */
    public void peel() throws MsmBusinessException {
        if (!hasWorm() && (getTasteLevel().getValue() > TasteLevel.THREE.getValue())) {
            getPeeler().peel();
            setPeeled(true);
        } else
            throw new MsmBusinessException("The apple has worm or low taste level.");
    }

    /**
     * @throws MsmBusinessException
     */
    public void eat() throws MsmBusinessException {
        if (isPeeled())
        System.out.println("Eat apple...:)");
        else
            throw new MsmBusinessException("The apple has to be peeled before eating.");

    }

}
