package at.fhooe.mc.model;

import java.awt.*;
import java.util.ArrayList;

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

    public Marble getMarbleForPosition(Point position){
        return mPlayfield[position.x][position.y];
    }

    public void rearrangeMarbles(){
        //TODO: continue here ->

        //TODO: after rearranging check for end of game
    }

    public ArrayList<Marble> getNeighboursForMarble(Marble marble){
        ArrayList<Marble> neighbourList = new ArrayList<>();
        Marble tempMarble;

        if ((marble.getPosition().x - 1 >= 0)){
            tempMarble = mPlayfield[marble.getPosition().x-1][marble.getPosition().y];
            if (tempMarble != null) neighbourList.add(tempMarble);
            tempMarble = null;
        }


        if (marble.getPosition().y - 1 >= 0){
            tempMarble = mPlayfield[marble.getPosition().x][marble.getPosition().y-1];
            if (tempMarble != null) neighbourList.add(tempMarble);
            tempMarble = null;
        }


        if (marble.getPosition().x < mPlayfield.length - 1){
            tempMarble = mPlayfield[marble.getPosition().x+1][marble.getPosition().y];
            if (tempMarble != null) neighbourList.add(tempMarble);
            tempMarble = null;
        }

        if (marble.getPosition().y < mPlayfield[0].length - 1){
            tempMarble = mPlayfield[marble.getPosition().x][marble.getPosition().y+1];
            if (tempMarble != null)neighbourList.add(tempMarble);
            tempMarble = null;
        }

        return neighbourList;
    }

    public boolean removeMarbleAt(Point position){
        if (mPlayfield[position.x][position.y] != null){
            mPlayfield[position.x][position.y] = null;
            System.out.println("removed Marble");
            return true; //marble removed successfully
        }
        System.out.println("no Marble");
        return false; //there was no marble in there
    }

}
