// import javax.naming.Name;
// import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.sql.*;

public class DBMSBackend {

    ConnectionClass obj;  //class used to create a connection between a java application and a database

    DBMSBackend() {
        obj = new ConnectionClass();
    }


    public int RegisterStudent(String user_id, String name, String password, String phone_number, String gender, String dob) {
        try {
            String q1 = String.format("INSERT INTO Student(user_id, name, password, phone_number, gender, dob) " +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
            user_id, name, password, phone_number, gender, dob);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "User already exists");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int LoginStudent(String user_id, String password) {
        try {
            String q1 = String.format("select * from Student where user_id = '%s' and password = '%s';",user_id, password);
            ResultSet rs = obj.stm.executeQuery(q1);
            if (rs.next()) {
                System.out.println("Login Successful");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login Details");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int LoginAdmin(String admin_id, String name, String password) {
        try {
            String q1 = String.format("select * from Admin where admin_id = '%s' and name = '%s' and password = '%s';",admin_id,name, password);
            ResultSet rs = obj.stm.executeQuery(q1);
            if (rs.next()) {
                System.out.println("Login Successful");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login Details");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String q2 = String.format("Insert into Admin where admin_id = '%s' and name = '%s' and password = '%s';",admin_id,name, password);
            int aa = obj.stm.executeUpdate(q2);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "User already exists");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }


    public int InsertRoom(String room_no, String room_capacity, String hostel_id, String status) {
        try {
            String q1 = String.format("INSERT INTO Room(room_no, room_capacity, hostel_id, status) " +
            "VALUES ('%s', '%s', '%s', '%s');",
            room_no, room_capacity, hostel_id, status);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Room Created Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }

        } 
        // catch (

        // SQLIntegrityConstraintViolationException e) {
        //     JOptionPane.showMessageDialog(null, "Room already exists");
        // } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int UpdateRoom(String room_no, String status, String room_capacity, String hostel_id) {
        try {
            String q1 = String.format("insert into Room where room_no = '%s' and status = '%s' and room_capacity = '%s' and hostel_id = '%s';",room_no ,status, room_capacity, hostel_id);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }

        } 
        // catch (

        // SQLIntegrityConstraintViolationException e) {
        //     JOptionPane.showMessageDialog(null, "Room already exists");
        // } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int InsertHostel(String hostel_name, String status, String hostel_id, String wing_id) {
        int hostel_capacity = 120;
        try {
            String q1 = String.format("insert into Hostel where hostel_name = '%s' and status = '%s' and hostel_id = '%s' and wing_id = '%s' and hostel_capacity = '%d';",hostel_name ,status, hostel_id, wing_id, hostel_capacity);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Hostel Created Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        }
        // catch (

        // SQLIntegrityConstraintViolationException e) {
        //     JOptionPane.showMessageDialog(null, "Hostel already exists");
        // } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int UpdateHostel(String hostel_name, String status, String hostel_id, String wing_id, String hostel_capacity) {
        try {
            String q1 = String.format("insert into Hostel where hostel_name = '%s' and status = '%s' and hostel_id = '%s' and wing_id = '%s';",hostel_name ,status, hostel_id, wing_id);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Hostel Updated Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } 
        catch (
        SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Hostel already exists");
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int InsertWing(String wing_id, String wing_representative, String capacity, 
                String preference1, String preference2, String preference3, String status) {
        try {
            String q1 = String.format("INSERT INTO Wing(wing_id, wing_representative, capacity, preference1, preference2, preference3, status) " +
                           "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                           wing_id, wing_representative, capacity, preference1, preference2, preference3, status);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Wing Created Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } 
        // catch (

        // SQLIntegrityConstraintViolationException e) {
        //     JOptionPane.showMessageDialog(null, "Wing already exists");
        // } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int UpdateWing(String wing_id, String status, String capacity) {
        try {
            String q1 = String.format("INSERT INTO Wing(wing_id, status, capacity) " +
            "VALUES ('%s', '%s', '%s');",
            wing_id, status, capacity);
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Wing Updated Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } 
        // catch (

        // SQLIntegrityConstraintViolationException e) {
        //     JOptionPane.showMessageDialog(null, "Wing already exists");
        // } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int JoinWing(String wing_id, String user_id) {
        try {
            String q2 = String.format("INSERT INTO Wing_members(wing_id, user_id) " +
            "VALUES ('%s', '%s');", wing_id, user_id);
            int aa = obj.stm.executeUpdate(q2);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Wing Updated Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return 0;}}

public int DeleteWing(String wing_id, String status, String capacity) {
        try {
            String q = "DELETE FROM Wing " +
                       "WHERE wing_id = '%s' AND status = '%s' AND capacity = '%s'";
            String q1 = String.format(q, "your_wing_id", "your_status", "your_capacity");
            int aa = obj.stm.executeUpdate(q1);
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Wing Deleted Successfully");
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid details");
                return 0;
            }
        } 
        catch (

        SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Wing already exists");
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}


/*public int Status(String wing_id,String capacity)
{
    int wing_capacity = IntegertoparseInt(capacity);
    SELECT COUNT(*) AS student_count
FROM Students
    WHERE wing_id = 'your_wing_id';
}
*/