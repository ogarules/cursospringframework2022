insert into SPRING_DATA_CUSTOMER_TBL(NAME,LAST_NAME) values('oga', 'Garcia');
insert into SPRING_DATA_USER_TBL(FK_CUSTOMER_ID,USERNAME,PASSWORD) values(1, 'xvanhalenx', '123123');

insert into SPRING_DATA_ACCOUNT_TBL(FK_CUSTOMER_ID,ACCOUNT_NUMBER,CREATED_DATE,BALANCE) values(1, '00112233445566', '2016-02-28', 125590.55);
insert into SPRING_DATA_ACCOUNT_TBL(FK_CUSTOMER_ID,ACCOUNT_NUMBER,CREATED_DATE,BALANCE) values(1, '00112233445577', '2016-02-20', 150000.00);
