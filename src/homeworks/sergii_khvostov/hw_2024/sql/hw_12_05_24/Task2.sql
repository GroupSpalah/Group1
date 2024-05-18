USE student_university;

CREATE TABLE Address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50),
    street VARCHAR(50),
    house_number INT,
    apartment_number INT
);

CREATE TABLE University (
    university_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    foundation_date DATE
);

CREATE TABLE Faculty (
    faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    foundation_date DATE
);

CREATE TABLE Student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    gender ENUM('Male', 'Female'),
    birth_date DATE,
    address_id INT,
    group_number INT,
    FOREIGN KEY (address_id) REFERENCES Address(address_id)
);

CREATE TABLE StudentGroup (
    group_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    foundation_date DATE,
    head_student_id INT,
    faculty_id INT,
    FOREIGN KEY (head_student_id) REFERENCES Student(student_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

CREATE TABLE UniversityFaculty (
    university_id INT,
    faculty_id INT,
    PRIMARY KEY (university_id, faculty_id),
    FOREIGN KEY (university_id) REFERENCES University(university_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

INSERT INTO Address (city, street, house_number, apartment_number) VALUES
('Kharkiv', 'Sumska St',            1, 101),
('Kharkiv', 'Sumska St',            1, 102),
('Kharkiv', 'Sumska St',            2, 201),
('Kharkiv', 'Sumska St',            2, 202),
('Kharkiv', 'Geroiv Kharkova',      10, 301),
('Kyiv',    'Freedom St',           20, 401),
('Kyiv',    'Freedom St',           20, 402),
('Kyiv',    'Kharkivska Ave',       15, 501),
('Lviv',    'Liberty Ave',          5, 601),
('Lviv',    'Liberty Ave',          5, 602);


INSERT INTO University (name, foundation_date) VALUES
('Kharkiv University', '1805-01-01'),
('Kyiv University',    '1834-01-01');


INSERT INTO Faculty (name, foundation_date) VALUES
('Engineering Faculty', '1950-01-01'),
('Arts Faculty',        '1960-01-01'),
('Science Faculty',     '1970-01-01');


INSERT INTO UniversityFaculty (university_id, faculty_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3);


INSERT INTO Student (first_name, last_name, age, gender, birth_date, address_id, group_number) VALUES
('John',   'Doe',       20, 'Male',   '2004-01-01', 1,  101),
('Jane',   'Doe',       21, 'Female', '2003-02-01', 2,  101),
('Jim',    'Beam',      22, 'Male',   '2002-03-01', 3,  102),
('Jack',   'Daniels',   23, 'Male',   '2001-04-01', 4,  102),
('Jill',   'Valentine', 24, 'Female', '2000-05-01', 5,  103),
('Chris',  'Redfield',  20, 'Male',   '2004-06-01', 6,  103),
('Leon',   'Kennedy',   21, 'Male',   '2003-07-01', 7,  104),
('Claire', 'Redfield',  22, 'Female', '2002-08-01', 8,  104),
('Ada',    'Wong',      23, 'Female', '2001-09-01', 9,  105),
('Albert', 'Wesker',    24, 'Male',   '2000-10-01', 10, 105),
('Bruce',  'Wayne',     20, 'Male',   '2004-01-01', 1,  106),
('Clark',  'Kent',      21, 'Male',   '2003-02-01', 2,  106),
('Diana',  'Prince',    22, 'Female', '2002-03-01', 3,  107),
('Barry',  'Allen',     23, 'Male',   '2001-04-01', 4,  107),
('Arthur', 'Curry',     24, 'Male',   '2000-05-01', 5,  108),
('Hal',    'Jordan',    20, 'Male',   '2004-06-01', 6,  108),
('Oliver', 'Queen',     21, 'Male',   '2003-07-01', 7,  109),
('Dinah',  'Drake',     22, 'Female', '2002-08-01', 8,  109),
('Roy',    'Harper',    23, 'Male',   '2001-09-01', 9,  110),
('Wally',  'West',      24, 'Male',   '2000-10-01', 10, 110);


INSERT INTO StudentGroup (name, foundation_date, head_student_id, faculty_id) VALUES
('Group 101', '2020-09-01', 1,  1),
('Group 102', '2020-09-01', 3,  1),
('Group 103', '2020-09-01', 5,  2),
('Group 104', '2020-09-01', 7,  2),
('Group 105', '2020-09-01', 9,  3),
('Group 106', '2020-09-01', 11, 3),
('Group 107', '2020-09-01', 13, 2),
('Group 108', '2020-09-01', 15, 1),
('Group 109', '2020-09-01', 17, 3),
('Group 110', '2020-09-01', 19, 2);

