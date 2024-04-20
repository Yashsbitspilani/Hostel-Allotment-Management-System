import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddRoom implements ActionListener {
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color buttonColor = new Color(63, 81, 120);
    final private Font labelFont = new Font("Arial", Font.BOLD, 24);
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);

    JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    DBMSBackend util = new DBMSBackend();

    AddRoom() {
        f = new JFrame("Add Room");
        f.getContentPane().setBackground(backgroundColor);
        f.setLayout(new BorderLayout());
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

        l1 = new JLabel("Room No:");
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
        l2 = new JLabel("Status:");
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
        l4 = new JLabel("Hostel ID:");
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

        b2 = new JButton("Add Room");
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
            String room_no = t1.getText();
            String status = t2.getText();
            String room_capacity = t3.getText();
            String hostel_id = t4.getText();

            try {
                if (util.InsertRoom(room_no, room_capacity, hostel_id, status) == 1) {
                    JOptionPane.showMessageDialog(null, "Room Added");
                    f.dispose();
                    new AdminHome();
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
        new AddRoom();
    }
}
