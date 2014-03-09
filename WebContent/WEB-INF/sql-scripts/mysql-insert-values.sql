use accounting;

INSERT INTO `accounting`.`User` (`Id`,`Firstname`,`Lastname`,`Mobile`,`Email`,`Password`) VALUES (9,'Aditya','Rajurkar','9665020551','aditya.rajurkar@gmail.com','aditya.rajurkar@gmail.com');
INSERT INTO `accounting`.`User` (`Id`,`Firstname`,`Lastname`,`Mobile`,`Email`,`Password`) VALUES (10,'Tejas','Alsi','9665020552','tejas.alsi@gmail.com','tejas.alsi@gmail.com');
INSERT INTO `accounting`.`User` (`Id`,`Firstname`,`Lastname`,`Mobile`,`Email`,`Password`) VALUES (11,'Krishna','Singh','9665020553','krishna.singh@gmail.com','krishna.singh@gmail.com');

INSERT INTO `accounting`.`residence_table` (`RESIDENCE_ID`,`RESIDENCE_TYPE`) VALUES (1,'Owned');
INSERT INTO `accounting`.`residence_table` (`RESIDENCE_ID`,`RESIDENCE_TYPE`) VALUES (2,'Rented');
INSERT INTO `accounting`.`residence_table` (`RESIDENCE_ID`,`RESIDENCE_TYPE`) VALUES (3,'C/o');
INSERT INTO `accounting`.`residence_table` (`RESIDENCE_ID`,`RESIDENCE_TYPE`) VALUES (4,'Shifted');

INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (1,"Bajaj", "Discover-125");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (2,"Bajaj", "Pulsar-150");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (3,"Bajaj", "Pulsar-200");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (4,"Honda", "Dio");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (5,"Honda", "Activa");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (6,"Honda", "Brio");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (7,"Mahindra", "XUV500");
INSERT INTO `accounting`.`product_table`  (`PRODUCT_ID`,`VEHICLE_COMPANY`,`VEHICLE_MODEL`) VALUES (8,"Mahindra", "Rexton");


INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(1,'A1','B1','C1','D1','E1','F1','H1','I1');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(2,'A2','B2','C2','D2','E2','F2','H2','I2');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(3,'A3','B3','C3','D3','E3','F3','H3','I3');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(4,'A4','B4','C4','D4','E4','F4','H4','I4');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(5,'A5','B5','C5','D5','E5','F5','H5','I5');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(6,'A6','B6','C6','D6','E6','F6','H6','I6');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(7,'A7','B7','C7','D7','E7','F7','H7','I7');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(8,'A8','B8','C8','D8','E8','F8','H8','I8');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(9,'A9','B9','C9','D9','E9','F9','H9','I9');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(10,'A10','B10','C10','D10','E10','F10','H10','I10');
INSERT INTO `accounting`.`customer_table`(`CUSTOMER_ID`,`FIRST_NAME`,`LAST_NAME`,`RES_ADD`,`OFFICE_ADD`,`PERMANENT_ADD`,`TELEPHONE`,`MOBILE`,`EMAIL`)
VALUES(11,'A11','B11','C11','D11','E11','F11','H11','I11');

INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (1,1,'MH-01-A-0001');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (2,1,'MH-01-A-0002');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (3,2,'MH-01-A-0003');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (4,2,'MH-01-A-0004');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (5,3,'MH-01-A-0005');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (6,3,'MH-01-A-0006');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (7,4,'MH-01-A-0007');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (8,4,'MH-01-A-0008');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (9,5,'MH-01-A-0009');
INSERT INTO `accounting`.`resale_prod_table` (`RP_ID`,`X_PRODUCT_ID`,`REGISTRATION_NUM`) VALUES (10,5,'MH-01-A-0010');



INSERT INTO `accounting`.`resale_table`(`RESALE_ID`,`X_PURCHASER_ID`,`X_GARENTOR_ID`,`X_RP_ID`) VALUES(1,1,2,1);
INSERT INTO `accounting`.`resale_table`(`RESALE_ID`,`X_PURCHASER_ID`,`X_GARENTOR_ID`,`X_RP_ID`) VALUES(2,3,4,2);
INSERT INTO `accounting`.`resale_table`(`RESALE_ID`,`X_PURCHASER_ID`,`X_GARENTOR_ID`,`X_RP_ID`) VALUES(3,5,6,3);
INSERT INTO `accounting`.`resale_table`(`RESALE_ID`,`X_PURCHASER_ID`,`X_GARENTOR_ID`,`X_RP_ID`) VALUES(4,7,8,4);


-- ------------------------------------------------------------------------------------------------------------


INSERT INTO `accounting`.`repay_mode_table`(`REPAY_MODE_ID`,`REPAY_MODE`) VALUES(1,'Cash');
INSERT INTO `accounting`.`repay_mode_table`(`REPAY_MODE_ID`,`REPAY_MODE`) VALUES(2,'Cheque');
INSERT INTO `accounting`.`repay_mode_table`(`REPAY_MODE_ID`,`REPAY_MODE`) VALUES(3,'NEFT');
INSERT INTO `accounting`.`repay_mode_table`(`REPAY_MODE_ID`,`REPAY_MODE`) VALUES(4,'RTGS');

-- (year-month-date)
INSERT INTO `accounting`.`loan_table`
(`LOAN_ID`, `X_CUSTOMER_ID`,`ASSET_VALUE`,`LOAN_AMOUNT`,`TENURE`,`INSTALLMENT`,`ROI`,`DISBURSMENT_DATE`,`CHEQUE_NO`,`REPAYMENT_START`)
VALUES (1,1,10,10,5,2,10,'2014-01-02','CHQ1','2014-02-04');
INSERT INTO `accounting`.`loan_table`
(`LOAN_ID`, `X_CUSTOMER_ID`,`ASSET_VALUE`,`LOAN_AMOUNT`,`TENURE`,`INSTALLMENT`,`ROI`,`DISBURSMENT_DATE`,`CHEQUE_NO`,`REPAYMENT_START`)
VALUES (2,3,10,10,5,2,10,'2014-01-02','CHQ2','2014-02-04');
INSERT INTO `accounting`.`loan_table`
(`LOAN_ID`, `X_CUSTOMER_ID`,`ASSET_VALUE`,`LOAN_AMOUNT`,`TENURE`,`INSTALLMENT`,`ROI`,`DISBURSMENT_DATE`,`CHEQUE_NO`,`REPAYMENT_START`)
VALUES (3,5,10,10,5,2,10,'2014-01-02','CHQ3','2014-02-04');


INSERT INTO `accounting`.`repayment_table`
(`REPAY_ID`,`X_LOAN_ID`,`X_REPAY_MODE_ID`,`CASH_RECEIPT_NO`,`LOAN_ACCOUNT_NO`,`CHEQUE_NO`,`BANK_NAME`,`AMOUNT`,`AMOUNT_REMAINING`)
VALUES(1,1,1,'CASH1','ACC1','CHQ1','BANK1',9,1);
INSERT INTO `accounting`.`repayment_table`
(`REPAY_ID`,`X_LOAN_ID`,`X_REPAY_MODE_ID`,`CASH_RECEIPT_NO`,`LOAN_ACCOUNT_NO`,`CHEQUE_NO`,`BANK_NAME`,`AMOUNT`,`AMOUNT_REMAINING`)
VALUES(2,1,1,'CASH1','ACC1','CHQ1','BANK1',9,1);
INSERT INTO `accounting`.`repayment_table`
(`REPAY_ID`,`X_LOAN_ID`,`X_REPAY_MODE_ID`,`CASH_RECEIPT_NO`,`LOAN_ACCOUNT_NO`,`CHEQUE_NO`,`BANK_NAME`,`AMOUNT`,`AMOUNT_REMAINING`)
VALUES(3,2,2,'CASH1','ACC1','CHQ1','BANK1',9,1);






