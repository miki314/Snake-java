/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Objects snake cannot touch
 * @author Mikolaj Chmist
 * @version 1.0
 */
public class Obstacle {
    /**
     * Coordinates of the object
     */
    private final int x, y;
    /**
     * Constructot
     * @param x x position of the obstacle
     * @param y y position of the obstacle
     */
    public Obstacle(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Getter of the x variable
     * @return x coordinate of the position
     */
    public int getX() {return x;}
    /**
     * Getter of the y variable
     * @return y coordinate of the position
     */
    public int getY() {return y;}

    /**
     * Tells how to draw the object
     * @param g object able to make graphics
     * @param unitSize size of the single field on the board
     */
    public void draw(Graphics g, int unitSize) {
        g.setColor(Color.red);
        g.fillPolygon(new int[] {x*unitSize, (x+1)*unitSize, (int)((x+0.5)*unitSize)},
                      new int[] {(y+1)*unitSize,(y+1)*unitSize,y*unitSize}, 3);
    }
}
