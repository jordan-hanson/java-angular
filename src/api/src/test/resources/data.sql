INSERT INTO departments(id, name) values (6, 'Engineering');
INSERT INTO departments(id, name) values (7, 'Operations');
INSERT INTO departments(id, name) values (8, 'Accounting');


INSERT INTO users(userid, firstname, lastname, code, department, manager) values (13, 'Jordan', 'Tester', 12, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (14, 'Abby', 'Tester', 123, 'Operations', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (15, 'Katelyn', 'Tester', 1234, 'Operations', 'Lacee Marcus');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (16, 'Jackson', 'Tester', 12345, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (17, 'Jenson', 'Tester', 45, 'Operations', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (18, 'Erik', 'Tester', 345, 'Engineering', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (19, 'Pam', 'Tester', 2345, 'Engineering', 'Lacee Marcus');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (20, 'Deborah', 'Tester', 980, 'Engineering', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (21, 'Camin', 'Tester', 124, 'Engineering', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (22, 'Camie', 'Tester', 125, 'Accounting', 'Denna Livingston');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (23, 'Jessica', 'Tester', 126, 'Accounting', 'Lloyd Hanson');
INSERT INTO users(userid, firstname, lastname, code, department, manager) values (24, 'Zavier', 'Tester', 127, 'Accounting', 'Lacee Marcus');
--
INSERT INTO roles(id, name)
VALUES(500, 'ADMIN'),
      (600, 'USER'),
      (700, 'MANAGER'),
      (800, 'EMPLOYEE');
