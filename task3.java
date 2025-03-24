import javax.swing.*;
import java.awt.*;

public class task3 {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Font Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a JLabel
        JLabel label = new JLabel("Hello, Tanvi!");
        label.setHorizontalAlignment(JLabel.CENTER);

        // Change font (Font name, Style, Size)
        Font newFont = new Font("Arial", Font.BOLD, 20);
        label.setFont(newFont);

        // Add label to frame
        frame.add(label);
        frame.setVisible(true);
    }
}
