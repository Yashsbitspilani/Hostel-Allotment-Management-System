import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class CreateWing implements ActionListener {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);
    final private Font labelFont = new Font("Arial", Font.BOLD, 24);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color buttonColor = new Color(63, 81, 120);

    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    DBMSBackend util = new DBMSBackend();

    CreateWing() {
        f = new JFrame("Create a wing");
        f.setLayout(new BorderLayout());
        f.getContentPane().setBackground(backgroundColor);
        f.setSize(1000, 800); 
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setVisible(true);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridBagLayout());
        fieldsPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 10, 20); // Add padding

        l1 = new JLabel("Wing ID:");
        l1.setForeground(foregroundColor);
        l1.setFont(labelFont);
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField();
        t1.setFont(mainFont);
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t1, gbc);

        gbc.gridy++;
        l2 = new JLabel("Wing Rep. Name:");
        l2.setForeground(foregroundColor);
        l2.setFont(labelFont);
        fieldsPanel.add(l2, gbc);

        gbc.gridy++;
        t2 = new JTextField();
        t2.setFont(mainFont);
        t2.setColumns(8); // Decrease width
        t2.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t2.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t2, gbc);

        gbc.gridy++;
        l3 = new JLabel("Capacity:");
        l3.setForeground(foregroundColor);
        l3.setFont(labelFont);
        fieldsPanel.add(l3, gbc);

        gbc.gridy++;
        t3 = new JTextField();
        t3.setFont(mainFont);
        t3.setColumns(8); // Decrease width
        t3.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t3.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t3, gbc);

        gbc.gridy++;
        l4 = new JLabel("Hostel Pref. 1:");
        l4.setForeground(foregroundColor);
        l4.setFont(labelFont);
        fieldsPanel.add(l4, gbc);

        gbc.gridy++;
        t4 = new JTextField();
        t4.setFont(mainFont);
        t4.setColumns(8); // Decrease width
        t4.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t4.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t4, gbc);

        gbc.gridy++;
        l5 = new JLabel("Hostel Pref. 2:");
        l5.setForeground(foregroundColor);
        l5.setFont(labelFont);
        fieldsPanel.add(l5, gbc);

        gbc.gridy++;
        t5 = new JTextField();
        t5.setFont(mainFont);
        t5.setColumns(8); // Decrease width
        t5.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t5.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t5, gbc);

        gbc.gridy++;
        l6 = new JLabel("Hostel Pref. 3:");
        l6.setForeground(foregroundColor);
        l6.setFont(labelFont);
        fieldsPanel.add(l6, gbc);

        gbc.gridy++;
        t6 = new JTextField();
        t6.setFont(mainFont);
        t6.setColumns(8); // Decrease width
        t6.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t6.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t6, gbc);

        gbc.gridy++;
        l7 = new JLabel("Status:");
        l7.setForeground(foregroundColor);
        l7.setFont(labelFont);
        fieldsPanel.add(l7, gbc);

        gbc.gridy++;
        t7 = new JTextField();
        t7.setFont(mainFont);
        t7.setColumns(8); // Decrease width
        t7.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t7.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t7, gbc);

        f.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(backgroundColor);

        b1 = new JButton("Back");
        b1.setBackground(buttonColor);
        b1.setForeground(Color.WHITE);
        b1.setFont(mainFont);
        b1.addActionListener(this);
        b1.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b1);

        b2 = new JButton("Register");
        b2.setBackground(buttonColor);
        b2.setForeground(Color.WHITE);
        b2.setFont(mainFont);
        b2.addActionListener(this);
        b2.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b2);

        f.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            String wing_ID = t1.getText();
            String status = t7.getText();
            String capacity = t3.getText();
            String wing_representative = t2.getText();
            String preference1 = t4.getText();
            String preference2 = t5.getText();
            String preference3 = t6.getText();

            try {
                if (util.InsertWing(wing_ID, wing_representative, capacity, preference1, preference2, preference3, status) == 1) {
                    JOptionPane.showMessageDialog(null, "Wing created successfully");
                    f.dispose();
                    new UserHome();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == b1) {
            f.dispose();
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

    public static void main(String[] args) {
        new CreateWing();
    }
}
