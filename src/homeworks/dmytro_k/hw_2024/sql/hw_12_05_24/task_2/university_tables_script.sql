use university_db;

CREATE TABLE address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50),
    street VARCHAR(50),
    house_number INT,
    apartment_number INT
);

INSERT INTO address (city, street, house_number, apartment_number) 
VALUES 
 ('City A', 'Street A', 1,  1),
 ('City B', 'Street B', 2,  2),
 ('City C', 'Street E', 3,  3),
 ('City D', 'Street F', 4,  4),
 ('City E', 'Street G', 5,  5),
 ('City A', 'Street H', 6,  6),
 ('City B', 'Street I', 7,  7),
 ('City C', 'Street J', 8,  8),
 ('City D', 'Street A', 9,  9),
 ('City E', 'Street B', 2, 10),
 ('City A', 'Street C', 1, 11),
 ('City B', 'Street D', 2, 12),
 ('City C', 'Street E', 3, 13),
 ('City D', 'Street D', 4, 14),
 ('City E', 'Street E', 5, 15),
 ('City A', 'Street F', 6, 16),
 ('City B', 'Street G', 7, 17),
 ('City C', 'Street H', 8, 18),
 ('City D', 'Street I', 9, 19),
 ('City E', 'Street J', 8, 20);
   
CREATE TABLE university (
    university_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    foundation_date DATE
);   

INSERT INTO university (name, foundation_date) 
VALUES 
('University A', '1904-05-05');

CREATE TABLE faculty (
    faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    foundation_date DATE
);  

INSERT INTO faculty (name, foundation_date) 
VALUES 
('Faculty A', '1910-01-01'),
('Faculty B', '1911-02-02'),
('Faculty C', '1912-03-03');

CREATE TABLE university_faculty (
    university_faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    FK_university_id INT,
    FK_faculty_id INT,
    FOREIGN KEY (FK_university_id) REFERENCES university(university_id),
    FOREIGN KEY (FK_faculty_id) REFERENCES faculty(faculty_id)
);  

INSERT INTO university_faculty (FK_university_id, FK_faculty_id) 
VALUES 
 (1, 1),
 (1, 2),
 (1, 3);

CREATE TABLE students_group (
    students_group_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    foundation_date DATE,
    FK_group_faculty INT,
    /*UNIQUE (name, FK_group_faculty),??*/
    FK_group_leader INT,
    FOREIGN KEY (FK_group_faculty) REFERENCES faculty(faculty_id)
);

INSERT INTO students_group (name, foundation_date, FK_group_faculty) 
VALUES 
('Group A', '2000-01-01', 1),
('Group B', '2001-02-02', 1),
('Group C', '2002-03-03', 1),
('Group A', '2000-01-01', 2),
('Group B', '2001-02-02', 2),
('Group C', '2002-03-03', 2),
('Group A', '2000-01-01', 3),
('Group B', '2001-02-02', 3),
('Group C', '2002-03-03', 3);

CREATE TABLE student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    surname VARCHAR(30),    
    gender CHAR(1),
    birth_date DATE,
    FK_student_address INT,
    FK_student_group INT,
    FOREIGN KEY (FK_student_address) REFERENCES address(address_id),
    FOREIGN KEY (FK_student_group) REFERENCES students_group(students_group_id)
);

INSERT INTO student (name, surname, gender, birth_date, FK_student_address, FK_student_group) 
VALUES 
 ('John',   'Doe',      'M', '2002-01-01', 1,   1),
 ('Jane',   'Doe',      'F', '2003-02-02', 2,   2),
 ('Jim',    'Smith',    'M', '2001-03-03', 3,   3),
 ('Jill',   'Smith',    'F', '2000-04-04', 4,   4),
 ('Joe',    'Johnson',  'M', '1999-05-05', 5,   5),
 ('Jenny',  'Johnson',  'F', '1998-06-06', 1,   6),
 ('Jack',   'Brown',    'M', '1997-07-07', 2,   7),
 ('Jill',   'Brown',    'F', '1996-08-08', 8,   8),
 ('Jerry',  'Davis',    'M', '1995-09-09', 9,   9),
 ('Jessica','Davis',    'F', '1994-10-10', 10,  1),
 ('Jeff',   'Miller',   'M', '1993-11-11', 11,  2),
 ('Jennifer','Miller',  'F', '1992-12-12', 12,  3),
 ('Jake',   'Wilson',   'M', '1991-01-13', 5,   4),
 ('Julia',  'Wilson',   'F', '1990-02-14', 14,  5),
 ('Jason',  'Moore',    'M', '1989-03-15', 11,  6),
 ('Julie',  'Moore',    'F', '1988-04-16', 16,  7),
 ('Justin', 'Taylor',   'M', '1987-05-17', 17,  8),
 ('June',   'Taylor',   'F', '1986-06-18', 6,   9),
 ('Jeremy', 'Anderson', 'M', '1985-07-19', 19,  1),
 ('Joy',    'Anderson', 'F', '1984-08-20', 6,   2);


ALTER TABLE students_group ADD FOREIGN KEY (FK_group_leader) REFERENCES student(student_id);
    
UPDATE students_group SET FK_group_leader = 1 WHERE students_group_id = 1;
UPDATE students_group SET FK_group_leader = 2 WHERE students_group_id = 2;
UPDATE students_group SET FK_group_leader = 3 WHERE students_group_id = 3;
UPDATE students_group SET FK_group_leader = 6 WHERE students_group_id = 4;
UPDATE students_group SET FK_group_leader = 7 WHERE students_group_id = 5;
UPDATE students_group SET FK_group_leader = 8 WHERE students_group_id = 6;
UPDATE students_group SET FK_group_leader = 11 WHERE students_group_id = 7;
UPDATE students_group SET FK_group_leader = 12 WHERE students_group_id = 8;
UPDATE students_group SET FK_group_leader = 13 WHERE students_group_id = 9;