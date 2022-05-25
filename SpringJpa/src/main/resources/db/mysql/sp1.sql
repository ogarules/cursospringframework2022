CREATE PROCEDURE read_customer_user(IN in_customerId INTEGER,OUT out_user_id INTEGER,OUT out_customer_id INTEGER,OUT out_username VARCHAR(100),OUT out_password VARCHAR(100),OUT out_name VARCHAR(100),OUT out_last_name VARCHAR(100))
BEGIN
    SELECT USER_ID, CUSTOMER_ID, USERNAME, PASSWORD, NAME, LAST_NAME  
    INTO out_user_id, out_customer_id, out_username, out_password, out_name, out_last_name  
    FROM SPRING_DATA_USER_TBL, SPRING_DATA_CUSTOMER_TBL  WHERE CUSTOMER_ID = FK_CUSTOMER_ID AND CUSTOMER_ID = in_customerId;
END;
