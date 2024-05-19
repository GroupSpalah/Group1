use university;

CREATE TABLE Address (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    city VARCHAR(50),
    street VARCHAR(50),
    house_number INT,
    apartment_number INT
);

INSERT INTO Address (city, street, house_number, apartment_number) 
VALUES 
('City A', 'Street A', 1,  1),
('City B', 'Street B', 2,  2),
('City C', 'Street C', 3,  3),
('City D', 'Street D', 4,  4),
('City E', 'Street E', 5,  5),
('City F', 'Street F', 6,  6),
('City G', 'Street G', 7,  7),
('City H', 'Street H', 8,  8),
('City I', 'Street I', 9,  9),
('City J', 'Street J', 10, 10),
('City K', 'Street K', 11, 11),
('City L', 'Street L', 12, 12),
('City M', 'Street M', 13, 13),
('City N', 'Street N', 14, 14),
('City O', 'Street O', 15, 15),
('City P', 'Street P', 16, 16),
('City Q', 'Street Q', 17, 17),
('City R', 'Street R', 18, 18),
('City S', 'Street S', 19, 19),
('City T', 'Street T', 20, 20);
   
CREATE TABLE University (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    foundation_date DATE
);   

INSERT INTO University (name, foundation_date) 
VALUES 
('University A', '1900-01-01'),
('University B', '1901-02-02'),
('University C', '1902-03-03'),
('University D', '1903-04-04'),
('University E', '1904-05-05');

CREATE TABLE Faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    foundation_date DATE
);  

INSERT INTO Faculty (name, foundation_date) 
VALUES 
('Faculty A', '1910-01-01'),
('Faculty B', '1911-02-02'),
('Faculty C', '1912-03-03'),
('Faculty D', '1913-04-04'),
('Faculty E', '1914-05-05');

CREATE TABLE University_Faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    university_id INT,
    faculty_id INT,
    FOREIGN KEY (university_id) REFERENCES University(id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(id)
);  

INSERT INTO University_Faculty (university_id, faculty_id) 
VALUES 
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(5, 2),
(5, 1),
(4, 3),
(3, 3),
(3, 1),
(1, 4),
(1, 5);

CREATE TABLE Group (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    foundation_date DATE,
    FK_group_student INT,
    FK_group_faculty INT,
    FOREIGN KEY (FK_group_student) REFERENCES Student(id),
    FOREIGN KEY (FK_group_faculty) REFERENCES Faculty(id)
);

INSERT INTO Group (name, foundation_date, head_student_id, faculty_id) 
VALUES 
('Group A', '2000-01-01', 1, 1),
('Group B', '2001-02-02', 2, 2),
('Group C', '2002-03-03', 3, 3),
('Group D', '2003-04-04', 4, 4),
('Group E', '2004-05-05', 5, 5);

CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    surname VARCHAR(30),    
    gender CHAR(1),
    birth_date DATE,
    FK_student_address INT,
    FK_student_group INT,
    FOREIGN KEY (FK_student_address) REFERENCES Address(id),
    FOREIGN KEY (FK_student_group) REFERENCES Group(id)
);

INSERT INTO Student (name, surname,  age, gender, birth_date, address_id, group_id) 
VALUES 
('John',   'Doe',    20,  'M', '2002-01-01', 1,   1),
('Jane',   'Doe',    19,  'F', '2003-02-02', 2,   2),
('Jim',    'Smith',  21,  'M', '2001-03-03', 3,   3),
('Jill',   'Smith',  22,  'F', '2000-04-04', 4,   4),
('Joe',    'Johnson',23,  'M', '1999-05-05', 5,   5),
('Jenny',  'Johnson',24,  'F', '1998-06-06', 1,   1),
('Jack',   'Brown',  25,  'M', '1997-07-07', 2,   2),
('Jill',   'Brown',  26,  'F', '1996-08-08', 8,   3),
('Jerry',  'Davis',  27,  'M', '1995-09-09', 9,   4),
('Jessica','Davis',  28,  'F', '1994-10-10', 10,  5),
('Jeff',   'Miller', 29,  'M', '1993-11-11', 11,  1),
('Jennifer','Miller',30,  'F', '1992-12-12', 12,  2),
('Jake',   'Wilson', 31,  'M', '1991-01-13', 5,   3),
('Julia',  'Wilson', 32,  'F', '1990-02-14', 14,  4),
('Jason',  'Moore',  33,  'M', '1989-03-15', 11,  5),
('Julie',  'Moore',  34,  'F', '1988-04-16', 16,  1),
('Justin', 'Taylor', 35,  'M', '1987-05-17', 17,  2),
('June',   'Taylor', 36,  'F', '1986-06-18', 6,   3),
('Jeremy', 'Anderson',37, 'M', '1985-07-19', 19,  4),
('Joy',    'Anderson',38, 'F', '1984-08-20', 6,   5);
    
   
   