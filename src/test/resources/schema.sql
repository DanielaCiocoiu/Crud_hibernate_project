CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

SELECT * FROM employee_directory.employee;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `employee_detail`;



CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `departament` varchar(60) DEFAULT NULL,
  `employee_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`employee_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_detail_id`) REFERENCES `employee_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `employee_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary` int(50) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;



insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (1, 'Avani', 'Gupta', str_to_date('1978-10-05 00:00:00', '%Y-%m-%d %T'), 'avani@gmail.com', 'FINANCE', 1);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (2, 'Yuri', 'Petrov', str_to_date('1990-10-05 00:00:00', '%Y-%m-%d %T'), 'yuri@gmail.com', 'HR', 2);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (3, 'Juan', 'Vega', str_to_date('1975-10-05 01:00:00', '%Y-%m-%d %T'), 'juan@gmail.com', 'IT', 3);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (4, 'Jack', 'Boot', str_to_date('1989-10-05 00:00:00', '%Y-%m-%d %T'), 'Jack@gmail.com', 'HR', 4);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (5, 'Mia', 'Marina', str_to_date('1945-10-05 00:00:00', '%Y-%m-%d %T'), 'Mia@gmail.com', 'FINANCE', 5);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (6, 'Maia', 'Baumgarten', str_to_date('1965-10-05 00:00:00', '%Y-%m-%d %T'), 'emma@gmail.com', 'HR', 6);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (7, 'Ion', 'Miresleanu', str_to_date('1969-10-05 00:00:00', '%Y-%m-%d %T'), 'Ion@gmail.com', 'IT', 7);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (8, 'Irinel', 'Nicolescu', str_to_date('1955-01-01 00:00:00', '%Y-%m-%d %T'), 'irinel@yahoo.com', 'HR', 8);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (9, 'Emma', 'Nica', str_to_date('1956-02-14 00:00:00', '%Y-%m-%d %T'), 'ema@yahoo.com', 'FINANCE', 9);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (10, 'Vasile', 'Frasin', str_to_date('1989-11-08 00:00:00', '%Y-%m-%d %T'), 'Vasile@gmail.com', 'HR', 10);
insert into employee (id, first_name, last_name, date_of_birth, email, departament, employee_detail_id) values (11, 'Ama', 'Iliescu', str_to_date('1988-11-08 00:00:00', '%Y-%m-%d %T'), 'Ama@gmail.com', 'IT', 11);




insert into employee_detail (id, salary, address) values (1, 2000, 'Reservelor');
insert into employee_detail (id, salary, address) values (2, 1500, 'Baia de Arama');
insert into employee_detail (id, salary, address) values (3, 3000, 'Ficusului');
insert into employee_detail (id, salary, address) values (4, 6000, 'Unirii');
insert into employee_detail (id, salary, address) values (5, 5000, 'Elisabeta');
insert into employee_detail (id, salary, address) values (6, 8000, 'Mosilor');
insert into employee_detail (id, salary, address) values (7, 9000, 'Ferentari');
insert into employee_detail (id, salary, address) values (8, 4000, 'Primaverii');
insert into employee_detail (id, salary, address) values (9, 4000, 'Ceusului');
insert into employee_detail (id, salary, address) values (10, 5000, 'Apeductului');
insert into employee_detail (id, salary, address) values (11, 6000, 'Iuliu Maniu');
