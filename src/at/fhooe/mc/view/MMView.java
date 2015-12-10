package at.fhooe.mc.view;

import at.fhooe.mc.model.Marble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MMView extends JFrame{

    private static MMView ourInstance = new MMView();
    public static MMView getInstance() {
        return ourInstance;
    }

    PlayfieldView mPlayfieldView;
    ScoreView mScoreView;

    private MMView(){
        super("Magic Marbles");
        //setup frame itself
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());

        setup();
    }

    private void setup(){
        //setup contents of frame
        createMenuBar();
        createPlayfieldView();
        createScoreView();

        pack();
    }

    private void createMenuBar(){
        MenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar);
    }

    private void createPlayfieldView(){
        mPlayfieldView = new PlayfieldView();
        mPlayfieldView.adjustViewToMarbleCount(10,10);
        add(BorderLayout.CENTER, mPlayfieldView);
    }

    private void createScoreView(){
        mScoreView = new ScoreView();
        add(BorderLayout.SOUTH, mScoreView);
    }

    public void updateScore(int score){
        mScoreView.updateScore(score);
    }

    public void adjustView(int width, int height){
        mPlayfieldView.adjustViewToMarbleCount(width, height);
    }

    public void insertMarbleToPlayfield(Marble marble){
        mPlayfieldView.insertMarble(marble);
    }



}
