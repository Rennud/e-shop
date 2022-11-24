DROP TABLE IF EXISTS item_table CASCADE;
DROP TABLE IF EXISTS order_table CASCADE;

CREATE TABLE item_table
(
    id SERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    sold boolean NOT NULL,
    category VARCHAR(100) NOT NULL,
	order_id INTEGER,
    PRIMARY KEY(id)
);

insert into item_table(name, price, sold, category) values ('KENYA KIMANDI AB', 25.15, false,'Africa');
insert into item_table(name, price, sold, category) values ('COSTA RICA EL PEREZOSO', 18.75, false, 'Central America');
insert into item_table(name, price, sold, category) values ('CASCARA PANAMA CARMEN ESTATE', 20.00, false,'Central America');
insert into item_table(name, price, sold, category) values ('Etiopie Harbegona', 15.00, false,'Africa');
insert into item_table(name, price, sold, category) values ('El Salvador El Aguacatal', 22.00, false,'Central America');
insert into item_table(name, price, sold, category) values ('Columbia Supremo', 22.00, false,'Central America');

CREATE TABLE order_table(
    id SERIAL NOT NULL,
    quantity NUMERIC,
    total_price DECIMAL,
    user_id INTEGER,
    PRIMARY KEY(id)
);

ALTER TABLE IF EXISTS item_table
    ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id)
    REFERENCES public.order_table(id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS  order_table
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
    REFERENCES public.user_table(id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

insert into order_table(quantity,total_price,user_id) values(2,46.75,1);
insert into item_table(name, price, sold, category, order_id) values ('Columbia Testerio', 0.99, true,'Central America',1);