package com.palarran.kitesizer.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Swing-based user interface.
 */
public class SwingUI extends JFrame {

    public SwingUI() {
        init();
    }

    /**
     * Initialize user interface.
     */
    private void init() {
        setTitle("Kite Sizer");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Bootup method
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SwingUI ui = new SwingUI();
                ui.setVisible(true);
            }
        });
    }
}
