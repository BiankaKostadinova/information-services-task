use airport_management_system;

INSERT INTO airline(airline_name, airline_phone, airline_code)
VALUES ('Qatar Airways','+974 4423 7999','QR'),
       ('Emirates','+971600555555','EK'),
       ('British Airways','+44 (0)203 250 0145','BA');

INSERT INTO airplane(model_aircraft, capacity, airline_id)
VALUES ('A220',130,1),
       ('A300',254,2),
       ('A310',187,3);

INSERT INTO country(country_name, country_code)
VALUES ('Qatar','QAT'),
       ('Dubai','XD'),
       ('United Kingdom','UK');

INSERT INTO city(city_name, country_id)
VALUES ('Doha',1),
       ('Dubai',2),
       ('London',3);

INSERT INTO airport(airport_name, country_id, city_id)
VALUES ('Doha Hamad International Airport',1,1),
       ('Dubai International Airport',2,2),
       ('Heathrow Airport',3,3);

INSERT INTO route(departure_airport, arrival_airport, air_distance)
VALUES ('Doha Hamad International Airport','Erbil(EBL)','1420 kilometers'),
       ('Dubai International Airport','Rajiv Gandhi International Airpo','2549 kilometers'),
       ('Heathrow Airport','Frankfurt FDA','655 kilometers');

INSERT INTO flight(departure_time, arrival_time, status, flight_number, route_id, airline_id)
VALUES ('2022-02-01 18:03:01','2022-02-01 20:45:01','Scheduled on time','QR450',1,1),
       ('2022-02-05 18:03:01','2022-02-05 19:03:01','Arrived on time','6E025',2,2),
       ('2022-02-06 14:03:01','2022-02-06 15:43:01','Scheduled','BA906',3,3);

INSERT INTO passenger(first_name, last_name, passport_number, ticket_number, flight_id)
VALUES ('Fahad','Kumar','234098006','QAT5678200123',1),
       ('Amina','Abbas','234000034','EK5679000345',2),
       ('James','Thompson','5452407DH','UK56000766GH',3);

INSERT INTO crew_category(description)
VALUES ('pilot'),
       ('co pilot'),
       ('stewardess');

INSERT INTO crew(crew_category_id,first_name,last_name,personnel_license,phone)
VALUES (1,'Sherlin','Wickramasinghe','67-8765','+974 4023 0000'),
       (2,'George','Evans','ATPL000876','07911 123456'),
       (3,'Yasmin','Ahmed', 'IN118336A','+971 4573');

INSERT INTO flight_crew(flight_id, crew_id)
VALUES (1,1),
       (2,2),
       (3,3);




