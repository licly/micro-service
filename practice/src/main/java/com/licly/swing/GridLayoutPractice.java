package com.licly.swing;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/20
 */
public class GridLayoutPractice extends JFrame {


    public GridLayoutPractice() {
        setLayout(new GridLayout(3, 7));

        for (int i = 0; i < 5; i++) {
            add(new JButton("btn" + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayoutPractice(), 300, 300);
    }
}
