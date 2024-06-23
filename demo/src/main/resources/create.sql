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
INSERT INTO `user` (userID, user_name, gender, student_number, age)VALUES (1, 'aa', 'female', '2024001', 18);

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE merchant (
                          merchantID INT AUTO_INCREMENT PRIMARY KEY,
                          merchant_name VARCHAR(255),
                          address VARCHAR(255)
);
INSERT INTO merchant (merchantID, merchant_name, address)VALUES (1, 'hamburger', 'H201');


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
INSERT INTO good (good_name,price, category, description, image, if_in_main_dish, merchantID)VALUES ('good1',10.99, 'Electronics', 'High-quality headphones', 'headphones.jpg', TRUE, 1);
INSERT INTO good (good_name,price, category, description, image, if_in_main_dish, merchantID)VALUES ('good2',10.99, 'Electronics', 'High-quality headphones', 'headphones.jpg', TRUE, 1);
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
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
                         FOREIGN KEY (orderID) REFERENCES `order`(orderID)
);


DROP TABLE IF EXISTS `message`;
CREATE TABLE message (
                         messageID INT AUTO_INCREMENT PRIMARY KEY,
                         orderID INT,
                         userID INT,
                         content TEXT,
                         FOREIGN KEY (orderID) REFERENCES `order`(orderID),
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
