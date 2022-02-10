create or replace table airline
(
    id            int auto_increment
        primary key,
    airline_name  varchar(100) not null,
    airline_phone varchar(30)  not null,
    airline_code  char(4)      not null,
    constraint airline_airline_code_uindex
        unique (airline_code),
    constraint airline_airline_phone_uindex
        unique (airline_phone)
);

create or replace table airplane
(
    id             int auto_increment
        primary key,
    model_aircraft char(4) not null,
    capacity       int     not null,
    airline_id     int     null,
    constraint airplane_airline_fk
        foreign key (airline_id) references airline (id)
);

create or replace table country
(
    id           int auto_increment
        primary key,
    country_name varchar(20) not null,
    country_code char(4)     not null,
    constraint country_country_code_uindex
        unique (country_code),
    constraint country_country_name_uindex
        unique (country_name)
);

create or replace table city
(
    id         int auto_increment
        primary key,
    city_name  varchar(20) not null,
    country_id int         null,
    constraint city_country_fk
        foreign key (country_id) references country (id)
);

create or replace table airport
(
    id           int auto_increment
        primary key,
    airport_name varchar(50) not null,
    country_id   int         null,
    city_id      int         null,
    constraint airport_city_fk
        foreign key (city_id) references city (id),
    constraint airport_country_fk
        foreign key (country_id) references country (id)
);

create or replace table crew_category
(
    id          int auto_increment
        primary key,
    description varchar(50) not null
);

create or replace table crew
(
    id                int auto_increment
        primary key,
    first_name        varchar(120) not null,
    last_name         varchar(128) not null,
    personnel_license varchar(15)  not null,
    phone             varchar(30)  not null,
    crew_category_id  int          null,
    constraint crew_personnel_license_uindex
        unique (personnel_license),
    constraint crew_phone_uindex
        unique (phone),
    constraint crew_crew_category_fk
        foreign key (crew_category_id) references crew_category (id)
);

create or replace table route
(
    id                int auto_increment
        primary key,
    departure_airport varchar(100) not null,
    arrival_airport   varchar(100) not null,
    air_distance      varchar(20)  not null,
    constraint route_arrival_airport_uindex
        unique (arrival_airport),
    constraint route_departure_airport_uindex
        unique (departure_airport)
);

create or replace table flight
(
    id             int auto_increment
        primary key,
    departure_time timestamp   null,
    arrival_time   timestamp   null,
    status         varchar(20) not null,
    flight_number  varchar(10) not null,
    route_id       int         null,
    airline_id     int         null,
    constraint flight_airline_fk
        foreign key (airline_id) references airline (id),
    constraint flight_route_fk
        foreign key (route_id) references route (id)
);

create or replace table flight_crew
(
    flight_id int null,
    crew_id   int null,
    constraint flight_crew_crew_fk
        foreign key (crew_id) references crew (id),
    constraint flight_crew_flight_fk
        foreign key (flight_id) references flight (id)
);

create or replace table passenger
(
    id              int auto_increment
        primary key,
    first_name      varchar(100) not null,
    last_name       varchar(120) not null,
    passport_number varchar(30)  not null,
    ticket_number   varchar(30)  not null,
    flight_id       int          null,
    constraint passenger_ticket_number_uindex
        unique (ticket_number),
    constraint passenger_flight_fk
        foreign key (flight_id) references flight (id)
);


