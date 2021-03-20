--OFFERINGS
INSERT INTO public.offerings(id, description, name)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', null, 'Best Price');
INSERT INTO public.offerings(id, description, name)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', null, 'Best Productivity');
INSERT INTO public.offerings(id, description, name)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', null, 'Best Rating');



--PRODUCT CATEGORIES
INSERT INTO public.product_categories(id, description, name)
VALUES ('a2778a28-4435-460b-8480-63fe8e0e17a5', null, 'Television Sets');
INSERT INTO public.product_categories(id, description, name)
VALUES ('d72fce72-ab46-49a3-ad52-937a1bcf1190', null, 'Laptops');
INSERT INTO public.product_categories(id, description, name)
VALUES ('2f5f3367-32ec-48a1-8a8a-a91bb75e412d', null, 'Tablets');
INSERT INTO public.product_categories(id, description, name)
VALUES ('5686643f-46fc-4b56-bd25-4153afef78b9', null, 'Smartphones');
INSERT INTO public.product_categories(id, description, name)
VALUES ('7c925a87-c362-4a58-aa90-8585b5c92811', null, 'Headphones');
INSERT INTO public.product_categories(id, description, name)
VALUES ('bd5b1062-cf16-4d75-aadb-af277fbdd09f', null, 'Cameras');



--PRODUCTS
--SMARTPHONES
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('28bc87ae-6037-47b9-8b53-0a6abb0f4032', null, 'Xiaomi Redmi Note 9 Pro 6/128GB Interstellar Grey',
        'https://i.ibb.co/jTDkYHR/1.jpg',
        300, 5, 24, '5686643f-46fc-4b56-bd25-4153afef78b9');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('eca5af9a-da54-46d4-8691-1559ba642010', null, 'Xiaomi Mi 10T Pro 8/256GB Lunar Silver',
        'https://i.ibb.co/0h9zTvN/2.jpg',
        250, 5, 18, '5686643f-46fc-4b56-bd25-4153afef78b9');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('89d30e5a-6aae-4501-b0a7-130f0790634b', null, 'Samsung Galaxy S21 Ultra 12/128GB Phantom Black (SM-G998BZKDSEK)',
        'https://i.ibb.co/R32qm6p/3.jpg',
        290, 6, 24, '5686643f-46fc-4b56-bd25-4153afef78b9');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('14d9bf92-6d3a-4a70-8a16-9faa378769f1', null, 'Poco X3 6/128GB Shadow Gray',
        'https://i.ibb.co/mT9Kw5x/4.jpg',
        310, 6, 27, '5686643f-46fc-4b56-bd25-4153afef78b9');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('55215a7a-fae9-46d4-b278-02bdf7347f57', null, 'Huawei P40 lite E 4/64Gb Black (51095DCE)',
        'https://i.ibb.co/wBj0RNT/smartphones-5.jpg',
        305, 5, 24, '5686643f-46fc-4b56-bd25-4153afef78b9');

--LAPTOPS
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('2d7d6984-1f0a-4d34-a5fe-fd4f63e7e138', null, 'ASUS E410MA-EB268 (90NB0Q11-M17970)',
            'https://i.ibb.co/QbQJjrr/laptops-1.jpg',
        400, 20, 97, 'd72fce72-ab46-49a3-ad52-937a1bcf1190');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('fa39a5c3-abe6-45de-9b33-85a06a55303a', null, 'Huawei MateBook D 15 (53010TSY) Space Grey',
        'https://i.ibb.co/pK9crTt/laptops-2.jpg',
        550, 15, 63, 'd72fce72-ab46-49a3-ad52-937a1bcf1190');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('c075d86c-f17d-4882-b7e2-9c174d003618', null, 'Apple MacBook Pro 2019 16" 1Тb (MVVM2) Silver',
        'https://i.ibb.co/PMGBSVR/laptops-3.jpg',
        3050, 3, 13, 'd72fce72-ab46-49a3-ad52-937a1bcf1190');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('6b0e578a-2277-428b-bd41-d4b3fce2cd46', null, 'ASUS Laptop X515JP-BQ031 (90NB0SS1-M00620)',
        'https://i.ibb.co/BnT02xh/laptops-4.jpg',
        530, 5, 24, 'd72fce72-ab46-49a3-ad52-937a1bcf1190');

--TV SETS
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('5d31c5b4-0794-431e-96f9-12b6f51212f9', null, 'Sony KD65XH9505BR2',
        'https://i.ibb.co/8XhgqqC/tv-1.jpg',
        2950, 22, 96, 'a2778a28-4435-460b-8480-63fe8e0e17a5');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('74937ce0-5949-4bc2-a027-b8d935e9c779', null, '65" Sony KD65XH8096BR2 Black',
        'https://i.ibb.co/khvLqs7/tv-2.jpg',
        1475, 16, 63, 'a2778a28-4435-460b-8480-63fe8e0e17a5');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('613bd724-9484-448c-83d9-4769bea2ec60', null, '32" Samsung UE32N5000AUXUA Black',
        'https://i.ibb.co/qD07PyT/tv-3.jpg',
        380, 8, 18, 'a2778a28-4435-460b-8480-63fe8e0e17a5');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('bd230d08-7803-49c1-9930-93e63df38ccf', null, '55" LG OLED55CX6LA Black',
        'https://i.ibb.co/dtgzgdN/tv-4.jpg',
        1700, 10, 49, 'a2778a28-4435-460b-8480-63fe8e0e17a5');

--TABLETS
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('4f86fcc0-0d9d-411e-8627-471674df6f62', null, 'Samsung Tab S6 Lite 4/64GB 10.4" Wi-Fi Grey (SM-P610NZAASEK)',
        'https://i.ibb.co/m9pNmRn/tablets-1.jpg',
        330, 26, 96, '2f5f3367-32ec-48a1-8a8a-a91bb75e412d');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('d3331187-51a6-4007-8939-216f9a4dd9a5', null, 'HUAWEI MediaPad T3 9.6" 16GB LTE Grey',
        'https://i.ibb.co/kKFQStG/tablets-2.jpg',
        175, 18, 63, '2f5f3367-32ec-48a1-8a8a-a91bb75e412d');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('fb7c4a74-e2fb-4eef-ad4d-5dd0cfdc5976', null, 'Lenovo Tab M10 HD 2/16 LTE Slate Black (ZA4H0057UA)',
        'https://i.ibb.co/P6rLV03/tablets-3.jpg',
        180, 4, 18, '2f5f3367-32ec-48a1-8a8a-a91bb75e412d');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('c4a7bc4e-6bc0-454d-a99d-05ee7b05bc3b', null, 'Apple iPad 7th 10.2" 2019 Wi-Fi 32GB Space Gray (MW742)',
        'https://i.ibb.co/TRZh23m/tablets-4.jpg',
        350, 11, 49, '2f5f3367-32ec-48a1-8a8a-a91bb75e412d');

--HEADPHONES
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('45359da9-a1cc-48cc-bee5-0710584ef304', null, 'Apple AirPods Max Space Gray',
        'https://i.ibb.co/1dxFbLx/headphones-1.jpg',
        900, 14, 59, '7c925a87-c362-4a58-aa90-8585b5c92811');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('c3819c70-d1dc-4d7c-b2cd-f7bf8550a48c', null, 'Samsung Galaxy Buds Pro (SM-R190NZKASEK) Black',
        'https://i.ibb.co/N7Z2wTJ/headphones-2.jpg',
        170, 17, 72, '7c925a87-c362-4a58-aa90-8585b5c92811');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('ec94ff60-fe6c-440a-ab47-b3f0a0c3a27b', null, 'Amazfit PowerBuds Dynamic Black',
        'https://i.ibb.co/6P7gThx/headphones-3.jpg',
        70, 30, 105, '7c925a87-c362-4a58-aa90-8585b5c92811');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('ec19f973-8ebf-46a2-bd6f-ae0401ded5f8', null, '1MORE Piston Fit (E1009-SR) Silver',
        'https://i.ibb.co/vPWN9Fw/headphones-4.jpg',
        10, 40, 117, '7c925a87-c362-4a58-aa90-8585b5c92811');

--CAMERAS
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('d9b0f550-f316-40bd-a93f-4fdf67dc4323', null, 'Canon EOS M50 kit 15-45mm IS STM black',
        'https://i.ibb.co/mh55VT0/cameras-1.jpg',
        600, 13, 59, 'bd5b1062-cf16-4d75-aadb-af277fbdd09f');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('f6109317-a9d1-4cc5-8428-406c278a702d', null, 'Canon PowerShot SX430 Black',
        'https://i.ibb.co/ngPNh9c/cameras-2.jpg',
        300, 17, 70, 'bd5b1062-cf16-4d75-aadb-af277fbdd09f');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('f721e0b7-ea04-4577-8429-d7aaa24db2eb', null, 'Canon EOS 77D Body',
        'https://i.ibb.co/s5GhSxY/cameras-3.jpg',
        590, 25, 110, 'bd5b1062-cf16-4d75-aadb-af277fbdd09f');
INSERT INTO public.products(id, description, name, image_url, price, rating_count, rating_sum, category_id)
VALUES ('e7810901-0e3b-4dc3-b2bd-1e809f2e326b', null, 'Canon EOS M100 15-45 IS STM White Kit',
        'https://i.ibb.co/wLMfs9k/cameras-4.jpg',
        410, 19, 89, 'bd5b1062-cf16-4d75-aadb-af277fbdd09f');


--OFFERINGS_PRODUCTS
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', 'fb7c4a74-e2fb-4eef-ad4d-5dd0cfdc5976');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', '613bd724-9484-448c-83d9-4769bea2ec60');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', '2d7d6984-1f0a-4d34-a5fe-fd4f63e7e138');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', 'eca5af9a-da54-46d4-8691-1559ba642010');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', 'ec19f973-8ebf-46a2-bd6f-ae0401ded5f8');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('ab78bc01-1f84-4423-9db6-366083050361', 'f6109317-a9d1-4cc5-8428-406c278a702d');

INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', '14d9bf92-6d3a-4a70-8a16-9faa378769f1');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', 'c075d86c-f17d-4882-b7e2-9c174d003618');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', '5d31c5b4-0794-431e-96f9-12b6f51212f9');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', 'c4a7bc4e-6bc0-454d-a99d-05ee7b05bc3b');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', '45359da9-a1cc-48cc-bee5-0710584ef304');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('c7f542e6-1b95-42ba-a913-dcc1f1c6d8ad', 'e7810901-0e3b-4dc3-b2bd-1e809f2e326b');

INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', '28bc87ae-6037-47b9-8b53-0a6abb0f4032');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', '2d7d6984-1f0a-4d34-a5fe-fd4f63e7e138');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', 'bd230d08-7803-49c1-9930-93e63df38ccf');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', 'c4a7bc4e-6bc0-454d-a99d-05ee7b05bc3b');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', 'c3819c70-d1dc-4d7c-b2cd-f7bf8550a48c');
INSERT INTO public.offerings_products(offerings_id, products_id)
VALUES ('a67152ba-4e16-4835-bc5c-8656cea8a766', 'd9b0f550-f316-40bd-a93f-4fdf67dc4323');


--PRODUCT_COMMENTS
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('10cb01e4-6089-42cb-9058-4ba9f2b91eb5', 'Mark', 'Very good!', '28bc87ae-6037-47b9-8b53-0a6abb0f4032');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('f11e901e-651e-418a-b241-f26eec019458', 'John', 'Can be better for such price!', 'eca5af9a-da54-46d4-8691-1559ba642010');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('0679f8e1-92d2-43a5-9086-5eb68bfb1928', 'Stephan', 'Nice style, i like the colors', '14d9bf92-6d3a-4a70-8a16-9faa378769f1');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('d094d98e-97da-4abc-acfd-d40a5967edbc', 'Yurii', 'Good parameters for such price', '5d31c5b4-0794-431e-96f9-12b6f51212f9');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('ae1e47f9-86c9-4352-940a-69dfe5b98427', 'Olha', 'I got product with broken corpus, please be more careful with shipping', '5d31c5b4-0794-431e-96f9-12b6f51212f9');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('6a312733-f136-4ff9-af05-bc1608bada18', 'Vlad', 'Nice!', '6b0e578a-2277-428b-bd41-d4b3fce2cd46');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('e9f8a501-047d-49c5-b9a5-f7df3efd2ae1', 'Andre', 'All works fine already 5 years', '4f86fcc0-0d9d-411e-8627-471674df6f62');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('1b3ea3ef-c37f-4cc7-9853-de0bc0758c19', 'Anatolii', 'Good productivity', 'd3331187-51a6-4007-8939-216f9a4dd9a5');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('bdae549b-eb58-4e9e-9fca-e097639afca5', 'Selena', 'Awesome!', 'fb7c4a74-e2fb-4eef-ad4d-5dd0cfdc5976');
INSERT INTO public.product_comments(id, author, content, product_id)
VALUES ('5da8f58e-5aed-4c72-8849-c9c8fe25beeb', 'Roman', 'Unbelievable quality!', 'c4a7bc4e-6bc0-454d-a99d-05ee7b05bc3b');


--CHARACTERISTIC_GROUPS
INSERT INTO public.characteristic_groups(id, description, name)
VALUES ('7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab', null, 'Color');
INSERT INTO public.characteristic_groups(id, description, name)
VALUES ('e162c2a7-1f0d-4836-a0f7-7b463e1ba882', null, 'Smartphone Models');


--CHARACTERISTICS
--Color
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('c0b7bc50-bc7c-4e86-b44e-eb9509bf229e', 'Black', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('d6b4bd65-b214-450e-850e-e008cccebdae', 'White', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('e9102a56-2374-4514-9426-b4019528b576', 'Grey', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('b5c00cba-e931-4967-ad52-10b5b79c8fc5', 'Silver', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
--Smartphone Models
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('88e04986-ee86-4afd-8ef3-df1b1c764421', 'Xiaomi', 'e162c2a7-1f0d-4836-a0f7-7b463e1ba882');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('2644e345-b917-4479-886b-965ba935c896', 'Samsung', 'e162c2a7-1f0d-4836-a0f7-7b463e1ba882');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('99f6220e-0aee-4a2b-9cb2-ceda5177fd45', 'Poco', 'e162c2a7-1f0d-4836-a0f7-7b463e1ba882');
INSERT INTO public.characteristics(id, value, group_id)
VALUES ('6571aa58-8e46-4da2-a8b8-ef00b754073c', 'Huawei', 'e162c2a7-1f0d-4836-a0f7-7b463e1ba882');


--PRODUCT_CATEGORIES_CHARACTERISTIC_GROUPS
--Color
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('a2778a28-4435-460b-8480-63fe8e0e17a5', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('d72fce72-ab46-49a3-ad52-937a1bcf1190', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('2f5f3367-32ec-48a1-8a8a-a91bb75e412d', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('5686643f-46fc-4b56-bd25-4153afef78b9', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('7c925a87-c362-4a58-aa90-8585b5c92811', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('bd5b1062-cf16-4d75-aadb-af277fbdd09f', '7d93a7e1-96d9-4b95-b78e-5f81e3ed18ab');
--Smartphone Models
INSERT INTO public.product_categories_characteristic_groups(product_categories_id, characteristic_groups_id)
VALUES ('5686643f-46fc-4b56-bd25-4153afef78b9', 'e162c2a7-1f0d-4836-a0f7-7b463e1ba882');


--PRODUCTS_CHARACTERISTICS
--Color: Black
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('89d30e5a-6aae-4501-b0a7-130f0790634b', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('55215a7a-fae9-46d4-b278-02bdf7347f57', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('74937ce0-5949-4bc2-a027-b8d935e9c779', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('613bd724-9484-448c-83d9-4769bea2ec60', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('bd230d08-7803-49c1-9930-93e63df38ccf', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('fb7c4a74-e2fb-4eef-ad4d-5dd0cfdc5976', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('c3819c70-d1dc-4d7c-b2cd-f7bf8550a48c', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('ec94ff60-fe6c-440a-ab47-b3f0a0c3a27b', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('d9b0f550-f316-40bd-a93f-4fdf67dc4323', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('f6109317-a9d1-4cc5-8428-406c278a702d', 'c0b7bc50-bc7c-4e86-b44e-eb9509bf229e');
--Color: White
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('e7810901-0e3b-4dc3-b2bd-1e809f2e326b', 'd6b4bd65-b214-450e-850e-e008cccebdae');
--Color: Grey
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('28bc87ae-6037-47b9-8b53-0a6abb0f4032', 'e9102a56-2374-4514-9426-b4019528b576');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('fa39a5c3-abe6-45de-9b33-85a06a55303a', 'e9102a56-2374-4514-9426-b4019528b576');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('4f86fcc0-0d9d-411e-8627-471674df6f62', 'e9102a56-2374-4514-9426-b4019528b576');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('d3331187-51a6-4007-8939-216f9a4dd9a5', 'e9102a56-2374-4514-9426-b4019528b576');
--Color: Silver
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('eca5af9a-da54-46d4-8691-1559ba642010', 'b5c00cba-e931-4967-ad52-10b5b79c8fc5');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('c075d86c-f17d-4882-b7e2-9c174d003618', 'b5c00cba-e931-4967-ad52-10b5b79c8fc5');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('ec19f973-8ebf-46a2-bd6f-ae0401ded5f8', 'b5c00cba-e931-4967-ad52-10b5b79c8fc5');

--Smartphone Models: Xiaomi
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('28bc87ae-6037-47b9-8b53-0a6abb0f4032', '88e04986-ee86-4afd-8ef3-df1b1c764421');
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('eca5af9a-da54-46d4-8691-1559ba642010', '88e04986-ee86-4afd-8ef3-df1b1c764421');
--Smartphone Models: Samsung
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('89d30e5a-6aae-4501-b0a7-130f0790634b', '2644e345-b917-4479-886b-965ba935c896');
--Smartphone Models: Poco
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('14d9bf92-6d3a-4a70-8a16-9faa378769f1', '99f6220e-0aee-4a2b-9cb2-ceda5177fd45');
--Smartphone Models: Huawei
INSERT INTO public.products_characteristics(products_id, characteristics_id)
VALUES ('55215a7a-fae9-46d4-b278-02bdf7347f57', '6571aa58-8e46-4da2-a8b8-ef00b754073c');

