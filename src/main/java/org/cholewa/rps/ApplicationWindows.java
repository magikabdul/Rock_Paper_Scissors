package org.cholewa.rps;

import javax.swing.*;

public class ApplicationWindows {

    public ApplicationWindows() {
        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setBounds(100, 100, 400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
