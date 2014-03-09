SELECT * FROM accounting.resale_prod_table;

SELECT * FROM accounting.resale_table;

SELECT * FROM accounting.loan_table;

SELECT * FROM accounting.residence_table;

Select * 
from accounting.product_table as A , accounting.resale_prod_table as B 
where A.PRODUCT_ID = B.X_PRODUCT_ID;

Select A.*, B.*, C.* 
from accounting.product_table as A , accounting.resale_prod_table as B , accounting.resale_table as C
where A.PRODUCT_ID = B.X_PRODUCT_ID and B.RP_ID = C.X_RP_ID;

Select A.*, B.*, C.* , D.LOAN_ID, D.X_CUSTOMER_ID
from accounting.product_table as A , accounting.resale_prod_table as B , accounting.resale_table as C , loan_table as D
where A.PRODUCT_ID = B.X_PRODUCT_ID and B.RP_ID = C.X_RP_ID and C.X_PURCHASER_ID = D.X_CUSTOMER_ID; 

Select A.LOAN_ID, B.X_LOAN_ID , A.*, B.* 
from  loan_table as A, repayment_table as B 
where A.LOAN_ID=B.X_LOAN_ID; 




