package at.fhooe.mc.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public abstract class Marble extends JButton{
    private Point mPosition;

    public Marble(Point position){
        mPosition = position;
    }

}
