
--we have to add role manually in mysql
--and also users_roles for admin
INSERT INTO ROLE (id, name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (id, name)
VALUES (2, 'ROLE_USER');
insert into user (email, first_name, gender, last_name, password, phone) values ("admin@gmail.com", "pranav", "patel", "123456", "$2a$11$OMrqr.cyvcq58uK853X8E.eKXIIKoLAdkhZYJFgXUEbJFop1D1tCa", "1234567890")
insert into user (email, first_name, gender, last_name, password, phone) values ("user@gmail.com", "pranav", "patel", "123456", "$2a$11$OMrqr.cyvcq58uK853X8E.eKXIIKoLAdkhZYJFgXUEbJFop1D1tCa", "9876543210")
--password=123456



INSERT INTO USERS_ROLES (user_id, role_id)
VALUES (1, 1);

INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Soap', 'Pears baby soap for Kids', 35.75);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Tooth Brush', 'Signal Tooth Brushes Size in (L, M, S)',34.50);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Shirt', 'Casual Shirt imported from France',1500.00);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Office Bag', 'Leather bag imported from USA', 1000.00);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Bottle', 'Hot Water Bottles',450.45);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Wrist Watch', 'Imported wrist watches from swiss',2500.00);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Mobile Phone', '3G/4G capability',  45000.00);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Shampoo', 'Head and Shoulders Shampoo', 300.00);
INSERT INTO PRODUCTS ( category,name, price)
VALUES ('Leather Wallets', 'Imported Leather Wallets from AUS', 500.00);
