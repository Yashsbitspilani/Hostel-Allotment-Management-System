# Hostel-Allotment-Management-System
HOSTEL MANAGEMENT SYSTEM


SETTING UP OUR DATABASE:
We start with the download and setup of MySQL using 
https://dev.mysql.com/downloads/mysql/

Then, we open the server in our terminal 
and run the following commands to setup our          
database.
In case of encountering issues executing the commands from this file, access the list of commands to be executed in order from the schema.SQL file of the project.


Assumptions:
Based on the provided information, here are some assumptions that can be made about the hostel management system:

1. Freshman and Senior Students: 
    - Freshman students are those who have recently joined the institution and are in their first year.
    - Senior students are those who have been in the institution for more than one year, ranging from the second to the fifth year.
2. Room Allocation:
    - Each student is allocated to a specific room within a hostel.
    - Every room is associated with a hostel and must have at least one student staying in it.
    - Rooms have a capacity limit, indicating the maximum number of students that can be accommodated.

3. Hostel Structure:
    - Hostels may contain multiple wings, defining different sections within the hostel.
    - Each wing is associated with a hostel and may have its own capacity and wing representative.
    - Not all hostels necessarily have wings.

4. Allotment Process:
    - The allotment process assigns students to specific rooms and optionally to wings within the hostel.
    - This process is managed by an admin who oversees the assignment of students to rooms and wings.
    - The allotment process involves specifying check-in and check-out dates for students.

5. Admin Role:
    - Admins play a crucial role in managing the allotment process.
    - Each admin has an admin ID and password for authentication purposes.

6. Student Information:
    - Students have user IDs, passwords, gender, contact numbers, and date of birth stored in the system.
    - They are associated with a specific room within a hostel.
    - Freshman students may have additional attributes such as personality traits.

These assumptions provide a basic understanding of how the hostel management system operates and how the entities and relationships interact within the system.







ER Diagram:


Source: www.lucidchart.com






Relational schema:


Functional dependencies:

1. Student entity:
- user_id -> {password, gender, contact_no, date_of_birth, room_no} 
- password -> {user_id, gender, contact_no, date_of_birth, room_no} 
- room_no -> {user_id, password, gender, contact_no, date_of_birth}

2. Freshman entity:
- No additional functional dependencies beyond those inherited from the Student entity

3. Senior entity:
- No additional functional dependencies beyond those inherited from the Student entity.

4. Room entity:
- room_number -> {room_capacity, hostel_id} 
- hostel_id -> {room_capacity, room_number} 

5. Hostel entity: 
- hostel_id -> {hostel_name} - hostel_name -> {hostel_id} 

6. Wing entity: 
- wing_id -> {wing_representative, capacity, preference_1, preference_2, preference_3, hostel_id} 
- hostel_id -> {wing_representative, capacity, preference_1, preference_2, preference_3, wing_id} 



7. Allotment entity: 
- check-in_date, check-out_date, student_id -> {admin_id, range_of_rooms, capacity, room_id} 
- admin_id -> {check-in_date, check-out_date, student_id, range_of_rooms, capacity, room_id} 

8. Admin entity: 
- admin_id -> {password} - password -> {admin_id}


These functional dependencies represent the relationships between attributes within each entity. They help ensure data integrity by defining how attributes depend on each other within the database schema. 



Normalization:
First Normal Form(1NF): In order to achieve the first normal form (1NF) for the current schema, composite attributes must be eliminated. Since this requirement is already met, the schema is in 1NF. 

Second Normal Form(2NF): To reach the second normal form (2NF), the schema must ensure that all non-key attributes depend on the entire primary key. Since there are no partial dependencies in any of the tables, the schema already meets the requirements for 2NF.

Third Normal Form(3NF): Since there are no transitive dependencies in the model, the model is in 3NF. None of the non-key attributes are dependent on other non-key attributes.

FrontEnd (Swing, Java)
Ensure that the database has been declared properly and there are no errors.
Download the jar file provided inside the project folder and execute it.
Add some dummy data in the database by running the abdc.sql file provided.
You can now book cab rides as the user and see your ride statuses, you can view all of your ride statuses at once.
We have implemented the front end using the GUI library of Java named Swing. Our application starts at the App.java class which presents two options to choose from, UserLogin or AdminLogin. After logging in to either of them, there will be a unique home page. On the User Home Page, you can book a new ride, check the status of all your booked rides, or cancel a ride. On the Admin Home page, you can view Customer Details, view Driver Details, view Cab-Type Details, Add a new Driver, or Add a new Cab Type.

Backend (MySQL)
The file DBMSBackend.java stores all the backend functions that are required for the processing of data. It has separate functions for each query that needs to be executed on the database.

Adding Dummy Data to database
Run the abdc.sql file to add 10 entries to each table in the database.

























































































































































































































https://github.com/Yashsbitspilani/Hostel-Allotment-Management-System
Link to code











































































































































































