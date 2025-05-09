 //If you want to test the this specific class, uncomment this code and run it and also the Deck Class's class Main Testing code only one calss main can run at a time
  /* final class Main {
     public static void main(String[] args) {
        Card card1 = new Card("King", "Clubs", 12);
        Card card2 = new Card("Queen", "Diamonds", 12);
        Card card3 = new Card("King", "Clubs", 12);

        System.out.println(card1); // Output: Queen of Diamonds
        System.out.println(card1.equals(card2)); // Output: true
        System.out.println(card1.equals(card3)); // Output: false
        System.out.println(card1.getValue());
    }
}
 
*/

public class Card {
    //instance variables
    private String name;
    private String suit;
    private int value;

    /**
     * Constructor for Card class
     * @param name
     * @param suit
     * @param value
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Getter for card name
     * @return returns the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the card suit
     * @return returns the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Getter for the card value
     * @return returns the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * toString method for Card class
     * Formats the cards as a string in the format "name of suit"
     * @return returns the name and suit of the card as a string (e.g. "Ace of Hearts")
     */
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }
    
    /**
     * Equals method for Card class
     * Compares two cards to see if they are equal based on their name, suit, and value
     * @return returns true if the cards are equal, false otherwise
     * obj instanceof Card checks if the object is an instance of the Card class
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Card) {
            Card card = (Card)obj;
            if(this.name.equals(card.getName()) && this.suit.equals(card.getSuit()) && this.value == card.getValue()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

