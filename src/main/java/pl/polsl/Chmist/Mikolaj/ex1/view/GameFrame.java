/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.view;

import javax.swing.*;
/**
 * Window of the game
 * @author Mikołaj Chmist
 * @version 1.0
 */
public class GameFrame extends JFrame {
    /**
     * Canvas when all things are drawn
     */
    private GamePanel panel;
    /**
     * Constructor of the object
     * @param title What name should window has
     */
    public GameFrame(String title) {
        super(title);
        this.panel = new GamePanel();
        this.add(this.panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
