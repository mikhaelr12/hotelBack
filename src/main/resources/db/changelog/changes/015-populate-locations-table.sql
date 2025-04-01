INSERT INTO locations (id, address, image, phone_number, hotel_id)
VALUES
    -- România (Country id=1: Hotel id 1-3)
    (nextval('location_id_seq'), 'Str. Libertății, Nr. 10', '', '+40 213456789', 1),
    (nextval('location_id_seq'), 'Str. Unirii, Nr. 20', '', '+40 214567890', 2),
    (nextval('location_id_seq'), 'Str. Mihai Eminescu, Nr. 30', '', '+40 215678901', 3),

    -- SUA (Country id=2: Hotel id 4-6)
    (nextval('location_id_seq'), '5th Avenue', '', '+1 2123456789', 4),
    (nextval('location_id_seq'), 'Madison Avenue', '', '+1 2134567890', 5),
    (nextval('location_id_seq'), 'Broadway', '', '+1 2145678901', 6),

    -- Franța (Country id=3: Hotel id 7-9)
    (nextval('location_id_seq'), 'Champs-Élysées', '', '+33 123456789', 7),
    (nextval('location_id_seq'), 'Rue de Rivoli', '', '+33 234567890', 8),
    (nextval('location_id_seq'), 'Avenue des Champs', '', '+33 345678901', 9),

    -- Germania (Country id=4: Hotel id 10-12)
    (nextval('location_id_seq'), 'Unter den Linden', '', '+49 301234567', 10),
    (nextval('location_id_seq'), 'Potsdamer Platz', '', '+49 302345678', 11),
    (nextval('location_id_seq'), 'Alexanderplatz', '', '+49 303456789', 12),

    -- Marea Britanie (Country id=5: Hotel id 13-15)
    (nextval('location_id_seq'), 'Piccadilly', '', '+44 2071234567', 13),
    (nextval('location_id_seq'), 'Oxford Street', '', '+44 2072345678', 14),
    (nextval('location_id_seq'), 'Regent Street', '', '+44 2073456789', 15),

    -- Italia (Country id=6: Hotel id 16-18)
    (nextval('location_id_seq'), 'Via Veneto', '', '+39 061234567', 16),
    (nextval('location_id_seq'), 'Piazza Navona', '', '+39 062345678', 17),
    (nextval('location_id_seq'), 'Via Appia', '', '+39 063456789', 18),

    -- Spania (Country id=7: Hotel id 19-21)
    (nextval('location_id_seq'), 'Gran Vía', '', '+34 912345678', 19),
    (nextval('location_id_seq'), 'Calle de Alcalá', '', '+34 923456789', 20),
    (nextval('location_id_seq'), 'Plaza Mayor', '', '+34 934567890', 21),

    -- Canada (Country id=8: Hotel id 22-24)
    (nextval('location_id_seq'), 'Yonge Street', '', '+1 4161234567', 22),
    (nextval('location_id_seq'), 'Queen Street', '', '+1 4162345678', 23),
    (nextval('location_id_seq'), 'Bloor Street', '', '+1 4163456789', 24),

    -- Australia (Country id=9: Hotel id 25-27)
    (nextval('location_id_seq'), 'George Street', '', '+61 292345678', 25),
    (nextval('location_id_seq'), 'Circular Quay', '', '+61 293456789', 26),
    (nextval('location_id_seq'), 'Darling Harbour', '', '+61 294567890', 27),

    -- Brazilia (Country id=10: Hotel id 28-30)
    (nextval('location_id_seq'), 'Avenida Paulista', '', '+55 1123456789', 28),
    (nextval('location_id_seq'), 'Rua Augusta', '', '+55 1223456789', 29),
    (nextval('location_id_seq'), 'Av. Faria Lima', '', '+55 1323456789', 30),

    -- India (Country id=11: Hotel id 31-33)
    (nextval('location_id_seq'), 'MG Road', '', '+91 2212345678', 31),
    (nextval('location_id_seq'), 'Linking Road', '', '+91 2223456789', 32),
    (nextval('location_id_seq'), 'Colaba Causeway', '', '+91 2234567890', 33),

    -- China (Country id=12: Hotel id 34-36)
    (nextval('location_id_seq'), 'Wangfujing', '', '+86 1012345678', 34),
    (nextval('location_id_seq'), 'Chang''an Avenue', '', '+86 1023456789', 35),
    (nextval('location_id_seq'), 'Tiananmen', '', '+86 1034567890', 36),

    -- Rusia (Country id=13: Hotel id 37-39)
    (nextval('location_id_seq'), 'Tverskaya Street', '', '+7 4951234567', 37),
    (nextval('location_id_seq'), 'Arbat Street', '', '+7 4952345678', 38),
    (nextval('location_id_seq'), 'Novinsky Boulevard', '', '+7 4953456789', 39),

    -- Japonia (Country id=14: Hotel id 40-42)
    (nextval('location_id_seq'), 'Ginza', '', '+81 351234567', 40),
    (nextval('location_id_seq'), 'Shinjuku', '', '+81 352345678', 41),
    (nextval('location_id_seq'), 'Akihabara', '', '+81 353456789', 42),

    -- Coreea de Sud (Country id=15: Hotel id 43-45)
    (nextval('location_id_seq'), 'Myeongdong', '', '+82 221234567', 43),
    (nextval('location_id_seq'), 'Gangnam', '', '+82 222345678', 44),
    (nextval('location_id_seq'), 'Itaewon', '', '+82 223456789', 45),

    -- Mexic (Country id=16: Hotel id 46-48)
    (nextval('location_id_seq'), 'Paseo de la Reforma', '', '+52 5512345678', 46),
    (nextval('location_id_seq'), 'Insurgentes', '', '+52 5523456789', 47),
    (nextval('location_id_seq'), 'Polanco', '', '+52 5534567890', 48),

    -- Argentina (Country id=17: Hotel id 49-51)
    (nextval('location_id_seq'), 'Avenida 9 de Julio', '', '+54 1123456789', 49),
    (nextval('location_id_seq'), 'Calle Florida', '', '+54 1223456789', 50),
    (nextval('location_id_seq'), 'Recoleta', '', '+54 1323456789', 51),

    -- Egipt (Country id=18: Hotel id 52-54)
    (nextval('location_id_seq'), 'Tahrir Square', '', '+20 2123456789', 52),
    (nextval('location_id_seq'), 'Al Ahram Street', '', '+20 2134567890', 53),
    (nextval('location_id_seq'), 'Giza, Cairo', '', '+20 2145678901', 54),

    -- Africa de Sud (Country id=19: Hotel id 55-57)
    (nextval('location_id_seq'), 'Long Street', '', '+27 1123456789', 55),
    (nextval('location_id_seq'), 'Simmonds Street', '', '+27 1223456789', 56),
    (nextval('location_id_seq'), 'Pretoria Road', '', '+27 1323456789', 57),

    -- Turcia (Country id=20: Hotel id 58-60)
    (nextval('location_id_seq'), 'Istiklal Avenue', '', '+90 2123456789', 58),
    (nextval('location_id_seq'), 'Sultanahmet', '', '+90 2134567890', 59),
    (nextval('location_id_seq'), 'Taksim Square', '', '+90 2145678901', 60);
