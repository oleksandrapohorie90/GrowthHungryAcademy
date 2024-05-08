package Github_200days.OOP.black;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfATwoCard(){
    Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
    assertEquals(2,card1.getValue());
    }

    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfAThreeCard(){
        Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);
        assertEquals(3,card1.getValue());
    }

    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfAnAceCard(){
        Card card1 = new Card(Suit.DIAMONDS, Rank.ACE);
        assertEquals(1,card1.getValue());
    }
    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfAJackCard(){
        Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);
        assertEquals(10,card1.getValue());
    }

    @Test //Ctrl+Shift+R to run the test
    public void canGetValueOfAKingCard(){
        Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);
        assertEquals(10,card1.getValue());
    }

}