/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
/**
 * Class generates apples snake eats.
 * @author Mikołaj Chmist
 * @version 1.0
 */
public class Apple{
    /**
     * Color of the apple
     */
    private Color color;
    /**
     * position of the apple
     */
    private int x,y;
    /**
     * Random number generator.
     */
    private Random random;
    
    /**
     * Makes first apple
     */
    public Apple(){
        this.random = new Random();
        this.randomize();
    }
    
    /**
     * x position getter
     * @return x position of the apple
     */
    public int getX() { return this.x; }
    
    /**
     * y position getter
     * @return y position of the apple
     */
    public int getY() { return this.y; }
    
    /**
     * Randomly changes position and color of the apple
     */
    public void randomize(){
        this.color = new Color(this.random.nextInt(80,255), this.random.nextInt(80,255), this.random.nextInt(80,255));
        this.x = this.random.nextInt(20);
        this.y = this.random.nextInt(20);
    }
    
    /**
     * Tells how and where display the apple
     * @param g Graphics object
     * @param squareSize unit square size
     */
    public void draw(Graphics g, int squareSize){
        g.setColor(color);
        g.fillOval(x*squareSize, y*squareSize, squareSize, squareSize);
    }
}
