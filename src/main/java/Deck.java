import java.util.ArrayList;
import java.util.Random;

    /* final class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        //Card c1 = deck.draw();
        //Card c2 = deck.draw();
        //System.out.println("Drawn cards: " + c1 + ", " + c2);
        //System.out.println("Deck size: " + deck.size()); // output 50
        //Card[] cards = {c1, c2};
        // deck.reShuffle(cards); 
        deck.printDeck(); // prints out the new deck of cards order 
        System.out.println("Deck size: " + deck.size()); // Output: Deck size: 52
        deck.shuffle(); // Shuffle the deck after drawing a card so that each time you run the code you get 2 different cards if you want the same cards remove this line of code
        Card drawnCard = deck.draw();
        Card drawnCard2 = deck.draw();
        Card addCard = new Card("Ace", "Clubs", 1);
        //if you only want to keep one card and just shuffle the deck after drawing a card, do deck.shuffle() after the first drawncard
        System.out.println("Drawn card: " + drawnCard); // Output: Drawn card: [Random card]
        System.out.println("Drawn card 2: " + drawnCard2);
        System.out.println("Add Card: " + addCard); // Output: Add Card: Ace of Hearts);
        System.out.println("Deck size after drawing a card: " + deck.size()); // Output: Deck size after drawing a card: 48
        
    }
}

*/


public class Deck {
    // instance variables
    // ArrayList of cards that the deck contains
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Constructor for Deck class - takes in an array of cards and sets it as the deck 
     * @param cardList
     */
    public Deck(Card[] cardList) {
        for(Card card : cardList) {
            if(card != null) {
                cards.add(card);
            }
        }
    }
    /**
     * Constructor for Deck Class
     * Creates a new deck of cards with 52 cards.
     * The deck contains 4 suits: Hearts, Clubs, Diamonds, and Spades.
     * Each suit contains 13 cards: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, and King.
     */
    public Deck() {
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for(String suit : suits) {  // goes through the suits array
            for(int i = 0; i < names.length; i++) {
                Card card = new Card(names[i], suit, i + 1); // creates a new card with the name, suit, and value. E.g. Ace of Hearts = 1, 2 of Hearts = 2, etc.
                cards.add(card);
            }
        }
     }

     /**
      * Prints out every card in the current deck 
      */
     public void printDeck() {
        for(Card card : cards) {
            System.out.println(card);
        }
     }
    
     /**
      * Getter for the size of the deck
      * @return returns the size of the deck
      * @return returns 0 if the deck is empty 
      */
     public int size() {
        if(cards.isEmpty()) {
            return 0;
        }
        return cards.size();
     }

     /**
      * Draw a card from the deck
      * @return removes the top card from the deck and returns it 
      */
     public Card draw() {
        if(cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(0); 
        }
     }

     /**
      * shuffles the deck of cards 
      * returns void if cards is empty

      */
     public void shuffle() {
        if(cards.isEmpty()) {
            return;
        }
        
        Random random = new Random();
        for(int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // generates a random number between 0 and i 
            Card temp = cards.get(i); // stores the card at index i in a temporary variable
            cards.set(i, cards.get(j)); // sets the card at index i to the card at index j
            cards.set(j, temp); // sets the card at index j to the card stored in the temporary variable
        }
     }

     /**
      * Adds a card to the deck as long as the card is not null
      * @param card
      */
     public void addCard(Card card) {
        if(card != null) {
            cards.add(card);
        }
     }

     /**
      * Reshuffles the Card array ( Adds an array of cards to the deck as long as the card is not null )
      * @param cards
      */
     public void reShuffle(Card[] cards) {
        for(Card card : cards) {
            if(card != null) {
                this.cards.add(card); //adds the og card array to the new deck
            }
        }
        shuffle();
     }
}
    
