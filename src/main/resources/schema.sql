-- 社員マスタテーブルの作成
create table EMPLOYEE (
    ID INTEGER NOT NULL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    BIRTHDAY DATE NOT NULL,
    RANK VARCHAR(10) NOT NULL,
    RATE INTEGER NOT NULL
);

create table EMPLOYEE_EXTRACT_EXECUTION (
    EMPLOYEE_ID INTEGER NOT NULL PRIMARY KEY,
    STATUS VARCHAR(10) NOT NULL,
    CREATE_TIME DATE NOT NULL,
    LAST_UPDATED DATE NOT NULL
);