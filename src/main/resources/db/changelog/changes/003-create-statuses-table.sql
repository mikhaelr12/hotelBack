create table statuses
(

    id          bigint primary key,
    status_name varchar(15) not null
);

alter table statuses owner to root;
create sequence status_id_seq;
alter sequence status_id_seq owner to root;