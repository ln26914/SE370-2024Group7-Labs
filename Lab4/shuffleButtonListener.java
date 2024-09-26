public class shuffleButtonListener implements ActionListener {
    // Class Variables
    private DeckGui deckGUI;
    private Deck deck;

    public shuffleButtonListener(DeckGUI deckGUI, Deck deck) {
        this.deckGUI = deckGUI;
        this.deck = deck;
        
    }

    public void actionPerformed(ActionEvent e) {
        // Peform the shuffling method on the deck.
        deck.shuffle();
        
        // Display the new cards
        deckGUI.display();
    }
}