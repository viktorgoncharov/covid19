CREATE DATABASE covid19;
CREATE USER 'covid19'@'localhost' IDENTIFIED BY 'covid19localhost';
GRANT ALL PRIVILEGES ON covid19.* TO 'covid19'@'localhost';