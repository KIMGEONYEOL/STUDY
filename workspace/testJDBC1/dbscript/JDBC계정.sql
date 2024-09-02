-- 관리자 계정에서
create user c##jdbc identified by jdbc;
grant connect, resource to c##jdbc;
alter user c##jdbc quota 1024M ON users;

grant create view to c##jdbc;

-- 사번 자동 발생 시퀀스 생성
CREATE SEQUENCE SEQ_EMPID
START WITH 211
INCREMENT BY 1
MAXVALUE 999
NOCYCLE
NOCACHE;


CREATE TABLE  BOOK (
     book_id NUMBER PRIMARY KEY
    ,title VARCHAR2(50) NOT NULL
    ,author VARCHAR2(20) NOT NULL
    ,publisher VARCHAR2(20) NOT NULL
    ,publish_date DATE NOT NULL
    ,price NUMBER NOT NULL);
