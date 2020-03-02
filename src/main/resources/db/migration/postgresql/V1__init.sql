create table eventos(
id serial,
nome varchar(50),
local varchar(50),
data varchar(50),
horario varchar(50),
primary key (id));

create table convidado(
rg serial,
nome_convidado varchar(50),
primary key(rg),
eventos integer,
foreign key(eventos) references eventos(id));