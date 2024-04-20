
/*

import java.awt.*;*
import java.awt.event.*;*
import javax.swing.*;* //import javax.swing.border.EmptyBorder;
*
import java.sql.*;**

public class FresherSignUp implements ActionListener {
    *
    JFrame f;*
    JLabel l1, l2, l3, l4, l5, l6, l7;*
    JTextField t1, t2, t3, t4, t5, t6, t7;*
    JButton b1, b2, b3, b4;*
    DBMSBackend util = new DBMSBackend();**

   FresherSignUp() {
 * f = new JFrame("Create Account");
 * f.getContentPane().setBackground(new Color(40, 44, 52)); // Set background
 * color
 * f.setLayout(new BorderLayout());
 * f.setSize(1000, 800);
 * f.setLocationRelativeTo(null); // Center the frame on the screen
 * f.setVisible(true);
 * 
 * JPanel fieldsPanel = new JPanel();
 * fieldsPanel.setLayout(new GridBagLayout());
 * fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
 * GridBagConstraints gbc = new GridBagConstraints();
 * gbc.gridx = 0;
 * gbc.gridy = 0;
 * gbc.insets = new Insets(10, 20, 10, 20); // Add padding
 * 
 * l1 = new JLabel("User ID:");
 * l1.setForeground(new Color(125, 125, 255)); // Set font color
 * l1.setFont(new Font("Arial", Font.BOLD, 10)); // Set font
 * fieldsPanel.add(l1, gbc);
 * 
 * gbc.gridy++;
 * t1 = new JTextField();
 * t1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t1.setColumns(8); // Decrease width
 * t1.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t1.setBorder(null); // Set border to null
 * t1.setBackground(Color.WHITE); // Set text field background color
 * t1.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t1, gbc);
 * 
 * gbc.gridy++;
 * l2 = new JLabel("Name:");
 * l2.setForeground(new Color(125, 125, 255)); // Set font color
 * l2.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
 * fieldsPanel.add(l2, gbc);
 * 
 * gbc.gridy++;
 * t2 = new JTextField();
 * t2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t2.setColumns(8); // Decrease width
 * t2.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t2.setBorder(null); // Set border to null
 * t2.setBackground(Color.WHITE); // Set text field background color
 * t2.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t2, gbc);
 * 
 * gbc.gridy++;
 * l3 = new JLabel("Password:");
 * l3.setForeground(new Color(125, 125, 255)); // Set font color
 * l3.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
 * fieldsPanel.add(l3, gbc);
 * 
 * gbc.gridy++;
 * t3 = new JTextField();
 * t3.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t3.setColumns(8); // Decrease width
 * t3.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t3.setBorder(null); // Set border to null
 * t3.setBackground(Color.WHITE); // Set text field background color
 * t3.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t3, gbc);
 * 
 * gbc.gridy++;
 * l4 = new JLabel("Gender:");
 * l4.setForeground(new Color(125, 125, 255)); // Set font color
 * l4.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
 * fieldsPanel.add(l4, gbc);
 * 
 * gbc.gridy++;
 * t4 = new JTextField();
 * t4.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t4.setColumns(8); // Decrease width
 * t4.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t4.setBorder(null); // Set border to null
 * t4.setBackground(Color.WHITE); // Set text field background color
 * t4.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t4, gbc);
 * 
 * gbc.gridy++;
 * l5 = new JLabel("Phone Number:");
 * l5.setForeground(new Color(125, 125, 255)); // Set font color
 * l5.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
 * fieldsPanel.add(l5, gbc);
 * 
 * gbc.gridy++;
 * t5 = new JTextField();
 * t5.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t5.setColumns(8); // Decrease width
 * t5.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t5.setBorder(null); // Set border to null
 * t5.setBackground(Color.WHITE); // Set text field background color
 * t5.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t5, gbc);
 * 
 * gbc.gridy++;
 * l6 = new JLabel("Date of birth:");
 * l6.setForeground(new Color(125, 125, 255)); // Set font color
 * l6.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
 * fieldsPanel.add(l6, gbc);
 * 
 * gbc.gridy++;
 * t6 = new JTextField();
 * t6.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * t6.setColumns(8); // Decrease width
 * t6.setPreferredSize(new Dimension(150, 20)); // Decrease height
 * t6.setBorder(null); // Set border to null
 * t6.setBackground(Color.WHITE); // Set text field background color
 * t6.setForeground(Color.BLACK); // Set text color
 * fieldsPanel.add(t6, gbc);
 * 
 * gbc.gridy++;
 * l7 = new JLabel("Personality Trait");
 * l7.setForeground(new Color(125, 125, 255)); // Set font color
 * l7.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
 * fieldsPanel.add(l7, gbc);
 * 
 * // b3 = new JButton("Introvert");
 * // b3.setBackground(new Color(63, 81, 120)); // Set button color
 * // b3.setForeground(Color.WHITE);
 * // b3.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font
 * // b3.addActionListener(this);
 * // b3.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
 * // f.add(b3);
 * // // f.add(buttonPanel, BorderLayout.CENTER);
 * 
 * // b4 = new JButton("Extrovert");
 * // b4.setBackground(new Color(63, 81, 120)); // Set button color
 * // b4.setForeground(Color.WHITE);
 * // b4.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font
 * // b4.addActionListener(this);
 * // b4.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
 * // f.add(b4);
 * // // f.add(buttonPanel, BorderLayout.CENTER);
 * 
 * JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
 * buttonPanel.setBackground(new Color(40, 44, 52)); // Set background color
 * 
 * b1 = new JButton("Back");
 * b1.setBackground(new Color(63, 81, 120)); // Set button color
 * b1.setForeground(Color.WHITE);
 * b1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * b1.addActionListener(this);
 * b1.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
 * buttonPanel.add(b1);
 * f.add(buttonPanel, BorderLayout.SOUTH);
 * 
 * b2 = new JButton("Sign Up");
 * b2.setBackground(new Color(63, 81, 120)); // Set button color
 * b2.setForeground(Color.WHITE);
 * b2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font
 * b2.addActionListener(this);
 * b2.setUI(new RoundedCornerButtonUI()); // Apply rounded corner UI
 * buttonPanel.add(b2);
 * f.add(buttonPanel, BorderLayout.SOUTH);
 * 
 * }***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;

public class FresherSignUp implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2, b3, b4;
    DBMSBackend util = new DBMSBackend();

    FresherSignUp() {
        f = new JFrame("Create Account");
        f.getContentPane().setBackground(new Color(240, 248, 255)); // Set background color
        f.setLayout(new BorderLayout());
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null); // Center the frame on the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        l1 = new JLabel("User ID:");
        l1.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField(10);
        fieldsPanel.add(t1, gbc);

        gbc.gridy++;
        l2 = new JLabel("Name:");
        l2.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l2, gbc);

        gbc.gridy++;
        t2 = new JTextField(10);
        fieldsPanel.add(t2, gbc);

        gbc.gridy++;
        l3 = new JLabel("Password:");
        l3.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l3, gbc);

        gbc.gridy++;
        t3 = new JPasswordField(10);
        fieldsPanel.add(t3, gbc);

        gbc.gridy++;
        l4 = new JLabel("Gender:");
        l4.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l4, gbc);

        gbc.gridy++;
        t4 = new JTextField(10);
        fieldsPanel.add(t4, gbc);

        gbc.gridy++;
        l5 = new JLabel("Phone Number:");
        l5.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l5, gbc);

        gbc.gridy++;
        t5 = new JTextField(10);
        fieldsPanel.add(t5, gbc);

        gbc.gridy++;
        l6 = new JLabel("Date of birth:");
        l6.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l6, gbc);

        gbc.gridy++;
        t6 = new JTextField(10);
        fieldsPanel.add(t6, gbc);

        gbc.gridy++;
        l7 = new JLabel("Personality Traits:");
        l7.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l7, gbc);

        // Creating a panel for buttons b3 and b4
        JPanel traitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        traitButtonPanel.setBackground(new Color(40, 44, 52)); // Set background color

        gbc.gridy++;
        fieldsPanel.add(traitButtonPanel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(40, 44, 52)); // Set background color

        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK); // Set button color
        b1.setForeground(Color.black); // Set text color
        b1.addActionListener(this);
        buttonPanel.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBackground(Color.BLACK); // Set button color
        b2.setForeground(Color.black); // Set text color
        b2.addActionListener(this);
        buttonPanel.add(b2);

        f.add(fieldsPanel, BorderLayout.CENTER);
        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }

    // String user_id = t1.getText();

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
        }

        // if (ae.getSource() == b3) {
        // String user_id = t1.getText();

        // String query = String.format("INSERT INTO Freshman (user_id,
        // personality_traits)" + "VALUES ('%s', '%s');",
        // user_id, "Introvert");
        // int aa;
        // try {
        // ConnectionClass obj = new ConnectionClass();
        // aa = obj.stm.executeUpdate(query);
        // if (aa == 1) {
        // JOptionPane.showMessageDialog(null, "Details entered successfully!!");
        // } else {
        // JOptionPane.showMessageDialog(null, "Oops,Try Again.");
        // }
        // } catch (SQLException e1) {
        // e1.printStackTrace();
        // }
        // }

        // if (ae.getSource() == b4) {
        // String user_id = t1.getText();

        // String query = String.format("INSERT INTO Freshman (user_id,
        // personality_traits)" + "VALUES ('%s', '%s');",
        // user_id, "Extrovert");
        // int aa;
        // try {
        // ConnectionClass obj = new ConnectionClass();
        // aa = obj.stm.executeUpdate(query);
        // if (aa == 1) {
        // JOptionPane.showMessageDialog(null, "Details entered successfully!!");
        // } else {
        // JOptionPane.showMessageDialog(null, "Oops,Try Again.");
        // }
        // } catch (SQLException e1) {
        // e1.printStackTrace();
        // }
        // }
    }
    // public class PersonalityTrait extends FresherSignUp {
    // JFrame f1;
    // JLabel l8, l9;
    // JButton b8, b9;
    // DBMSBackend util = new DBMSBackend();

    // PersonalityTrait() {
    // f1 = new JFrame("Create Account");

    // f1.getContentPane().setBackground(new Color(240, 248, 255)); // Set
    // background color
    // f1.setLayout(new BorderLayout());

    // f1.setSize(400, 500);
    // f.setLocationRelativeTo(null); // Center the frame on the screen
    // f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // JPanel traitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    // traitButtonPanel.setBackground(new Color(40, 44, 52)); // Set background
    // color

    // b8 = new JButton("Introvert");
    // b8.setBackground(Color.BLACK); // Set button color
    // b8.setForeground(Color.black); // Set text color
    // b8.addActionListener(this);
    // traitButtonPanel.add(b8);

    // b9 = new JButton("Extrovert");
    // b9.setBackground(Color.BLACK); // Set button color
    // b9.setForeground(Color.black); // Set text color
    // b9.addActionListener(this);
    // traitButtonPanel.add(b9);
    // }

    // public void actionPerformed(ActionEvent ae) {
    // if (ae.getSource() == b8) {

    // String query = String.format(
    // "INSERT INTO Freshman (user_id, personality_traits)" + "VALUES ('%s',
    // '%s');",
    // user_id, "Introvert");
    // int aa;
    // try {
    // ConnectionClass obj = new ConnectionClass();
    // aa = obj.stm.executeUpdate(query);
    // if (aa == 1) {
    // JOptionPane.showMessageDialog(null, "Details entered successfully!!");
    // } else {
    // JOptionPane.showMessageDialog(null, "Oops,Try Again.");
    // }
    // } catch (SQLException e1) {
    // e1.printStackTrace();
    // }
    // }
    // if (ae.getSource() == b9)

    // {
    // String query = String.format(
    // "INSERT INTO Freshman (user_id, personality_traits)" + "VALUES ('%s',
    // '%s');",
    // user_id, "Extrovert");
    // int aa;
    // try {
    // ConnectionClass obj = new ConnectionClass();
    // aa = obj.stm.executeUpdate(query);
    // if (aa == 1) {
    // JOptionPane.showMessageDialog(null, "Details entered successfully!!");
    // } else {
    // JOptionPane.showMessageDialog(null, "Oops,Try Again.");
    // }
    // } catch (SQLException e1) {
    // e1.printStackTrace();
    // }
    // }
    // }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PersonalityTrait();
            }
        });
    }
};
