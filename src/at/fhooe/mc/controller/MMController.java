package at.fhooe.mc.controller;

import at.fhooe.mc.model.MMModel;
import at.fhooe.mc.model.Marble;
import at.fhooe.mc.view.MMView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MMController implements ActionListener{

    private static MMController ourInstance = new MMController();

    public static MMController getInstance() {
        return ourInstance;
    }

    private MarbleFactory marbleFactory = new MarbleFactory();
    private int mScore = 0;
    private ArrayList<Marble> mSelectedMarbles = new ArrayList<>();
    private ArrayList<Marble> mValidMarbles = new ArrayList<>();
    private Marble.MarbleType mCurrentSelectionType;

    private MMController() {
    }

    public void setupPlayfield(int width, int height){
        MMView.getInstance().resetView();
        MMView.getInstance().resetScore();
        Marble[][] playfield = MMModel.getInstance().createPlayfieldArray(width, height);
        playfield = fillPlayfield(playfield);
        MMModel.getInstance().setPlayfieldArray(playfield);
        MMView.getInstance().adjustView(width, height);
    }

    private Marble[][] fillPlayfield(Marble[][] playfield){
        //iterate over every field
        for (int i = 0; i < playfield.length; i++){
            for (int j = 0; j < playfield[i].length; j++){
                Marble marble = marbleFactory.getRandomMarble();
                marble.setPosition(new Point(i, j));
                playfield[i][j] = marble;
                marble.addActionListener(this);
                //insert marble to view
                MMView.getInstance().insertMarbleToPlayfield(marble);
            }
        }
        return playfield;
    }

    private void removeSelectedMarbles(){
        if (mSelectedMarbles.size() > 1){//only remove clusters
            for (Marble marble : mSelectedMarbles){
                marble.remove();
            }

            incrementScore(mSelectedMarbles.size());

            if (isGameFinished()){
                MMView.getInstance().showSetupDialog();
            }else {
                MMModel.getInstance().rearrangeMarbles();
                adjustViewToArray(MMModel.getInstance().getPlayfieldArray());
            }
        }

    }

    private boolean isGameFinished(){
        ArrayList<Marble> remainingMarbles = MMModel.getInstance().getRemainingMarbles();

        for (Marble marble : remainingMarbles){
            mValidMarbles.clear();
            addToMarbleCluster(marble);
            if (mValidMarbles.size() > 1)
                return false;
        }

        return true;
    }

    private void adjustViewToArray(Marble[][] marbleArray){
        MMView.getInstance().resetView();

        for (int i = 0; i < marbleArray.length; i++) {
            for (int j = 0; j < marbleArray[i].length; j++) {
                Marble marble = marbleArray[i][j];
                marble.setPosition(new Point(i,j));
                MMView.getInstance().insertMarbleToPlayfield(marble);
            }
        }
    }

    private void checkSelection(Marble marble){

        if (!mValidMarbles.contains(marble)){//marble not in cluster
            clearSelection();
        }

        if (mCurrentSelectionType != marble.getMarbleType()){//other marble type
            clearSelection();
        }

        selectMarble(marble);
        //recursive call for identifying the cluster in which the marble is located
        addToMarbleCluster(marble);
        checkForRemoval();
    }

    private void checkForRemoval(){
        if (mSelectedMarbles.containsAll(mValidMarbles)){
            removeSelectedMarbles();
            clearSelection();
        }
    }

    private void incrementScore(int removedMarbles){
        mScore += removedMarbles * removedMarbles;
        MMView.getInstance().updateScore(mScore);
    }

    private void addToMarbleCluster(Marble marble){
        if (!mValidMarbles.contains(marble)){
            mValidMarbles.add(marble);
        }else {
            return;
        }

        for (Marble neighbourMarble : MMModel.getInstance().getNeighboursForMarble(marble)){
            if (neighbourMarble.getMarbleType().equals(marble.getMarbleType())){
                addToMarbleCluster(neighbourMarble);
            }
        }
    }

    private void selectMarble(Marble marble){
        marble.select();
        mSelectedMarbles.add(marble);
        mCurrentSelectionType = marble.getMarbleType();
    }

    private void clearSelection(){
        for (Marble marble : mSelectedMarbles){
            marble.deselect(); //deselect
        }
        mSelectedMarbles.clear();
        mValidMarbles.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Marble clickedMarble = (Marble)e.getSource();
        checkSelection(clickedMarble);
    }
}
