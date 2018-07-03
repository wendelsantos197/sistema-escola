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