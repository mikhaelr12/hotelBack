insert into users(id, username, password, email, role_id)
values (nextval('user_id_seq'), 'admin1', 'admin1123', '.', 2),
       (nextval('user_id_seq'), 'admin2', 'admin2123', '..', 2),
       (nextval('user_id_seq'), 'admin3', 'admin3123', '...', 2),
       (nextval('user_id_seq'),'partner1', 'partner1123', '....', 3),
       (nextval('user_id_seq'),'partner2', 'partner1123', '.....', 3),
       (nextval('user_id_seq'),'partner3', 'partner1123', '......', 3)