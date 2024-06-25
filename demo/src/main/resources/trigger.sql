USE database_pj;
-- 创建触发器，监视 orders 表中 status 字段的更新
DELIMITER //
CREATE TRIGGER orders_status_update_trigger
    AFTER UPDATE ON `orders`
    FOR EACH ROW
BEGIN
    IF NEW.status = 'complete' AND OLD.status <> 'complete' THEN
        INSERT INTO message (orderID, userID, content)
        VALUES (NEW.orderID, NEW.userID, CONCAT('您的订单 ', NEW.orderID, ' 已完成'));
    END IF;
END//
DELIMITER ;