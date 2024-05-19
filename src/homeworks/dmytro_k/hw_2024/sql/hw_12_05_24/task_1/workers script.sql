use workers;

CREATE TABLE dept(
dept_id int AUTO_INCREMENT PRIMARY KEY,
city varchar(50)
);

INSERT INTO dept (city) VALUES
('South Kathleenport'),
('Rollinsmouth'),
('South Marissa'),
('South Ryan'),
('West Shawnview')
('West Kathleenport');

CREATE TABLE workers(
workers_id int AUTO_INCREMENT PRIMARY KEY,
first_name varchar(30),
last_name varchar(30),
FK_workers_dept int,
FOREIGN KEY (FK_workers_dept) REFERENCES dept(dept_id)
);

INSERT INTO workers (first_name, last_name, FK_workers_dept) VALUES
('Irina'    ,  'Petrov'    , 1),
('Anastasiya', 'Sokolova' , 2),
('Olena'    ,  'Kovalchuk' , 3),
('Katerina' ,  'Ivanova'   , 4),
('Yuliya'   ,  'Lysenko'   , 5),
('Nataliya' ,  'Zaytseva'  , 1),
('Lyudmyla' ,  'Kozak'     , 5),
('Tetyana'  ,  'Moroz'     , 5),
('Mariya'   ,  'Hryhorenko', 3),
('Viktoriya',  'Shevchenko', 2),
('Oleksandr',  'Ivanov'    , 1),
('Mykhaylo' ,  'Petrov'    , 1),
('Ihor'     ,  'Sydorov'   , 4),
('Volodymyr',  'Koval'     , 4),
('Serhiy'   ,  'Morozov'   , 2),
('Andriy'   ,  'Zaytsev'   , 4),
('Vitaliy'  ,  'Khravchuk' , 5),
('Pavlo'    ,  'Lysenko'   , 3),
('Denys'    ,  'Hrytsenko' , 3),
('Yaroslav' ,  'Semenov'   , 1),
('Viktoriya',  'Myronenko'),	
('Viktoriya',  'Shevchenko', 2),
('Anastasiya', 'Sokolova',   2);
  
   