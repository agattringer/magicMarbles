package at.fhooe.mc.main;

import at.fhooe.mc.view.MMView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MagicMarbles {

    public static void main(String[] args){
        MMView frame = MMView.getInstance();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();

        frame.setVisible(true);
    }
}
