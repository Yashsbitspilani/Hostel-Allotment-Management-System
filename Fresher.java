// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// //import java.sql.*;

// public class Fresher extends JFrame {
// private JLabel questionLabel;
// private JRadioButton option1, option2;
// private JButton b1;
// private int questionIndex = 0;

// private String[][] questions = {
// { "QUESTION: Are you an introvert or an extrovert?",

// "A.) I am an introvert.",
// "B.) I am an extrovert"
// }
// // Add more options
// };

// public Fresher() {
// setTitle("Personality Test");
// setSize(400, 200);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// setLayout(new GridLayout(5, 1));

// questionLabel = new JLabel(questions[questionIndex][0]);
// add(questionLabel);

// ButtonGroup optionsGroup = new ButtonGroup();
// option1 = new JRadioButton(questions[questionIndex][1]);
// option2 = new JRadioButton(questions[questionIndex][2]);

// optionsGroup.add(option1);
// optionsGroup.add(option2);

// JPanel optionsPanel = new JPanel();
// optionsPanel.setLayout(new GridLayout(1, 4));
// optionsPanel.add(option1);
// optionsPanel.add(option2);
// // optionsPanel.add(option3);
// // optionsPanel.add(option4);
// // optionsPanel.add(option5);
// // optionsPanel.add(option6);

// add(optionsPanel);

// b1 = new JButton("Next");
// // b2 = new JButton("Exit");
// b1.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// // Handle button click
// // Here you can collect the user's response and move to the next question
// // For simplicity, we are just displaying the next question here
// // if (questionIndex < questions.length - 1) {
// // questionIndex++;
// if (questionIndex < questions.length - 1) {
// questionIndex++;
// questionLabel.setText(questions[questionIndex][0]);
// option1.setText(questions[questionIndex][1]);
// option2.setText(questions[questionIndex][2]);
// // option3.setText(questions[questionIndex][3]);
// // option4.setText(questions[questionIndex][4]);
// // option5.setText(questions[questionIndex][5]);
// // option6.setText(questions[questionIndex][6]);
// } else {
// // End of questions, show results
// JOptionPane.showMessageDialog(null, "Personality Test completed!");
// new UserLogin();
// // Perform analysis and display results
// // Implement your analysis logic here
// }
// // }
// }
// });

// add(b1);

// setVisible(true);
// }

// public static void main(String[] args) {
// SwingUtilities.invokeLater(new Runnable() {
// @Override
// public void run() {
// new Fresher();
// }
// });

// }
// }
