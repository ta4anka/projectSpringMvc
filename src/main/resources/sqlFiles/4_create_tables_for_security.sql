USE employeemanagerDB;

-- Table: users
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active bit(1) NOT NULL
) ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    ) ENGINE = InnoDB;

-- Table: user_roles
CREATE TABLE user_role(
user_id INT NOT NULL,
role_id INT NOT NULL,


FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (role_id) REFERENCES roles(id),

UNIQUE (user_id, role_id)
) ENGINE = InnoDB;

