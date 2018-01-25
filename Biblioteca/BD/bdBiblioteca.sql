create database biblioteca;
use biblioteca;

create table usuario(
    id int auto_increment,
    nome varchar(100),
    telefone varchar(20),
    cpf varchar(20),
    cep varchar(20),
    nresidencia varchar(10),
    primary key (id)
);

create table livro(
    id int auto_increment,
    titulo varchar(150),
    autor varchar(150),
    primary key (id)
);
    
Create table emprestimo(
    id int auto_increment,
    usuarioFk int,
    livroFk int,
    dataEmprestimo varchar(11),
    dataDevolucao varchar(11),
    primary key (id),
    foreign key (usuarioFk) references usuario(id),
    foreign key (livroFk) references livro(id)
);

Create table reserva(
    id int auto_increment,
    usuarioFk int,
    livroFk int,
    dataSolicitacao varchar(11),
    dataReserva varchar(11),
    primary key (id),
    foreign key (usuarioFk) references usuario(id),
    foreign key (livroFk) references livro(id)
);

create table funcionario(
    id int auto_increment,
    nome varchar(100),
    telefone varchar(20),
    cpf varchar(20),
    cep varchar(20),
    nresidencia varchar(10),
    primary key (id)
);

