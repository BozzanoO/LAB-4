drop schema if exists spring;
drop user if exists 'user'@'localhost';

create schema spring;
create user 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table anc_anuncio (
 anc_id bigint primary key auto_increment,
 anc_nome_produto varchar (100) not null,
 anc_descricao varchar (200),
 anc_data_hora datetime not null,
 anc_preco float,
 anc_peso float
);

insert into anc_anuncio (anc_nome_produto, anc_data_hora, anc_peso)
    values ('Resistência 6800@','2024-03-15 23:59:59', 0.2),
        ('Liquidificador', current_timestamp(), null);