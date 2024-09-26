public class Card {
    """
    Card Class
    This class simulates a poker card:
     - suit: integer from 0-3 (inclusive). 0 = Clubs, 1 = Hearts, 2 = Spades, 3 = Diamonds
     - rank: integer from 0-12 (inclusive). Aces are 0, ..., Jack is 10, Queen is 11, King is 12. 
     - id: integer from 0-51 (inclusive), position within a deck object.
     - img: String. file path to the image
    """

    // Default value: First one of the deck, 2 of clubs
    private int suit = 0;
    private int rank = 0;
    private int id = 0;
    private String img = "./CardImages/2C.jpg";

    public static int NEXT_ID = 0;
    
    /**
     * Card()
     * Creates a card when given the suit, rank and file path.
     */
    public Card(int suit, int rank, String img) {
        
        // Assign values from parameters
        this.suit = suit;
        this.rank = rank;
        this.img = img;

        // Assign variable ID
        this.id = NEXT_ID;
        NEXT_ID += 1;
    }

    /**
     * setSuit(int newSuit)
     * Usage: changes this card's suit:
     * 0 = Clubs, 1 = Hearts, 2 = Spades, 3 = Diamonds
     * Input: newSuit (integer from 0 - 4)
     * Output: None
     */
    public void setSuit(int newSuit) {
        this.suit = newSuit;
    }

    /**
     * setSuit(int newSuit)
     * Usage: changes this card's suit:
     * 0 = Clubs, 1 = Hearts, 2 = Spades, 3 = Diamonds
     * Input: newSuit (integer from 0 - 4)
     * Output: None
     */
    public void setRank(int newRank) {
        this.rank = newRank;
    }

    /**
     * setSuit(int newSuit)
     * Usage: changes this card's suit:
     * 0 = Clubs, 1 = Hearts, 2 = Spades, 3 = Diamonds
     * Input: newSuit (integer from 0 - 4)
     * Output: None
     */
    public void setImg(String newImg) {
        this.img = newImg;
    }

    /**
     * getSuit()
     * Usage: Returns this card's suit
     * 0 = Clubs, 1 = Hearts, 2 = Spades, 3 = Diamonds
     * Input: None
     * Output: This card's suit (0 - 3)
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * getRank()
     * Usage: Returns this card's rank
     * Input: None
     * Output: This card's rank (0 - 12)
     */
    public int getRank() {
        return this.suit;
    }

    /**
     * getSuit()
     * Usage: Returns this card's image filepath
     * Input: None
     * Output: This card's desired image filepath
     */
    public int getImg() {
        return this.img;
    }
}