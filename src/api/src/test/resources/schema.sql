DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
   id int AUTO_INCREMENT  PRIMARY KEY,
   name varchar(1000) NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    userid int AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    code int,
    department VARCHAR(255),
    manager VARCHAR(255));

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
    id int AUTO_INCREMENT  PRIMARY KEY,
    name varchar(1000) NOT NULL
);
