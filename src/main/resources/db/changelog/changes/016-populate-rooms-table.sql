INSERT INTO rooms (id, no_people, price, image, description, type_id, location_id)
VALUES
    --romania
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 1),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 1),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 1),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 1),


    --sua
    (nextval('room_id_seq'), 2, 80.00, '',
     'Standard room with comfortable amenities', 1, 2),
    (nextval('room_id_seq'), 3, 110.00, '',
     'Premium room with enhanced services', 2, 2),
    (nextval('room_id_seq'), 4, 140.00, '',
     'Luxury room offering superior comfort', 3, 2),
    (nextval('room_id_seq'), 5, 170.00, '',
     'Presidential suite with exclusive features', 4, 2),


    --franta
    (nextval('room_id_seq'), 2, 80.00, '',
     'Standard room with comfortable amenities', 1, 3),
    (nextval('room_id_seq'), 3, 110.00, '',
     'Premium room with enhanced services', 2, 3),
    (nextval('room_id_seq'), 4, 140.00, '',
     'Luxury room offering superior comfort', 3, 3),
    (nextval('room_id_seq'), 5, 170.00, '',
     'Presidential suite with exclusive features', 4, 3),


    --germania
    (nextval('room_id_seq'), 2, 80.00, '',
     'Standard room with comfortable amenities', 1, 4),
    (nextval('room_id_seq'), 3, 110.00, '',
     'Premium room with enhanced services', 2, 4),
    (nextval('room_id_seq'), 4, 140.00, '',
     'Luxury room offering superior comfort', 3, 4),
    (nextval('room_id_seq'), 5, 170.00, '',
     'Presidential suite with exclusive features', 4, 4),


    --uk
    (nextval('room_id_seq'), 2, 80.00, '',
     'Standard room with comfortable amenities', 1, 5),
    (nextval('room_id_seq'), 3, 110.00, '',
     'Premium room with enhanced services', 2, 5),
    (nextval('room_id_seq'), 4, 140.00, '',
     'Luxury room offering superior comfort', 3, 5),
    (nextval('room_id_seq'), 5, 170.00, '',
     'Presidential suite with exclusive features', 4, 5),


    --italia
    (nextval('room_id_seq'), 2, 80.00, '',
     'Standard room with comfortable amenities', 1, 6),
    (nextval('room_id_seq'), 3, 110.00, '',
     'Premium room with enhanced services', 2, 6),
    (nextval('room_id_seq'), 4, 140.00, '',
     'Luxury room offering superior comfort', 3, 6),
    (nextval('room_id_seq'), 5, 170.00, '',
     'Presidential suite with exclusive features', 4, 6),

    --spania
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 7),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 7),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 7),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 7),

    --canada
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 8),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 8),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 8),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 8),

    --australia
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 9),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 9),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 9),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 9),

    --brazil
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 10),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 10),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 10),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 10),

    --india
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 11),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 11),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 11),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 11),

    --china
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 12),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 12),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 12),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 12),

    --russia
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 13),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 13),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 13),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 13),

    --japan
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 14),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 14),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 14),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 14),

    --south korea
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 15),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 15),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 15),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 15),

    --mexico
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 16),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 16),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 16),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 16),

    --argentina
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 17),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 17),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 17),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 17),

    --egypt
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 18),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 18),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 18),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 18),

    --south africa
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 19),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 19),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 19),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 19),

    --turkey
    (nextval('room_id_seq'), 2, 60.00, '',
     'Standard room with comfortable amenities', 1, 20),
    (nextval('room_id_seq'), 3, 90.00, '',
     'Premium room with enhanced services', 2, 20),
    (nextval('room_id_seq'), 4, 120.00, '',
     'Luxury room offering superior comfort', 3, 20),
    (nextval('room_id_seq'), 5, 150.00, '',
     'Presidential suite with exclusive features', 4, 20)





