import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class UpdateRoomDetails implements ActionListener {
    final private Color foregroundColor = new Color(125, 125, 255);
    JFrame f;
    JButton b1, b2, b3;
    DBMSBackend util = new DBMSBackend();

    UpdateRoomDetails() {
        f = new JFrame("Add or Delete Room");
        f.getContentPane().setBackground(new Color(40, 44, 52)); // Light gray background
        f.setLayout(new BorderLayout());

        Font titleFont = new Font("Arial", Font.BOLD, 24);

        // Title label
        JLabel titleLabel = new JLabel("Update Room Details");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(foregroundColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        f.add(titleLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(40, 44, 52)); // Match background color

        // Button to add a new room
        b1 = new JButton("Add Room");
        customizeButton(b1);
        buttonPanel.add(b1);

        // Button to delete an existing room
        b2 = new JButton("Delete Room");
        customizeButton(b2);
        buttonPanel.add(b2);

        // Button to go back to the App Home
        b3 = new JButton("Back");
        customizeButton(b3);
        buttonPanel.add(b3);

        f.add(buttonPanel, BorderLayout.CENTER);

        // Action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        f.setVisible(true);
        f.setSize(1000, 800); // Reduced height
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(63, 81, 120)); // Dark blue button color
        button.setFocusPainted(false);
        button.setUI(new RoundedCornerButtonUI()); // Set rounded corner UI
        button.setPreferredSize(new Dimension(200, 50)); // Button size remains the same
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            new AddRoom();
        } else if (ee.getSource() == b2) {
            new DeleteRoom();
        } else if (ee.getSource() == b3) {
            f.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UpdateRoomDetails();
            }
        });
    }
}

// Custom Button UI for rounded edges
class RoundedCornerButtonUI extends BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setBorderPainted(false); // Remove default border
        b.setContentAreaFilled(false); // Make content area transparent
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
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10); // Rounded corners
    }
}
