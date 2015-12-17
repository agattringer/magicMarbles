package at.fhooe.mc.model;

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
    private int mHeight;
    private int mWidth;

    private MMModel() {
    }

    public Marble[][] createPlayfieldArray(int width, int height){
        mPlayfield = new Marble[width][height];
        mHeight = width;
        mWidth = height;
        return mPlayfield;
    }

    public Marble[][] getPlayfieldArray(){
        return mPlayfield;
    }

    public void setPlayfieldArray(Marble[][] pfArray){
        mPlayfield = pfArray;
    }

    public ArrayList<Marble> getRemainingMarbles(){
        ArrayList<Marble> remainingMarbles = new ArrayList<>();
        for (int i = 0; i < mPlayfield.length; i++) {
            for (int j = 0; j < mPlayfield[i].length; j++) {
                if (mPlayfield[i][j].isVisible()){
                    remainingMarbles.add(mPlayfield[i][j]);
                }
            }
        }
        return remainingMarbles;
    }

    public void rearrangeMarbles(){

        System.out.println("width: " + mHeight + " height: " + mWidth);

        for (int i = 0; i < mWidth; i++){
            for (int j = 0; j < mHeight; j++){
                dropMarblesToBotton(i);
            }
        }


        for (int j = 0; j < mWidth; j++){
            for (int i = mWidth - 1; i > 0; i--){
                moveMarblesToRight(i);
            }
        }

    }

    private void dropMarblesToBotton(int column){

        for (int i = mHeight - 1; i > 0; i--){
            Marble tempMarble = mPlayfield[i][column];

            if (!tempMarble.isVisible()){
                mPlayfield[i][column] = mPlayfield[i-1][column];
                mPlayfield[i-1][column] = tempMarble;
            }
        }
    }

    private void moveMarblesToRight(int column){
        if (!mPlayfield[mHeight -1][column].isVisible()){
            //move whole column to right
            for (int i = mHeight - 1; i >= 0; i--){
                Marble tempMarble = mPlayfield[i][column];
                mPlayfield[i][column] = mPlayfield[i][column-1];
                mPlayfield[i][column-1] = tempMarble;
            }
        }
    }

    public ArrayList<Marble> getNeighboursForMarble(Marble marble){
        ArrayList<Marble> neighbourList = new ArrayList<>();
        Marble tempMarble;

        if ((marble.getPosition().x - 1 >= 0)){
            tempMarble = mPlayfield[marble.getPosition().x-1][marble.getPosition().y];
            if (tempMarble.isVisible()) neighbourList.add(tempMarble);
            tempMarble = null;
        }


        if (marble.getPosition().y - 1 >= 0){
            tempMarble = mPlayfield[marble.getPosition().x][marble.getPosition().y-1];
            if (tempMarble.isVisible()) neighbourList.add(tempMarble);
            tempMarble = null;
        }


        if (marble.getPosition().x < mPlayfield.length - 1){
            tempMarble = mPlayfield[marble.getPosition().x+1][marble.getPosition().y];
            if (tempMarble.isVisible()) neighbourList.add(tempMarble);
            tempMarble = null;
        }

        if (marble.getPosition().y < mPlayfield[0].length - 1){
            tempMarble = mPlayfield[marble.getPosition().x][marble.getPosition().y+1];
            if (tempMarble.isVisible())neighbourList.add(tempMarble);
            tempMarble = null;
        }

        return neighbourList;
    }

}
