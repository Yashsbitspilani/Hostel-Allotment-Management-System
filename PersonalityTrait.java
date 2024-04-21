import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PersonalityTrait implements ActionListener {
    JFrame f1;
    JLabel l1;
    JButton b8, b9;
    JTextField t1;
    DBMSBackend util = new DBMSBackend();

    final int pad = 50;

    final int tx = 200;
    final int ty = 25;
    final int tw = 150;
    final int th = 35;

    final int lx = 50;
    final int ly = 20;
    final int lw = 150;
    final int lh = 50;

    public PersonalityTrait() {
        f1 = new JFrame("Set Personality Trait");

        f1.getContentPane().setBackground(new Color(40, 44, 52)); // Set background color
        f1.setLayout(new BorderLayout());
        f1.setSize(400, 500);
        f1.setLocationRelativeTo(null); // Center the frame on the screen
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        l1 = new JLabel("User ID:");
        l1.setForeground(Color.WHITE); // Set label text color to white
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t1, gbc);

        f1.add(fieldsPanel, BorderLayout.CENTER);

        JPanel traitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        traitButtonPanel.setBackground(new Color(40, 44, 52)); // Set background color

        b8 = new JButton("Introvert");
        b8.setBackground(new Color(63, 81, 120)); // Set button color
        b8.setForeground(Color.WHITE); // Set text color
        b8.setFont(new Font("Arial", Font.PLAIN, 20));
        b8.addActionListener(this);
        b8.setUI(new RoundedCornerButtonUI());
        traitButtonPanel.add(b8);

        b9 = new JButton("Extrovert");
        b9.setBackground(new Color(63, 81, 120)); // Set button color
        b9.setForeground(Color.WHITE); // Set text color
        b9.setFont(new Font("Arial", Font.PLAIN, 20));
        b9.addActionListener(this);
        b9.setUI(new RoundedCornerButtonUI());
        traitButtonPanel.add(b9);

        f1.add(traitButtonPanel, BorderLayout.SOUTH);

        // Increase the size of text field t1
        f1.setVisible(true);
        f1.setSize(1000,800); 
        f1.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {

                if (ae.getSource() == b8) {
                    String user_id = t1.getText();
                    String query = String.format(
                            "INSERT INTO Freshman (user_id, personality_traits)" + "VALUES ('%s', '%s');",
                            user_id, "Introvert");
                    int aa;
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        aa = obj.stm.executeUpdate(query);
                        if (aa == 1) {
                            JOptionPane.showMessageDialog(null, "Details entered successfully!!");
                            f1.dispose();
                            new UserLogin();
                        } else {
                            JOptionPane.showMessageDialog(null, "Oops,Try Again.");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                if (ae.getSource() == b9) {
                    String user_id = t1.getText();
                    String query = String.format(
                            "INSERT INTO Freshman (user_id, personality_traits)" + "VALUES ('%s', '%s');",
                            user_id, "Extrovert");
                    int aa;
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        aa = obj.stm.executeUpdate(query);
                        if (aa == 1) {
                            JOptionPane.showMessageDialog(null, "Details entered successfully!!");
                            f1.dispose();
                            new UserLogin();
                        } else {
                            JOptionPane.showMessageDialog(null, "Oops,Try Again.");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        
        };

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
