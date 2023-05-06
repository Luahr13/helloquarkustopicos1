-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into pessoa (nome) values('Marco');
insert into pessoa (nome) values('Fredson');

insert into pessoafisica(id, cpf, sexo) values (1, '111.111.111-11', 1);
insert into pessoafisica(id, cpf) values (2, '222.222.222-22');

insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

insert into municipio (nome, id_estado) values( 'Palmas', 1);
insert into municipio (nome, id_estado) values( 'Paraiso do Tocantins', 1);

--insert into usuario(login, senha, id_pessoa_fisica) values ("marco", "123", 1);
--insert into usuario(login, senha, id_pessoa_fisica) values ("fred", "123", 2);


insert into usuario (login, senha) values('marco', '123');
insert into usuario (login, senha, id_pessoa_fisica) values('fredson', '123', 2);

insert into perfis(id_usuario, perfil) values(1, 'Admin');
insert into perfis(id_usuario, perfil) values(1, 'User');
insert into perfis(id_usuario, perfil) values(2, 'User');