-- USE employeemanagerDB;

-- Table: roles
CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
    ) ENGINE = InnoDB;

-- Table: users
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BIT DEFAULT 1,

    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
) ENGINE = InnoDB;


