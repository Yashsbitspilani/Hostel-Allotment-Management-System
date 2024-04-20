import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserSignUp implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    DBMSBackend util = new DBMSBackend();

    UserSignUp() {
        f = new JFrame("Create Account");
        f.getContentPane().setBackground(new Color(40, 44, 52)); // Set background color
        f.setLayout(new BorderLayout());
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setVisible(true);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 10, 20); // Add padding

        l1 = new JLabel("User ID:");
        l1.setForeground(new Color(125, 125, 255)); // Set font color
        l1.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t1.setColumns(8); // Decrease width
        t1.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t1.setBorder(null); // Set border to null
        t1.setBackground(Color.WHITE); // Set text field background color
        t1.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t1, gbc);

        gbc.gridy++;
        l2 = new JLabel("Name:");
        l2.setForeground(new Color(125, 125, 255)); // Set font color
        l2.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l2, gbc);

        gbc.gridy++;
        t2 = new JTextField();
        t2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t2.setColumns(8); // Decrease width
        t2.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t2.setBorder(null); // Set border to null
        t2.setBackground(Color.WHITE); // Set text field background color
        t2.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t2, gbc);

        gbc.gridy++;
        l3 = new JLabel("Password:");
        l3.setForeground(new Color(125, 125, 255)); // Set font color
        l3.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l3, gbc);

        gbc.gridy++;
        t3 = new JTextField();
        t3.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t3.setColumns(8); // Decrease width
        t3.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t3.setBorder(null); // Set border to null
        t3.setBackground(Color.WHITE); // Set text field background color
        t3.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t3, gbc);

        gbc.gridy++;
        l4 = new JLabel("Gender:");
        l4.setForeground(new Color(125, 125, 255)); // Set font color
        l4.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l4, gbc);

        gbc.gridy++;
        t4 = new JTextField();
        t4.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t4.setColumns(8); // Decrease width
        t4.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t4.setBorder(null); // Set border to null
        t4.setBackground(Color.WHITE); // Set text field background color
        t4.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t4, gbc);

        gbc.gridy++;
        l5 = new JLabel("Phone Number:");
        l5.setForeground(new Color(125, 125, 255)); // Set font color
        l5.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l5, gbc);

        gbc.gridy++;
        t5 = new JTextField();
        t5.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t5.setColumns(8); // Decrease width
        t5.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t5.setBorder(null); // Set border to null
        t5.setBackground(Color.WHITE); // Set text field background color
        t5.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t5, gbc);

        gbc.gridy++;
        l6 = new JLabel("Date of birth:");
        l6.setForeground(new Color(125, 125, 255)); // Set font color
        l6.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        fieldsPanel.add(l6, gbc);

        gbc.gridy++;
        t6 = new JTextField();
        t6.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        t6.setColumns(8); // Decrease width
        t6.setPreferredSize(new Dimension(150, 25)); // Decrease height
        t6.setBorder(null); // Set border to null
        t6.setBackground(Color.WHITE); // Set text field background color
        t6.setForeground(Color.BLACK); // Set text color
        fieldsPanel.add(t6, gbc);

        f.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(40, 44, 52)); // Set background color

        b1 = new JButton("Back");
        b1.setBackground(new Color(63, 81, 120)); // Set button color
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        b1.addActionListener(this);
        b1.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
        buttonPanel.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBackground(new Color(63, 81, 120)); // Set button color
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
        b2.addActionListener(this);
        b2.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
        buttonPanel.add(b2);

        f.add(buttonPanel, BorderLayout.SOUTH);
    }

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
                if (user_id.equals("") || name.equals("") || password.equals("") || phone.equals("") || gender.equals("") || dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the required fields");
                } else {
                    if (util.RegisterStudent(user_id, name, password, phone, gender, dob) == 1) {
                        f.dispose();
                        new UserLogin();
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
