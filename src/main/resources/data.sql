INSERT INTO ARTISTS(NAME, DESCRIPTION) VALUES ('Fellepo1', 'Fellepo1 leiras');

INSERT INTO ARTISTS(NAME, DESCRIPTION) VALUES ('Fellepo2', 'Fellepo2 leiras');

INSERT INTO ARTISTS(NAME, DESCRIPTION, picture) VALUES ('Fellepo3', 'Fellepo3 leiras', 'macskak.jpg');

INSERT INTO ARTISTS(NAME, DESCRIPTION, picture) VALUES ('Fellepo4', 'Fellepo4 leiras', 'ticket.png');

INSERT INTO ARTISTS(NAME, DESCRIPTION, picture) VALUES ('Fellepo5', 'Fellepo5 leiras', 'user.png');

INSERT INTO ARTISTS(NAME, DESCRIPTION) VALUES ('Fellepo6', 'Fellepo6 leiras');

INSERT INTO ARTISTS(NAME, DESCRIPTION) VALUES ('Fellepo7', 'Fellepo7 leiras');

INSERT INTO ARTISTS(NAME, DESCRIPTION) VALUES ('Fellepo8', 'Fellepo8 leiras');

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Rock', (SELECT id FROM ARTISTS WHERE NAME='Fellepo1'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Rock', (SELECT id FROM ARTISTS WHERE NAME='Fellepo2'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Pop', (SELECT id FROM ARTISTS WHERE name='Fellepo2'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Rock', (SELECT id FROM ARTISTS WHERE name='Fellepo3'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Metal', (SELECT id FROM ARTISTS WHERE name='Fellepo3'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Punk', (SELECT id FROM ARTISTS WHERE name='Fellepo3'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Rock', (SELECT id FROM ARTISTS WHERE name='Fellepo4'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Folk', (SELECT id FROM ARTISTS WHERE name='Fellepo4'));

INSERT INTO MUSICSTYLES(STYLE, ARTIST_ID) VALUES ('Reggae', (SELECT id FROM ARTISTS WHERE name='Fellepo8'));

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 48.217,20.300, 'Ózd', 'FesztivalPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 48.333, 21.133, 'Encs', 'FestPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.830,16.843, 'Zalaegerszeg', 'FestPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.830,16.843, 'Kecskemét', 'FestPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.830,16.843, 'Paks', 'FestPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.830,16.843, 'Ukk', 'FestPos');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.830,16.843, 'Győr', 'FestPos');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ózd' and DESCRIPTION='FesztivalPos'), '2018-10-23', '2018-11-14', 'ÓzdFest', 'Ózd legjobb fesztiválja');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Encs' and DESCRIPTION='FestPos'), '2018-10-11', '2018-10-19', 'EncsFest', 'Encs legjobb fesztiválja');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Kecskemét' and DESCRIPTION='FestPos'), '2019-04-11', '2019-04-14', 'KecsFest', 'Kecskemét legjobb fesztiválja');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Paks' and DESCRIPTION='FestPos'), '2018-02-11', '2018-02-14', 'PaksFest', 'Paks legjobb fesztiválja');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ukk' and DESCRIPTION='FestPos'), '2019-05-11', '2019-05-14', 'UkkFest', 'Ukk legjobb fesztiválja');

INSERT INTO FESTIVALS(POSITION_ID, BEGINDATE, ENDDATE, NAME, DESCRIPTION) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Győr' and DESCRIPTION='FestPos'), '2018-12-11', '2018-12-14', 'GyőrFest', 'Győr legjobb fesztiválja');

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Street-food', (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Beer', (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Street-food', (SELECT id FROM FESTIVALS WHERE name='EncsFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Pálinka', (SELECT id FROM FESTIVALS WHERE name='EncsFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Pálinka', (SELECT id FROM FESTIVALS WHERE name='EgerszegFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Free', (SELECT id FROM FESTIVALS WHERE name='EncsFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Free', (SELECT id FROM FESTIVALS WHERE name='EgerszegFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('KutyaBarát', (SELECT id FROM FESTIVALS WHERE name='EncsFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('KutyaBarát', (SELECT id FROM FESTIVALS WHERE name='EgerszegFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('DogFriendly', (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('FoodTruck', (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('FoodTruck', (SELECT id FROM FESTIVALS WHERE name='KecsFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('FoodTruck', (SELECT id FROM FESTIVALS WHERE name='PaksFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('FoodTruck', (SELECT id FROM FESTIVALS WHERE name='UkkFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('FoodTruck', (SELECT id FROM FESTIVALS WHERE name='GyőrFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('Free', (SELECT id FROM FESTIVALS WHERE name='UkkFest'));

INSERT INTO FESTIVALSTYLES(STYLE, FESTIVAL_ID) VALUES ('VízParti', (SELECT id FROM FESTIVALS WHERE name='GyőrFest'));

INSERT INTO USERS (USERNAME, PASSWORD, Role, FULLNAME, EMAIL) VALUES ('admin@aa.hu', '123Asd7as', 'ADMIN', 'Admin József', 'admin@aa.hu');

INSERT INTO USERS (USERNAME, PASSWORD, Role, FULLNAME, EMAIL) VALUES ('admin', '123Asd7as', 'ADMIN', 'Admin Géza', 'admin@bb.hu');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo2'), (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'), '2018-11-15');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='EncsFest'), '2018-11-12');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo1'), (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo4'), (SELECT id FROM FESTIVALS WHERE name='EncsFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo7'), (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo8'), (SELECT id FROM FESTIVALS WHERE name='ÓzdFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo2'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-15');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='UkkFest'), '2018-11-12');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo1'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo4'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo7'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo8'), (SELECT id FROM FESTIVALS WHERE name='GyőrFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='KecsFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo2'), (SELECT id FROM FESTIVALS WHERE name='UkkFest'), '2018-11-15');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo3'), (SELECT id FROM FESTIVALS WHERE name='PaksFest'), '2018-11-12');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo1'), (SELECT id FROM FESTIVALS WHERE name='UkkFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo4'), (SELECT id FROM FESTIVALS WHERE name='KecsFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo7'), (SELECT id FROM FESTIVALS WHERE name='KecsFest'), '2018-11-14');

INSERT INTO CONCERTS (artist_id, festival_id, beginDate) values ((SELECT id FROM ARTISTS WHERE name='Fellepo8'), (SELECT id FROM FESTIVALS WHERE name='UkkFest'), '2018-11-14');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.840,16.844, 'Zalaegerszeg', 'Hotel1');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.851,16.834, 'Zalaegerszeg', 'Hotel11');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.783,16.833, 'Bocfölde', 'Hotel3');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 46.934,16.855, 'Egervár', 'Hotel2');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 48.211,20.310, 'Ózd', 'Hotel4');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 48.221,20.306, 'Ózd', 'Hotel5');

INSERT INTO POSITIONS(X, Y, CITY, DESCRIPTION) VALUES ( 48.209,20.301, 'Ózd', 'Hotel6');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Zalaegerszeg' and DESCRIPTION='Hotel1'),
 'Aranybárány Hotel', 1111, 111, 'Zalaegerszeg legelitebb szállodája', 'arany@barany.hu', '4122334455', 'http://aranybarany.hu/hu/');

 INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Zalaegerszeg' and DESCRIPTION='Hotel11'),
 'Aranybirka Hotel', 1211, 311, 'Zalaegerszeg legelitebb szállodája', 'arany@birka.hu', '2222334455', 'http://aranybirka.hu/hu/');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Encs' and DESCRIPTION='FestPos'),
 'Ezüstbirka Hotel', 1121, 115, 'Encs legelitebb szállodája', 'ezust@barany.hu', '1122314455', 'http://ezustbirka.hu/');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ózd' and DESCRIPTION='Hotel4'),
 'Platinamarha Kemping', 1221, 511, 'Ózd legelitebb kempingje', 'platina@marha.hu', '1122344457', 'http://platinamarha.hu/');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ózd' and DESCRIPTION='Hotel5'),
 'Platinamarha Hotel', 1221, 511, 'Ózd legelitebb szállodája', 'platina@marha.hu', '1122334451', 'http://platinamarha.hu/');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ózd' and DESCRIPTION='Hotel6'),
 'A Hotel', 1221, 511, 'Ózd legelitebb szállodája', 'a@hotel.hu', '1122334459', 'http://ahotel.hu/');

INSERT INTO ACCOMMONDATION(ADDRESS_ID, NAME, PRICE, HEADS, DESCRIPTION, EMAIL, PHONENUMBER, WEBSITE) VALUES ((SELECT id FROM POSITIONS WHERE CITY='Ózd' and DESCRIPTION='FesztivalPos'),
 'B Kollégium', 1221, 511, 'Ózd legelitebb Kollégiuma', 'koli@b.hu', '1122394455', 'http://bkoli.hu/');