import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class StudentDetails {
    JFrame f;
    JButton b1, b2, b3, b4;
    ConnectionClass c1 = new ConnectionClass();

    StudentDetails() throws SQLException {
        String q1 = "select * from STUDENT";
        ResultSet rs = c1.stm.executeQuery(q1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Vector<String> columnNames = new Vector<String>(columnsNumber);

        for (int column = 1; column <= columnsNumber; column++) {
            columnNames.add(rsmd.getColumnName(column));
        }

        Vector data = new Vector();
        Vector row = new Vector();
        while (rs.next()) {
            row = new Vector(columnsNumber);
            for (int i = 1; i <= columnsNumber; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }

        JFrame frame = new JFrame("BITS Hostel Allotment");
        frame.setSize(500, 400);
        JScrollPane jsp = new JScrollPane(new JTable(data, columnNames));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jsp, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}