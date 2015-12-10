package at.fhooe.mc.model;

import javafx.beans.Observable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public abstract class Marble extends JButton implements ActionListener{
    public static final int DIMENSION = 50;

    private Point mPosition;
    private LineBorder mBorder;
    private boolean mIsEnabled;

    public Marble(){
        setSize(DIMENSION, DIMENSION);
        mBorder = new LineBorder(Color.white);
        setOpaque(true);
        addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!mIsEnabled){
            setBorder(mBorder);
            mIsEnabled = true;
            return;
        }
        //no border on disable
        setBorder(null);
        mIsEnabled = false;
    }
}
