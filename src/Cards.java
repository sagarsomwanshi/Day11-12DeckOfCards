public class Cards {
    String suit;
    String rank;
    public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
