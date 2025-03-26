create table user_roles
(
    id        bigint primary key,
    role_name varchar(10) not null unique
);

alter table user_roles owner to root;
create sequence user_role_id_seq;
alter sequence user_role_id_seq owner to root;