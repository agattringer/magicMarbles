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

    public enum MarbleType {
        BlueMarble, RedMarble, GreenMarble
    }

    private Point mPosition;
    private LineBorder mBorder;
    private boolean mIsEnabled;
    private MarbleType mMarbleType;

    public Marble(){
        setSize(DIMENSION, DIMENSION);
        mBorder = new LineBorder(Color.white);
        setOpaque(true);
        setBorderPainted(false);
    }

    public MarbleType getMarbleType(){
        return mMarbleType;
    }

    public void setMarbleType(MarbleType type){
        mMarbleType = type;
    }

    public void setPosition(Point position){
        mPosition = position;
    }

    public Point getPosition(){
        return mPosition;
    }

    public void select(){
        setBorder(mBorder);
        setBorderPainted(true);
        mIsEnabled = true;
        return;

    }

    public void deselect(){
        setBorder(null);
        mIsEnabled = false;
    }

    public void remove(){
        setVisible(false);
    }
}
