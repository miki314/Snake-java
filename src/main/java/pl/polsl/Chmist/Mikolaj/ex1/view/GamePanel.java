/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pl.polsl.Chmist.Mikolaj.ex1.controller.GameLogic;
import pl.polsl.Chmist.Mikolaj.ex1.model.Player.Movement;

import pl.polsl.Chmist.Mikolaj.ex1.model.HighScore;
/**
 * Describes how objects in the game should be displayed
 * Changes in this version:
 * - Used "Movement" enum type to describe movement direction instead of char
 * @author Mikołaj Chmist
 * @version 2.0
 */
public class GamePanel extends JPanel implements ActionListener{
    /**
     * Height and width of the window
     * squareSize: size of the single element on the board
     */
    private final int screenHeight = 800, screenWidth = 800, squareSize = 40;
    /**
     * Botton to play again without quitting program
     */
    private JButton retry;
    
    /**
     * table of scores
     */
    private HighScore score;
    /**
     * Table of scores
     */
    private JTable scores;
    /**
     * In which direction snake should move
     */
    private Movement direction;
    /**
     * true if it isn't game over
     */
    private boolean isRunning;
    /**
     * Timer used to adjust speed of the game
     */
    private Timer timer;
    /**
     * Logic of the game
     */
    private GameLogic logic;
    /**
     * Constructor of the class
     */
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new SnakeKeyAdapter());
        
        //Setting score table
        this.score = new HighScore();
        this.scores = new JTable(score.getData(),score.getColumns());
        this.scores.setPreferredSize(new Dimension(400,400));
        this.add(this.scores);
        
        this.add(this.scores);
        
        //Setting retry button
        this.retry = new JButton("Play again");
        this.retry.setActionCommand("newGame");
        this.retry.setMnemonic('n');    //N as in "New game"
        this.retry.addActionListener(this);
        this.retry.setToolTipText("Press if you want to play this game again");
        this.add(this.retry);
        
        this.newGame();
    }
    
    /**
     * Setting up the game was moved to separate function, so it can be reused i.e. in ActionPerformed method
     */
    public void newGame(){
        this.isRunning = true;
        this.direction = Movement.RIGHT;
        this.logic = new GameLogic(0);//new GameLogic((screenHeight*screenWidth)/squareSize);
        this.retry.setVisible(false);
        this.scores.setVisible(false);
        this.timer = new Timer(250, this);
        this.timer.start();   
    }
    /**
     * Method responsible for painting objects on the window
     * @param g object able to draw needed elements
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(isRunning){
            logic.draw(g, squareSize);
        }
        else{
            this.score.addScore(logic.getScore());
            this.scores.setVisible(true);
            
            this.retry.setFocusable(true);
            this.retry.setVisible(true);
        }
    }

    /**
     * routine of actions done after time described as delay in this class Timer object
     * @param e Action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning){
            logic.move(direction);
            logic.collision();
            logic.eatApple();
            isRunning = !logic.collision();
        }
        else if(e.getActionCommand().equals("newGame")){
            this.newGame();
        }
        repaint();
    }
    
    /**
     * Game controls. You can use arrows or WASD do move.
     */
    private class SnakeKeyAdapter extends KeyAdapter {
        /**
         * Tells how to change direction based on pressed key
         * @param e Event happened when any key is pressed
         */
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP, KeyEvent.VK_W -> {
                    if(direction != Movement.DOWN) direction = Movement.UP;
                }
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {
                    if(direction != Movement.UP) direction = Movement.DOWN;
                }
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                    if(direction != Movement.RIGHT) direction = Movement.LEFT;
                }
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                    if(direction != Movement.LEFT) direction = Movement.RIGHT;
                }
                case KeyEvent.VK_N -> retry.doClick();  //Implementation of the mnemonic
            }
        }
    }
}