create table countries(
    id bigint primary key ,
    country_name varchar(50) not null ,
    city_name varchar(50) not null
);

alter table countries owner to root;
create sequence country_id_seq;
alter sequence country_id_seq owner to root;