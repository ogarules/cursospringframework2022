CREATE PROCEDURE read_user (
    IN in_customerId INT,
    OUT out_user_id INT,
    OUT out_fk_customer_id INT,
    OUT out_username VARCHAR(100),
    OUT out_password VARCHAR(100))
BEGIN
    SELECT USER_ID, FK_CUSTOMER_ID, USERNAME, PASSWORD 
    INTO out_user_id, out_fk_customer_id, out_username, out_password 
    FROM SPRING_DATA_USER_TBL where FK_CUSTOMER_ID = in_customerId;
END;