/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Snake player control during game
 * Changes in this version:
 * - Replaced basic arrays with ArrayList class
 * - Added enum type to describe movement
 * @author Mikolaj Chmist
 * @version 2.0
 */
public class Player {
    /**
     * Position of each part
     */
    private final ArrayList<Integer> x, y;
    /**
     * Color of snake's body
     */
    private Color color;
    /**
     * Enum used to describe in which direction snake moves
     */
    public enum Movement{
        /**
         * Move up
         */
        UP,
        /**
         * Move down
         */
        DOWN,
        /**
         * Move left
         */
        LEFT,
        /**
         * Move right
         */
        RIGHT
    }
    /**
     * tells how to draw snake
     * @param g object able to draw geometric objects on the Panel
     * @param squareSize Size of the one unit on window
     */
    public void draw(Graphics g, int squareSize){
        for (int i = 0; i < x.size(); i++) {
            g.setColor(color);
            g.fillRect(x.get(i)*squareSize, y.get(i)*squareSize, squareSize, squareSize);
        }
    }
    
    /**
     * x position getter of the snake's parts of the body
     * @param i which part get (0 = head, the bigger number the further part)
     * @return x position of given part of the body
     */
    public int getX(int i) { return x.get(i); }
    /**
     * y position getter of the snake's parts of the body
     * @param i which part get (0 = head, the bigger number the further part)
     * @return y position of given part of the body
     */
    public int getY(int i) { return y.get(i); }
    /**
     * Size getter of the snake
     * @return How many parts snake's body has
     */
    public int getSize() { return x.size(); }
    /**
     * Makes snake bigger. Used while snake eats an apple.
     */
    public void grow() {
        this.x.add(x.get(x.size()-1));
        this.y.add(y.get(y.size()-1));
    }
    /**
     * Describes movement of the player
     * @param direction What direction should snake move
     */
    public void move(Movement direction){
        for (int i = x.size()-1; i > 0; i--) {
            x.set(i, x.get(i-1));
            y.set(i, y.get(i-1));
        }
        switch(direction){
            case UP-> y.set(0, y.get(0)-1);     //y[0]--;
            case DOWN-> y.set(0, y.get(0)+1);   //y[0]++;
            case LEFT -> x.set(0, x.get(0)-1);  //x[0]--;
            case RIGHT -> x.set(0, x.get(0)+1); //x[0]++;
        }
    }
    /**
     * Construct snake controlled by player
     * @param xy Pass how many parts can fit into board where the game is played
     */
    public Player(int xy){
        this.x = new ArrayList();
        this.y = new ArrayList();
        for (int i = 0; i < 3; i++) {
            this.x.add(xy-i);
            this.y.add(xy);    
        }
        this.color = Color.green;
    }
}
