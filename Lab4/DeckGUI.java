import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;

public class DeckGUI extends JPanel {
    // I set specific dimensions for the cards (in pixels)
    private static final int CARD_WIDTH = 80;  
    private static final int CARD_HEIGHT = 120;

    // The deck of cards in question:
    private Deck deck = new Deck(); // If you say "deck" enough times it stops seeming like a word.
    // hahaha "deck deck deck deck deck"

    public void display() {
        // Display Function here
        for(int i = 0; i < 51; i++) {
            // Iterate through deck

            // Fetch filepath from this card
            String filename = Deck.getDeck(i).getImg();

            // Add ImageIcon from this filepath to the GUI
            try {
                // Load the image file using ImageIO
                File imgFile = new File(filename);
                Image image = ImageIO.read(imgFile);
                
                if (image != null) {
                    // Scale the image to fit in the frame and spread out equally                        Image scaledImage = image.getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH);
                    
                    // Create an ImageIcon from the scaled image
                    ImageIcon cardIcon = new ImageIcon(scaledImage);
                    
                    // Create a JLabel with the card icon
                    JLabel cardLabel = new JLabel(cardIcon);
                    cardLabel.setHorizontalAlignment(JLabel.CENTER);  // Center the card
                        
                    // Add the label to the panel before moving to the next card
                    add(cardLabel);
                    
                } else {
                    System.out.println("Error: Image is null for " + imageName);
                }
            } catch (Exception e) {
                System.out.println("Error loading image: " + imageName); // Exception needed for fileIO
                e.printStackTrace();
            } // End of TryCatch
        } // End of For Loop
    } // End of display()

    
    public DeckGUI() {
        // Set layout for the panel: 4 rows and 13 columns for 52 cards
        setLayout(new GridLayout(4, 13));  // 4 rows (suits) and 13 columns (ranks)
        this.display();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Deck Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.green); //changes the background color
        // Create an instance for the function that grabs the cards and sets the jFrame
        DeckGUI cardPanel = new DeckGUI();
        frame.add(cardPanel);

        // set the dimensions for the frame, adjusting for card grid and size
        frame.setPreferredSize(new Dimension(1300, 600));  // You can adjust the size as needed

        // Create the shuffling button
        JButton shuffleButton = new JButton("Shuffle Deck");
        shuffleButton.addActionListener(new shuffleButtonListener(this, this.deck));
        frame.add(shuffleButton);

        // used pack to fix spacing
        frame.pack();
        frame.setVisible(true);
    }
}
