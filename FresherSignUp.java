import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FresherSignUp implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    DBMSBackend util = new DBMSBackend();

    FresherSignUp() {
        f = new JFrame("Create Account");
        f.getContentPane().setBackground(new Color(240, 248, 255)); // Set background color
        f.setLayout(new BorderLayout());
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 10, 20); // Add padding

        l1 = new JLabel("User ID:");
        l1.setForeground(Color.WHITE); // Set label text color to white
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 35)); // Decrease height
        t1.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add empty border
        fieldsPanel.add(t1, gbc);

        // Add other labels and text fields
        gbc.gridy++;
        l2 = new JLabel("Name:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l2, gbc);

        gbc.gridy++;
        t2 = new JTextField();
        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setColumns(8);
        t2.setPreferredSize(new Dimension(150, 35));
        t2.setBorder(new EmptyBorder(5, 10, 5, 10));
        fieldsPanel.add(t2, gbc);

        gbc.gridy++;
        l3 = new JLabel("Password:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l3, gbc);

        gbc.gridy++;
        t3 = new JPasswordField();
        t3.setFont(new Font("Arial", Font.PLAIN, 20));
        t3.setColumns(8);
        t3.setPreferredSize(new Dimension(150, 35));
        t3.setBorder(new EmptyBorder(5, 10, 5, 10));
        fieldsPanel.add(t3, gbc);

        gbc.gridy++;
        l4 = new JLabel("Gender:");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l4, gbc);

        gbc.gridy++;
        t4 = new JTextField();
        t4.setFont(new Font("Arial", Font.PLAIN, 20));
        t4.setColumns(8);
        t4.setPreferredSize(new Dimension(150, 35));
        t4.setBorder(new EmptyBorder(5, 10, 5, 10));
        fieldsPanel.add(t4, gbc);

        gbc.gridy++;
        l5 = new JLabel("Phone Number:");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l5, gbc);

        gbc.gridy++;
        t5 = new JTextField();
        t5.setFont(new Font("Arial", Font.PLAIN, 20));
        t5.setColumns(8);
        t5.setPreferredSize(new Dimension(150, 35));
        t5.setBorder(new EmptyBorder(5, 10, 5, 10));
        fieldsPanel.add(t5, gbc);

        gbc.gridy++;
        l6 = new JLabel("Date of birth:");
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Arial", Font.BOLD, 24));
        fieldsPanel.add(l6, gbc);

        gbc.gridy++;
        t6 = new JTextField();
        t6.setFont(new Font("Arial", Font.PLAIN, 20));
        t6.setColumns(8);
        t6.setPreferredSize(new Dimension(150, 35));
        t6.setBorder(new EmptyBorder(5, 10, 5, 10));
        fieldsPanel.add(t6, gbc);

        f.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(40, 44, 52)); // Set background color

        b1 = new JButton("Back");
        b1.setBackground(new Color(63, 81, 120));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.addActionListener(this);
        buttonPanel.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBackground(new Color(63, 81, 120));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.PLAIN, 20));
        b2.addActionListener(this);
        buttonPanel.add(b2);

        // Apply rounded border to buttons
        b1.setUI(new RoundedCornerButtonUI());
        b2.setUI(new RoundedCornerButtonUI());

        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setVisible(true);
        
    }

    @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == b1) {
                f.setVisible(false);
                new App();
            } else if (ae.getSource() == b2) {
                String user_id = t1.getText();
                String name = t2.getText();
                String password = t3.getText();
                String gender = t4.getText();
                String phone = t5.getText();
                String dob = t6.getText();
    
                try {
                    if (user_id.equals("") || name.equals("") || password.equals("") ||
                            phone.equals("")
                            || gender.equals("") || dob.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the required fields");
                    } else {
                        if (util.RegisterStudent(user_id, name, password, phone, gender, dob) == 1) {
                            f.dispose();
                            new PersonalityTrait();
                        }
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FresherSignUp();
            }
        });
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
  …
