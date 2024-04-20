import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class AdminLogin implements ActionListener {
    final private Font mainFont = new Font("Ariel", Font.PLAIN, 30);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color buttonColor = new Color(63, 81, 120);

    JPanel panel;
    JFrame f;
    JLabel l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JButton b1, b2;
    DBMSBackend util = new DBMSBackend();

    AdminLogin() {
        f = new JFrame("Login Account");
        f.setBackground(backgroundColor);
        f.setLayout(new BorderLayout());

        panel = new JPanel(new GridBagLayout());
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

        l3 = new JLabel("Admin ID : ");
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

        l4 = new JLabel("Username : ");
        l4.setForeground(foregroundColor);
        l4.setFont(mainFont);
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(l4, gbc);

        t2 = new JTextField(20);
        t2.setFont(mainFont);
        t2.setPreferredSize(new Dimension(300, 40));
        t2.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        gbc.gridx = 1;
        panel.add(t2, gbc);

        l5 = new JLabel("Password : ");
        l5.setForeground(foregroundColor);
        l5.setFont(mainFont);
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(l5, gbc);

        t3 = new JPasswordField(20);
        t3.setFont(mainFont);
        t3.setPreferredSize(new Dimension(300, 40));
        t3.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        gbc.gridx = 1;
        panel.add(t3, gbc);

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

        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(buttonColor);
        b2.setFont(mainFont.deriveFont(Font.BOLD, 20));
        b2.addActionListener(this);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Thick bordered edges
        b2.setFocusPainted(false); // Remove focus border
        b2.setPreferredSize(new Dimension(150, 40)); // Smaller button size
        b2.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b2);

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
                String admin_id = t1.getText();
                String name = t2.getText();
                String password = t3.getText();

                if (admin_id.equals("") || name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    f.dispose();
                    new AdminLogin();
                } else {
                    if (util.LoginAdmin(admin_id, name, password) == 1) {
                        new AdminHome();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ee.getSource() == b2) {
            f.setVisible(false);
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
