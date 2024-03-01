/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pl.polsl.Chmist.Mikolaj.ex1.model.Obstacle;

/**
 * Tests made for obstacle class
 * @author Mikolaj Chmist
 * @version 1.0
 */
public class ObstacleTest {
    /**
     * Checks if constructor of the class works properly
     */
    @Test
    public void constructorTest(){
        //Given
        Obstacle obstacle = new Obstacle(2,3);
        //Then
        assertEquals(obstacle.getX(),2);
        assertEquals(obstacle.getY(),3);
    }
}
