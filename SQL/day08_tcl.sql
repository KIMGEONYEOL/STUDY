-- day08_tcl.sql

-- TCL (Transaction Control Language : Ʈ����� �����)
-- ��ɾ� : COMMIT, ROLLBACK, SAVEPOINT
-- DML (INSERT, UPDATE, DELETE) ���� �Բ� �����

-- Ʈ������� ���� : 
-- ���� Ʈ������� ����ǰ� ����, ù��° DML ��ɱ����� ����� ��
-- DDL (CREATE, ALTER, DROP) ������ ����� �� : ���� Ʈ������� AUTO COMMIT ��

-- Ʈ������� ���� : 
-- COMMIT (���� �ݿ�), ROLLBACK(��ɱ����� ���) ���� �� Ʈ������� ����.
-- �ڵ� ���� : ���ο� DDL ��� ������ ����� ��

-- DDL ���� : Ʈ����� ����
ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT FK_MGRID; -- ���������� ��Ȱ��ȭ��Ŵ

SAVEPOINT S0;

INSERT INTO DEPARTMENT
VALUES ('40', '��ȹ������', 'A1');
-- Ȯ��
SELECT * FROM DEPARTMENT;

SAVEPOINT S1;

UPDATE EMPLOYEE
SET DEPT_ID = '40'
WHERE DEPT_ID IS NULL;
-- Ȯ��
SELECT * FROM EMPLOYEE
WHERE DEPT_ID = '40';

SAVEPOINT S2;

DELETE FROM EMPLOYEE;
-- Ȯ��
SELECT COUNT(*) FROM EMPLOYEE; -- 0

--ROLLBACK; -- Ʈ����� ���� DML ��ɾ ��� ���.

-- S2 ������ �ѹ�
ROLLBACK TO S2; -- DELETE�� ��ҵ�.
--Ȯ��
SELECT COUNT(*) FROM EMPLOYEE; -- 22

-- S1 ������ �ѹ�
ROLLBACK TO S1; -- UPDATE�� ��ҵ�.
-- Ȯ��
SELECT * FROM EMPLOYEE
WHERE DEPT_ID = '40';

-- S0 ������ �ѹ�
ROLLBACK TO S0;
-- Ȯ��
SELECT * FROM DEPARTMENT;








