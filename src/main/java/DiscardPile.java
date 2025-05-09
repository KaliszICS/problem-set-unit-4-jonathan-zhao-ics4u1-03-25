import java.util.ArrayList;
// //DONE ON VS CODE FIRST AND THEN COPIED AND PASTED MY CODE HERE

 /* final class Main {
     public static void main(String[] args) {
        DiscardPile discardPile = new DiscardPile();
        Card card1 = new Card("Ace", "Hearts", 1);
        Card card2 = new Card("King", "Hearts", 2);
        Card card3 = new Card("Queen", "Hearts", 3);
        Card card4 = new Card("Jack" , "Hearts", 4);
        Card card5 = new Card("9", "Spades", 5);
        Card[] cards = {card1, card2, card3, card4, card5};
        discardPile = new DiscardPile(cards); // creates a new discard pile with the cards in the array
        System.out.println(discardPile); // prints out the discard pile, java autoimatically calls the toString method of the DiscardPile class
        System.out.println("Discard pile size: " + discardPile.size()); // Output: Discard pile size: 4
        discardPile.removeAll(); // removes all cards from the discard pile
        System.out.println(discardPile.size());;
    }
}
    
*/
public class DiscardPile {
  // instance variables
    // ArrayList of cards that the discard pile contains
    private ArrayList<Card> discardPile;

    /**
     * Constructor for DiscardPile class
     * @param cardArray
     * Takes in an array of cards and sets it as the discard pile.
     */
    public DiscardPile(Card[] cardArray) {
        discardPile = new ArrayList<>();
        for(Card card1 : cardArray) {
            if(card1 != null) {
                discardPile.add(card1);
            }
        }
     }

     /**
      * Constructor for DiscardPile class
      * Creates an empty discard pile.
      */
     public DiscardPile() {
        discardPile = new ArrayList<>();
     }

     /**
      * Getter for discard pile
      * @return returns the discard pile as an array of cards
      */

     public Card[] getDiscardPile() {
        return discardPile.toArray(new Card[0]); // Converts ArrayList to array and sets the size of the new array to 0
    }

    /**
     * Getter for the discard pile size
     * @return returns the size of the discard pile
     */
    public int size() {
        return discardPile.size();
    }

    /**
     * Adds a card orovided to the discard pile 
     * @param card
     */
    public void addCard(Card card) {
        discardPile.add(card);
    }

    /**
     * Removes a specified card from the discard pile 
     * @param card
     */
    public Card removeCard(Card card) {
        if(discardPile != null) {
            boolean remove = discardPile.remove(card);
            if(remove) {
                return card;
            }
            
        }
        return null;
        
    }

    /**
     * Removes all cards from the discard pile 
     * if discard Pile is null, creates a new ArrayList
     */
    public Card[] removeAll() {
        if (discardPile == null) {
            return new Card[0];
        }
        
        Card[] removedCards = discardPile.toArray(new Card[0]);
        discardPile.clear();
        return removedCards;
    }
    

    /**
     * toString method for the DiscardPile class
     * @return returns the cards in the discard pile in the format "card1, card2, card3..."
     */
    @Override
    public String toString() {
        if(discardPile.isEmpty()) {
            return "";
        }

        String result = "";
            for(int i = 0; i < discardPile.size(); i++) {
                result += discardPile.get(i).toString();
                if(i < discardPile.size() - 1) { // checks if the current index is not the last index of the array
                    result += ", "; 
                } else {
                    result += "."; // adds a period at the end of the string
                }
            }           
            return result;
        }

    }


