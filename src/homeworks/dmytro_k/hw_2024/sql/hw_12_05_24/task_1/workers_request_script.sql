use workers;

/*1
 *Выведите список городов, где находятся подразделения компании.*/
SELECT city 
FROM dept d;

/*2
*Выведите список имен работников (без повторов, упорядочен по алфавиту).*/
SELECT DISTINCT first_name 
FROM workers w
ORDER BY w.first_name;

/*3
*Выведите число, сколько работников в каждом подразделении в заданном городе (номер).
*Упорядочить по убыванию числа работников.*/
SELECT COUNT(*)
FROM workers w 
WHERE w.FK_workers_dept = 1;

/*4
*Получите список количества работников в каждом подразделении (номер). Упорядочить по убыванию числа работников.*/
SELECT d.dept_id, d.city, COUNT(*) AS num_workers
FROM dept d
JOIN workers w ON d.dept_id = w.FK_workers_dept 
GROUP BY d.dept_id
ORDER BY num_workers DESC;

/*5
*Получите список количества работников в каждом подразделении (номер). Упорядочить по названию города, где располагается подразделение.*/
SELECT d.dept_id, d.city, count(*) AS num_workers
FROM dept d 
JOIN workers w ON d.dept_id = w.FK_workers_dept 
GROUP BY d.dept_id 
ORDER BY d.city ASC;

/*6
*Выберите список городов, содержащие букву 'й' в начале слова.*/
SELECT city 
FROM dept d
WHERE city LIKE 'S%';

/*7
*Выберите список всех городов, содержащие букву 'й' в середине слова и соответствующее количество
*работников напротив каждого названия. Учесть что в таблице подразделений может быть город, в котором
*отсутствуют работники и что таблице работники могут быть также для которых данные поля DeptId = NULL.*/
SELECT d.city, count(w.workers_id) AS num_workers
FROM dept d 
LEFT JOIN workers w ON d.dept_id = w.FK_workers_dept /*FULL OUTER JOIN??*/
WHERE d.city LIKE '%a%' 
GROUP BY d.city;

/*8
*Выберите список людей имеющих однофамильцев. Упорядочить по алфавиту.*/
SELECT w.last_name, group_concat(w.first_name ORDER BY w.first_name) as first_names
FROM workers w
GROUP BY w.last_name
HAVING count(w.workers_id) > 1
ORDER BY w.last_name;

/*8 v2*/
SELECT w1.last_name, w1.first_name
FROM workers w1
WHERE EXISTS (
    SELECT 1
    FROM workers w2
    WHERE w1.workers_id != w2.workers_id AND w1.last_name = w2.last_name
)
ORDER BY w1.last_name, w1.first_name;

/*9
 *Выберите список людей имеющих несколько полных совпадений имени и фамилии из города 'Льво́в' и упроядочить по имени.*/
SELECT w.first_name, w.last_name, count(*) 
FROM workers w 
JOIN dept d  ON d.dept_id = w.FK_workers_dept 
WHERE d.city = 'Rollinsmouth' /*= w.FK_workers_dept = 2*/ /*вместо JOIN*/ /*Льво́в*/
GROUP BY w.first_name, w.last_name 
HAVING count(w.workers_id) > 1
ORDER BY w.first_name;

/*10*/
/*Получите список городов с количеством рабонико с именем 'Василий* более 10. Упорядочить по номеру.*/

SELECT w.first_name, d.city , count(*) as num_workers
FROM workers w 
JOIN dept d  ON d.dept_id = w.FK_workers_dept 
WHERE w.first_name = 'Viktoriya'/*Василий*/
GROUP BY w.first_name, d.city 
HAVING count(w.workers_id) > 1/*10*/
ORDER BY num_workers; 
/*w.workers_id?*/




