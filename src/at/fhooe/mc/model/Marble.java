package at.fhooe.mc.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public abstract class Marble extends JButton{
    private static final int DIMENSION = 15;

    private Point mPosition;

    public Marble(){
        this.setSize(DIMENSION, DIMENSION);
    }

    public Marble(Point position){
        this();
        mPosition = position;
    }

    public void setPosition(Point position){
        mPosition = position;
    }

    public Point getPosition(){
        return mPosition;
    }

}
