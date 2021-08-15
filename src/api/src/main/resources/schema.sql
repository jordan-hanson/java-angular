-- DROP TABLE IF EXISTS tester;
-- CREATE TABLE tester(
--    id int AUTO_INCREMENT  PRIMARY KEY,
--    name varchar(1000) NOT NULL
-- );

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    userid int AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    code int);
