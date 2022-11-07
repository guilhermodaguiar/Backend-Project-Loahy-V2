INSERT INTO orders (order_id, order_date) VALUES (1, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (2, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (3, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (4, '2022-07-02');

INSERT INTO wishlists(wishlist_id) VALUES (200);
INSERT INTO wishlists(wishlist_id) VALUES (201);

INSERT INTO shopping_carts(shopping_cart_id) VALUES (50);
INSERT INTO shopping_carts(shopping_cart_id) VALUES (51);


INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1000, 'Brikkon - Stad', 'Met de Brikkon World stad bouw je een prachtige stad van hout.', 64.95, 'clementoni_Frame_Me_Up_Foosball.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1001, 'Frame me up - Tokyo Lights', 'Puzzel de stad Tokyo en frame het op', 15.95, 'Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1002, 'Frame me up - Vintage', 'Puzzel een vintage kamer en frame het op', 15.95, 'Clementoni_Vintage.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1003, 'Brikkon - Huis', 'Met Brikkon Huis heb je een toffe huis voor de kleintjes', 24.95, 'Brikkon_huis.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1004, 'Superpetit Artiste Placemat Kasteel', 'Een placemat voor de creatieve painter thuis', 24.95, 'superpetit_castle.jpeg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1005, 'Frame me up - Foosball','Puzzel een foosball tafel voor de foosball liefhebber', 15.95, 'clementoni_Frame_Me_Up_Foosball.jpg' );

INSERT INTO remarks (contact_name, contact_email, contact_phone, contact_organisation, remark) VALUES ('Contact Test', 'contact@test.nl', 0611111111, 'Testers', 'Hoi, Ik ben een tester voor testbureau Tester. Graag zou ik een telefonisch gesprek houden over een van uw producten. Mijn mobiel is 06123455678. Fijne dag nog');
INSERT INTO remarks (contact_name, contact_email, contact_phone, remark) VALUES ('Wim Test', 'Wim@test.nl', 0611111112, 'Hoi, Ik ben een tester voor testbureau Tester. Graag zou ik een telefonisch gesprek houden over een van uw producten. Mijn mobiel is 06123455678. Fijne dag nog');

INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (200, 1000);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (200, 1001);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (200, 1002);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (200, 1003);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (201, 1000);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (201, 1002);
INSERT INTO wishlist_product(wishlist_id, product_id) VALUES (201, 1005);

INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (50, 1000);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (50, 1001);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (50, 1002);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (50, 1003);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (51, 1000);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (51, 1002);
INSERT INTO shopping_cart_product(shopping_cart_id, product_id) VALUES (51, 1005);

INSERT INTO users (user_id, user_email, password) VALUES (2001, 'user@test.nl', '$2a$12$Bw4eg6ErI5jYx2TMdI7eierfbrghh/YwdjU6XPvJWHdmIXfeUfBcK');
INSERT INTO users (user_id, user_email, password) VALUES (2002, 'admin@test.nl', '$2a$12$kFPBcSnUNJ/Ojs.m8ko//uV44D0ZhGUyOZQVzux36l5y8JFJLXOdG');
INSERT INTO users (user_id, user_email, password) VALUES (2003, 'jenfromlomok@test.nl', '$2a$12$BmMv.oCR96Hcw81S7yoW/uNPBGPADmdBI45EZS6I1tlq3FwTv3Ncu');
INSERT INTO users (user_id, user_email, password) VALUES (2004, 'Guilfromlombok@test.nl', '$2a$12$v8obCBMrcCq6s9qBRAUEZuWAK9oSWSn1JzceR7/BWt3UnN643QMOW');

INSERT INTO authorities (user_email, authority) VALUES ('user@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('jenfromlombok@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_ADMIN');
INSERT INTO authorities (user_email, authority) VALUES ('guilfromlombok@test.nl', 'ROLE_USER');

INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_stad.jpg', 'image/jpeg', 'http://localhost:8080/images/download/Brikkon_stad.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Frame_Me_Up_Tokyo.jpg', 'image/jpeg', 'http://localhost:8080/images/download/Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Vintage.jpg', 'image/jpeg', 'http://localhost:8080/images/download/Clementoni_Vintage.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_huis.jpg', 'image/jpeg', 'http://localhost:8080/images/downloaad/Brikkon_huis.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('superpetit_castle.jpeg', 'image/jpeg', 'http://localhost:8080/images/download/superpetit_castle.jpeg');
INSERT INTO image (file_name, content_type, url) VALUES ('clementoni_Frame_Me_Up_Foosball.jpg', 'image/jpeg', 'http://localhost:8080/images/download/clementoni_Frame_Me_Up_Foosball.jpeg');