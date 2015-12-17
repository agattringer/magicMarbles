package at.fhooe.mc.view;

import at.fhooe.mc.model.Marble;
import javafx.geometry.Pos;

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

    private PlayfieldView mPlayfieldView;
    private ScoreView mScoreView;

    private MMView(){
        super("Magic Marbles");
        //setup frame itself
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setup();

        //set frame to center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void setup(){
        //setup contents of frame
        createMenuBar();
        createPlayfieldView();
        createScoreView();

        pack();

        //ask user first
        showSetupDialog();
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
        pack();
    }

    public void resetView(){
        mPlayfieldView.reset();
    }

    public void resetScore(){
        mScoreView.updateScore(0);
    }

    public void insertMarbleToPlayfield(Marble marble){
        mPlayfieldView.insertMarble(marble);
    }

    public void closeWindow(){
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void showSetupDialog(){
        SetupDialog setupDialog = new SetupDialog();
        //set to center of window
        setupDialog.setLocationRelativeTo(this);
        setupDialog.setVisible(true);

        //bring dialog to front
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setupDialog.toFront();
                setupDialog.repaint();
            }
        });
    }

    public void showWinDialog(int finalScore){
        JOptionPane.showMessageDialog(this,
                "Your final score is: " + finalScore + " points");

        showSetupDialog();
    }

}
