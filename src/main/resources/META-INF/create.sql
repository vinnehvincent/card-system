CREATE TYPE CARD_STATUS AS ENUM('INACTIVE','ACTIVE','LOST','STOLEN','CLOSED');

CREATE TABLE CARDS(
    ID INT PRIMARY KEY,
    ACTIVATED_DATE DATE,
    ACTUAL_BALANCE NUMERIC(20,2),
    AVAILABLE_BALANCE NUMERIC(20,2),
    CARD_NUMBER CHAR(16) UNIQUE,
    CREATED_DATE DATE,
    EXPIRY_DATE DATE,
    PRIMARY_SECONDARY_INDICATOR BOOLEAN,
    STATUS CARD_STATUS
);
INSERT INTO CARDS(ID,ACTIVATED_DATE,ACTUAL_BALANCE,AVAILABLE_BALANCE,CARD_NUMBER,CREATED_DATE,EXPIRY_DATE,PRIMARY_SECONDARY_INDICATOR,STATUS)
          VALUES (2,'2019-05-27',200.02, 157.12,'1234123412341235', '2019-05-27','2024-05-27',TRUE,'ACTIVE');




--DROP TABLE CARDS;QQ