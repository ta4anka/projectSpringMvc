USE employeemanagerDB;


INSERT INTO roles(name)
VALUES 
('ROLE_ADMIN'),
('ROLE_MODERATOR'),
('ROLE_USER');


INSERT INTO users(username,password,role_id)
VALUES
('Vladimir','$2a$10$y71Rwd.9kmqbQRY3cdpSweAK4f4FVgsCgvHdlW9y58AQ7w4K7JQM2',1),
('Vlad','$2a$10$jl7.xjwvQryUcO2SUzvugORf8eJx6HywhTOch9SGSptP5ax8mjTz.',2),
('Maya','$2a$10$rAIYcBIbzRQrJ5nVwK0iP.PUwI29q1mEIw32Ga9.tIFP6i4arTQ9O',3);





 
