package at.fhooe.mc.view;

import at.fhooe.mc.controller.MMController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexandergattringer on 08/12/15.
 */
public class SetupDialog extends JDialog implements ActionListener{

    private TextField mWidthField;
    private TextField mHeightField;
    private JButton mOkButton;
    private JButton mCancelButton;

    public SetupDialog(){
        super();
        addComponents();
        pack();
    }

    private void addComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        mOkButton = new JButton("OK");
        mCancelButton = new JButton("Cancel");
        mWidthField = new TextField();
        mHeightField = new TextField();

        mOkButton.addActionListener(this);
        mCancelButton.addActionListener(this);

        panel.add(new JLabel("Height"));
        panel.add(new JLabel("Width"));

        panel.add(mWidthField);
        panel.add(mHeightField);
        panel.add(mOkButton);
        panel.add(mCancelButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mOkButton)){
            if (isValidInput(mWidthField.getText()) && isValidInput(mHeightField.getText())){
                setupGame(Integer.valueOf(mWidthField.getText()), Integer.valueOf(mHeightField.getText()));
                dispose();
            }else{
                //show user input error
                JOptionPane.showMessageDialog(this,
                        "Input has to be between 3 and 10",
                        "Wrong input",
                        JOptionPane.ERROR_MESSAGE);
            }

            return;
        }

        if (e.getSource().equals(mCancelButton)){
            dispose();
        }
    }

    private boolean isValidInput(String input){
        String regex = "^[3-9]{1}$|^10{1}$";

        return input.matches(regex);
    }

    private void setupGame(int width, int height){
        MMController.getInstance().setupPlayfield(width, height);
    }
}
