INSERT INTO airlines(airline_name, airline_phone, airline_code)
VALUES ('Qatar Airways','+974 4423 7999','QR'),
       ('Emirates','+971600555555','EK'),
       ('British Airways','+44 (0)203 250 0145','BA');

INSERT INTO airplanes(model_aircraft, capacity, airline_id)
VALUES ('A220',130,1),
       ('A300',254,2),
       ('A310',187,3);

INSERT INTO airports(airport_name, country_id, city_id)
VALUES ('Doha Hamad International Airport',1,1),
       ('Dubai International Airport',2,2),
       ('Heathrow Airport',3,3);

INSERT INTO countries(country_name,code)
VALUES ('Qatar','QAT'),
       ('Dubai','XD'),
       ('United Kingdom','UK');

INSERT INTO cities(city_name,county_id)
VALUES ('Doha',1),
       ('Dubai',2),
       ('London',3);

INSERT INTO destinations(destination_name, country_id)
VALUES ('Erbil(EBL)',1),
       ('Rajiv Gandhi International Airpo',2),
       ('Frankfurt FDA',3);

INSERT INTO flights(departure_time, arrival_time,status, airline_id, route_id, flight_number)
VALUES ('2022-02-01 18:03:01','2022-02-01 20:45:01','Scheduled on time',1,1,'QR450'),
       ('2022-02-05 18:03:01','2022-02-05 19:03:01','Arrived on time',2,2,'6E025'),
       ('2022-02-06 14:03:01','2022-02-06 15:43:01','Scheduled',3,3,'BA906');

INSERT INTO routes(air_distance, destination_id)
VALUES ('1420 kilometers',1),
       ('2549 kilometers',2),
       ('655 kilometers',3);

INSERT INTO passengers(first_name, last_name, passport_number, ticket_number, flight_id)
VALUES ('Fahad','Kumar','234098006','QAT5678200123',1),
       ('Amina','Abbas','234000034','EK5679000345',2),
       ('James','Thompson','5452407DH','UK56000766GH',3);

INSERT INTO cabin_crews(first_name, last_name, designation, phone, personnel_license, flight_id)
VALUES ('Sherlin','Wickramasinghe','pilot','+974 4023 0000','67-8765',1),
       ('Yasmin','Ahmed','stewardess','+971 4573','IN118336A',2),
       ('George','Evans','co pilot','07911 123456','ATPL000876',3);
	   
INSERT INTO airports_airlines(airport_id, airline_id)
VALUES (1,1),
       (2,2),
       (3,3);	   
	   