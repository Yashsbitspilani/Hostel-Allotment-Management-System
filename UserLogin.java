import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class UserLogin implements ActionListener {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 30);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color buttonColor = new Color(63, 81, 120);

    JFrame f;
    JLabel l2, l3;
    JTextField t1, t2;
    JPasswordField pf1;
    JButton b1, b2, b3;
    DBMSBackend util = new DBMSBackend();

    UserLogin() {
        f = new JFrame("Login Account");
        f.setBackground(backgroundColor);
        f.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        l2 = new JLabel("Login Account");
        l2.setForeground(foregroundColor);
        l2.setFont(mainFont);
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(backgroundColor);
        labelPanel.add(l2);
        f.add(labelPanel, BorderLayout.NORTH);

        l3 = new JLabel("User ID : ");
        l3.setForeground(foregroundColor);
        l3.setFont(mainFont);
        gbc.gridy = 1;
        panel.add(l3, gbc);

        t1 = new JTextField(20);
        t1.setFont(mainFont);
        t1.setPreferredSize(new Dimension(300, 40));
        t1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        gbc.gridx = 1;
        panel.add(t1, gbc);

        JLabel l4 = new JLabel("Password : ");
        l4.setForeground(foregroundColor);
        l4.setFont(mainFont);
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(l4, gbc);

        pf1 = new JPasswordField(20);
        pf1.setFont(mainFont);
        pf1.setPreferredSize(new Dimension(300, 40));
        pf1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        gbc.gridx = 1;
        panel.add(pf1, gbc);

        f.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(backgroundColor);

        b1 = new JButton("Login");
        b1.setForeground(Color.WHITE);
        b1.setBackground(buttonColor);
        b1.setFont(mainFont.deriveFont(Font.BOLD, 20));
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b1.setFocusPainted(false); // Remove focus border
        b1.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b1.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b1);

        b2 = new JButton("Sign up");
        b2.setForeground(Color.WHITE);
        b2.setBackground(buttonColor);
        b2.setFont(mainFont.deriveFont(Font.BOLD, 20));
        b2.addActionListener(this);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b2.setFocusPainted(false); // Remove focus border
        b2.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b2.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b2);

        b3 = new JButton("Back");
        b3.setForeground(Color.WHITE);
        b3.setBackground(buttonColor);
        b3.setFont(mainFont.deriveFont(Font.BOLD, 20));
        b3.addActionListener(this);
        b3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b3.setFocusPainted(false); // Remove focus border
        b3.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b3.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b3);

        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setVisible(true);
        f.getContentPane().setBackground(backgroundColor);
        f.setSize(1000,800);
        f.setResizable(true);
        f.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            try {
                String user_id = t1.getText();
                String password = new String(pf1.getPassword());

                if (user_id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    if (util.LoginStudent(user_id, password) == 1) {
                        f.dispose();
                        new UserHome();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ee.getSource() == b2) {
            f.dispose();
            new UserSignUp();
        } else if (ee.getSource() == b3) {
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
