INSERT INTO orders (order_id, order_date) VALUES (1, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (2, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (3, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (4, '2022-07-02');

INSERT INTO wishlists(wishlist_id) VALUES (200);
INSERT INTO wishlists(wishlist_id) VALUES (201);

INSERT INTO shopping_carts(shopping_cart_id) VALUES (50);
INSERT INTO shopping_carts(shopping_cart_id) VALUES (51);


INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1000, 'Brikkon - Stad', 'Met de Brikkon World stad bouw je een prachtige stad van hout.', 64.95, 'Brikkon_stad.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1001, 'Frame me up - Tokyo Lights', 'Puzzel de stad Tokyo en frame het op', 15.95, 'Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1002, 'Frame me up - Vintage', 'Puzzel een vintage kamer en frame het op', 15.95, 'Clementoni_Vintage.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1003, 'Brikkon - Huis', 'Met Brikkon Huis heb je een toffe huis voor de kleintjes', 24.95, 'Brikkon_huis.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1004, 'Superpetit Artiste Placemat Kasteel', 'Een placemat voor de creatieve painter thuis', 24.95, 'superpetit_castle.jpeg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1005, 'Frame me up - Foosball','Puzzel een foosball tafel voor de foosball liefhebber', 15.95, 'clementoni_Frame_Me_Up_Foosball');

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

INSERT INTO about_brand (brand_title, brand_information) VALUES ('Loahy', 'Loahy staat voor duurzaam en creatieve producten voor kinderen van alle leeftijden. Speelgoed om kinderen te stimuleren hun fantasie te gebruiken en hun vaardigheden te ontwikkelen.Na de geboorte van zijn zoon Felipe in 2017, besloot oprichter Guilhermo om op zoek te gaan naar de leukste kinderproducten die er zijn. Zo ontstond Loahy. De producten zijn met zorg geselecteerd en worden internationaal ingekocht. Mis je nog iets op de website? Laat het ons weten!');
INSERT INTO about_brand (brand_title, brand_information) VALUES ('LoahyTree', 'LoahyTree staat voor duurzaam en creatieve producten voor kinderen van alle leeftijden. Speelgoed om kinderen te stimuleren hun fantasie te gebruiken en hun vaardigheden te ontwikkelen. Na de geboorte van zijn zoon Felipe in 2017, besloot oprichter Guilhermo om op zoek te gaan naar de leukste kinderproducten die er zijn. Zo ontstond Loahy. De producten zijn met zorg geselecteerd en worden internationaal ingekocht. Mis je nog iets op de website? Laat het ons weten!');

INSERT INTO users (user_email, user_id, user_password) VALUES ('user@test.nl',2001,  '$2a$10$P69ll.yZqXHwgVHwq15eYuFfonxsmHj1R0Qv2vMrH8ac6a3CZXgFC');
INSERT INTO users (user_email, user_id, user_password) VALUES ('admin@test.nl',2002, '$2a$10$WwNYEScuyU71JIDCxW9q6OKp.wfaS5f1x9UG.uIaVgqWo.msUAG6q');
INSERT INTO users (user_email, user_id, user_password) VALUES ('jenfromlomok@test.nl',2003, '$2a$10$LDiBruYLWJEsmEmcLsrW.uqlmBj4Du6CUtSaMxJibajL.r7uy4wVi');
INSERT INTO users (user_email, user_id, user_password) VALUES ('Guilfromlombok@test.nl',2004, '$2a$10$zzwIZ/EWVubx13KsnBH0iuN8r2OoXVilaXkBeb9ydYarflJDQFNdq');

INSERT INTO authorities (user_email, authority) VALUES ('user@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('jenfromlombok@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_ADMIN');
INSERT INTO authorities (user_email, authority) VALUES ('guilfromlombok@test.nl', 'ROLE_USER');

INSERT INTO customers (customer_id, customer_first_name, customer_last_name, customer_street_name, customer_house_number, customer_city, customer_zipcode, customer_phone) VALUES (5000, 'Pim', 'Tester', 'Daltonlaan', 34, Utrecht, '3575 PX', 0612345678);
INSERT INTO customers (customer_id, customer_first_name, customer_last_name, customer_street_name, customer_house_number, customer_add_number, customer_city, customer_zipcode, customer_phone) VALUES (5001, 'Saïd', 'Admin', 'Daltonlaan', 34, Utrecht, '3575 PX', 0678903460);
INSERT INTO customers (customer_id, customer_first_name, customer_last_name, customer_street_name, customer_house_number, customer_add_number, customer_city, customer_zipcode, customer_phone) VALUES (5002, 'Jenny', 'van Lombok', 'Iemandslaan', 300, 'B',  Utrecht, '3575 PX', 0611123454);
INSERT INTO customers (customer_id, customer_first_name, customer_last_name, customer_street_name, customer_house_number, customer_add_number, customer_city, customer_zipcode, customer_phone) VALUES (5003, 'Guily', 'van Lomnok', 'Niemandslaan', 400, 'A', Utrecht, '3575 PX', 0634756345);

INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_stad.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/Brikkon_stad.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Frame_Me_Up_Tokyo.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Vintage.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/Clementoni_Vintage.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_huis.jpg', 'image/jpeg', 'http://localhost:8080/pictures/downloaad/Brikkon_huis.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('superpetit_castle.jpeg', 'image/jpeg', 'http://localhost:8080/pictures/download/superpetit_castle.jpeg');
INSERT INTO image (file_name, content_type, url) VALUES ('clementoni_Frame_Me_Up_Foosball.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/clementoni_Frame_Me_Up_Foosball.jpeg');