
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PersonalityTrait implements ActionListener {
    JFrame f1;
    JLabel l1, l8, l9;
    JButton b8, b9;
    JTextField t1;
    DBMSBackend util = new DBMSBackend();

    PersonalityTrait() {

        f1 = new JFrame("Set Personality Trait");

        f1.getContentPane().setBackground(new Color(240, 248, 255)); // Set background color
        f1.setLayout(new BorderLayout());

        f1.setSize(400, 500);
        f1.setLocationRelativeTo(null); // Center the frame on the screen
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(new Color(40, 44, 52)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add paddinJPanel traitButtonPanel = new JPanel(new
                                                 // FlowLayout(FlowLayout.CENTER));

        JPanel traitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        traitButtonPanel.setBackground(new Color(40, 44, 52)); // Set background colortraitButtonPanel.setBackground(new
                                                               // Color(40, 44, 52)); // Set background color
        l1 = new JLabel("User ID:");
        l1.setForeground(Color.WHITE); // Set label text color to white
        fieldsPanel.add(l1, gbc);

        gbc.gridy++;
        t1 = new JTextField(10);
        fieldsPanel.add(t1, gbc);

        b8 = new JButton("Introvert");
        b8.setBackground(Color.BLACK); // Set button color
        b8.setForeground(Color.black); // Set text color
        b8.addActionListener(this);
        traitButtonPanel.add(b8);

        b9 = new JButton("Extrovert");
        b9.setBackground(Color.BLACK); // Set button color
        b9.setForeground(Color.black); // Set text color
        b9.addActionListener(this);
        traitButtonPanel.add(b9);

        f1.add(fieldsPanel, BorderLayout.CENTER);
        f1.add(traitButtonPanel, BorderLayout.SOUTH);

        // Increase the size of text field t1
        f1.setVisible(true);
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

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(new Runnable() {
    // public void run() {
    // new PersonalityTrait();
    // }
    // });
    // }
};