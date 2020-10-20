package com.licly.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/20
 */
public class MyButton extends JFrame {

    private JButton b1 = new JButton("btn1");
    private JButton b2 = new JButton("btn2");
    private JTextField textField = new JTextField(10);
    ActionListenerImpl listener = new ActionListenerImpl();

    public MyButton() {
        b1.addActionListener(e -> {
            System.out.println(e.getSource());
        });
        b2.addActionListener(listener);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(textField);
    }

    public static void main(String[] args) {
        MyButton button = new MyButton();
        SwingConsole.run(button, 500, 800);
    }

    class ActionListenerImpl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            textField.setText(name);
        }
    }
}
