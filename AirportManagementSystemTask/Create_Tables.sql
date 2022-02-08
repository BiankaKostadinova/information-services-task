create or replace table airlines
(
    airline_id    int auto_increment
        primary key,
    airline_name  varchar(20) not null,
    airline_phone varchar(30) not null,
    airline_code  char(4)     not null,
    constraint airlines_airline_email_uindex
        unique (airline_code),
    constraint airlines_airline_name_uindex
        unique (airline_name),
    constraint airlines_airline_phone_uindex
        unique (airline_phone)
);

create or replace table airplanes
(
    airplane_id    int auto_increment
        primary key,
    model_aircraft char(4) not null,
    capacity       int     null,
    airline_id     int     null,
    constraint airplanes_airlines_fk
        foreign key (airline_id) references airlines (airline_id)
);

create or replace table cities
(
    city_id   int auto_increment
        primary key,
    city_name varchar(14) not null,
    country_id   int         null,
    constraint cities_city_name_uindex
        unique (city_name),
    constraint cities_countries_fk
        foreign key (country_id) references countries (country_id)

);

create or replace table airports
(
    airport_id   int auto_increment
        primary key,
    airport_name varchar(45) not null,
    country_id   int         null,
    city_id      int         null,
    constraint airports_airport_name_uindex
        unique (airport_name),
    constraint airports_cities_fk
        foreign key (city_id) references cities (city_id),
    constraint airports_countries_fk
            foreign key (country_id) references countries (country_id)
);

create or replace table countries
(
    country_id   int auto_increment
        primary key,
    country_name varchar(15) not null,
    code         char(4)     not null,
    constraint countries_code_uindex
        unique (code),
    constraint countries_country_name_uindex
        unique (country_name)
);

create or replace table destinations
(
    destination_id   int auto_increment
        primary key,
    destination_name varchar(45) not null,
    country_id       int         null,
    constraint destinations_countries_fk
        foreign key (country_id) references countries (country_id)
);

create or replace table routes
(
    route_id       int auto_increment
        primary key,
    air_distance   varchar(20) not null,
    destination_id int         null,
    constraint route_destinations_fk
        foreign key (destination_id) references destinations (destination_id)
);

create or replace table flights
(
    flight_id      int auto_increment
        primary key,
    departure_time timestamp   null,
    arrival_time   timestamp   null,
    status         varchar(20) not null,
    airline_id    int         null,
    route_id       int         null,
    flight_number  varchar(10) not null,
    constraint flights_airlines_fk
        foreign key (airline_id) references airlines (airline_id),
    constraint flights_route_fk
        foreign key (route_id) references routes (route_id)
);

create or replace table cabin_crews
(
    cabin_crew_id     int auto_increment
        primary key,
    first_name        varchar(15) not null,
    last_name         varchar(15) not null,
    designation       varchar(10) not null,
    phone             varchar(30) not null,
    personnel_license varchar(15) not null,
    flight_id         int         null,
    constraint cabin_crews_flights_fk
        foreign key (flight_id) references flights (flight_id)
);

create or replace table passengers
(
    passenger_id    int auto_increment
        primary key,
    first_name      varchar(15) not null,
    last_name       varchar(20) not null,
    passport_number varchar(15) not null,
    ticket_number   varchar(30) not null,
    flight_id       int         null,
    constraint passengers_passport_number_uindex
        unique (passport_number),
    constraint passengers_ticket_number_uindex
        unique (ticket_number),
    constraint passengers_flights_fk
        foreign key (flight_id) references flights (flight_id)
);

create or replace table airports_airlines
(
    airport_id int null,
    airline_id int null,
    constraint airports_airlines_airlines_fk
        foreign key (airline_id) references airlines (airline_id),
    constraint airports_airlines_airports_fk
        foreign key (airport_id) references airports (airport_id)
);

