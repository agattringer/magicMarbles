package at.fhooe.mc.model;

import java.awt.*;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class RedMarble extends Marble{

    public RedMarble(){
        super();
    }

    public RedMarble(Point position) {
        super(position);
        setBackground(Color.RED);
    }
}
