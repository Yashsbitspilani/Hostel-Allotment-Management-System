CREATE DATABASE DBMSProject;
USE DBMSProject;


/* User Table stores data for all the users that register on the website*/
CREATE TABLE Student (
    user_id INT PRIMARY KEY auto_increment,
    name VARCHAR(50),
    gender VARCHAR(10),
    phone_number VARCHAR(20),
    password VARCHAR(255),
    FOREIGN KEY (room_no) REFERENCES Room(room_no) on update cascade on delete cascade
)AUTO_INCREMENT=1;


CREATE TABLE Admin (
    admin_id INT PRIMARY KEY auto_increment,
    name VARCHAR(50),
    password VARCHAR(255)
)AUTO_INCREMENT=1;


CREATE TABLE Allotment (
    capacity INT,
    room_id INT,
    range_of_rooms INT,
    check_in_date INT,
    check_out_date INT, 
  FOREIGN KEY (admin_id) REFERENCES Admin(admin_id) on update cascade on delete cascade
)AUTO_INCREMENT=1;



CREATE TABLE Wing (
    wing_id INT PRIMARY KEY auto_increment,
    wing_representative VARCHAR(50),
    capacity VARCHAR(20),
    preference1 VARCHAR(20),
    preference2 VARCHAR(20),
    preference3 VARCHAR(20),
    status VARCHAR(20) DEFAULT 'available',
    FOREIGN KEY (type_id) REFERENCES Car_Type(type_id) on update cascade on delete cascade
)AUTO_INCREMENT=1;


/* Stores all the details of the car */
CREATE TABLE Hostel (
    hostel_id INT PRIMARY KEY auto_increment,
    hostel_name VARCHAR(20),
    status VARCHAR(20) DEFAULT 'available',
    FOREIGN KEY (wing_id) REFERENCES Wing(wing_id) on update cascade on delete cascade,
)AUTO_INCREMENT=1;


/* Stores all the details of the ride */
CREATE TABLE Room (
    room_no INT PRIMARY KEY auto_increment,
    room_capacity INT,
    status VARCHAR(20) DEFAULT 'available',
    FOREIGN KEY (hostel_id) REFERENCES Hostel(hostel_id) on update cascade on delete cascade
)AUTO_INCREMENT=1;


INSERT INTO Student (user_id, name, gender, phone_number, password, dob)
VALUES
   ('0' , 'Yash'   ,'M','6887797999','BKaksan','12-01-2004'),
   ('1' ,'Aryan'   ,'M','7897320230','BKaksan','05-02-2004'),
   ('2' ,'Anuj'    ,'M','8204023490','BKJBIdn','21-04-2004'),
   ('3' ,'Nishit'  ,'M','7894457356','Ankjdja','19-06-2004'),
   ('4' ,'Ankur'   ,'M','7779764434','KJHhjka','09-08-2004'),
   ('4' ,'Ankur'   ,'M','7779764434','NODwhqn','14-06-2004'),
   ('5' ,'Rajdeep' ,'M','6875456433','NAkldna','23-09-2004'),
   ('6' ,'Atharv'  ,'M','8776735737','LKnLNDA','26-03-2004'),
   ('7' ,'Harsh'   ,'M','7763567989','nwkjfdD','18-11-2004'),
   ('8' ,'Shreyans','M','7784984997','NDKLnsq','17-07-2004'),
   ('9' ,'Aman'    ,'M','7337357679','DWNqlkn','04-03-2004'),
   ('10','Kalpana' ,'F','8498498499','Saowpoq','20-12-2004');


INSERT INTO Room (room_no, room_capacity, status)
VALUES
   ('134-AK','1', 'available'),
   ('345-RP','1', 'NA'),
   ('256-SR','2', 'available'),
   ('198-VK','2', 'NA');
   ('198-SK','2', 'NA');


INSERT INTO Hostel (hostel_id, hostel_name, status)
VALUES
   ('Ashok', 'available'),
   ('Rana Pratap', 'available'),
   ('Vishwakarma', 'available'),
   ('Bhagirath', 'available'),
   ('SR', 'available'),
   ('Gandhi', 'available'),
   ('Krishna', 'available'),
   ('Shankar', 'available'),
   ('Vyas', 'available'),
   ('Ram', 'available'),
   ('Meera', 'available'),
   ('Budh', 'available'),
   ('Malviya', 'available');


INSERT INTO Wing (wing_id, wing_representative, capacity, preference1, preference2, preference3, status)
VALUES
   ('0','Yash','2','Ashok','Ram','Rana pratap','Available'),
   ('1','Aryan','6','Shankar','Ashok','Vyas','Available'),
   ('2','Anuj','4','Rana pratap','Malviya','Ram','NA'),
   ('3','Nishit','6','Ashok','Vyas','Malviya','NA'),
   ('4','Ankur','2','Vyas','Malviya','Ashok','NA'),
   ('5','Rajdeep','6','Ashok','Rana Pratap','Malviya','NA'),
   ('6','Atharv','4','Vyas','Shankar','Ram','Available'),
   ('7','Harsh','2','Rana pratap','Ashok','Shankar','NA'),
   ('8','Shreyans','2','Vyas','Malviya','Vishwakarma','Available');
   ('9','Aman','4','Vyas','Shankar','Vishwakarma','Available');
   ('10','Kalpana','4','Meera-BlockA','Budh','Meera-BlockB','Available');

INSERT INTO admin_ (admin_id, name, password)
VALUES
   ('0', 'Yash'    ,'BKaksan'),
   ('1', 'Aryan'   ,'BKJBIdn'),
   ('2', 'Anuj'    ,'Ankjdja'),
   ('3', 'Nishit'  ,'KJHhjka'),
   ('4', 'Ankur'   ,'NODwhqn'),
   ('5', 'Rajdeep' ,'NAkldna'),
   ('6', 'Atharv'  ,'LKnLNDA'),
   ('7', 'Harsh'   ,'nwkjfdD'),
   ('8', 'Shreyans','NDKLnsq'),
   ('9', 'Aman'    ,'DWNqlkn'),
   ('10','Kalpana' ,'Saowpoq');


INSERT INTO Allotment (capacity, range_of_rooms, room_no, check_in_date, check_out_date)
VALUES
('368','100-468','345-AK' ,'16-10-2022','16-09-2026'),
('152','100-252','102-VK' ,'16-10-2022','28-09-2026'),
('398','100-498','326-AK' ,'16-10-2022','23-09-2026'),
('392','100-492','432-GN' ,'19-08-2021','21-07-2025'),
('458','100-558','347-CVR','17-08-2019','19-08-2024'),
('400','100-500','493-SK' ,'16-10-2022','18-09-2026'),
('400','100-500','119-SR' ,'14-08-2023','13-08-2027'),
('268','100-368','223-RP' ,'16-10-2022','15-09-2026'),
('258','100-358','337-RP' ,'16-10-2022','17-09-2026'),
('278','100-378','197-KR' ,'19-11-2021','19-07-2025'),
('258','100-358','341-SR' ,'14-08-2023','11-08-2027'),
('400','100-500','452-AK' ,'16-10-2022','13-09-2026');

INSERT INTO Fresher (personality_traits)
VALUES
 ('1'),
 ('13'),
 ('23'),
 ('16'),
 ('14'),
 ('19'),
 ('31'),
 ('18'),
 ('17'),
 ('6');




INSERT INTO Senior (wing_id, wing_representative)
VALUES
    ('0','Yash','2','Ashok','Ram','Rana pratap','Available'),
   ('1','Aryan','6','Shankar','Ashok','Vyas','Available'),
   ('2','Anuj','4','Rana pratap','Malviya','Ram','NA'),
   ('3','Nishit','6','Ashok','Vyas','Malviya','NA'),
   ('4','Ankur','2','Vyas','Malviya','Ashok','NA'),
   ('5','Rajdeep','6','Ashok','Rana Pratap','Malviya','NA'),
   ('6','Atharv','4','Vyas','Shankar','Ram','Available'),
   ('7','Harsh','2','Rana pratap','Ashok','Shankar','NA'),
   ('8','Shreyans','2','Vyas','Malviya','Vishwakarma','Available');
   ('9','Aman','4','Vyas','Shankar','Vishwakarma','Available');
   ('10','Kalpana','4','Meera-BlockA','Budh','Meera-BlockB','Available');


