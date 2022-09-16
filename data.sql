INSERT INTO orders (order_id, order_date) VALUES (1, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (2, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (3, '2021-02-02');
INSERT INTO orders (order_id, order_date) VALUES (4, '2022-07-02');

INSERT INTO wishlists(wishlist_id) VALUES (200);
INSERT INTO wishlists(wishlist_id) VALUES (201);

INSERT INTO shopping_carts(shopping_cart_id) VALUES (50);
INSERT INTO shopping_carts(shopping_cart_id) VALUES (51);


INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1000, 'Brikkon - Stad', 'Met de Brikkon World stad bouw je een prachtige stad van hout.', 64.95, 4);
INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1001, 'Frame me up - Tokyo Lights', 'Puzzel de stad Tokyo en frame het op', 15.95, 5);
INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1002, 'Frame me up - Vintage', 'Puzzel een vintage kamer en frame het op', 15.95, 4);
INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1003, 'Brikkon - Huis', 'Met Brikkon Huis heb je een toffe huis voor de kleintjes', 24.95, 7);
INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1004, 'Superpetit Artiste Placemat Kasteel', 'Een placemat voor de creatieve painter thuis', 24.95, 12);
INSERT INTO products (product_id, product_name, product_information, product_price, product_quantity) VALUES (1005, 'Frame me up - Foosball','Puzzel een foosball tafel voor de foosball liefhebber', 15.95, 5);

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

INSERT INTO users (user_email, user_password, user_name, user_adres, user_phone) VALUES ('user@test.nl', '$2a$10$P69ll.yZqXHwgVHwq15eYuFfonxsmHj1R0Qv2vMrH8ac6a3CZXgFC', 'User Test', 'Teststraat 1, 1234AB, Utrecht', 0612345678);
INSERT INTO users (user_email, user_password, user_name, user_adres, user_phone) VALUES ('admin@test.nl', '$2a$10$WwNYEScuyU71JIDCxW9q6OKp.wfaS5f1x9UG.uIaVgqWo.msUAG6q', 'Admin Test', 'Teststraat 2, 1234AB, Utrecht', 0687654321);
INSERT INTO users (user_email, user_password, user_name, user_adres, user_phone) VALUES ('jenfromlomok@test.nl', '$2a$10$LDiBruYLWJEsmEmcLsrW.uqlmBj4Du6CUtSaMxJibajL.r7uy4wVi', 'Jen van Lombok', 'Lombokstraat 1, 4321AB, Utrecht', 0698765432);
INSERT INTO users (user_email, user_password, user_name, user_adres, user_phone) VALUES ('Guilfromlombok@test.nl','$2a$10$zzwIZ/EWVubx13KsnBH0iuN8r2OoXVilaXkBeb9ydYarflJDQFNdq','Guil van Lombok', 'Lombokstraat 24, 1234AB, Utrecht', 612678690);

INSERT INTO authorities (user_email, authority) VALUES ('user@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('jenfromlombok@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_ADMIN');
INSERT INTO authorities (user_email, authority) VALUES ('guilfromlombok@test.nl', 'ROLE_USER');
