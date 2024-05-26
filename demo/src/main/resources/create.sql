USE database_pj;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 检查表是否存在，如果不存在则创建
DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
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
                       price DECIMAL(10, 2),
                       category VARCHAR(255),
                       description TEXT,
                       img VARCHAR(255),
                       if_in_main_dish BOOLEAN,
                       merchantID INT,
                       FOREIGN KEY (merchantID) REFERENCES merchant(merchantID)
);
DROP TABLE IF EXISTS `comment`;
CREATE TABLE comment (
                         commentID INT AUTO_INCREMENT PRIMARY KEY,
                         content TEXT,
                         rating DECIMAL(3, 2),
                         goodID INT,
                         FOREIGN KEY (goodID) REFERENCES good(goodID)
);
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
