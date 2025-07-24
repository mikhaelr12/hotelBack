insert into statuses(id, status_name) values (nextval('status_id_seq'), 'Pending'),
                                             (nextval('status_id_seq'), 'Confirmed'),
                                             (nextval('status_id_seq'), 'Cancelled'),
                                             (nextval('status_id_seq'), 'Completed')