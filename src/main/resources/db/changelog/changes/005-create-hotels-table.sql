create table hotels
(
    id          bigint       primary key ,
    name        varchar(50)  not null unique,
    description varchar(500) not null,
    country_id bigint not null ,
    constraint FK_COUNTRY_HOTEL foreign key (country_id) references countries (id)
);

alter table hotels owner to root;
create sequence hotel_id_seq;
alter sequence hotel_id_seq owner to root;