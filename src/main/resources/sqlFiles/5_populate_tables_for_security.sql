-- USE employeemanagerDB;


INSERT INTO roles(id,name)
VALUES 
(1,'ROLE_ADMIN'),
(2,'ROLE_MODERATOR'),
(3,'ROLE_USER');


INSERT INTO users(id,username,password,role_id)
VALUES
(1,'Vladimir','$2a$10$y71Rwd.9kmqbQRY3cdpSweAK4f4FVgsCgvHdlW9y58AQ7w4K7JQM2',1),
(2,'Vlad','$2a$10$jl7.xjwvQryUcO2SUzvugORf8eJx6HywhTOch9SGSptP5ax8mjTz.',2),
(3,'Maya','$2a$10$rAIYcBIbzRQrJ5nVwK0iP.PUwI29q1mEIw32Ga9.tIFP6i4arTQ9O',3);





 
