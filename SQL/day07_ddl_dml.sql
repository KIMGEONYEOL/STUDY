-- day07_ddl_dml.sql

-- DDL (Data Definition Language, ������ ���Ǿ�)
-- ��ɾ� : CREATE, ALTER, DROP
-- �����ͺ��̽� ��ü�� ����, ����, �����ϴ� ������.
-- ���̺� ��ü : CREATE TABLE, ALTER TABLE, DROP TABLE 
-- �� ��ü : CREATE VIEW, DROP VIEW
-- ������ ��ü : CREATE SEQUENCE, ALTER SEQUENCE, DROP SEQUENCE
-- ����� ��ü : CREATE USER, ALTER USER, DROP USER

-- ���̺� �����
/*
CREATE TABLE ���̺�� (
        �÷���   �ڷ���, 
        �÷���   �����ڷ���,
        �÷���   ��¥�ڷ���,
        �÷���   �����ڷ���(����� �ִ� ����Ʈ ũ��)  -- �������� �ݵ�� ����� �ִ� ����Ʈ ũ�� �����ؾ� ��.
);

���̺��� �ּ� 1���� �÷��� ������ �� => �÷��� ���� �� ���̺��� ���� �� ����.
*/

CREATE TABLE TEST; -- ERROR
CREATE TABLE TEST(); -- ERROR

CREATE TABLE TEST(
    ID  NUMBER
    , NAME  VARCHAR2(20)
    , ADDRESS VARCHAR2(100)
    , ENROLL_DATE DATE DEFAULT SYSDATE
);

DROP TABLE TEST;

-- SQL PLUS ���� ������ ���̺��� ���� Ȯ�� ��ɾ� : DESC[RIBE] ���̺��;
DESCRIBE TEST;

CREATE TABLE ORDERS(
    ORDERNO CHAR(4)
    , CUSTNO CHAR(4)
    , ORDERDATE DATE DEFAULT SYSDATE
    , SHIPDATE DATE
    , SHIPADDRESS VARCHAR2(40)
    , QUANTITY NUMBER
);    

DESC ORDERS;

-- �÷��� ����(COMMENT) �߰� : 
-- COMMENT ON COLUMN [�����ڰ���.]���̺��.�÷��� IS '����';

COMMENT ON COLUMN ORDERS.ORDERNO IS '�ֹ���ȣ';
COMMENT ON COLUMN ORDERS.CUSTNO IS '����ȣ';
COMMENT ON COLUMN ORDERS.ORDERDATE IS '�ֹ�����';
COMMENT ON COLUMN ORDERS.SHIPDATE IS '�������';
COMMENT ON COLUMN ORDERS.SHIPADDRESS IS '����ּ�';
COMMENT ON COLUMN ORDERS.QUANTITY IS '�ֹ�����';


-- *******************************************************
-- ���Ἲ �������ǵ� (CONSTRAINTS)
-- NOT NULL, UNIQUE, PRIMARY KEY, CHECK, FOREIGN KEY

-- 1. NOT NULL ��������
-- �÷��� �ݵ�� ���� ����ؾ� �� (�ʼ� �Է��׸��� ����)
-- �÷��� NULL ��� ���Ѵٴ� ����������
-- NULL�� ���Ǹ� ERROR �߻���
-- ���� : �÷����������� ������ �� ���� (���̺� ���������� ���� �Ұ�)
-- �÷����� : �÷��� �ڷ��� [DEFAULT �⺻��] NOT NULL

CREATE TABLE TESTNN (
        NID NUMBER (5) NOT NULL -- �÷�����
        , N_NAME VARCHAR2(30)
);

-- ���������� ���̺� ������ ��Ͻ� �۵���. (�˻��ϴ� ���)
-- DML �� INSERT ��ɹ� ����Ͽ� ���
INSERT INTO TESTNN (NID, N_NAME)
VALUES (1, '�׽�Ʈ'); -- �����۵���

SELECT * FROM TESTNN;

INSERT INTO TESTNN (NID, N_NAME)
VALUES (NULL, '�׽�Ʈ2'); -- ERROR : NOT NULL ���������� �ɾ���� ������ NULL�� �߰� �� �� ����.

INSERT INTO TESTNN (NID, N_NAME)
VALUES (2, NULL); -- N_NAME���� NOT NULL ���������� ���� ������ ��� ����.

SELECT * FROM TESTNN;

-- ���������� DBMS �� �̸����� ������
-- �������� ������ �̸��� �������� ������ �ڵ����� 'SYS_C....' �������� �̸��� �ڵ������.

-- �������ǿ� �̸� ���� �����ϱ�
-- �÷����� : �÷��� �ڷ��� CONSTRAINT �̸����� ��������
-- ���̺��� : CONSTRAINT �̸����� �������� (������ �÷���)

CREATE TABLE TESTNN2 (
        NID NUMBER (5) CONSTRAINT TNN2_NID_NN NOT NULL 
        , N_NAME VARCHAR2(30)
        -- ���̺������� �������ǵ��� ���� ��Ƽ� ������ �� ����.
        -- ������������ (������ �÷���)
        -- CONSTRAINT �̸����� �������� (������ �÷���)
--        , CONSTRAINT TNN2_NAME_NN NOT NULL (N_NAME) -- ERROR : NOT NULL �� �÷����������� ��������
);

-- 2. UNIQUE �������� ===============================================
-- ���� �÷��� �ߺ���(���� �� �ι� ��Ͻ�) �Է��� �˻��ϴ� ��������
-- ���� �� �ι� ��� ���ϴ� �÷��� ��
-- NULL �� ����� �� ����.
-- ����Ű (���� ���� �÷��� ����)�� ������ ���� ����

CREATE TABLE TESTUN (
        U_ID CHAR(3) UNIQUE,
        U_NAME VARCHAR2(10) NOT NULL
);

-- �� ���
INSERT INTO TESTUN (U_ID, U_NAME) VALUES ('AAA', '����Ŭ');
INSERT INTO TESTUN VALUES ('AAA' , ' �ڹ�'); -- ERROR
INSERT INTO TESTUN VALUES (NULL, '�ڹ�'); -- NULL ��� ����
INSERT INTO TESTUN VALUES ('AAB', '�ڹ�');


SELECT *FROM TESTUN;

-- �������� ������ �̸� ���� 
CREATE TABLE TESTUN2 (
        UN_ID CHAR(3) CONSTRAINT TUN2_ID_UN UNIQUE
        , UN_NAME VARCHAR2(10) CONSTRAINT TUN2_NAME_NN NOT NULL        
);

-- �������� ���� �߻��� ���������̸����� �ľ��� ������.
INSERT INTO TESTUN2 VALUES('AAA', '����Ŭ');
INSERT INTO TESTUN2 VALUES('AAA', '����Ŭ'); -- ERROR : �̸����� Ȯ��

-- ���̺��� ����
CREATE TABLE TESTUN3 (
        UN_ID CHAR(3)
        , UN_NAME VARCHAR2(10) CONSTRAINT TUN3_NAME_NN NOT NULL        
        -- ���̺���
        , CONSTRAINT TUN3_ID_UN UNIQUE (UN_ID)
);

-- 3. PRIMARY KEY (�⺻Ű) �������� ------------------------------
-- NOT NULL + UNIQUE 
-- �ĺ���(IDENTIFIER) : ���̺��� �� ���� ������ ã�� ���� �̿��� �� �ִ� �÷�(�Ӽ�)
-- ����Ű(���� ���� �÷��� ��� �ϳ��� ���������� ������)�� ������ ���� ����
-- �� ���̺� �� ���� ����� �� ����.

CREATE  TABLE TESTPK (
        P_ID NUMBER PRIMARY KEY
        , P_NAME VARCHAR2(10) NOT NULL
        , P_DATE DATE DEFAULT SYSDATE        
);

-- �� ���
INSERT INTO TESTPK (P_ID, P_NAME) VALUES (1, 'ȫ�浿');
INSERT INTO TESTPK VALUES (2, '�̼���', DEFAULT); -- DEFAULT : ����Ʈ�� �����Ǿ��ִ� ���� ���.
INSERT INTO TESTPK VALUES (3, '�̼���'); -- ERROR
-- INSERT �� �÷��� �����ϸ�, ���̺��� ��� �÷��� ���� ����Ѵٴ� �ǹ�.
-- VALUES (���̺��� �÷� ������ ��ġ�ǰ� �� ���� �����)
INSERT INTO TESTPK VALUES (NULL, '�̼���', SYSDATE); -- ERROR : NULL ��� x
INSERT INTO TESTPK VALUES (2, '�̼���', DEFAULT); -- ERROR : �ߺ��Ǵ� �� ��� �� ��

SELECT * FROM TESTPK;

CREATE TABLE TSETPK2 (
        PID NUMBER PRIMARY KEY
        , PNAME VARCHAR2(10) PRIMARY KEY
); -- ERROR : �� ���̺� �⺻Ű(PRIMARY KEY) �� �� ���� ����� �� ����.

-- �÷� ����
CREATE TABLE TESTPK2 (
        PID NUMBER CONSTRAINT TPK2_ID_PK PRIMARY KEY
        , PNAME VARCHAR2(10)
);

-- ���̺� ����
CREATE TABLE TESTPK3 (
        PID NUMBER 
        , PNAME VARCHAR2(10)
        , CONSTRAINT TPK3_ID_PK PRIMARY KEY (PID)
);


-- 4. CHECK �������� ----------------------------------------------------
-- �÷��� ��ϵǴ� ���� ���� ���� �����ϴ� ����������
-- CHECK (�÷��� ������ ���ǰ� AND | OR ����2 ...)
-- ���ǻ��� : ���ǰ��� �ٲ�� ���� ����� �� ���� (SYSDATE ��)

CREATE TABLE TESTCHE (
        C_NAME VARCHAR2(15) CONSTRAINT TCK_NAME_NN NOT NULL
        , C_PRICE NUMBER(5) CHECK (C_PRICE BETWEEN 1 AND 99999)
        , C_LEVEL CHAR(1) CHECK (C_LEVEL IN ('A', 'B', 'C'))
);
-- �� ���
INSERT INTO TESTCHE VALUES ('������S23', 54000, 'A');
INSERT INTO TESTCHE VALUES ('LG G9', 125000, 'A'); -- ERROR : C_PRICE�� CHECK �������ǿ� ����� �� �Է�.
INSERT INTO TESTCHE VALUES ('LG G9', 65000, 'D'); -- ERROR : C_LEVEL�� CHECK �������ǿ� ����� �� �Է�.
INSERT INTO TESTCHE VALUES ('������S25', 52000, 'a'); -- ERROR : C_LEVEL�� CHECK �������ǿ� ����� �� �Է�.
-- ���(����)�Ǵ� ������(��)�� ��ҹ��� ������
SELECT * FROM TESTCHE;

CREATE TABLE  TESTCHK2 (
         C_NAME VARCHAR2(15) CONSTRAINT TCK2_NAME_NN NOT NULL
        , C_PRICE NUMBER(5) CHECK (C_PRICE BETWEEN 1 AND 99999)
        , C_LEVEL CHAR(1) CHECK (C_LEVEL IN ('A', 'B', 'C'))
--      , C_DATE DATE CHECK (C_DATE < SYSDATE) -- ERROR : ���� �� ������ �ٲ�� ���� ���� �� ��. 
--      , C_DATE DATE CHECK (C_DATE < TO_DATE('24/12/31')) -- ERROR : BUG        
--      , C_DATE DATE CHECK (C_DATE < TO_DATE('24/12/31', 'RR/MM/DD')) -- ERROR : BUG
        , C_DATE DATE CHECK (C_DATE < TO_DATE('24/12/31', 'YYYY/MM/DD')) -- OK : BUG
);

-- 5. FOREIGN KEY �������� --------------------------------------------
-- �ٸ� ���̺� �Ǵ� ���� ���̺� (�θ� ���̺�)���� �����ϴ� ��(�����÷�)�� ����ϴ� �÷�(�ڽ� ���ڵ�)�� ������ �� �̿��ϴ� ��������
-- ������� : �θ� �����ϴ� ���� ��Ͽ� ����� �� �ְ� ��
--          => �������� �ʴ� ���� ����ϰ� �Ǹ� ERROR �߻���.
-- �÷����� : [CONSTRAINT �̸�] REFERENCES �θ����̺�� (�����÷���) 
-- ���̺��� : 
--          [CONSTRAINT �̸�] FOREIGN KEY (������ �÷���) REFERENCES �θ����̺�� (�����÷���)
-- ���ǻ��� : �����÷��� �ݵ�� PRIMARY KEY �Ǵ� UNIQUE ���������� ������ �÷��̾�� ��.
-- NULL ����� �� ����

CREATE TABLE TESTFK (
        EID CHAR(3) REFERENCES EMPLOYEE -- EMPLOYEE �� PRIMARY KEY �÷��� �ڵ� �����÷��� ��
        , DID CHAR(2) CONSTRAINT TFK_DID_FK REFERENCES DEPARTMENT (DEPT_ID)
        , JID CHAR(2) 
        --  ���̺� �������� ����
        , CONSTRAINT TFK_JID_FK FOREIGN KEY (JID) REFERENCES JOB (JOB_ID)
);

-- �������̺�(�θ����̺�)�� �����÷��� �ִ� ���� ��Ͽ� ����� �� �ִٴ°� ����������.
INSERT INTO TESTFK VALUES ('300', NULL, NULL); -- ERROR : �������� �ʴ� ��� ���.
INSERT INTO TESTFK VALUES ('100', NULL, NULL);
INSERT INTO TESTFK VALUES ('200', '70', NULL); -- ERROR : �������� �ʴ� �μ��ڵ� ���.
INSERT INTO TESTFK VALUES ('200', '90', NULL);
INSERT INTO TESTFK VALUES ('124', '80', 'j7'); -- ERROR : ���� ��ҹ��ڸ� ������. �������� �ʴ� �����ڵ� ���.
INSERT INTO TESTFK VALUES ('124', '80', 'J7');

SELECT * FROM TESTFK;

-- �������̺�(�θ����̺�)�� �����÷�(�θ�KEY)�� �� �߿���, �ڽķ��ڵ尡 ����ϰ� �ִ� ���� ���� �� ��.
-- �� : �μ����̺��� 90�� �μ��� ���� (�����)
-- DEML �� DELETE �� ���.
/*
DELECTE FROM ���̺��
WHERE �÷��� = �����Ұ�; -- ������ ���� ��ϵ� ���� ã�Ƽ� �����϶�.
*/

DELETE FROM DEPARTMENT
WHERE DEPT_ID = '90'; -- ERRPR : �ڽ� ���ڵ尡 �����ϸ�(���� ������̸�) ���� ��  ��

DELETE FROM DEPARTMENT
WHERE DEPT_ID = '30';

SELECT * FROM DEPARTMENT;

-- ��� ������ �۾��� �����
ROLLBACK;
-- Ȯ��
SELECT * FROM DEPARTMENT;

-- FOREIGN KEY �������� �����ÿ� ���� �ɼ� �߰��� �� ����
-- ���� �ɼ� (DELETION OPTION) : �θ�Ű ���� ���� ���� �ɼ�
-- RESTRICTED (���� �� ��, �⺻), SET NULL (�ڽķ��ڵ� NULL�� �ٲ�), CASCADE(�Բ� ����)

-- ON DELETE SET NULL -----------------------------
-- �θ�Ű �� ������ �ڽ� ���ڵ��� �÷����� NULL �� �ٲ�

-- �θ�Ű ���� ���̺� : 
CREATE TABLE PRODUCT_STATE (
        PSTATE CHAR(1) PRIMARY KEY
        , PCOMMENT VARCHAR2(10)
);

INSERT INTO PRODUCT_STATE VALUES ('A', '�ְ��');
INSERT INTO PRODUCT_STATE VALUES ('B', '����');
INSERT INTO PRODUCT_STATE VALUES ('C', '����');

-- �ܷ�Ű(FOREIGN KEY) ���� ���̺� :
CREATE TABLE PRODUCT (
        PNAME VARCHAR2(20) PRIMARY KEY
        , PPRICE NUMBER CHECK (PPRICE >0)
        , PSTATE CHAR(1) REFERENCES PRODUCT_STATE ON DELETE SET NULL
);

INSERT INTO PRODUCT VALUES ('������', 65400, 'A');
INSERT INTO PRODUCT VALUES ('����', 75500, 'B');
INSERT INTO PRODUCT VALUES ('G9', 15000, 'C');

SELECT * FROM PRODUCT ;

SELECT*
FROM PRODUCT
NATURAL JOIN PRODUCT_STATE;

-- �θ����̺��� �����÷� �� ���� Ȯ��
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'A'; -- �����, ���� �� ��.

-- �ڽ� ���ڵ� �� Ȯ�� : NULL �� �ٲ� �� Ȯ��.
SELECT * FROM PRODUCT ;

-- ON DELETE CASCADE ----------------------------------
-- �θ�Ű �� ������ �ڽ� ���ڵ� �൵ �Բ� ������

CREATE TABLE PRODUCT2 (
        PNAME VARCHAR2(20) PRIMARY KEY
        , PPRICE NUMBER CHECK (PPRICE >0)
        , PSTATE CHAR(1) REFERENCES PRODUCT_STATE ON DELETE CASCADE
);
INSERT INTO PRODUCT2 VALUES ('������', 65400, 'A');
INSERT INTO PRODUCT2 VALUES ('����', 75500, 'B');
INSERT INTO PRODUCT2 VALUES ('G9', 15000, 'C');

SELECT * FROM PRODUCT2 ;
-- �θ�Ű ����
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'B'; -- 1�� ����, ���� �� ��.

-- �ڽ� ���ڵ� �� Ȯ�� : ���� �Բ� ������.
SELECT * FROM PRODUCT2 ;

-----------------------------------------------------------------------------------------------
CREATE TABLE CONSTRAINT_EMP (
        EID CHAR(3) CONSTRAINT PKEID PRIMARY KEY
        , ENAME VARCHAR2(20) CONSTRAINT NENAME NOT NULL
        , ENO CHAR(14) CONSTRAINT NENO NOT NULL CONSTRAINT UENO UNIQUE
        , EMAIL VARCHAR2(25) CONSTRAINT UEMAIL UNIQUE
        , PHONE VARCHAR2(12)
        , HIRE_DATE DATE DEFAULT SYSDATE
        , JID CHAR(2) CONSTRAINT FKJID REFERENCES JOB ON DELETE SET NULL
        , SALARY NUMBER
        , BONUS_PCT NUMBER
        , MARRIAGE CHAR(1) DEFAULT 'N' CONSTRAINT CHK CHECK (MARRIAGE IN ('Y', 'N'))
        , MID CHAR(3) CONSTRAINT FKMID REFERENCES CONSTRAINT_EMP ON DELETE SET NULL
        , DID CHAR(2)
        , CONSTRAINT FKDID FOREIGN KEY (DID) REFERENCES DEPARTMENT ON DELETE CASECADE
);

CREATE TABLE CONSTRAINT_EMP
(EID CHAR(3) CONSTRAINT PKEID PRIMARY KEY,
ENAME VARCHAR2(20) CONSTRAINT NENAME NOT NULL,
ENO CHAR(14) CONSTRAINT NENO NOT NULL CONSTRAINT UENO UNIQUE,
EMAIL VARCHAR2(25) CONSTRAINT UEMAIL UNIQUE,
PHONE VARCHAR2(12),
HIRE_DATE DATE DEFAULT SYSDATE,
JID CHAR(2) CONSTRAINT FKJID REFERENCES JOB ON DELETE SET NULL,
SALARY NUMBER,
BONUS_PCT NUMBER,
MARRIAGE CHAR(1) DEFAULT 'N' CONSTRAINT CHK CHECK (MARRIAGE IN ('Y','N')),
MID CHAR(3) CONSTRAINT FKMID REFERENCES CONSTRAINT_EMP ON DELETE SET NULL,
DID CHAR(2),
CONSTRAINT FKDID FOREIGN KEY (DID) REFERENCES DEPARTMENT ON DELETE CASCADE
);
