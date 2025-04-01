create table users
(

    id       bigint primary key,
    username varchar(50) not null unique,
    password varchar(255) not null,
    email    varchar(50) not null unique,
    phone_number varchar(30),
    loyalty_points int,
    role_id  bigint,
    constraint FK_ROLE_USER foreign key (role_id) references user_roles (id)
);

alter table users owner to root;
create sequence user_id_seq;
alter sequence user_id_seq owner to root;