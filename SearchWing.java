import java.sql.*;
import javax.swing.*;

public class SearchWing {
    // centralised searching for driver data
    private String wing_id;
    //private String room_capacity;
    //private String user_id;
    private String status;
    private String hostel_id;
    private String wing_capacity;


    SearchWing(String wing_id) {
        String query1 = "SELECT * FROM Wing where wing_id like '" +
                wing_id + "'";
        ResultSet rs;
        try {
            ConnectionClass obj = new ConnectionClass();
            rs = obj.stm.executeQuery(query1);
            if (rs.next()) {
                wing_id = rs.getString("wing_id");
                //room_capacity = rs.getString("room_capacity");
                //user_id = rs.getString("user_id");
                status = rs.getString("status");
                hostel_id = rs.getString("hostel_id");
                //room_no = rs.getString("room_no");
                wing_capacity = rs.getString("wing_capacity");
                JOptionPane.showMessageDialog(null, status);
            } else {
                JOptionPane.showMessageDialog(null, "No such wing found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String get_wing_id() {
        return wing_id;
    }

    // public String get_room_capacity() {
    //     return room_capacity;
    // }

    // public String get_user_id() {
    //     return user_id;
    // }

    public String get_status() {
        return status;
    }

    // public String get_room_no() {
    //     return room_no;
    // }

    public String get_hostel_id() {
        return hostel_id;
    }

    public String get_wing_capacity() {
        return wing_capacity;
    }

}

