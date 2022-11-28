CREATE TABLE user_table
(
    id SERIAL NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

insert into user_table(email, username, first_name, last_name, password) values ('lojza@gmail.com', 'test', 'lojza', 'kulihra', 'test');
insert into user_table(email, username, first_name, last_name, password) values ('test@gmail.com', 'maro', 'maro', 'balor', 'test');
