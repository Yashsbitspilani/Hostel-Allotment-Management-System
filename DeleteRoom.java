import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class DeleteRoom implements ActionListener {
    final private Color foregroundColor = new Color(125, 125, 255);
    final private Color backgroundColor = new Color(40, 44, 52);
    final private Color buttonColor = new Color(63, 81, 120);
    final private Font labelFont = new Font("Arial", Font.BOLD, 24);
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);

    static JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3, b4;
    DBMSBackend util = new DBMSBackend();

    DeleteRoom() {
        f = new JFrame("Delete Room");
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

        gbc.gridx++;
        t1 = new JTextField();
        t1.setFont(mainFont);
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        l2 = new JLabel("Status:");
        l2.setForeground(foregroundColor);
        l2.setFont(labelFont);
        fieldsPanel.add(l2, gbc);

        gbc.gridx++;
        t2 = new JTextField();
        t2.setFont(mainFont);
        t2.setColumns(8); // Decrease width
        t2.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t2.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        l3 = new JLabel("Capacity:");
        l3.setForeground(foregroundColor);
        l3.setFont(labelFont);
        fieldsPanel.add(l3, gbc);

        gbc.gridx++;
        t3 = new JTextField();
        t3.setFont(mainFont);
        t3.setColumns(8); // Decrease width
        t3.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t3.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t3, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        l4 = new JLabel("Hostel ID:");
        l4.setForeground(foregroundColor);
        l4.setFont(labelFont);
        fieldsPanel.add(l4, gbc);

        gbc.gridx++;
        t4 = new JTextField();
        t4.setFont(mainFont);
        t4.setColumns(8); // Decrease width
        t4.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t4.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t4, gbc);

        f.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(backgroundColor);

        b1 = new JButton("Find");
        b1.setBackground(buttonColor);
        b1.setForeground(Color.WHITE);
        b1.setFont(mainFont);
        b1.addActionListener(this);
        b1.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b1);

        b2 = new JButton("Update");
        b2.setBackground(buttonColor);
        b2.setForeground(Color.WHITE);
        b2.setFont(mainFont);
        b2.addActionListener(this);
        b2.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b2);

        b3 = new JButton("Remove");
        b3.setBackground(buttonColor);
        b3.setForeground(Color.WHITE);
        b3.setFont(mainFont);
        b3.addActionListener(this);
        b3.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b3);

        b4 = new JButton("Back");
        b4.setBackground(buttonColor);
        b4.setForeground(Color.WHITE);
        b4.setFont(mainFont);
        b4.addActionListener(this);
        b4.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b4);

        f.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            SearchRoom s = new SearchRoom(t1.getText());
            if (!("").equals(s.get_room_no())) {
                t1.setText(s.get_room_no());
                t3.setText(s.get_room_capacity());
                t2.setText(s.get_status());
                t4.setText(s.get_hostel_id());
            } else {
                JOptionPane.showMessageDialog(null, "Room not registered.");
     }   } else if (e.getSource() == b2) {
        util.UpdateRoom(t1.getText(), t2.getText(),t3.getText(),t4.getText());
            } else if (e.getSource() == b3) {
                String query = String.format("Delete from Room where room_no = '%s' and room_capacity = '%s';",t1.getText(), t3.getText());
                int aa;
                try {
                    ConnectionClass obj = new ConnectionClass();
                    aa = obj.stm.executeUpdate(query);
                    if (aa == 1) {
                        JOptionPane.showMessageDialog(null, "Room removed.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Room not found. Try Again.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
    }        } else if (e.getSource() == b4) {
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

   
}
