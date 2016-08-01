package com.msm.main;

import com.msm.enums.Color;
import com.msm.enums.TasteLevel;
import com.msm.exception.MsmBusinessException;

/**
 * Created by praveenr on 31/07/2016.
 */
public class TestApple {

    public static void main(String args[]){
        try {
            Apple ap = new Apple(Color.GREEN, 12.0, TasteLevel.FOUR, false);
            ap.eat();
        } catch(MsmBusinessException ex){
            ex.printStackTrace();
        }

    }

    }
