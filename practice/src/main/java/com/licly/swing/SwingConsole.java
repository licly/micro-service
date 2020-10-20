package com.licly.swing;

import javax.swing.*;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/20
 */
public class SwingConsole {

    public static void run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(() -> {
            f.setTitle(f.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(width, height);
            f.setVisible(true);
        });
    }
}
