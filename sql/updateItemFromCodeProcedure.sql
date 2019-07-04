DELIMITER //
CREATE PROCEDURE update_Item(
 IN _code varchar(10),
 IN _price decimal(4,2))
 
BEGIN
	UPDATE ITEM SET Price = _price WHERE ItemCode = _code;
END //
DELIMITER ;