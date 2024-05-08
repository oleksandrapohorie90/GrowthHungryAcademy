package Github_200days.OOP.black;

public class Card {

    //changed to ENUM
    private Suit suit;
    private Rank rank;

    //initialize a newly created object

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Suit.CLUBS, Rank.JACK);
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        //int total = card1.plus(card2);
        //Hand hand = new Hand();
        //myHand.add(card1);
        //int total = myHand.getTotal();
    }

    public int getValue() {
        return 0;
    }
}
