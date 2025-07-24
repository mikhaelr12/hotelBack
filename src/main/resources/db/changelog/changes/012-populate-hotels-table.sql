INSERT INTO hotels (id, name, description, country_id, image,  address, phone_number)
VALUES
    -- România (id = 1)
    (nextval('hotel_id_seq'), 'Hotel Carpați', 'Hotel elegant situat în inima Bucureștiului, România.'
    , 1, '/europe/romania/carpati/carpati.jpg', 'Str. Libertății, Nr. 10', '+40 213456789'),
    (nextval('hotel_id_seq'), 'Hotel Transilvania', 'Cazare de lux și tradiție în România.'
    , 1, '/europe/romania/transilvania/transilvania.jpg', 'Str. Unirii, Nr. 20', '+40 214567890'),
    (nextval('hotel_id_seq'), 'Hotel Dacia', 'Ambianță rafinată și servicii impecabile, România.'
    , 1, '/europe/romania/dacia/dacia.jpg', 'Str. Mihai Eminescu, Nr. 30', '+40 215678901'),

    -- SUA (id = 2)
    (nextval('hotel_id_seq'), 'The Liberty Inn', 'Experiență rafinată în inima New York-ului, SUA.'
    , 2, '/americas/usa/libertyIn.jpg', '5th Avenue', '+1 2123456789'),
    (nextval('hotel_id_seq'), 'Manhattan Suites', 'Confort modern în centrul agitat al SUA.'
    , 2, '/americas/usa/manhattan.jpg', 'Madison Avenue', '+1 2134567890'),
    (nextval('hotel_id_seq'), 'Grand Continental', 'Servicii premium și design contemporan, SUA.'
    , 2,'/americas/usa/continental.jpg', 'Broadway', '+1 2145678901'),

    -- Franța (id = 3)
    (nextval('hotel_id_seq'), 'Le Château Parisien', 'Eleganță și rafinament în inima Parisului, Franța.'
    , 3,'/europe/france/parisien/parisien.jpg', 'Champs-Élysées', '+33 123456789'),
    (nextval('hotel_id_seq'), 'Hotel de la Tour', 'Cazare cu stil și vedere spectaculoasă, Franța.'
    , 3,'/europe/france/tour/tour.jpg', 'Rue de Rivoli', '+33 234567890'),
    (nextval('hotel_id_seq'), 'Belle Époque', 'O experiență autentică a eleganței franceze, Franța.'
    , 3,'/europe/france/epoque/epoque.jpg', 'Avenue des Champs', '+33 345678901'),

    -- Germania (id = 4)
    (nextval('hotel_id_seq'), 'Berliner Hof', 'Hotel modern cu influențe clasice în Berlin, Germania.'
    , 4,'/europe/germany/berliner/berliner.jpg', 'Unter den Linden', '+49 301234567'),
    (nextval('hotel_id_seq'), 'Rheinblick Hotel', 'Vedere impresionantă asupra Rinului, Germania.'
    , 4,'/europe/germany/rhein/rheinblick.jpg', 'Potsdamer Platz', '+49 302345678'),
    (nextval('hotel_id_seq'), 'Schlossgarten', 'O oază de liniște lângă monumente istorice, Germania.'
    , 4,'/europe/germany/schloss/schlossgarten.jpg', 'Alexanderplatz', '+49 303456789'),

    -- Marea Britanie (id = 5)
    (nextval('hotel_id_seq'), 'London Regency', 'Cazare rafinată în centrul Londrei, Marea Britanie.'
    , 5,'/europe/uk/regency.jpg', 'Piccadilly', '+44 2071234567'),
    (nextval('hotel_id_seq'), 'Imperial London', 'Hotel de lux cu servicii excepționale, Marea Britanie.'
    , 5,'/europe/uk/imperial.jpg', 'Oxford Street', '+44 2072345678'),
    (nextval('hotel_id_seq'), 'The Westminster', 'O experiență clasică în inima Londrei, Marea Britanie.'
    , 5,'/europe/uk/westminster.jpg', 'Regent Street', '+44 2073456789'),

    -- Italia (id = 6)
    (nextval('hotel_id_seq'), 'Roma Antica', 'Hotel cu design clasic și facilități moderne, Italia.'
    ,6,'/europe/italy/antica.jpg', 'Via Veneto', '+39 061234567'),
    (nextval('hotel_id_seq'), 'Hotel Colosseo', 'Experiență autentică lângă vestigiile istorice, Italia.'
    , 6,'/europe/italy/navona.jpg', 'Piazza Navona', '+39 062345678'),
    (nextval('hotel_id_seq'), 'Bella Roma', 'Eleganță și confort în inima Romei, Italia.'
    , 6,'/europe/italy/bella.jpg', 'Via Appia',  '+39 063456789'),

    -- Spania (id = 7)
    (nextval('hotel_id_seq'), 'Sol y Mar', 'Hotel cu vedere spre mare și soare, Spania.'
    , 7,'/europe/spain/sol.jpg', 'Gran Vía',  '+34 912345678'),
    (nextval('hotel_id_seq'), 'Hotel Iberia', 'Cazare modernă cu influențe iberice, Spania.'
    , 7,'/europe/spain/iberica.jpg', 'Calle de Alcalá',  '+34 923456789'),
    (nextval('hotel_id_seq'), 'Gran Via', 'Localizat în centrul vibrant al Madridului, Spania.'
    , 7,'/europe/spain/via.jpg', 'Plaza Mayor', '+34 934567890'),

    -- Canada (id = 8)
    (nextval('hotel_id_seq'), 'Maple Leaf Hotel', 'Cazare confortabilă cu influențe canadiene, Canada.'
    , 8, '/americas/canada/maple.jpg', '123 Maple Road, Toronto, Canada', '+1 4161234567'),
    (nextval('hotel_id_seq'), 'Hotel Canadien', 'Design modern și servicii prietenoase, Canada.'
    , 8, '/americas/canada/canadien.jpg', '456 Canadian Blvd, Montreal, Canada', '+1 5142345678'),
    (nextval('hotel_id_seq'), 'Northern Lights Inn', 'O experiență autentică în inima Canadei, Canada.'
    , 8, '/americas/canada/northern.jpg', '789 Aurora Avenue, Edmonton, Canada', '+1 7803456789'),

    -- Australia (id = 9)
    (nextval('hotel_id_seq'), 'Outback Oasis', 'Hotel tematic australian, aproape de natură, Australia.'
    , 9,'/others/australia/oasis.jpg', 'Yonge Street', '+1 4161234567'),
    (nextval('hotel_id_seq'), 'Sydney Harbour View', 'Cazare cu vedere spectaculoasă la portul Sydney, Australia.'
    , 9,'/others/australia/harbour.jpg', 'Queen Street', '+1 4162345678'),
    (nextval('hotel_id_seq'), 'Coral Reef Resort', 'O experiență exotică și relaxantă, Australia.'
    , 9,'/others/australia/coral.jpg', 'Bloor Street', '+1 4163456789'),

    -- Brazilia (id = 10)
    (nextval('hotel_id_seq'), 'Hotel Rio de Janeiro', 'Hotel modern situat lângă plajele din Rio, Brazilia.'
    , 10,'/americas/brazil/rio.jpg', 'Avenida Paulista',  '+55 1123456789'),
    (nextval('hotel_id_seq'), 'Copacabana Suites', 'Experiență de neuitat în inima Copacabanei, Brazilia.'
    , 10,'/americas/brazil/suites.jpg', 'Rua Augusta', '+55 1223456789'),
    (nextval('hotel_id_seq'), 'Amazonia Lodge', 'Cazare eco-friendly în inima Braziliei, Brazilia.'
    , 10,'/americas/brazil/lodge.jpg', 'Av. Faria Lima', '+55 1323456789'),

    -- India (id = 11)
    (nextval('hotel_id_seq'), 'Taj Mahal Hotel', 'Eleganță și rafinament inspirate de monumente istorice, India.'
    , 11,'/asia/india/mahal.jpg', 'MG Road', '+91 2212345678'),
    (nextval('hotel_id_seq'), 'Maharaja Palace', 'Cazare regală cu influențe tradiționale, India.'
    , 11,'/asia/india/maharaja.jpg', 'Linking Road', '+91 2223456789'),
    (nextval('hotel_id_seq'), 'Delhi Heritage Inn', 'O experiență culturală autentică, India.'
    , 11,'/asia/india/heritage.jpg', 'Colaba Causeway', '+91 2234567890'),

    -- China (id = 12)
    (nextval('hotel_id_seq'), 'Dragon Palace', 'Hotel ce îmbină tradiția chineză cu confortul modern, China.'
    , 12,'/asia/china/dragon.jpg', 'Wangfujing', '+86 1012345678'),
    (nextval('hotel_id_seq'), 'Imperial China', 'Experiență unică într-un cadru elegant, China.'
    , 12,'/asia/china/imperial.jpg', 'Chang''an Avenue', '+86 1023456789'),
    (nextval('hotel_id_seq'), 'Great Wall Retreat', 'Relaxare de lux aproape de marile minuni, China.'
    , 12,'/asia/china/retreat.jpg', 'Tiananmen',  '+86 1034567890'),

    -- Rusia (id = 13)
    (nextval('hotel_id_seq'), 'Kremlin Grandeur', 'Hotel de lux situat aproape de Kremlin, Rusia.'
    , 13,'/europe/russia/kremlin.jpg', 'Tverskaya Street', '+7 4951234567'),
    (nextval('hotel_id_seq'), 'Russian Elegance', 'Cazare rafinată și servicii premium, Rusia.'
    , 13,'/europe/russia/elegance.jpg', 'Arbat Street', '+7 4952345678'),
    (nextval('hotel_id_seq'), 'Siberia Retreat', 'O oază de confort și liniște, Rusia.'
    , 13,'/europe/russia/siberia.jpg', 'Novinsky Boulevard', '+7 4953456789'),

    -- Japonia (id = 14)
    (nextval('hotel_id_seq'), 'Hotel Sakura', 'Experiență autentică înconjurată de flori de cireș, Japonia.'
    , 14,'/asia/japan/sakura.jpg', 'Ginza', '+81 351234567'),
    (nextval('hotel_id_seq'), 'Tokyo Zenith', 'Cazare modernă în inima Tokyo-ului, Japonia.'
    , 14,'/asia/japan/tokyo.jpg', 'Shinjuku',  '+81 352345678'),
    (nextval('hotel_id_seq'), 'Fuji View Inn', 'Vedere spectaculoasă către Muntele Fuji, Japonia.'
    , 14,'/asia/japan/fuji.jpg', 'Akihabara', '+81 353456789'),

    -- Coreea de Sud (id = 15)
    (nextval('hotel_id_seq'), 'Seoul Grandeur', 'Hotel modern cu facilități de top, Coreea de Sud.'
    , 15,'/asia/southkorea/seoul.jpg', 'Myeongdong', '+82 221234567'),
    (nextval('hotel_id_seq'), 'Han River Suites', 'Cazare elegantă cu vedere la râul Han, Coreea de Sud.'
    , 15,'/asia/southkorea/han.jpg', 'Gangnam', '+82 222345678'),
    (nextval('hotel_id_seq'), 'K-Style Inn', 'O combinație între tradiție și modernitate, Coreea de Sud.'
    , 15,'/asia/southkorea/inn.jpg', 'Itaewon', '+82 223456789'),

    -- Mexic (id = 16)
    (nextval('hotel_id_seq'), 'Hotel Azteca', 'Cazare modernă inspirată de cultura aztecă, Mexic.'
    , 16,'/americas/mexico/azteca.jpg', 'Paseo de la Reforma', '+52 5512345678'),
    (nextval('hotel_id_seq'), 'Fiesta Inn', 'Hotel plin de culoare și viață, Mexic.'
    , 16,'/americas/mexico/fiesta.jpg', 'Insurgentes', '+52 5523456789'),
    (nextval('hotel_id_seq'), 'Mayan Riviera', 'Experiență unică în inima culturii maya, Mexic.'
    , 16,'/americas/mexico/mayan.jpg', 'Polanco', '+52 5534567890'),

    -- Argentina (id = 17)
    (nextval('hotel_id_seq'), 'Buenos Aires Elegance', 'Hotel sofisticat în centrul Buenos Aires, Argentina.'
    , 17,'/americas/argentina/elegance.jpg', 'Avenida 9 de Julio', '+54 1123456789'),
    (nextval('hotel_id_seq'), 'Pampas Retreat', 'Cazare cu influențe tradiționale argentiniene, Argentina.'
    , 17,'/americas/argentina/pampas.jpg', 'Calle Florida', '+54 1223456789'),
    (nextval('hotel_id_seq'), 'Tango Suites', 'O experiență autentică a pasiunii argentiniene, Argentina.'
    , 17,'/americas/argentina/tango.jpg', 'Recoleta', '+54 1323456789'),

    -- Egipt (id = 18)
    (nextval('hotel_id_seq'), 'Nile Palace', 'Hotel de lux cu vedere spre Nil, Egipt.'
    , 18,'/others/egypt/nile.jpg', 'Tahrir Square', '+20 2123456789'),
    (nextval('hotel_id_seq'), 'Cairo Comfort', 'Cazare elegantă și primitoare în Cairo, Egipt.'
    , 18,'/others/egypt/cairo.jpg', 'Al Ahram Street',  '+20 2134567890'),
    (nextval('hotel_id_seq'), 'Pharaoh Inn', 'O experiență autentică în inima Egiptului antic, Egipt.'
    , 18,'/others/egypt/pharaoh.jpg', 'Giza, Cairo', '+20 2145678901'),

    -- Africa de Sud (id = 19)
    (nextval('hotel_id_seq'), 'Cape Royale', 'Hotel de top situat în inima Cape Town, Africa de Sud.'
    , 19,'/others/southafrica/cape.jpg', 'Long Street', '+27 1123456789'),
    (nextval('hotel_id_seq'), 'Safari Lodge', 'Cazare autentică cu influențe africane, Africa de Sud.'
    , 19,'/others/southafrica/safari.jpg', 'Simmonds Street', '+27 1223456789'),
    (nextval('hotel_id_seq'), 'Johannesburg Gold', 'Experiență rafinată în centrul Johannesburg, Africa de Sud.'
    , 19,'/others/southafrica/gold.jpg', 'Pretoria Road', '+27 1323456789'),

    -- Turcia (id = 20)
    (nextval('hotel_id_seq'), 'Hotel Ottoman', 'Hotel elegant inspirat de tradițiile otomane, Turcia.'
    , 20,'/europe/turkey/ottoman.jpg', 'Istiklal Avenue', '+90 2123456789'),
    (nextval('hotel_id_seq'), 'Bosphorus View', 'Cazare cu vedere impresionantă la strâmtoarea Bosfor, Turcia.'
    , 20,'/europe/turkey/bosphorus.jpg', 'Sultanahmet', '+90 2134567890'),
    (nextval('hotel_id_seq'), 'Anatolia Retreat', 'O experiență de neuitat în inima Turciei, Turcia.'
    , 20,'/europe/turkey/anatolia.jpg', 'Taksim Square', '+90 2145678901');
