/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Chmist.Mikolaj.ex1.model;


import java.util.Date;

/**
 * Class where information about the best 20 games has been stored
 * @author Mikolaj Chmist
 * @version 1.0
 */
public class HighScore{
    /**
     * How many best players show
     */
    private final int TOP_PLAYERS=20;
    /**
     * Are needed to make JTable object
     */
    private Object[][] data = new Object[TOP_PLAYERS][2];
    /**
     * Names of columns in JTable
     */
    private String[] columns = {"Date", "Score"};
    /**
     * Generates dates when score was made
     */
    private final Date date = new Date();
    /**
     * data's array getter
     * @return data array of objects 
     */
    public Object[][] getData() { return data; }
    /**
     * array of columns names getter
     * @return columns array of strings
     */
    public String[] getColumns() { return columns; }
    /**
     * Checks if score made in game is in top scores and if so, replaces existing score
     * @param score Score earned during game
     * @return Place in data array of the score. If game is not in high scores, returns -1
     */
    public int addScore(int score){
        if(score<=(int)data[TOP_PLAYERS-1][1]) return -1;
        int i;
        //Checking how good score is compared to high scores
        for(i=TOP_PLAYERS-1;i>0;i--)
            if(score<=(int)data[i-1][1]) break;
        //Moving every score worse than current by 1
        for(int j=TOP_PLAYERS-1;j<i;j--){
            data[j][1]=data[j-1][1];
            data[j][0]=data[j-1][0];
        }
        data[i][1] = score;
        data[i][0] = date.toString();
        return i;
    }
    /**
     * Object constructor
     */
    public HighScore(){
        for(int i=0;i<TOP_PLAYERS;i++){
            data[i][0]= date.toString();
            data[i][1]=0;
        }
    }
    /**
     * Getter of the score in the array
     * @param pos which position
     * @return pos'th score
     */
    public int getScore(int pos) {return (int)data[pos][1];}
    /**
     * Getter of the date in the array
     * @param pos which position
     * @return pos'thh date
     */
    public String getDate(int pos) {return data[pos][0].toString();}
}
