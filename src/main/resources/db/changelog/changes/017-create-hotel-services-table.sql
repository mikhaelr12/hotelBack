create table hotel_services(
    id bigint primary key ,
    service_name varchar(50) not null
);

alter table hotel_services owner to root;
create sequence services_id_seq;
alter sequence services_id_seq owner to root;