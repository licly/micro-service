package com.licly.swing;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/20
 */
public class SwingProgram extends JFrame {

    public SwingProgram() {
        super("hello swing");
        Label label = new Label("a label");
        add(label);

        JButton but = new JButton();
        but.setText("按钮");
        but.setSize(100, 100);
        add(but);

        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
