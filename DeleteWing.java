
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class DeleteWing implements ActionListener {
    static JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2, b3;
    DBMSBackend util = new DBMSBackend();

    DeleteWing() {
        f = new JFrame("Delete Wing");
        f.setLayout(new BorderLayout());
        f.getContentPane().setBackground(new Color(40, 44, 52));
        f.setSize(1000, 800); 
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setVisible(true);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 10, 20); // Add padding

        l1 = new JLabel("Wing ID:");
        l1.setForeground(new Color(125, 125, 255));
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 35)); // Decrease height
        t1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t1, gbc);

        gbc.gridy++;
        l2 = new JLabel("Capacity:");
        l2.setForeground(new Color(125, 125, 255));
        l2.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l2, gbc);

        gbc.gridy++;
        t2 = new JTextField();
        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setColumns(8); // Decrease width
        t2.setPreferredSize(new Dimension(150, 35)); // Decrease height
        t2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t2, gbc);

        gbc.gridy++;
        l3 = new JLabel("Status:");
        l3.setForeground(new Color(125, 125, 255));
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l3, gbc);

        gbc.gridy++;
        t3 = new JTextField();
        t3.setFont(new Font("Arial", Font.PLAIN, 20));
        t3.setColumns(8); // Decrease width
        t3.setPreferredSize(new Dimension(150, 35)); // Decrease height
        t3.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t3, gbc);

        f.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(40, 44, 52));

        b1 = new JButton("Find");
        b1.setBackground(new Color(63, 81, 120));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.addActionListener(this);
        b1.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b1);

        b2 = new JButton("Remove");
        b2.setBackground(new Color(63, 81, 120));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.PLAIN, 20));
        b2.addActionListener(this);
        b2.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b2);

        b3 = new JButton("Back");
        b3.setBackground(new Color(63, 81, 120));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.PLAIN, 20));
        b3.addActionListener(this);
        b3.setUI(new RoundedCornerButtonUI());
        buttonPanel.add(b3);

        f.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            SearchWing s = new SearchWing(t1.getText());
            if (!("").equals(s.get_wing_id())) {
                t1.setText(s.get_wing_id());
                t2.setText(s.get_wing_capacity());
                t3.setText(s.get_status());
                //t4.setText(s.get_user_id());
            } else {
                JOptionPane.showMessageDialog(null, "Wing not registered.");
            }
        } else if (e.getSource() == b2) {
            String query = String.format("Delete from Wing where wing_id = '%s' and capacity = '%s' and status = '%s';",t1.getText(), t2.getText(), t3.getText());
            int aa;
            try {
                ConnectionClass obj = new ConnectionClass();
                aa = obj.stm.executeUpdate(query);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Wing removed.");
                } else {
                    JOptionPane.showMessageDialog(null, "Wing not found. Try Again.");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b3) {
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
        new DeleteWing();
    }
}
