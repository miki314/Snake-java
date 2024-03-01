package pl.polsl.snake;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * TODO:
 * GUI powinno zawierać co najmniej jedną kontrolkę złożoną tj. tabelę lub drzewo (o przewijalnej zawartości),
 * Reakcja na sytuacje wyjątkowe powinna być raportowana w formie graficznej (okno konsoli musi pozostać puste).
 */

import pl.polsl.Chmist.Mikolaj.ex1.view.GameFrame;
/**
 * Main class of the program
 * @author Mikołaj Chmist
 * @version 2.0
 * Changes:
 * Window of the game is within separate thread
 */
public class Snake {
    /**
     * Main function of the game
     * @param args does nothing
     */
    public static void main(String args[]) {
        //javax.swing.SwingUtilities.invokeLater(new Runnable() {
          //  public void run() {
                new GameFrame("Snake");
            //}
        //});
    }
}