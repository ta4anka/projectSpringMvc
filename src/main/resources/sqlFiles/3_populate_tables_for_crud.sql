-- USE employeemanagerDB;

INSERT INTO departments(name)
VALUES
('HR department'),
('IT department'),
('R&D department'),
('Finance department');

INSERT INTO employees(first_name,last_name,salary,birth_day,employment_day,department_id)
VALUES
('Brian','Kernighan',7000,'1985-09-15','2009-02-20',11),
('Dennis','Ritchie',6500,'1984-07-10','2012-04-21',21),
('Bjarne','Stroustrup',7500,'1980-06-12','2012-07-25',31),
('James','Gosling',9500,'1979-05-19','2016-01-06',21),
('Steve','Wozniak',9500,'1982-03-21','2018-09-17',21),
('Linus','Torvalds',8000,'1987-05-09','2014-08-01',31),
('Guido','vanRossum',9000,'1988-09-09','2013-09-07',21),
('Brendan','Eich',6000,'1995-03-05','2019-02-10',31),
('Brad','Cox',2000,'1999-01-01','2019-05-01',11);


