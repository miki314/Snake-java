/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex2.model;

import pl.polsl.Chmist.Mikolaj.ex1.model.Player;
import pl.polsl.Chmist.Mikolaj.ex1.model.Player.Movement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class with unit tests for a Player class
 * @author Mikolaj Chmist
 * @version 1.0
 */
public class PlayerTest {
    /**
     * Checks if grow function works properly, and size of the snake is incremented
     */
    @Test
    public void growTest(){
        //Giver
        Player p = new Player(0);
        //When
        p.grow();
        //Then
        assertEquals(p.getSize(),4);
    }
    
    /**
     * Checks if snake moves upward when it is told move up
     */
    @Test
    public void moveUpTest(){
        //Given
        Player p = new Player(2);
        //When
        p.move(Movement.UP);
        //Then
        assertEquals(1,p.getY(0));
        assertEquals(2,p.getX(0));
    }
    
    /**
     * Checks if snake moves downward when it is told move down
     */
        @Test
    public void moveDownTest(){
        //Given
        Player p = new Player(2);
        //When
        p.move(Movement.DOWN);
        //Then
        assertEquals(3,p.getY(0));
        assertEquals(2,p.getX(0));
    }
    
    /**
     * Checks if snake moves left when it is told move left
     */
        @Test
    public void moveLeftTest(){
        //Given
        Player p = new Player(2);
        //When
        p.move(Movement.LEFT);
        //Then
        assertEquals(2,p.getY(0));
        assertEquals(1,p.getX(0));
    }
    
    /**
     * Checks if snake moves right when it is told move right
     */
        @Test
    public void moveRightTest(){
        //Given
        Player p = new Player(2);
        //When
        p.move(Movement.RIGHT);
        //Then
        assertEquals(2,p.getY(0));
        assertEquals(3,p.getX(0));
    }
    
    /**
     * Checks if object is constructed correctly
     */
    @Test
    public void constructorTest(){
        //Given, when
        Player p = new Player(4);
        //Then
        assertEquals(4,p.getY(0));
        assertEquals(4,p.getX(0));
        assertEquals(3,p.getX(1));
        assertEquals(2,p.getX(2));
        assertEquals(3,p.getSize());
    }
}
