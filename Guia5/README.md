MYSQL DOCKER IMAGE

docker pull mysql

docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql --lower_case_table_names=1

docker exec -it mysql-db mysql -p

Enter password: secret

CREATE DATABASE IF NOT EXISTS crud;

USE crud;

CREATE TABLE IF NOT EXISTS superhero(id int NOT NULL PRIMARY KEY auto_increment, nombre VARCHAR(50) NOT NULL, votos int DEFAULT 0);

INSERT INTO superhero (nombre, votos) VALUES ("Capitan America", 7);
INSERT INTO superhero (nombre, votos) VALUES ("Iron Man", 8);
INSERT INTO superhero (nombre, votos) VALUES ("Thor", 9);
INSERT INTO superhero (nombre, votos) VALUES ("Spiderman", 12);
INSERT INTO superhero (nombre, votos) VALUES ("Doctor Strange", 9);
INSERT INTO superhero (nombre, votos) VALUES ("Black Widow", 6);
INSERT INTO superhero (nombre, votos) VALUES ("Scarlet Witch", 7);
INSERT INTO superhero (nombre, votos) VALUES ("Hulk", 7);
INSERT INTO superhero (nombre, votos) VALUES ("Hawk Eye", 5);
INSERT INTO superhero (nombre, votos) VALUES ("Capitana Marvel", 10);
INSERT INTO superhero (nombre, votos) VALUES ("Start Lord", 4);
INSERT INTO superhero (nombre, votos) VALUES ("Black Panter", 9);
INSERT INTO superhero (nombre, votos) VALUES ("Ant Man", 4);