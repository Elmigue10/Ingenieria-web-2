REQUSITOS: 

- Servidor de Glassfish instalado.

- MySQL.

CREACIÓN DE LA BASE DE DATOS:

CREATE DATABASE IF NOT EXISTS umb;

USE umb;

CREATE TABLE IF NOT EXISTS persona(Id int PRIMARY KEY auto_increment, DNI varchar(50), Nombres varchar(50));

INSERT INTO persona(DNI, Nombres) VALUES ("7863425", "Miguel Valbuena");
INSERT INTO persona(DNI, Nombres) VALUES ("6242112", "Juan Perez");
INSERT INTO persona(DNI, Nombres) VALUES ("2895433", "Luis Diaz");