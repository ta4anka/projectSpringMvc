CREATE DATABASE  IF NOT EXISTS employeemanagerDB CHARACTER SET UTF8;
USE employeemanagerDB;


create table departments(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

create table employees (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    salary INT NOT NULL,
    birth_day DATE NOT NULL,
    employment_day DATE NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id)
    );



