package Github_200days.OOP.black;

public class Card {

    //changed to ENUM
    private Suit suit;
    private Rank rank;

    //initialize a newly created object
    //this belongs to the property field
    public Card(String suit, String rank) {
        this.suit = Suit.valueOf(suit.toUpperCase());
        this.rank = Rank.valueOf(rank.toUpperCase());
    }
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
        Card card3 = new Card(Suit.DIAMONDS, Rank.TEN);
        //int total = card1.plus(card2);
        //Hand hand = new Hand();
        //myHand.add(card1);
        //int total = myHand.getTotal();
        System.out.println(card3);
        System.out.println(card2);
        System.out.println(card1);
    }

    @Override
    public String toString(){
        return
    this.rank.toString().concat(" ").concat(this.suit.toString());
    }
    public int getValue() {
      return this.rank.getValue();
    }

}
