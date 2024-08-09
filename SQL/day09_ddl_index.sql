-- day09_ddl_index.sql

-- �ε��� ----------------------------------
-- SQL ���� (SELECT, DML)�� ó�� �ӵ��� ����Ű�� ���ؼ� �÷��� ���� �����ϴ� ����Ʈ���̽� ��ü��
-- �ε��� ���� ������ B* Ʈ��(����Ž��Ʈ�� : BST, Binary Search Tree) ��
-- �ε��� ��ü�� �����ϴ� ���� �ð��� �ʿ��ϰ�, ������ �ʿ���=> ����Ѵٰ� �ݵ�� ���� ���� �ƴ�.
-- �ε��� ����(����) �Ŀ� DML �۾��� �����ϸ�, �ε����� ����� Ű����(�÷���)�� ����ǹǷ� B*Ʈ�� ���� ���� �����.
-- B*Ʈ���� �ٽ� ������ �Ǿ�� �ϹǷ�(�ڵ�) DML �۾��� �ξ� ���ſ����� ��.

-- ���� :
-- �˻� �ӵ��� ����
-- �ý��ۿ� �ɸ��� ���ϸ� �ٿ��� �ý��� ��ü ������ ����Ŵ

-- ���� :
-- �ε����� ���� �߰����� ������ �ʿ���
-- �ε����� �����ϴ� �� �ð��� �ʿ���
-- ���̺� DML(INSERT, UPDATE, DELETE)�� ���� �߻��ϴ� ���, �ε��� Ʈ�� �籸���� �ڵ� ����ǹǷ�
-- ���� ���ϵ�.

-- �ε��� ���� ���� : 
/*
CREATE  [UNIQUE] INDEX �ε����̸� ON ���̺�� (�÷���[, �÷���, ......] | �Լ�����);

�ε��� ���� : UNIQUE INDEX, NONUNIQUE INDEX
*/

-- UNIQUE INDEX :
-- �÷��� UNIQUE �������� ������ �Ͱ� ���� => ���� �� �ι� ��� �� �� (�ߺ��˻�)
-- PRIAMARY KEY�� UNIQUE ���������� ������ �÷��� ���� �ڵ����� UNIQUE INDEX�� ������.

CREATE UNIQUE INDEX IDX_DNM 
ON DEPARTMENT (DEPT_NAME);

-- �ε����� �ڵ����� ����� �� :
-- SELECT, INSERT, UPDATE, DELETE ���� ����
-- WHERER ��, JOIN �÷� ���� �ڵ����� ���.

-- �ε��� ���� �ǽ�--------------------------
-- 1. EMPLOYEE ���̺��� EMP_NAME �÷���
-- IDX_ENM �̸��� UNIQUE INDEX ����

CREATE UNIQUE INDEX EMP_NAME
ON EMPLOYEE (EMP_NAME);

-- 2. ���ο� �����͸� �Է� �غ���, ���� ������ �ľ��Ͻÿ�.
CREATE SEQUENCE SEQ_EID
START WITH 400
NOMAXVALUE
NOCYCLE NOCACHE;

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES (SEQ_EID.NEXTVAL, '880808-1234567', '���켷');
-- ���� ���� :
-- EMPLOYEE �� EMP_NAME �÷��� '���켷' �̸��� �̹� ������.
-- UNIQUE INDEX�� UNIQUE �������� ����� ������.

-- 3. EMPLOYEE ���̺��� DEPT_ID �÷���
-- IDX_DID �̸��� UNIQUE INDEX �� ������ ����
CREATE UNIQUE INDEX IDX_DID
ON EMPLOYEE (DEPT_ID);

-- ���� ���� :
-- DEPT_ID �÷��� �̹� �ߺ����� ���� �� ����ϰ� �ִ� �÷���
-- UNIQUE INDEX ���� �� ��

-- NONUNIQUE INDEX -------------------
-- ����ϰ� ���Ǵ� �Ϲ� �÷��� �����ϴ� �ε�����
-- ���� ����� ���� ����
CREATE INDEX IDX_DID
ON EMPLOYEE (DEPT_ID);

-- �ε��� ���� ---------------
-- ���̺��� �����Ǹ�, �ε����� ���� ������.
-- DROP INDEX �ε����̸�;
DROP INDEX EMP_NAME;

-- �ε��� ���� ��ųʸ� ���� Ȯ��
DESC USER_INDEXES;
DESC USER_IND_COLUMNS;

SELECT INDEX_NAME, COLUMN_NAME, TABLE_NAME, INDEX_TYPE, UNIQUENESS
FROM USER_INDEXES
JOIN USER_IND_COLUMNS USING (INDEX_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'EMPLOYEE';


-- �˻� �ӵ� ���غ���
-- EMPLOYEE ���̺��� ��� ������ �������� ����ؼ� ������ EMPL01, EMPL02 ���̺� ����ÿ�.
-- EMPL 01 �� EMP_ID �÷��� ���� UNIQUE INDEX ����ÿ�. : IDX_EID
-- �˻� �ӵ� �񱳸� ���� SELECT �������� EMP_ID �÷����� ��ȸ�غ��� : ��� 141�� ���� ��ȸ
CREATE TABLE EMPL01
AS
SELECT * FROM EMPLOYEE;

CREATE TABLE EMPL02
AS
SELECT * FROM EMPLOYEE;

CREATE UNIQUE INDEX IDX_EID
ON EMPL01 (EMP_ID);

SELECT * FROM EMPL01
WHERE EMP_ID = '141' ; -- 0.002 ��

SELECT * FROM EMPL02
WHERE EMP_ID = '141'; -- 0.004 ��

-- ���� �ε��� -------------------------
-- ���� �ε��� : �� ���� �÷����� ������ �ε���
-- ���� �ε��� : �� �� �̻��� �÷����� ������ �ε���
CREATE TABLE DEPT01
AS
SELECT * FROM DEPARTMENT;

-- �μ���ȣ�� �μ����� �����ؼ� �ε��� �����
CREATE INDEX IDX_DEPT01_COMP 
ON DEPT01 (DEPT_ID, DEPT_NAME);

-- ��ųʸ����� Ȯ�� :
SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'DEPT01';

-- �Լ� ��� �ε��� -----------------------
-- SELECT ���̳� WHERE ���� ��� �����̳� �Լ����� ����ϴ� ���
-- ������ �ε����� ������ ���� �ʴ´�. (�ε����� ����� ������ �� ���� ����)
-- ��� ������� Ű����� �ؼ� �˻� Ʈ���� ������ �� ����.
-- �������� �˻��ϴ� ��찡 ���ٸ�, �����̳� �Լ����� �ε����� ���� �� ����
CREATE TABLE EMPL03
AS
SELECT * FROM EMPLOYEE;

CREATE INDEX IDX_EMPL3_SALCALC
ON EMPL03 ((SALARY + (SALARY * NVL(BONUS_PCT, 0)))* 12);

SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'EMPL03';



