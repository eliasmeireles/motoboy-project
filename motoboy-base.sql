drop schema if exists fast_motoboy;
create schema fast_motoboy;
use fast_motoboy;

create table cliente (
	id char(36) not null,
	nome varchar(50) not null,
	sobrenome varchar(50) not null,
	cpf char(11) not null unique,
	email varchar(50) not null unique,
    senha varchar(96) not null,
    datacadastro date not null,
	celular char(12) not null
);
alter table cliente add constraint pk_cliente primary key (id);

create table motoboy (
	id char(36)  not null,
	nome varchar(50) not null,
	sobrenome varchar(50) not null,
    senha varchar(96) not null,
	cpf char(11) not null unique,
	email varchar(50) not null unique,
    datacadastro date not null,
	celular char(12) not null
);
alter table motoboy add constraint pk_motoboy primary key (id);

create table moto (
	id char(36)  not null,
	nome varchar(100) not null,
    modelo varchar(100) not null,
	cor varchar(50) not null,
	placa char(8) not null unique,
    datacadastro date not null,
    motoboy_id char(36) not null
);
alter table moto add constraint pk_moto primary key (id);
alter table moto add constraint fk_motoboy_id foreign key(motoboy_id) references motoboy(id);



