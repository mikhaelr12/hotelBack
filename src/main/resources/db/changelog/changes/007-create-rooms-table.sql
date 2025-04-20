create table rooms
(
    id          bigint primary key,
    no_people   int           not null,
    price       decimal(7, 2) not null,
    image       varchar(75)   not null,
    description varchar(250)  not null,
    type_id     bigint        not null,
    hotel_id bigint        not null,
    constraint FK_TYPE_ROOM foreign key (type_id) references room_types (id),
    constraint FK_HOTEL_ROOM foreign key (hotel_id) references hotels (id)
);

alter table rooms owner to root;
create sequence room_id_seq;
alter sequence room_id_seq owner to root;