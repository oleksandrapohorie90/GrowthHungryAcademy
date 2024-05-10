package Github_200days.OOP.black;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuitTest {
    @Test
    public void heartPrintHeart(){
        assertEquals("\u2665",Suit.HEARTS.toString());
    }

}