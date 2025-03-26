create table room_types
(
    id        bigint primary key,
    type_name varchar(25) not null
);

alter table room_types owner to root;
create sequence types_id_seq;
alter sequence types_id_seq owner to root;