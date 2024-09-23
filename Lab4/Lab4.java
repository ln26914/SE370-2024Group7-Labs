import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.io.File;

public class Lab4 extends JPanel {
    // Arrays for card ranks and suits with the same lettering as the cards in the file we found
    private static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] SUITS = {"S", "H", "D", "C"};  // S: Spades, H: Hearts, D: Diamonds, C: Clubs
    
    // I set specific dimensions for the cards (in pixels)
    private static final int CARD_WIDTH = 80;  
    private static final int CARD_HEIGHT = 120;
    
    public Lab4() {
        // Set layout for the panel: 4 rows and 13 columns for 52 cards
        setLayout(new GridLayout(4, 13));  // 4 rows (suits) and 13 columns (ranks)
        
        // Loop through each suit and rank combination to maintain order before the reshuffle
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                // Construct the image file name
                String imageName = rank + suit + ".jpg";  // e.g., 2C.jpg, QS.jpg, AH.jpg
                
                try {
                    // Load the image file using ImageIO
                    File imgFile = new File("./Lab4/CardImages/" + imageName);
                    Image image = ImageIO.read(imgFile);
                    
                    if (image != null) {
                        // Scale the image to fit in the frame and spread out equally
                        Image scaledImage = image.getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH);
                        
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
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Deck Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance for the function that grabs the cards and sets the jFrame
        Lab4 cardPanel = new Lab4();
        frame.add(cardPanel);
        
        // set the dimensions for the frame, adjusting for card grid and size
        frame.setPreferredSize(new Dimension(1300, 600));  // You can adjust the size as needed
        
        // used pack to fix spacing
        frame.pack();
        frame.setVisible(true);
    }
}
