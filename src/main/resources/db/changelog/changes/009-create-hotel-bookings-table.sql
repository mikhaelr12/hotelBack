create table hotel_bookings
(
    id          bigint primary key,
    check_in    date           not null,
    check_out   date           not null,
    final_price decimal(15, 2) not null,
    user_id     bigint         not null,
    location_id bigint         not null,
    room_id     bigint         not null,
    status_id   bigint         not null,
    constraint FK_USER_BOOKING foreign key (user_id) references users (id),
    constraint FK_LOCATION_BOOKING foreign key (location_id) references locations (id),
    constraint FK_ROOM_BOOKING foreign key (room_id) references rooms (id),
    constraint FK_STATUS_BOOKING foreign key (status_id) references statuses (id)
);

alter table hotel_bookings owner to root;
create sequence hotel_booking_id_seq;
alter sequence hotel_booking_id_seq owner to root;