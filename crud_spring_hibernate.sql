create database crud_spring_hibernate;

use crud_spring_hibernate;

create table cliente(
cli_id integer not null primary key auto_increment,
cli_nome varchar(50) not null,
cli_rg varchar(15) not null,
cli_cpf varchar(15) not null
);

create table fornecedor(
for_id integer not null primary key auto_increment,
for_descricao varchar(50) not null
);

create table produto(
pro_id integer not null primary key auto_increment,
pro_descricao varchar(30) not null,
pro_qtd integer not null,
pro_for_id integer not null,
foreign key(pro_for_id) references fornecedor(for_id)
);

create table compra(
com_id integer not null primary key auto_increment,
com_cli_id integer not null,
com_pro_id integer not null,
com_data date not null,
com_hora time not null,
foreign key(com_cli_id) references cliente(cli_id),
foreign key(com_pro_id) references produto(pro_id)
);