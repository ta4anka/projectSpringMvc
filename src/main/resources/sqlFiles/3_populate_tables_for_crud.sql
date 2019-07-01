-- USE employeemanagerDB;

INSERT INTO departments(id,name)
VALUES
(1,'HR department'),
(2,'IT department'),
(3,'R&D department'),
(4,'Finance department');

INSERT INTO employees(id,first_name,last_name,salary,birth_day,employment_day,department_id)
VALUES
(1,'Brian','Kernighan',7000,'1985-09-15','2009-02-20',1),
(2,'Dennis','Ritchie',6500,'1984-07-10','2012-04-21',2),
(3,'Bjarne','Stroustrup',7500,'1980-06-12','2012-07-25',3),
(4,'James','Gosling',9500,'1979-05-19','2016-01-06',2),
(5,'Steve','Wozniak',9500,'1982-03-21','2018-09-17',4),
(6,'Linus','Torvalds',8000,'1987-05-09','2014-08-01',3),
(7,'Guido','vanRossum',9000,'1988-09-09','2013-09-07',1),
(8,'Brendan','Eich',6000,'1995-03-05','2019-02-10',1),
(9,'Brad','Cox',2000,'1999-01-01','2019-05-01',4);


