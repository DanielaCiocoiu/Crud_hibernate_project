CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

SELECT * FROM employee_directory.employee;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `employee_detail`;



CREATE TABLE `employee` (
  `id_employee` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `departament` varchar(60) DEFAULT NULL,
  `employee_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  KEY `FK_DETAIL_idx` (`employee_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_detail_id`)
  REFERENCES `employee_detail` (`id_employee`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `employee_detail` (
  `id_emp_detail` int(11) NOT NULL AUTO_INCREMENT,
  `salary` int(50) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_emp_detail`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `phones`;
CREATE TABLE `phones` (
  `id_phone` INT(50) NOT NULL AUTO_INCREMENT,
  `type_phone` varchar(45) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id_phone`),

  KEY `FK_EMPLOYEE_idx` (`employee_id`),

  CONSTRAINT `FK_EMPLOYEE`
  FOREIGN KEY (`employee_id`)
  REFERENCES `employee` (`id_employee`)

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('1', 'MOBILE', '0722139456', '1');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('2', 'FIX_HOME', '021555777', '1');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('3', 'FIX_WORK', '125444556', '1');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('4', 'WORK_MOBILE', '071112222', '1');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('5', 'MOBILE', '0722139456', '2');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('6', 'FIX_HOME', '071112222', '2');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('7', 'FIX_WORK', '071112222', '2');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('8', 'WORK_MOBILE', '0722139456', '2');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('9', 'MOBILE', '071112222', '3');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('10', 'FIX_HOME', '071112222', '3');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('11', 'FIX_WORK', '071112222', '3');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('12', 'WORK_MOBILE', '071112222', '3');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('13', 'MOBILE', '071112222', '4');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('14', 'FIX_HOME', '071112222', '4');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('15', 'FIX_WORK', '071112222', '4');
INSERT INTO `employee_directory`.`phones` (`id_phone`, `type_phone`, `phone_number`, `employee_id`) VALUES ('16', 'WORK_MOBILE', '071112222', '4');




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
