package at.fhooe.mc.view;

import at.fhooe.mc.model.Marble;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandergattringer on 10/12/15.
 */
public class PlayfieldView extends JPanel {

    public PlayfieldView(){
        super();
        setBackground(Color.black);

        adjustViewToMarbleCount(10, 10);
    }

    public void adjustViewToMarbleCount(int width, int height){
        setPreferredSize(new Dimension(width * Marble.DIMENSION, height * Marble.DIMENSION));
        setLayout(new GridLayout(height, width));
    }

    public void insertMarble(Marble marble){
        add(marble);
    }
}
