import java.util;

public class Deck {
    """
    Deck Class:
    This object simulates a deck of cards.
     - deck_: a 52-member array of cards in order. Index to this array to fetch card information.
     - deck: a 52-member integer array. This one should be reordered.
    """
    // Class Variables
    private Card deck_ = Card[52];
    private int deck = int[52];

    /**
     * Deck()
     * Constructor File for the Deck.
     * Does what it says on the can.
     */
    public Deck() {
        // Populate the deck
        for (int i = 0; i < 52; i++) {
            
            // Assign deck value
            deck[i] = i;

            // Assign master deck value
            String filename = Integer.toString(i) + ".jpg"; // Get the new filename
            String filepath = "./CardImages/"+filename; // Create the filepath
            
            deck_[i] = new Card(i % 4, i % 13, filepath); // Populate values into the master deck
        }
    }

    /**
     * shuffle()
     * Randomly reorder the deck.
     * Targets the member "this.deck", the integer array.
     */
    public void shuffle() {

        // Make a new order of the cards
        int numCards = this.deck.length;
        randomize(this.deck, numCards);
        
    }

    /**
     * getDeck(int index)
     * Get the specified card ID value from the main deck.
     * Because I don't know how to use ItemAt and this seems close enough.
     * Returns an integer value.
     */
    public getDeck(int index) {
        return this.deck[i];
    }

    /**
     * cardAt(int index)
     * Get a card from the master deck given the ID.
     */
    public Card cardAt(int index) {
        return this.deck_[i];
    }
}