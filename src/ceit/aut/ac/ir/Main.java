package ceit.aut.ac.ir;

import ceit.aut.ac.ir.gui.CFrame;

import javax.swing.*;

/**
 * this program is a simulation of notepad
 * @author  maedemirzazadeh
 */
public class Main {

    public static void main(String[] args) {

        CFrame frame = new CFrame("iNote");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
