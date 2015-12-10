package at.fhooe.mc.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandergattringer on 10/12/15.
 */
public class ScoreView extends JPanel {

    private int mScore;
    private JLabel mScoreLabel;

    public ScoreView(){
        mScore = 0;

        setSize(100, 20);
        setLayout(new FlowLayout());
        mScoreLabel = new JLabel("Score: " + mScore);
        add(mScoreLabel);
    }

    public void updateScore(int score){
        mScore = score;
        mScoreLabel.setText("Score: " + mScore);
    }
}
