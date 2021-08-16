INSERT INTO departments(id, name) values (1, 'engineering');
INSERT INTO departments(id, name) values (2, 'operations');
INSERT INTO users(userid, firstname, lastname, code) values (1, 'Jordan', 'Tester', 12345);
-- DELETE
-- FROM users;
--
-- DELETE
-- FROM roles;

-- INSERT INTO users(userid, firstname, lastname, code) values (1, 'Jordan', 'Tester', 12345);

--        (2, 'Manager', 'Tester', 'testmanager', 'testUserA@email.com', 'abcdef'),
--        (3, 'EmployeeJ', 'Tester', 'testempolyeej', 'testEmployeeJ@email.com', 'abcdef'),
--        (4, 'Abby', 'Tester', 'testemployeeA', 'testUserB@email.com', 'abcdef'),
--        (5, 'Katelyn', 'Tester', 'testemployeeK', 'testUserC@email.com', 'abcdef'),
--        (6, 'Tyler', 'Tester', 'testemployeeTy', 'testUserD@email.com', 'abcdef'),
--        (7, 'Jacob', 'Tester', 'testemployeeJa', 'testUserE@email.com', 'abcdef'),
--        (8, 'Jeff', 'Tester', 'testemployeeJe', 'testUserF@email.com', 'abcdef');
--
INSERT INTO roles(id, name)
VALUES(100, 'ADMIN'),
      (200, 'USER'),
      (300, 'MANAGER'),
      (400, 'EMPLOYEE');
--
-- INSERT INTO userroles(userid, roleid)
-- VALUES(1, 400),
--       (2, 300),
--       (3, 400),
--       (4, 400),
--       (5, 400),
--       (6, 400),
--       (7, 400),
--       (8, 400);
-- alter sequence hibernate_sequence restart with 20;