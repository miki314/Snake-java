/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTable;
import pl.polsl.Chmist.Mikolaj.ex1.model.*;
import pl.polsl.Chmist.Mikolaj.ex1.model.Player.Movement;

/**
 * Class responsible for all the game logic and behaviour
 * @author Mikołaj Chmist
 * @version 2.0
 * Changes in this version:
 * - Implements logic related to the new objects of the Obstacle class
 */
public class GameLogic {
    /**
     * Generates apples snake eats during game
     */
    private final Apple apple;
    /**
     * Snake controlled by player
     */
    private final Player player;
    /**
     * List of the obstacles snake must avoid
     */
    private final ArrayList<Obstacle> obstacle;
    /**
     * Used to generate random objects
     */
    private final Random random;
    /**
     * Data about best number of points in different games
     */
    private final HighScore score;
    
    /**
     * Constructor of the object
     * @param x How many square units can be displayed by window. In other words resolution / size of the single square of unit
     */
    public GameLogic(int x){
        this.score = new HighScore();
        this.apple = new Apple();
        this.player = new Player(x);
        this.random = new Random();
        this.obstacle = new ArrayList();
        this.obstacle.add(new Obstacle(random.nextInt(20),random.nextInt(20)));
    }
    /**
     * Checks if snake eats the apple and makes proper acction. If snake grows to any size divided by 10, number of obstacles is incremented
     */
    public void eatApple(){
        if((player.getX(0) == apple.getX()) && (player.getY(0) == apple.getY())){
            player.grow();
            if(player.getSize()%10 == 0) obstacle.add(new Obstacle(random.nextInt(20),random.nextInt(20)));
            apple.randomize();
            for(int i=0;i<player.getSize();i++){
                if(apple.getX() == player.getX(i) && apple.getY() == player.getY(i)){
                    i=0;
                    apple.randomize();
                }
            }
            for(Obstacle o : obstacle)
                if(apple.getX() == o.getX() && apple.getY() == o.getY())
                    o = new Obstacle(random.nextInt(20), random.nextInt(20));
        }
    }
    
    /**
     * Moves the snake.
     * @param direction Where snake moves. U - up, D - down, L - left, R - right
     */
    public void move(Movement direction) {player.move(direction);}
    
    /**
     * Checks if player position results in game over
     * @return true if snake collides with something
     */
    public boolean collision(){
        for(int i=1;i<player.getSize();i++)
            if(player.getX(0) == player.getX(i) && player.getY(0) == player.getY(i)) 
                return true;
        for(Obstacle o : obstacle)
            if(player.getX(0)==o.getX() && player.getY(0)==o.getY())
                return true;
        
        return (player.getX(0)<0 || player.getY(0)<0
                || player.getX(0)>20 || player.getY(0)>20);
    }
    
    /**
     * Tells to draw apple, snake and obstacles
     * @param g Graphics object
     * @param squareSize size of the square unit
     */
    public void draw(Graphics g, int squareSize){
        apple.draw(g, squareSize);
        player.draw(g, squareSize);
        for(Obstacle o : obstacle) o.draw(g, squareSize);
    }
    /**
     * Calculates how many points player earned
     * @return score gained in this session
     */
    public int getScore() {return player.getSize()-3;}
}
