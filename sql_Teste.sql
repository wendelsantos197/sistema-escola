create database escola;

use escola;

create TABLE aluno(
id int not null primary key auto_increment,
nome varchar(50),
email varchar(80),
data_nascimento date,
imagem varchar(100),
turma varchar(1)
);

create TABLE curso(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
codigo varchar(5),
nome varchar(100)
);

CREATE TABLE usuario (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(100),
email varchar(50),
login varchar(50),
senha varchar(50)
);