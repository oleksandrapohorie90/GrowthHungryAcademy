package Github_200days.OOP.black;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfACard(){
    Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
    assertEquals(2,card1.getValue());
    }

}