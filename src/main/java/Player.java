import java.util.ArrayList;
import java.util.Arrays;
  /* final class Main {
     public static void main(String[] args) {
        Card card1 = new Card("Ace", "Hearts", 1);
        Card card2 = new Card("King", "Diamonds", 2);
        Card card3 = new Card("Queen", "Clubs", 3);
        Card card4 = new Card("Jack", "Spades", 4);
        Card card5 = new Card("9", "Clubs", 5);
        Card[] handcards = {card1, card2, card3, card4};
        
        Player player = new Player("John Doe", 42, handcards);
        Deck deck = new Deck(); // Creates a new deck so that whenever you call the deck class it keeps drawing from this one.
        System.out.println(player); // prints out the player and their hand of cards
        System.out.println("Hand size: " + player.size());
        System.out.println("Player name: " + player.getName()); // Output: Player name: John Doe
        System.out.println("Player age: " + player.getAge()); // Output: Player age: 25
        System.out.println("Player hand: " + Arrays.toString(player.getHand())); // Output: Player hand: [Ace of Hearts, King of Diamonds, Queen of Clubs, Jack of Spades]
        System.out.println("Returned card: " + player.returnCard(card1, new Deck()));
        System.out.println("Player hand after returning: " + Arrays.toString(player.getHand())); // Output: Player hand after returning: [King of Diamonds, Queen of Clubs, Jack of Spades] TF: 4 cards in hand
        System.out.println("Discarded card: " + player.discardCard(card5, new DiscardPile())); // return false because card5 is not included in Card[] handcards array
        System.out.println("Player hand after discarding: " + Arrays.toString(player.getHand())); // Output: Player hand after discarding: [King of Diamonds, Queen of Clubs, Jack of Spades]
        System.out.println("Player hand size after discarding: " + player.size()); // Output: Player hand size after discarding: 3
        deck.shuffle();
        player.draw(deck); // draws a card from the deck and adds it to the player's hand
        System.out.println("Player hand after drawing: " + Arrays.toString(player.getHand())); // Output: Player hand after drawing: [King of Diamonds, Queen of Clubs, Jack of Spades, Ace of Hearts]");
        System.out.println("Player hand size after drawing: " + player.size()); // Output: Player hand size after drawing: 4;
        player.discardCard(card4, new DiscardPile());
        System.out.println("Player hand after discarding: " + Arrays.toString(player.getHand())); // Output: Player hand after discarding: [King of Diamonds, Queen of Clubs, Ace of Hearts]");
        player.draw(deck);
        System.out.println("Player hand after drawing: " + Arrays.toString(player.getHand())); // Output: Player hand after drawing: [King of Diamonds, Queen of Clubs, Ace of Hearts]");
        player.draw(deck);
        System.out.println("Player hand after drawing: " + Arrays.toString(player.getHand())); // Output: Player hand after drawing: [King of Diamonds, Queen of Clubs, Ace of Hearts]");
        //Check how you can get a different draw from deck each time you run the code because currently, it is the same card being drawn each time "Ace of Hearts";
            }
        }
        
      */  


public class Player {
    //instance varibales 

    private String name;
    private int age;
    private ArrayList<Card> hand;
    
    /**
     * Constructor for Player class
     * @param name
     * @param age
     * @param cards
     * hand is an ArrayList of cards that the player has in their hand
     */
    public Player(String name, int age, Card[] cards) {
        this.name = name;
        this.age = age;
        hand = new ArrayList<>();
        for(Card card : cards) {
            if(card != null) {
                hand.add(card);
            }
         }
    }
    
    /**
     * Constructor for Player class
     * @param name
     * @param age
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        hand = new ArrayList<>();
    }

    /**
     * Getter for name
     * @return returns the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for age
     * @return returns the age of the player
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Getter for items in hand
     * @return retuns the cards in the player's hand as an array
     */
    public Card[] getHand() {
        return this.hand.toArray(new Card[0]); // Converts ArrayList to array and sets the size of the new array to 0
    }
    
    /**
     * Getter for the size of the hand
     * @return returns the size of the hand
     */
    public int size() {
            return hand.size();
        }

        /**
         * Adds/draws a card from the deck to the hand of the player as long as the drawn card is not null
         * @param deck
         */
    public void draw(Deck deck) {
        Card drawn = deck.draw();
        if(drawn != null) {
            hand.add(drawn);
        }
    }

    /**
     * Discards a card from the hand of the player to the discard pile as long as the card is in the hand of the player
     * @param card
     * @param discardPile
     * @return
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if(hand.contains(card)) {
            hand.remove(card);
            discardPile.addCard(card);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a card from 
     * @param card
     * @param deck
     * @return returns true if the card is in the hand of the player and false if it is not and adds the card to the deck
     * @return else if the hand does not contain the card, return false
     */
    public boolean returnCard(Card card, Deck deck) {
        if(hand.contains(card)) {
            hand.remove(card);
            deck.addCard(card);
            return true;
        } else {
            return false;
        }
    }

    /**
     * toString method for the Player class
     * * @return returns the name, age, and cards in the hand of the player in the format "name, age, card1, card2, card3..."
     * * @return else if the hand is empty, return "name has no cards in their hand.."
     */
    public String toString() {
        String result = this.name + ", " + this.age + ", ";
        if(hand.isEmpty()) {
            return this.name + " has no cards in their hand..";
        }
        for (int i = 0; i < hand.size(); i++) {
            result += hand.get(i).toString(); // adds the card and returns the string representation (returns the format of the cards "name, age, and the cards in the hand") since we are calling the toString method we created 
            if(i < hand.size() - 1) { // if it isn't the last card, add a comma and space
                result += ", ";
            } else {
                result += "."; // else if it is the last card, add a period  
            }
        }
        return result;
    }
}
    
    

