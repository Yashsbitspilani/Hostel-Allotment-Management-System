import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, welcomeLabel;
    JButton b1, b2;

    final private Font mainFont = new Font("Arial", Font.BOLD, 36);
    final private Font buttonFont = new Font("Arial", Font.BOLD, 18);
    final private Font welcomeFont = new Font("Arial", Font.BOLD, 28);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color buttonColor = new Color(63, 81, 120);

    App() {
        f = new JFrame("BITS Hostel Management");
        f.setFont(mainFont);

        // Welcome Statement
        welcomeLabel = new JLabel("Welcome to BITS Pilani Hostel Management System");
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(foregroundColor);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        f.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(backgroundColor);

        // Admin Button
        b1 = new JButton("Admin");
        b1.addActionListener(this);
        b1.setFont(buttonFont);
        b1.setForeground(Color.WHITE);
        b1.setBackground(buttonColor);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b1.setFocusPainted(false); // Remove focus border
        b1.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b1.setUI(new RoundedCornerButtonUI()); // Rounded edges
        buttonPanel.add(b1);

        // User Button
        b2 = new JButton("User");
        b2.addActionListener(this);
        b2.setFont(buttonFont);
        b2.setForeground(Color.WHITE);
        b2.setBackground(buttonColor);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b2.setFocusPainted(false); // Remove focus border
        b2.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b2.setUI(new RoundedCornerButtonUI()); // Rounded edges
        buttonPanel.add(b2);

        f.add(buttonPanel, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(backgroundColor);
        f.setSize(1000,800); 
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new AdminLogin();
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            new UserType();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
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
