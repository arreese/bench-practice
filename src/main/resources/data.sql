DROP table Person if exists;
CREATE TABLE Person (
    id INTEGER IDENTITY NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL,
    occupation VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
insert into person (first_name, last_name, age, occupation) values ('Mark', 'Sage', 102, 'Retired');
insert into person (first_name, last_name, age, occupation) values ('Amber', 'Reese', 25, 'Engineer');
insert into person (first_name, last_name, age, occupation) values ('Arielle', 'Reese', 25, 'Engineer');
insert into person (first_name, last_name, age, occupation) values ('Elizabeth', 'Graham', 25, 'Engineer');
insert into person (first_name, last_name, age, occupation) values ('Hank', 'Libman', 25, 'Engineer');
insert into person (first_name, last_name, age, occupation) values ('Kassandra', 'Ortega', 25, 'Engineer');
insert into person (first_name, last_name, age, occupation) values ('Trishla', 'Shah', 25, 'Engineer');