package Github_200days.OOP.black;

public class Card {
    private String suit;
    private String rank;

    //initialize a newly created object

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public static void main(String[] args) {
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Diamonds", "");
        //int total = card1.plus(card2);
        //Hand hand = new Hand();
        //myHand.add(card1);
        //int total = myHand.getTotal();
    }
}
