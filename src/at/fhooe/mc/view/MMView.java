package at.fhooe.mc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class MMView extends JFrame implements ActionListener{

    private JMenuBar mMenuBar;
    private JMenu mFileMenu;
    private JMenuItem mNewMenuItem;
    private JMenuItem mExitMenuItem;

    private static MMView ourInstance = new MMView();
    public static MMView getInstance() {
        return ourInstance;
    }

    private MMView(){
        super("Magic Marbles");
        setup();
    }

    private void setup(){
        createMenuBar();
    }

    private void createMenuBar(){
        mMenuBar = new JMenuBar();
        mFileMenu = new JMenu("File");

        // "new" menu item
        mNewMenuItem = new JMenuItem("New");
        mNewMenuItem.addActionListener(this);
        mFileMenu.add(mNewMenuItem);

        // "exit" menu item
        mExitMenuItem = new JMenuItem("Exit");
        mExitMenuItem.addActionListener(this);
        mFileMenu.add(mExitMenuItem);

        mMenuBar.add(mFileMenu);

        setJMenuBar(mMenuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mNewMenuItem)) {
            SetupDialog setupDialog = new SetupDialog();
            setupDialog.setVisible(true);
            return;
        }

        if (e.getSource().equals(mExitMenuItem)) {
            //close
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
