package Github_200days.OOP.black;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class RankTest {

    @Test
   public void getValueOfKing(){
        //Rank KING = new Rank("KING");
        //Rank QUEEN = new Rank("QUEEN");
        //Rank JACK = new Rank("JACK");
        assertEquals(10,Rank.KING.getValue());
    }

}