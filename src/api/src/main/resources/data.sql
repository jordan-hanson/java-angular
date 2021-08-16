INSERT INTO departments(id, name) values (1, 'Engineering');
INSERT INTO departments(id, name) values (2, 'Operations');
INSERT INTO departments(id, name) values (3, 'Accounting');


INSERT INTO users(userid, firstname, lastname, code, department, manager) values (1, 'Jordan', 'Tester', 12, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (2, 'Abby', 'Tester', 123, 'Operations', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (3, 'Katelyn', 'Tester', 1234, 'Operations', 'Lacee Marcus');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (4, 'Jackson', 'Tester', 12345, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (5, 'Jenson', 'Tester', 45, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (6, 'Erik', 'Tester', 345, 'Engineering', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (7, 'Pam', 'Tester', 2345, 'Engineering', 'Lacee Marcus');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (8, 'Deborah', 'Tester', 980, 'Engineering', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (9, 'Camin', 'Tester', 124, 'Engineering', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (10, 'Camie', 'Tester', 125, 'Accounting', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (11, 'Jessica', 'Tester', 126, 'Accounting', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (12, 'Zavier', 'Tester', 127, 'Accounting', 'Lacee Marcus');
--
INSERT INTO roles(id, name)
VALUES(100, 'ADMIN'),
      (200, 'USER'),
      (300, 'MANAGER'),
      (400, 'EMPLOYEE');
