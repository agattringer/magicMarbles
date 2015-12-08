package at.fhooe.mc.controller;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MMController {
    private static MMController ourInstance = new MMController();

    public static MMController getInstance() {
        return ourInstance;
    }

    private MMController() {
    }

    public void setupPlayfield(int width, int height){

    }
}
