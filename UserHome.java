import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserHome implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6;
    DBMSBackend util = new DBMSBackend();

    UserHome() {
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color buttonColor = new Color(40, 44, 52);
        f = new JFrame("User");
        f.getContentPane().setBackground(new Color(63, 81, 120));
        f.setLayout(new GridLayout(2, 3, 30, 30));

        // Button 1: User Details
        b1 = createButton("User Details", buttonFont, buttonColor);
        f.add(b1);

        // Button 2: Create Wing
        b2 = createButton("Create Wing", buttonFont, buttonColor);
        f.add(b2);

        // Button 3: Join Wing
        b3 = createButton("Join Wing", buttonFont, buttonColor);
        f.add(b3);

        // Button 4: Update Wing
        b4 = createButton("Update Wing", buttonFont, buttonColor);
        f.add(b4);

        // Button 5: View Allotment Details
        b5 = createButton("View Allotment Details", buttonFont, buttonColor);
        f.add(b5);

        // Button 6: Logout
        b6 = createButton("Logout", buttonFont, buttonColor);
        f.add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        f.setSize(1000, 800);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private JButton createButton(String text, Font font, Color color) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        button.setPreferredSize(new Dimension(150, 40));
        button.setUI(new RoundedCornerButtonUI());
        return button;
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            try {
                new UserDetails();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b2) {
            new CreateWing();
        } else if (ee.getSource() == b3) {
            new JoinWing();
        } else if (ee.getSource() == b4) {
            new UpdateWing();
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
