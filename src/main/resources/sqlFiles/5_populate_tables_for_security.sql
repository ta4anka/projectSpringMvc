USE employeemanagerDB;


INSERT INTO roles(name)
VALUES 
('ROLE_ADMIN'),
('ROLE_MODERATOR'),
('ROLE_USER');


INSERT INTO users(username,password,role_id)
VALUES
('Vladimir','root1',1),
('Vlad','root2',2),
('Maya','root3',3);





 
