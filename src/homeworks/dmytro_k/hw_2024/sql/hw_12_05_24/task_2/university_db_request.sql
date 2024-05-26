use university_db;

/*Вывести в консоль:
  всех студентов учащихся в одном университете(по названию университета).*/
SELECT s.*
FROM student s
JOIN students_group sg
ON s.FK_student_group = sg.students_group_id
JOIN faculty f
ON sg.FK_group_faculty = f.faculty_id
JOIN university_faculty uf ON f.faculty_id = uf.FK_faculty_id
JOIN university u ON uf.FK_university_id = u.university_id
WHERE u.name = 'University A';

/* всех студентов учащихся в одном университете(по названию университета) и на одном факультете.*/
SELECT s.*
FROM student s
JOIN students_group sg ON s.FK_student_group = sg.students_group_id 
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id 
JOIN university_faculty uf ON f.faculty_id = uf.FK_faculty_id 
JOIN university u ON uf.FK_university_id = u.university_id 
WHERE u.name = 'University A' AND f.name = 'Faculty A';


/* количество студентов учащихся в каждом университете, факультете, группе.*/
SELECT u.name AS university_name, f.name AS faculty_name, sg.name AS students_group_name, COUNT(s.student_id) AS student_amount 
FROM student s 
JOIN students_group sg ON s.FK_student_group = sg.students_group_id 
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id 
JOIN university_faculty uf ON f.faculty_id = uf.FK_faculty_id 
JOIN university u ON uf.FK_university_id = u.university_id
GROUP BY u.name, f.name, sg.name;

/* найти группу с максимальным/минимальным количеством студентов.*/
WITH max_students AS (
    SELECT MAX(number_of_students) AS max_count
    FROM (
        SELECT COUNT(s.student_id) AS number_of_students
        FROM student s
        JOIN students_group sg ON s.FK_student_group = sg.students_group_id
        GROUP BY sg.students_group_id
    ) AS student_counts
)
SELECT sg.name AS group_name, f.name AS faculty_name, COUNT(s.student_id) AS number_of_students
FROM student s
JOIN students_group sg ON s.FK_student_group = sg.students_group_id
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id 
GROUP BY sg.students_group_id, sg.name, f.name
HAVING COUNT(s.student_id) = (SELECT max_count FROM max_students);


WITH max_students AS (
    SELECT MIN(number_of_students) AS max_count
    FROM (
        SELECT COUNT(s.student_id) AS number_of_students
        FROM student s
        JOIN students_group sg ON s.FK_student_group = sg.students_group_id
        GROUP BY sg.students_group_id
    ) AS student_counts
)
SELECT sg.name AS group_name, f.name AS faculty_name, COUNT(s.student_id) AS number_of_students
FROM student s
JOIN students_group sg ON s.FK_student_group = sg.students_group_id
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id 
GROUP BY sg.students_group_id, sg.name, f.name
HAVING COUNT(s.student_id) = (SELECT max_count FROM max_students);

/* подсчитать количество студентов, которые живут по одному адресу(улица, дом).*/
SELECT a.street, a.house_number, COUNT(s.student_id) AS number_of_students
FROM student s
JOIN address a ON s.FK_student_address  = a.address_id 
GROUP BY a.street, a.house_number
HAVING number_of_students > 1;

/*вывести даты рождения студентов в формате '30 Oct 16'*/

SELECT s.name, s.surname, date_format(s.birth_date, '%d %b %y') birth_date 
FROM student s;

/*вывести среднее количество людей в группе по университету.*/
SELECT u.name AS university_name, AVG(group_size) AS average_group_size
FROM (
    SELECT sg.FK_group_faculty, COUNT(s.student_id) AS group_size
    FROM student s
    JOIN students_group sg ON s.FK_student_group = sg.students_group_id
    GROUP BY sg.students_group_id
) AS group_sizes
JOIN students_group sg ON group_sizes.FK_group_faculty = sg.FK_group_faculty
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id
JOIN university_faculty uf ON f.faculty_id = uf.FK_faculty_id 
JOIN university u ON uf.FK_university_id  = u.university_id
GROUP BY u.name;

----------------------------------------------------
 SELECT I.Name, AVG(Qty)
 FROM (SELECT count(s.student_id) Qty, i.name Name
 FROM Student s
 RIGHT JOIN Class c ON s.class_id = c.class_id
 INNER JOIN Faculty f ON c.faculty_fk_id=f.faculty_id
 INNER JOIN Institute i ON f.institute_fk_id=i.institute_id
 GROUP BY s.class_id, i.institute_id) I
 GROUP BY i.Name;

----------------------------------------------------

/*вывести всех старост групп.*/

SELECT s.student_id, s.name, s.surname, sg.name AS group_name, f.name AS faculty_name
FROM student s
JOIN students_group sg ON s.student_id = sg.FK_group_leader 
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id;

/*вывести университет, с наибольшим количеством факультетов/групп/студентов.*/

SELECT u.name AS university_name, COUNT(uf.FK_faculty_id) AS faculty_count
FROM university u
JOIN university_faculty uf ON u.university_id = uf.FK_university_id
GROUP BY u.university_id, u.name
HAVING COUNT(uf.FK_faculty_id) = (
    SELECT MAX(faculty_count) AS max_faculty_count
    FROM (
        SELECT COUNT(FK_faculty_id) AS faculty_count
        FROM university_faculty
        GROUP BY FK_university_id
    ) AS max_faculty
);

/*доделать
 * 
 * WITH max_students AS (
    SELECT MAX(number_of_students) AS max_count
    FROM (
        SELECT COUNT(s.student_id) AS number_of_students
        FROM student s
        JOIN students_group sg ON s.FK_student_group = sg.students_group_id
        GROUP BY sg.students_group_id
    ) AS student_counts
)
SELECT sg.name AS group_name, f.name AS faculty_name, COUNT(s.student_id) AS number_of_students
FROM student s
JOIN students_group sg ON s.FK_student_group = sg.students_group_id
JOIN faculty f ON sg.FK_group_faculty = f.faculty_id 
GROUP BY sg.students_group_id, sg.name, f.name
HAVING COUNT(s.student_id) = (SELECT max_count FROM max_students);*/
/*
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