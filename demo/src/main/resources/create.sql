USE database_pj;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 检查表是否存在，如果不存在则创建
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                      userID INT AUTO_INCREMENT PRIMARY KEY ,
                      user_name VARCHAR(255),
                      gender VARCHAR(10),
                      student_number VARCHAR(20),
                      age INT
);

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE merchant (
                          merchantID INT AUTO_INCREMENT PRIMARY KEY,
                          merchant_name VARCHAR(255),
                          address VARCHAR(255)
);


DROP TABLE IF EXISTS `good`;
CREATE TABLE good (
                       goodID INT AUTO_INCREMENT PRIMARY KEY,
                       good_name VARCHAR(255),
                       price DECIMAL(10, 2),
                       category VARCHAR(255),
                       description TEXT,
                       image VARCHAR(255),
                       if_in_main_dish BOOLEAN,
                       merchantID INT,
                       FOREIGN KEY (merchantID) REFERENCES merchant(merchantID)
);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                         orderID INT AUTO_INCREMENT PRIMARY KEY,
                         merchantID INT,
                         userID INT,
                         `time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         good_id_list TEXT,
                         good_price_list TEXT,
                         total_cost DECIMAL(10, 2),
                         status VARCHAR(50),
                         FOREIGN KEY (merchantID) REFERENCES `merchant`(merchantID),
                         FOREIGN KEY (userID) REFERENCES `User`(userID)
);

DROP TABLE IF EXISTS `comment`;
CREATE TABLE comment (
                         commentID INT AUTO_INCREMENT PRIMARY KEY,
                         content TEXT,
                         rating DECIMAL(3, 2),
                         goodID INT,
                         orderID INT,
                         FOREIGN KEY (goodID) REFERENCES `good`(goodID),
                         FOREIGN KEY (orderID) REFERENCES `orders`(orderID)
);


DROP TABLE IF EXISTS `message`;
CREATE TABLE message (
                         messageID INT AUTO_INCREMENT PRIMARY KEY,
                         orderID INT,
                         userID INT,
                         content TEXT,
                         FOREIGN KEY (orderID) REFERENCES `orders`(orderID),
                         FOREIGN KEY (userID) REFERENCES `User`(userID)
);


DROP TABLE IF EXISTS `favored_merchant`;
CREATE TABLE `favored_merchant` (
                                    favored_merchantID INT AUTO_INCREMENT PRIMARY KEY,
                                    merchantID INT,
                                    userID INT,
                                    set_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    FOREIGN KEY (merchantID) REFERENCES `merchant`(merchantID),
                                    FOREIGN KEY (userID) REFERENCES `User`(userID)
);
DROP TABLE IF EXISTS `favored_goods`;
CREATE TABLE `favored_goods` (
                                 favored_goodsID INT AUTO_INCREMENT PRIMARY KEY,
                                 merchantID INT,
                                 userID INT,
                                 goodID INT,
                                 set_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (merchantID) REFERENCES `merchant`(merchantID),
                                 FOREIGN KEY (userID) REFERENCES `User`(userID),
                                 FOREIGN KEY (goodID) REFERENCES `good`(goodID)
);
# 这里是演示的商家数据
INSERT INTO merchant (merchantID, merchant_name, address)VALUES (1, 'hamburger', 'H201');
INSERT INTO merchant (merchantID, merchant_name, address)VALUES (2, 'food', 'H101');
INSERT INTO merchant (merchantID, merchant_name, address) VALUES (3, 'Pizza Place', 'P301');
INSERT INTO merchant (merchantID, merchant_name, address) VALUES (4, 'Sushi House', 'S401');
INSERT INTO merchant (merchantID, merchant_name, address) VALUES (5, 'Mexican Grill', 'M501');
INSERT INTO merchant (merchantID, merchant_name, address) VALUES (6, 'Coffee Shop', 'C601');
INSERT INTO merchant (merchantID, merchant_name, address) VALUES (7, 'Bakery', 'B701');
INSERT INTO merchant (merchantID, merchant_name, address)VALUES (8, 'food1', 'H102');

#这里是演示的商品信息
-- 商家1 (hamburger)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Hamburger Deluxe', 12.99, 'Food', 'Classic hamburger with cheese and fries', 'hamburger.jpg', TRUE, 1);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Cheeseburger', 10.99, 'Food', 'Simple cheeseburger with lettuce and tomato', 'cheeseburger.jpg', TRUE, 1);
-- 商家2 (food)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Chicken Wrap', 8.99, 'Food', 'Grilled chicken wrap with vegetables', 'https://www.simplejoy.com/wp-content/uploads/2020/07/Chicken-wrap-768x1152.webp', TRUE, 2);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Salad Bowl', 7.99, 'Food', 'Fresh salad bowl with assorted greens', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKi4F589upoZSmqvnpdO2RsgAhWFS45WFe4A&s', TRUE, 2);
-- 商家3 (Pizza Place)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Pepperoni Pizza', 15.99, 'Food', 'Classic pepperoni pizza with mozzarella cheese', 'pepperoni_pizza.jpg', TRUE, 3);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Vegetarian Pizza', 14.99, 'Food', 'Vegetarian pizza with assorted vegetables', 'vegetarian_pizza.jpg', TRUE, 3);
-- 商家4 (Sushi House)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Sashimi Platter', 18.99, 'Food', 'Assorted sashimi slices served with soy sauce', 'sashimi.jpg', TRUE, 4);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('California Roll', 12.99, 'Food', 'California roll with crab meat, avocado, and cucumber', 'california_roll.jpg', TRUE, 4);
-- 商家5 (Mexican Grill)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Taco Platter', 9.99, 'Food', 'Assorted tacos with beef, chicken, and pork', 'tacos.jpg', TRUE, 5);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Quesadilla', 8.99, 'Food', 'Cheese quesadilla served with salsa and guacamole', 'quesadilla.jpg', TRUE, 5);
-- 商家6 (Coffee Shop)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Espresso', 3.99, 'Beverage', 'Strong and rich espresso shot', 'espresso.jpg', FALSE, 6);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Cappuccino', 4.99, 'Beverage', 'Creamy cappuccino with frothy milk', 'cappuccino.jpg', TRUE, 6);
-- 商家7 (Bakery)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Croissant', 2.99, 'Food', 'Freshly baked buttery croissant', 'croissant.jpg', TRUE, 7);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Chocolate Chip Cookie', 1.99, 'Food', 'Delicious chocolate chip cookie', 'cookie.jpg', TRUE, 7);
-- 商家8 (food1)
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Croissant', 2.99, 'Food', 'Freshly baked buttery croissant', 'croissant.jpg', TRUE, 8);
INSERT INTO good (good_name, price, category, description, image, if_in_main_dish, merchantID) VALUES ('Chocolate Chip Cookie', 1.99, 'Food', 'Delicious chocolate chip cookie', 'cookie.jpg', TRUE, 8);

# 这里是演示的用户信息
INSERT INTO `user` (user_name, gender, student_number, age)VALUES ( 'aa', 'female', '2024001', 18);
INSERT INTO `user` (user_name, gender, student_number, age) VALUES ( 'bob', 'male', '2024002', 20);
INSERT INTO `user` (user_name, gender, student_number, age) VALUES ( 'alice', 'female', '2024003', 19);
INSERT INTO `user` (user_name, gender, student_number, age) VALUES ( 'john', 'male', '2024004', 21);
# 订单的信息
INSERT INTO `orders` (merchantID, userID, good_id_list, good_price_list, total_cost, status)
VALUES (2, 2, '3,4', '8.99,7.99', 16.98, 'processing');

INSERT INTO `orders` (merchantID, userID, good_id_list, good_price_list, total_cost, status)
VALUES (3, 2, '5,6', '15.99,14.99', 30.98, 'processing');

