package Github_200days.OOP.black;

public enum Rank {
    //one available method is
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);
    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        //ths - instance of an ob we are working with, whichever of above constants
//        return switch(this){
//            //if jack queen king map to 10
//            case JACK, QUEEN, KING -> 10;
//            //anything else use ordinal+1
//            default -> ordinal()+1;
//        };
        return value;
    }
}


