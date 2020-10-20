package com.licly.swing;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/20
 */
public class TextArea extends JFrame {

    private JButton btn1 = new JButton("add data");
    private JButton btn2 = new JButton("clear data");

    private JTextArea area = new JTextArea(10, 20);

    private Map<String, String> m = new HashMap<String, String>();

    public TextArea() {
        // setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // panel.setPreferredSize(new Dimension(400, 400));

        // area.setBounds(100, 100, 20, 100);
        btn1.setBounds(100, 200, 50, 20);
        btn2.setLocation(200, 200);
        btn2.setSize(50, 20);

        btn1.addActionListener(e -> {
            area.append("one\n");
            area.append("two\n");
            area.append("three\n");
        });

        btn2.addActionListener(e -> {area.setText("");});

        panel.add(btn1);
        panel.add(btn2);

        add(panel);

        // add(btn1);
        // add(btn2);
        // setLayout(new FlowLayout());
        // JScrollPane 内容滚动控制
        // add(new JScrollPane(area));
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 500, 800);
    }

}
