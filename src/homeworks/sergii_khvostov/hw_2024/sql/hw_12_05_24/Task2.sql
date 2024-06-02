/*1) SQL_SoftServe

2) Имеются сущности с полями:

Студент(имя, фамилия, возраст, пол, дата рождения, адрес, номер группы);
Университет(название, дата основания);
Факультет(название, дата основания);
Группа(название, дата основания, староста(внешний ключ на таблицу Student), факультет);
Адрес(город, улица, номер дома, номер квартиры);

Связь между Университетом и Факультетом ManyToMany

Создать 20 студентов так, чтобы некоторые имели:
- общие университеты.
- общие факультеты.
- одинаковый номер группы.
- общие номера домов на одной улице.
- одну улицу.
--------------------------------------------------------------------------
Вывести в консоль:
 - всех студентов учащихся в одном университете(по названию университета).
 - всех студентов учащихся в одном университете(по названию университета) и на одном факультете.
 - количество студентов учащихся в каждом университете, факультете, группе.
 - найти группу с максимальным/минимальным количеством студентов.
 - подсчитать количество студентов, которые живут по одному адресу(улица, дом).
 - вывести даты рождения студентов в формате '30 Oct 16'.
 - вывести среднее количество людей в группе по университету.
 - вывести всех старост групп.
 - вывести университет, с наибольшим количеством факультетов/групп/студентов.

 В написании запросов использовать:
- первичные и внешние ключи,
- autoincrement,
- default values,
- not null/null.
- соответствующие типы данных.
- joins
- свои функции
- views
- stored procedures*/

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
    FK_Student_StGroup INT,
    FOREIGN KEY (address_id) REFERENCES Address(address_id)
);

CREATE TABLE StudentGroup (
    group_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    foundation_date DATE,
    head_student_id INT,
    faculty_id INT,
    FK_Student_StGroup INT,
    FOREIGN KEY (head_student_id) REFERENCES Student(student_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id),
    FOREIGN KEY (FK_Student_StGroup) REFERENCES Student(student_id)
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

/*26_05_24*/
ALTER TABLE StudentGroup
ADD FOREIGN KEY (FK_Student_StGroup) REFERENCES Student(student_id);

UPDATE Student SET FK_Student_StGroup = 1  WHERE student_id = 1;
UPDATE Student SET FK_Student_StGroup = 3  WHERE student_id = 3;
UPDATE Student SET FK_Student_StGroup = 5  WHERE student_id = 5;
UPDATE Student SET FK_Student_StGroup = 7  WHERE student_id = 7;
UPDATE Student SET FK_Student_StGroup = 9  WHERE student_id = 9;
UPDATE Student SET FK_Student_StGroup = 11 WHERE student_id = 11;
UPDATE Student SET FK_Student_StGroup = 13 WHERE student_id = 13;
UPDATE Student SET FK_Student_StGroup = 15 WHERE student_id = 15;
UPDATE Student SET FK_Student_StGroup = 17 WHERE student_id = 17;
UPDATE Student SET FK_Student_StGroup = 19 WHERE student_id = 19;

UPDATE StudentGroup SET FK_Student_StGroup = 1  WHERE group_id = 1;
UPDATE StudentGroup SET FK_Student_StGroup = 3  WHERE group_id = 2;
UPDATE StudentGroup SET FK_Student_StGroup = 5  WHERE group_id = 3;
UPDATE StudentGroup SET FK_Student_StGroup = 7  WHERE group_id = 4;
UPDATE StudentGroup SET FK_Student_StGroup = 9  WHERE group_id = 5;
UPDATE StudentGroup SET FK_Student_StGroup = 11 WHERE group_id = 6;
UPDATE StudentGroup SET FK_Student_StGroup = 13 WHERE group_id = 7;
UPDATE StudentGroup SET FK_Student_StGroup = 15 WHERE group_id = 8;
UPDATE StudentGroup SET FK_Student_StGroup = 17 WHERE group_id = 9;
UPDATE StudentGroup SET FK_Student_StGroup = 19 WHERE group_id = 10;

/*26_05_24*/
/*1*/
SELECT s.first_name, s.last_name, u.name AS university_name
FROM Student s
INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
INNER JOIN University u ON uf.university_id = u.university_id
WHERE u.name = 'Kharkiv University';

/*2*/
SELECT s.first_name, s.last_name, u.name AS university_name, f.name AS faculty_name
FROM Student s
INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
INNER JOIN University u ON uf.university_id = u.university_id
WHERE u.name = 'Kharkiv University' AND f.name = 'Engineering Faculty';

/*3*/
SELECT u.name AS university_name, f.name AS faculty_name, sg.name AS group_name, COUNT(s.student_id) AS student_count
FROM Student s
INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
INNER JOIN University u ON uf.university_id = u.university_id
GROUP BY u.name, f.name, sg.name;

/*4*/
-- MAX
SELECT sg.name AS group_name, COUNT(s.student_id) AS student_count
FROM Student s
INNER JOIN StudentGroup sg
ON s.group_number = sg.group_id
GROUP BY sg.name
ORDER BY student_count DESC
LIMIT 1;

-- MIN
SELECT sg.name AS group_name, COUNT(s.student_id) AS student_count
FROM Student s
INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
GROUP BY sg.name
ORDER BY student_count ASC
LIMIT 1;

/*5*/
SELECT a.street, a.house_number, COUNT(s.student_id) AS student_count
FROM Student s
INNER JOIN Address a ON s.address_id = a.address_id
GROUP BY a.street, a.house_number;

/*6*/
SELECT s.first_name, s.last_name, DATE_FORMAT(s.birth_date, '%d %b %y') AS formatted_birth_date
FROM Student s;

/*7*/
SELECT university_name, AVG(student_count) AS average_students_per_group
FROM (
    SELECT u.name AS university_name, sg.group_id, COUNT(s.student_id) AS student_count
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
    INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
    INNER JOIN University u ON uf.university_id = u.university_id
    GROUP BY u.name, sg.group_id
) AS group_counts
GROUP BY university_name;


/*8*/
SELECT s.first_name, s.last_name, sg.name AS group_name
FROM StudentGroup sg
INNER JOIN Student s ON sg.head_student_id = s.student_id;

/*9*/
-- Faculty
SELECT u.name AS university_name, COUNT(uf.faculty_id) AS faculty_count
FROM University u
INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
GROUP BY u.name
ORDER BY faculty_count
LIMIT 1;

-- Group
SELECT u.name AS university_name, COUNT(sg.group_id) AS group_count
FROM University u
INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
INNER JOIN Faculty f ON uf.faculty_id = f.faculty_id
INNER JOIN StudentGroup sg ON f.faculty_id = sg.faculty_id
GROUP BY u.name
ORDER BY group_count
LIMIT 1;

-- Students
SELECT u.name AS university_name, COUNT(s.student_id) AS student_count
FROM University u
INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
INNER JOIN Faculty f ON uf.faculty_id = f.faculty_id
INNER JOIN StudentGroup sg ON f.faculty_id = sg.faculty_id
INNER JOIN Student s ON sg.group_id = s.group_number
GROUP BY u.name
ORDER BY student_count DESC
LIMIT 1;

/*Stored procedures*/
/*1*/
DELIMITER $$
CREATE PROCEDURE GetStudentsByUniversityName (IN universityName VARCHAR(100))
BEGIN
    SELECT s.first_name, s.last_name, u.name AS university_name
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
    INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
    INNER JOIN University u ON uf.university_id = u.university_id
    WHERE u.name = universityName;
END $$
DELIMITER ;
CALL GetStudentsByUniversityName('Kharkiv University');

/*2*/
DELIMITER $$
CREATE PROCEDURE GetStudentsByUniversityAndFaculty (
IN universityName VARCHAR(100),
IN facultyName VARCHAR(100))
BEGIN
    SELECT s.first_name, s.last_name, u.name AS university_name, f.name AS faculty_name
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
    INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
    INNER JOIN University u ON uf.university_id = u.university_id
    WHERE u.name = universityName
    AND f.name = facultyName;
END $$
DELIMITER ;
CALL GetStudentsByUniversityAndFaculty('Kharkiv University', 'Engineering Faculty');

/*3*/
DELIMITER $$
CREATE PROCEDURE GetStudentCountByGroup()
BEGIN
    SELECT u.name AS university_name, f.name AS faculty_name, sg.name AS group_name,
    COUNT(s.student_id) AS student_count
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
    INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
    INNER JOIN University u ON uf.university_id = u.university_id
    GROUP BY u.name, f.name, sg.name;
END $$
DELIMITER ;
CALL GetStudentCountByGroup();

/*4*/
--MAX
DELIMITER $$
CREATE PROCEDURE GetGroupWithMaxStudents()
BEGIN
    SELECT sg.name AS group_name,
    COUNT(s.student_id) AS student_count
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    GROUP BY sg.name
    ORDER BY student_count DESC
    LIMIT 1;
END $$
DELIMITER ;
CALL GetGroupWithMaxStudents();

--MIN
DELIMITER $$
CREATE PROCEDURE GetGroupWithMinStudents()
BEGIN
    SELECT sg.name AS group_name,
    COUNT(s.student_id) AS student_count
    FROM Student s
    INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
    GROUP BY sg.name
    ORDER BY student_count ASC
    LIMIT 1;
END $$
DELIMITER ;
CALL GetGroupWithMinStudents();

/*5*/
DELIMITER $$
CREATE PROCEDURE GetStudentCountByAddress()
BEGIN
    SELECT a.street, a.house_number,
    COUNT(s.student_id) AS student_count
    FROM Student s
    INNER JOIN Address a ON s.address_id = a.address_id
    GROUP BY a.street, a.house_number;
END $$
DELIMITER ;
CALL GetStudentCountByAddress();

/*6*/
DELIMITER $$
CREATE PROCEDURE GetFormattedStudentBirthDates()
BEGIN
    SELECT s.first_name, s.last_name, DATE_FORMAT(s.birth_date, '%d %b %y')
    AS formatted_birth_date
    FROM Student s;
END $$
DELIMITER ;
CALL GetFormattedStudentBirthDates();

/*7*/
DELIMITER $$
CREATE PROCEDURE GetAverageStudentsPerGroup()
BEGIN
    SELECT university_name, AVG(student_count) AS average_students_per_group
    FROM (
        SELECT u.name AS university_name, sg.group_id,
        COUNT(s.student_id) AS student_count
        FROM Student s
        INNER JOIN StudentGroup sg ON s.group_number = sg.group_id
        INNER JOIN Faculty f ON sg.faculty_id = f.faculty_id
        INNER JOIN UniversityFaculty uf ON f.faculty_id = uf.faculty_id
        INNER JOIN University u ON uf.university_id = u.university_id
        GROUP BY u.name, sg.group_id
    ) AS group_counts
    GROUP BY university_name;
END $$
DELIMITER ;
CALL GetAverageStudentsPerGroup();

/*8*/
DELIMITER $$
CREATE PROCEDURE GetGroupHeads()
BEGIN
    SELECT s.first_name, s.last_name, sg.name AS group_name
    FROM StudentGroup sg
    INNER JOIN Student s ON sg.head_student_id = s.student_id;
END $$
DELIMITER ;
CALL GetGroupHeads();

/*9*/
--Faculties
DELIMITER $$
CREATE PROCEDURE GetUniversityWithFewestFaculties()
BEGIN
    SELECT u.name AS university_name,
    COUNT(uf.faculty_id) AS faculty_count
    FROM University u
    INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
    GROUP BY u.name
    ORDER BY faculty_count
    LIMIT 1;
END $$
DELIMITER ;
CALL GetUniversityWithFewestFaculties();

--Groups
DELIMITER $$
CREATE PROCEDURE GetUniversityWithFewestGroups()
BEGIN
    SELECT u.name AS university_name,
    COUNT(sg.group_id) AS group_count
    FROM University u
    INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
    INNER JOIN Faculty f ON uf.faculty_id = f.faculty_id
    INNER JOIN StudentGroup sg ON f.faculty_id = sg.faculty_id
    GROUP BY u.name
    ORDER BY group_count
    LIMIT 1;
END $$
DELIMITER ;
CALL GetUniversityWithFewestGroups();

--Students
DELIMITER $$
CREATE PROCEDURE GetUniversityWithMostStudents()
BEGIN
    SELECT u.name AS university_name,
    COUNT(s.student_id) AS student_count
    FROM University u
    INNER JOIN UniversityFaculty uf ON u.university_id = uf.university_id
    INNER JOIN Faculty f ON uf.faculty_id = f.faculty_id
    INNER JOIN StudentGroup sg ON f.faculty_id = sg.faculty_id
    INNER JOIN Student s ON sg.group_id = s.group_number
    GROUP BY u.name
    ORDER BY student_count DESC
    LIMIT 1;
END $$
DELIMITER ;
CALL GetUniversityWithMostStudents();













