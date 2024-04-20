import java.sql.*;
import javax.swing.*;


public class SearchRoom {
    // centralised searching for driver data
    private String room_capacity;
    //private String user_id;
    private String status;
    private String hostel_id;
    private String room_no;
    //private String wing_capacity;


    SearchRoom(String room_no) {
        String query2 = "SELECT * FROM Room where room_no like '" +
                room_no + "'";
        ResultSet rs;
        try {
            ConnectionClass obj = new ConnectionClass();
            rs = obj.stm.executeQuery(query2);
            if (rs.next()) {
                room_no = rs.getString("room_no");
                room_capacity = rs.getString("room_capacity");
                //user_id = rs.getString("user_id");
                status = rs.getString("status");
                hostel_id = rs.getString("hostel_id");
                //room_no = rs.getString("room_no");
                //wing_capacity = rs.getString("wing_capacity");
                JOptionPane.showMessageDialog(null, status);
            } else {
                JOptionPane.showMessageDialog(null, "No such room found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String get_room_no() {
        return room_no;
    }

    public String get_room_capacity() {
        return room_capacity;
    }

    public String get_status() {
        return status;
    }

    public String get_hostel_id() {
        return hostel_id;
    }


}
