REQUERIMIENTOS:

-Docker

-nodeJs

COMANDOS PARA MONTAR LA BASE DE DATOS MYSQL EN DOCKER:

docker pull mysql

docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql --lower_case_table_names=1

docker exec -it mysql-db mysql -p

password: secret

CREACIÓN DE LA BASE DE DATOS:

CREATE DATABASE IF NOT EXISTS gestion;

USE gestion;

CREATE TABLE IF NOT EXISTS cliente(
    id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    activo BOOLEAN DEFAULT FALSE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

PASOS PARA EJECUTAR EL PROYECTO:

npm init -y -> Para iniciar nuestro proyecto con node

npm install express mysql2 body-parser --save -> Para instalar las librerias express, mysql2 y body-parser

node server.js

IMPORTAR LA COLECCIÓN DE POSTMAN Y PROBAR LOS SERVICIOS :).