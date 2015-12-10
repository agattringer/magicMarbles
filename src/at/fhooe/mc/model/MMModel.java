package at.fhooe.mc.model;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MMModel {
    private static MMModel ourInstance = new MMModel();

    public static MMModel getInstance() {
        return ourInstance;
    }

    private Marble[][] mPlayfield;

    private MMModel() {
    }

    public Marble[][] createPlayfieldArray(int width, int height){
        mPlayfield = new Marble[width][height];
        return mPlayfield;
    }

    public void setPlayfieldArray(Marble[][] pfArray){
        mPlayfield = pfArray;
    }

}
