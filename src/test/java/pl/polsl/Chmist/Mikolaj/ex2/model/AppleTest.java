/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex2.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import pl.polsl.Chmist.Mikolaj.ex1.model.Apple;
/**
 * Class with unit tests for an Apple class
 * @author Mikolaj Chmist
 * @version 1.0
 */
public class AppleTest {
    /**
     * Because function randomize makes random falues, it is possible to get false negative on this test
     */
    @Test
    public void randomizeTest(){
        //Given
        Apple apple = new Apple();
        //When
        int x = apple.getX();
        int y = apple.getY();
        apple.randomize();
        //Then
        assertNotEquals(x,apple.getX());
        assertNotEquals(y,apple.getY());
    }
}
