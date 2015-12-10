package at.fhooe.mc.controller;

import at.fhooe.mc.model.MMModel;
import at.fhooe.mc.model.Marble;
import at.fhooe.mc.view.MMView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private MMController() {
    }

    public int getCurrentScore(){
        return mScore;
    }

    public void setupPlayfield(int width, int height){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: marble has been selected
        Marble clickedMarble = (Marble)e.getSource();
        clickedMarble.selected();
        System.out.println("X: " + clickedMarble.getPosition().x + " Y: " + clickedMarble.getPosition().y);
    }
}
