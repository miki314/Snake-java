
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.polsl.Chmist.Mikolaj.ex1.model.HighScore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Unit tests of the HighScore class
 * @author Mikolaj Chmist
 */
public class HighScoreTest {
    /**
     * Unit test of the addScore method
     */
    @Test
    public void addScore(){
        //Given
        HighScore score = new HighScore();
        int pos;
        Date date = new Date();
        //When
        pos = score.addScore(3);
        //Then
        assertEquals(3,score.getScore(pos));
        assertEquals(date.toString(),score.getDate(pos));
    }
}
