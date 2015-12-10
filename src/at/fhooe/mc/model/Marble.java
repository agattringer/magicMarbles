package at.fhooe.mc.model;

import javafx.beans.Observable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public abstract class Marble extends JButton{
    public static final int DIMENSION = 50;

    private Point mPosition;
    private LineBorder mBorder;
    private boolean mIsEnabled;

    public Marble(){
        setSize(DIMENSION, DIMENSION);
        mBorder = new LineBorder(Color.white);
        setOpaque(true);
        setBorderPainted(false);
    }

    public void setPosition(Point position){
        mPosition = position;
    }

    public Point getPosition(){
        return mPosition;
    }

    public void selected(){
        if (!mIsEnabled){
            setBorder(mBorder);
            setBorderPainted(true);
            mIsEnabled = true;
            return;
        }
        //no border on disable
        setBorder(null);
        mIsEnabled = false;
    }
}
