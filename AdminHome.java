import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminHome implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6;
    DBMSBackend util = new DBMSBackend();

    AdminHome() {
        f = new JFrame("Admin Home");
        f.getContentPane().setBackground(new Color(63, 81, 120)); // Background color
        f.setLayout(new GridLayout(2, 3, 30, 30)); // Grid layout with 2 rows and 3 columns

        Font buttonFont = new Font("Arial", Font.BOLD, 20); // Button font
        Color buttonColor = new Color(40, 44, 52); // Button color

        // Button 1: Room Details
        b1 = createButton("Room Details", buttonFont, buttonColor);
        b1.addActionListener(this);b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b1.setFocusPainted(false); // Remove focus border
        b1.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b1.setUI(new RoundedCornerButtonUI());
        f.add(b1);

        // Button 2: Student Details
        b2 = createButton("Student Details", buttonFont, buttonColor);
        b2.addActionListener(this);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b2.setFocusPainted(false); // Remove focus border
        b2.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b2.setUI(new RoundedCornerButtonUI());
        f.add(b2);

        // Button 3: Update Room Details
        b3 = createButton("Update Room Details", buttonFont, buttonColor);
        b3.addActionListener(this);
        b3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b3.setFocusPainted(false); // Remove focus border
        b3.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b3.setUI(new RoundedCornerButtonUI());
        f.add(b3);

        // Button 4: Wing Details
        b4 = createButton("Wing Details", buttonFont, buttonColor);
        b4.addActionListener(this);
        b4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b4.setFocusPainted(false); // Remove focus border
        b4.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b4.setUI(new RoundedCornerButtonUI());
        f.add(b4);

        // Button 5: View Allotment Details
        b5 = createButton("View Allotment Details", buttonFont, buttonColor);
        b5.addActionListener(this);
        b5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b5.setFocusPainted(false); // Remove focus border
        b5.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b5.setUI(new RoundedCornerButtonUI());
        f.add(b5);

        // Button 6: Logout
        b6 = createButton("Logout", buttonFont, buttonColor);
        b6.addActionListener(this);
        b6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b6.setFocusPainted(false); // Remove focus border
        b6.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b6.setUI(new RoundedCornerButtonUI());
        f.add(b6);

        f.setSize(1000,800);
        f.setVisible(true);
        f.setLocationRelativeTo(null); // Center the frame on the screen
    }

    private JButton createButton(String text, Font font, Color color) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(color);
        button.setForeground(Color.WHITE); // Text color
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(100, 30)); // Adjusted button size
        return button;
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            try {
                new RoomDetails();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b2) {
            try {
                new StudentDetails();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b3) {
            new UpdateRoomDetails();
        } else if (ee.getSource() == b4) {
            try {
                new WingDetails();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b5) {
            try {
                new AllotmentDetails();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b6) {
            f.dispose();
            new App();
        }
    }
        // Custom Button UI for rounded edges
class RoundedCornerButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        b.setOpaque(false);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
    }
}
}
