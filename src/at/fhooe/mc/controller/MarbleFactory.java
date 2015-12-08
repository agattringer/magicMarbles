package at.fhooe.mc.controller;

import at.fhooe.mc.model.BlueMarble;
import at.fhooe.mc.model.GreenMarble;
import at.fhooe.mc.model.Marble;
import at.fhooe.mc.model.RedMarble;

import java.util.Random;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MarbleFactory {

    public static Marble getRandomMarble(){

        Random random = new Random();
        int randInt = random.nextInt(99);

        if (randInt < 33){
            return new BlueMarble();
        }

        if (randInt < 66){
            return new RedMarble();
        }

        return new GreenMarble();
    }
}
