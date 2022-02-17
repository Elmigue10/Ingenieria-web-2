REQUERIMIENTOS:

 -Docker
 
 -nodeJs

COMANDOS PARA MONTAR LA BASE DE DATOS MYSQL EN DOCKER:

docker pull mysql

docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql --lower_case_table_names=1

docker exec -it mysql-db mysql -p

password: secret

CREACIÓN DE LA BASE DE DATOS CON LA TABLA USER:

create database gestion;

use gestion;

create table user(id mediumint not null AUTO_INCREMENT, firstName VARCHAR(32) NOT NULL, lastName VARCHAR(32) NOT NULL, document VARCHAR(16) NOT NULL, address VARCHAR(64) NOT NULL, phone INT(10) DEFAULT NULL, email VARCHAR(32) DEFAULT NULL, primary key(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user ADD UNIQUE document(document);

VOLCADO DE DATOS TABLA USER:

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Miguel","Valbuena","10002345", "Calle 22a #3", 312323212, "miguel@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Angela","Gomez","11923123", "Calle 12a #6", 321424312, "angela@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Diego","Rodriguez","1214645", "Calle 26a #34", 312536331, "diego@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Isabella","Valbuena","124435", "Calle 122a #33", 316325312, "isabella@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Thomas","Perez","412234123", "Calle 32a #37", 311525145, "thomas@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Sara","Caicedo","10234525", "Calle 152a #11", 312452353, "sara@email.com");

INSERT INTO user (firstName, lastName, document, address, phone, email) VALUES ("Juan","Suarez","12344134", "Calle 127a #14", 312546421, "juan@email.com");

select * from user;

PASOS PARA EJECUTAR EL PROYECTO:

npm init -y -> Para iniciar nuestro proyecto con node

npm install mysql2 -> Para conectarnos a la base de datos. ¿Por que usar mysql2 y no mysql? https://stackoverflow.com/questions/50093144/mysql-8-0-client-does-not-support-authentication-protocol-requested-by-server

npm consulta.js -> Para ejecutar el proyecto

INSTALACIÓN DE EXPRESS PARA CREAR UN SERVIDOR:

npm install express -> Para instalar el modulo express

INSTALACIÓN DE UN MOTOR DE PLANTILLAS PARA HACER RENDERS DINAMICOS:

npm install pug -> Para instalar el motor de plantillas pug

POR ULTIMO:

node consulta.js -> Para ejecutar nuestro servidor

Visitar http://localhost:3000