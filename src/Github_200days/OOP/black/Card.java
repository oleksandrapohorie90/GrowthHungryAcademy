package Github_200days.OOP.black;

public class Card {

    //changed to ENUM
    private Suit suit;
    private String rank;

    //initialize a newly created object

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Suit.CLUBS, "King");
        Card card2 = new Card(Suit.DIAMONDS, "");
        //int total = card1.plus(card2);
        //Hand hand = new Hand();
        //myHand.add(card1);
        //int total = myHand.getTotal();
    }
}
