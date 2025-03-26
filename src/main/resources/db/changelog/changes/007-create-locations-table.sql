create table locations
(
    id           bigint primary key,
    address      varchar(50) not null,
    image        varchar(75) not null,
    phone_number varchar(20) not null,
    hotel_id     bigint,
    constraint FK_HOTEL_LOCATION foreign key (hotel_id) references hotels (id)
);

alter table locations owner to root;
create sequence location_id_seq;
alter sequence location_id_seq owner to root;