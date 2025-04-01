INSERT INTO hotels (id, name, description, country_id)
VALUES
    -- România (id = 1)
    (nextval('hotel_id_seq'), 'Hotel Carpați', 'Hotel elegant situat în inima Bucureștiului, România.', 1),
    (nextval('hotel_id_seq'), 'Hotel Transilvania', 'Cazare de lux și tradiție în România.', 1),
    (nextval('hotel_id_seq'), 'Hotel Dacia', 'Ambianță rafinată și servicii impecabile, România.', 1),

    -- SUA (id = 2)
    (nextval('hotel_id_seq'), 'The Liberty Inn', 'Experiență rafinată în inima New York-ului, SUA.', 2),
    (nextval('hotel_id_seq'), 'Manhattan Suites', 'Confort modern în centrul agitat al SUA.', 2),
    (nextval('hotel_id_seq'), 'Grand Continental', 'Servicii premium și design contemporan, SUA.', 2),

    -- Franța (id = 3)
    (nextval('hotel_id_seq'), 'Le Château Parisien', 'Eleganță și rafinament în inima Parisului, Franța.', 3),
    (nextval('hotel_id_seq'), 'Hotel de la Tour', 'Cazare cu stil și vedere spectaculoasă, Franța.', 3),
    (nextval('hotel_id_seq'), 'Belle Époque', 'O experiență autentică a eleganței franceze, Franța.', 3),

    -- Germania (id = 4)
    (nextval('hotel_id_seq'), 'Berliner Hof', 'Hotel modern cu influențe clasice în Berlin, Germania.', 4),
    (nextval('hotel_id_seq'), 'Rheinblick Hotel', 'Vedere impresionantă asupra Rinului, Germania.', 4),
    (nextval('hotel_id_seq'), 'Schlossgarten', 'O oază de liniște lângă monumente istorice, Germania.', 4),

    -- Marea Britanie (id = 5)
    (nextval('hotel_id_seq'), 'London Regency', 'Cazare rafinată în centrul Londrei, Marea Britanie.', 5),
    (nextval('hotel_id_seq'), 'Imperial London', 'Hotel de lux cu servicii excepționale, Marea Britanie.', 5),
    (nextval('hotel_id_seq'), 'The Westminster', 'O experiență clasică în inima Londrei, Marea Britanie.', 5),

    -- Italia (id = 6)
    (nextval('hotel_id_seq'), 'Roma Antica', 'Hotel cu design clasic și facilități moderne, Italia.', 6),
    (nextval('hotel_id_seq'), 'Hotel Colosseo', 'Experiență autentică lângă vestigiile istorice, Italia.', 6),
    (nextval('hotel_id_seq'), 'Bella Roma', 'Eleganță și confort în inima Romei, Italia.', 6),

    -- Spania (id = 7)
    (nextval('hotel_id_seq'), 'Sol y Mar', 'Hotel cu vedere spre mare și soare, Spania.', 7),
    (nextval('hotel_id_seq'), 'Hotel Iberia', 'Cazare modernă cu influențe iberice, Spania.', 7),
    (nextval('hotel_id_seq'), 'Gran Via', 'Localizat în centrul vibrant al Madridului, Spania.', 7),

    -- Canada (id = 8)
    (nextval('hotel_id_seq'), 'Maple Leaf Hotel', 'Cazare confortabilă cu influențe canadiene, Canada.', 8),
    (nextval('hotel_id_seq'), 'Hotel Canadien', 'Design modern și servicii prietenoase, Canada.', 8),
    (nextval('hotel_id_seq'), 'Northern Lights Inn', 'O experiență autentică în inima Canadei, Canada.', 8),

    -- Australia (id = 9)
    (nextval('hotel_id_seq'), 'Outback Oasis', 'Hotel tematic australian, aproape de natură, Australia.', 9),
    (nextval('hotel_id_seq'), 'Sydney Harbour View', 'Cazare cu vedere spectaculoasă la portul Sydney, Australia.', 9),
    (nextval('hotel_id_seq'), 'Coral Reef Resort', 'O experiență exotică și relaxantă, Australia.', 9),

    -- Brazilia (id = 10)
    (nextval('hotel_id_seq'), 'Hotel Rio de Janeiro', 'Hotel modern situat lângă plajele din Rio, Brazilia.', 10),
    (nextval('hotel_id_seq'), 'Copacabana Suites', 'Experiență de neuitat în inima Copacabanei, Brazilia.', 10),
    (nextval('hotel_id_seq'), 'Amazonia Lodge', 'Cazare eco-friendly în inima Braziliei, Brazilia.', 10),

    -- India (id = 11)
    (nextval('hotel_id_seq'), 'Taj Mahal Hotel', 'Eleganță și rafinament inspirate de monumente istorice, India.', 11),
    (nextval('hotel_id_seq'), 'Maharaja Palace', 'Cazare regală cu influențe tradiționale, India.', 11),
    (nextval('hotel_id_seq'), 'Delhi Heritage Inn', 'O experiență culturală autentică, India.', 11),

    -- China (id = 12)
    (nextval('hotel_id_seq'), 'Dragon Palace', 'Hotel ce îmbină tradiția chineză cu confortul modern, China.', 12),
    (nextval('hotel_id_seq'), 'Imperial China', 'Experiență unică într-un cadru elegant, China.', 12),
    (nextval('hotel_id_seq'), 'Great Wall Retreat', 'Relaxare de lux aproape de marile minuni, China.', 12),

    -- Rusia (id = 13)
    (nextval('hotel_id_seq'), 'Kremlin Grandeur', 'Hotel de lux situat aproape de Kremlin, Rusia.', 13),
    (nextval('hotel_id_seq'), 'Russian Elegance', 'Cazare rafinată și servicii premium, Rusia.', 13),
    (nextval('hotel_id_seq'), 'Siberia Retreat', 'O oază de confort și liniște, Rusia.', 13),

    -- Japonia (id = 14)
    (nextval('hotel_id_seq'), 'Hotel Sakura', 'Experiență autentică înconjurată de flori de cireș, Japonia.', 14),
    (nextval('hotel_id_seq'), 'Tokyo Zenith', 'Cazare modernă în inima Tokyo-ului, Japonia.', 14),
    (nextval('hotel_id_seq'), 'Fuji View Inn', 'Vedere spectaculoasă către Muntele Fuji, Japonia.', 14),

    -- Coreea de Sud (id = 15)
    (nextval('hotel_id_seq'), 'Seoul Grandeur', 'Hotel modern cu facilități de top, Coreea de Sud.', 15),
    (nextval('hotel_id_seq'), 'Han River Suites', 'Cazare elegantă cu vedere la râul Han, Coreea de Sud.', 15),
    (nextval('hotel_id_seq'), 'K-Style Inn', 'O combinație între tradiție și modernitate, Coreea de Sud.', 15),

    -- Mexic (id = 16)
    (nextval('hotel_id_seq'), 'Hotel Azteca', 'Cazare modernă inspirată de cultura aztecă, Mexic.', 16),
    (nextval('hotel_id_seq'), 'Fiesta Inn', 'Hotel plin de culoare și viață, Mexic.', 16),
    (nextval('hotel_id_seq'), 'Mayan Riviera', 'Experiență unică în inima culturii maya, Mexic.', 16),

    -- Argentina (id = 17)
    (nextval('hotel_id_seq'), 'Buenos Aires Elegance', 'Hotel sofisticat în centrul Buenos Aires, Argentina.', 17),
    (nextval('hotel_id_seq'), 'Pampas Retreat', 'Cazare cu influențe tradiționale argentiniene, Argentina.', 17),
    (nextval('hotel_id_seq'), 'Tango Suites', 'O experiență autentică a pasiunii argentiniene, Argentina.', 17),

    -- Egipt (id = 18)
    (nextval('hotel_id_seq'), 'Nile Palace', 'Hotel de lux cu vedere spre Nil, Egipt.', 18),
    (nextval('hotel_id_seq'), 'Cairo Comfort', 'Cazare elegantă și primitoare în Cairo, Egipt.', 18),
    (nextval('hotel_id_seq'), 'Pharaoh Inn', 'O experiență autentică în inima Egiptului antic, Egipt.', 18),

    -- Africa de Sud (id = 19)
    (nextval('hotel_id_seq'), 'Cape Royale', 'Hotel de top situat în inima Cape Town, Africa de Sud.', 19),
    (nextval('hotel_id_seq'), 'Safari Lodge', 'Cazare autentică cu influențe africane, Africa de Sud.', 19),
    (nextval('hotel_id_seq'), 'Johannesburg Gold', 'Experiență rafinată în centrul Johannesburg, Africa de Sud.', 19),

    -- Turcia (id = 20)
    (nextval('hotel_id_seq'), 'Hotel Ottoman', 'Hotel elegant inspirat de tradițiile otomane, Turcia.', 20),
    (nextval('hotel_id_seq'), 'Bosphorus View', 'Cazare cu vedere impresionantă la strâmtoarea Bosfor, Turcia.', 20),
    (nextval('hotel_id_seq'), 'Anatolia Retreat', 'O experiență de neuitat în inima Turciei, Turcia.', 20);
