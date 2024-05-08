package Github_200days.OOP.black;

public enum Rank {
    //one available method is
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public int getValue() {
        //ths - instance of an ob we are working with, whichever of above constants
        return switch(this){
            //if jack queen king map to 10
            case JACK, QUEEN, KING -> 10;
            //anything else use ordinal+1
            default -> ordinal()+1;
        };
    }

}
