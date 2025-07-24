insert into room_types (id, type_name)
values (nextval('types_id_seq'), 'Standard'),
       (nextval('types_id_seq'), 'Premium'),
       (nextval('types_id_seq'), 'Luxury'),
       (nextval('types_id_seq'), 'Presidential')