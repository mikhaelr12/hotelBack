create table booking_services_services(
    booking_id bigint not null ,
    service_id bigint not null ,
    primary key (booking_id, service_id),
    foreign key (booking_id) references booking_services (id),
    foreign key (service_id) references hotel_services (id)
);