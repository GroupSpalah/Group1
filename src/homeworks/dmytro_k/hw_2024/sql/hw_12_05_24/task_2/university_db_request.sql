use university_db;

/*Вывести в консоль:
 всех студентов учащихся в одном университете(по названию университета).*/
SELECT s.*
FROM student s
INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id
INNER JOIN university_faculty uf 
	ON f.faculty_id = uf.FK_faculty_id
INNER JOIN university u 
	ON uf.FK_university_id = u.university_id
WHERE u.name = 'University A';

CALL all_university_students('University A');

/* всех студентов учащихся в одном университете(по названию университета) и на одном факультете.*/
SELECT s.*
FROM student s
INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id 
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id 
INNER JOIN university_faculty uf 
	ON f.faculty_id = uf.FK_faculty_id 
INNER JOIN university u 
	ON uf.FK_university_id = u.university_id 
WHERE u.name = 'University A' AND f.name = 'Faculty A';

CALL all_university_and_faculty_students('University A', 'Faculty A'); /*вывод включает значения, но не ссылки*/

/* количество студентов учащихся в каждом университете, факультете, группе.*/
SELECT u.name university_name, f.name faculty_name, sg.name students_group_name, COUNT(s.student_id) student_amount 
FROM student s 
INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id 
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id 
INNER JOIN university_faculty uf 
	ON f.faculty_id = uf.FK_faculty_id 
INNER JOIN university u 
	ON uf.FK_university_id = u.university_id
GROUP BY u.name, f.name, sg.name;

CALL number_of_students_in_each_university_faculty_group();

/* найти группу с максимальным/минимальным количеством студентов.*/
WITH max_students AS (
  SELECT MAX(number_of_students) max_count
  FROM (
    SELECT COUNT(s.student_id) number_of_students
    FROM student s
    INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
    GROUP BY sg.students_group_id
  ) student_counts
)
SELECT sg.name group_name, f.name faculty_name, COUNT(s.student_id) number_of_students
FROM student s
INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id 
GROUP BY sg.students_group_id, sg.name, f.name
HAVING COUNT(s.student_id) = (SELECT max_count FROM max_students);

CALL groups_with_maximum_number_of_students();

WITH min_students AS (
  SELECT MIN(number_of_students) min_count
  FROM (
    SELECT COUNT(s.student_id) number_of_students
    FROM student s
    INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
    GROUP BY sg.students_group_id
  ) student_counts
)
SELECT sg.name group_name, f.name faculty_name, COUNT(s.student_id) number_of_students
FROM student s
INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id 
GROUP BY sg.students_group_id, sg.name, f.name
HAVING COUNT(s.student_id) = (SELECT min_count FROM min_students);

CALL groups_with_minimum_number_of_students();

/* подсчитать количество студентов, которые живут по одному адресу(улица, дом).*/
SELECT a.street, a.house_number, COUNT(s.student_id) number_of_students
FROM student s
INNER JOIN address a 
	ON s.FK_student_address = a.address_id 
GROUP BY a.street, a.house_number
HAVING number_of_students > 1;

CALL number_of_students_who_live_at_the_same_address();

/*вывести даты рождения студентов в формате '30 Oct 16'*/

SELECT s.name, s.surname, date_format(s.birth_date, '%d %b %y') birth_date 
FROM student s;

CALL university_db.students_dates_of_birth();

/*вывести среднее количество людей в группе по университету.*/
SELECT u.name university_name, AVG(group_size) average_group_size
FROM (
  SELECT sg.FK_group_faculty, COUNT(s.student_id) group_size
  FROM student s
  INNER JOIN students_group sg 
	ON s.FK_student_group = sg.students_group_id
  GROUP BY sg.students_group_id
) group_sizes
INNER JOIN students_group sg 
	ON group_sizes.FK_group_faculty = sg.FK_group_faculty
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id
INNER JOIN university_faculty uf 
	ON f.faculty_id = uf.FK_faculty_id 
INNER JOIN university u 
	ON uf.FK_university_id = u.university_id
GROUP BY u.name;

/*вариант Андрея для моей базы*/
SELECT u.name, AVG(Qty)
FROM (SELECT count(s.student_id) Qty, u.name Name
FROM Student s
RIGHT JOIN students_group sg  
	ON s.FK_student_group = sg.students_group_id
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id
INNER JOIN university_faculty uf 
	ON f.faculty_id = uf.FK_faculty_id 
INNER JOIN university u 
	ON uf.FK_university_id = u.university_id
GROUP BY s.FK_student_group, u.university_id) U
GROUP BY u.name;

CALL average_number_of_people_in_a_group_at_the_university();

/*вывести всех старост групп.*/

SELECT s.student_id, s.name, s.surname, sg.name group_name, f.name faculty_name
FROM student s
INNER JOIN students_group sg 
	ON s.student_id = sg.FK_group_leader 
INNER JOIN faculty f 
	ON sg.FK_group_faculty = f.faculty_id;

CALL group_leaders();

/*вывести университеты с наибольшим количеством факультетов*/

SELECT u.name university_name, COUNT(uf.FK_faculty_id) faculty_count
FROM university u
INNER JOIN university_faculty uf 
	ON u.university_id = uf.FK_university_id
GROUP BY u.university_id, u.name
HAVING COUNT(uf.FK_faculty_id) = (
  SELECT MAX(faculty_count) max_faculty_count
  FROM (
    SELECT COUNT(FK_faculty_id) faculty_count
    FROM university_faculty
    GROUP BY FK_university_id
  ) max_faculty
);

CALL university_with_the_most_faculties();

/*вывести университеты с наибольшим количеством групп v1*/

WITH University_group_counts AS (
    SELECT u.university_id, u.name university_name, COUNT(sg.students_group_id) group_count
    FROM university u
    INNER JOIN university_faculty uf 
    	ON u.university_id = uf.FK_university_id
    INNER JOIN faculty f 
    	ON uf.FK_faculty_id = f.faculty_id
    INNER JOIN students_group sg 
    	ON f.faculty_id = sg.FK_group_faculty
    GROUP BY u.university_id, u.name
), 
Max_group_count AS (
    SELECT MAX(group_count) max_group_count
    FROM University_group_counts
)
SELECT u.university_name, u.group_count
FROM University_group_counts u
INNER JOIN Max_group_count m 
	ON u.group_count = m.max_group_count;

/*вывести университеты с наибольшим количеством групп v2*/

SELECT u.name university_name, COUNT(sg.students_group_id) group_count
FROM university u
INNER JOIN university_faculty uf 
	ON u.university_id = uf.FK_university_id
INNER JOIN faculty f 
	ON uf.FK_faculty_id = f.faculty_id
INNER JOIN students_group sg 
	ON f.faculty_id = sg.FK_group_faculty
GROUP BY u.university_id, u.name
HAVING COUNT(sg.students_group_id) = (
    SELECT MAX(group_count)
    FROM (
        SELECT COUNT(sg.students_group_id) group_count
        FROM university u
        INNER JOIN university_faculty uf 
        	ON u.university_id = uf.FK_university_id
        INNER JOIN faculty f 
        	ON uf.FK_faculty_id = f.faculty_id
        INNER JOIN students_group sg 
        	ON f.faculty_id = sg.FK_group_faculty
        GROUP BY u.university_id
    ) subquery
);

/*вывести университет с наибольшим количеством групп v3 
 * (только 1 строка, не зависимо от кол-ва соответствующих условию университетов)*/

SELECT u.name AS university_name, COUNT(sg.students_group_id) group_count
FROM University u
INNER JOIN university_faculty uf 
	ON u.university_id = uf.FK_university_id
INNER JOIN Faculty f 
	ON uf.FK_faculty_id  = f.faculty_id
INNER JOIN students_group sg  
	ON f.faculty_id = sg.FK_group_faculty 
GROUP BY u.name
ORDER BY group_count
LIMIT 1;

CALL university_with_the_most_group();

/*вывести университеты с наибольшим количеством Студентов*/

WITH University_student_counts AS (
    SELECT u.university_id, u.name university_name, COUNT(s.student_id) student_count
    FROM university u
    INNER JOIN university_faculty uf 
    	ON u.university_id = uf.FK_university_id
    INNER JOIN faculty f 
    	ON uf.FK_faculty_id = f.faculty_id
    INNER JOIN students_group sg
    	ON f.faculty_id = sg.FK_group_faculty
    INNER JOIN student s 
    	ON sg.students_group_id = s.FK_student_group
    GROUP BY u.university_id, u.name
),
Max_student_count AS (
    SELECT MAX(student_count) max_student_count
    FROM University_student_counts
)
SELECT u.university_name, u.student_count
FROM University_student_counts u
INNER JOIN Max_student_count m 
	ON u.student_count = m.max_student_count;

CALL universities_with_the_most_students();
