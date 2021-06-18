DROP DATABASE if exists employee_management_system;
CREATE DATABASE employee_management_system;
USE employee_management_system;

CREATE TABLE employees(
    employee_id INT AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email_id VARCHAR(50) NOT NULL,
    CONSTRAINT employee_id_pk PRIMARY KEY(employee_id)
);

INSERT INTO employees VALUES (1000000, 'Barry', 'Allen', 'barry.allen@gmail.com');
INSERT INTO employees VALUES (1000001, 'Bruce', 'Wayne', 'bruce.wayne@gmail.com');

COMMIT;

SELECT * FROM employees;