package com.licly.swing;

import javax.swing.*;

/**
 * swing 练习
 *
 * @author licly
 * @date 2020/10/20
 */
public class SwingPractice {

    private static SwingProgram sp;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            sp = new SwingProgram();
        });
    }
}
