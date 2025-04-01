create table booking_services(
    id bigint primary key ,
    booking_id bigint,
    constraint FK_BOOKING_SERVICES foreign key (booking_id) references hotel_bookings (id)
);

alter table booking_services owner to root;
create sequence booking_services_id_seq;
alter sequence booking_services_id_seq owner to root;