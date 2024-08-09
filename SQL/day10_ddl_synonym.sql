-- day10_ddl_synonym.sql

-- ���Ǿ�(SYNONYM)
-- �ٸ� ����ڰ����� �ִ� ��ü�� ���� ALIAS (��Ī, ���Ӹ�) ��
-- ���� ����ڰ� ���̺��� ������ ���, �ٸ� ����ڰ� ���̺� ������ �� ����ڸ�.���̺�� ���� ǥ���ؾ� ��
-- �� �� ���Ǿ �����ϸ� �����ϰ� ǥ���� �� �ְ� ��.

-- �ۼ� ���� :
-- CREATE SYNONYM ���Ӹ� FOR ����ڸ�.��ü��;
-- �� : 
CREATE SYNONYM EP FOR C##STUDENT.EMPLOYEE; -- ���� ���� ���� ����� ERROR
-- ������ �������� CREATE SYNONYM ������ �ο��ް� ����ؾ� ��
-- GRANT CREATE SYNONYM TO C##STUDENT; <-- ������ �������� ����

-- Ȯ��
SELECT * FROM C##STUDENT.EMPLOYEE;
-- ���� ���� �ȿ����� ����ڸ� ������
SELECT * FROM EMPLOYEE;
-- ���Ǿ� ���
SELECT * FROM EP;

-- ���Ǿ� ��뿹 :
SELECT * FROM SYS.DUAL;
SELECT * FROM DUAL; 
SELECT * FROM C##SCOTT.EMP; -- �ٸ� ������ ��ü�� ���� (��, ���� �ο��� �ʿ���)

-- ���Ǿ�� ��� ����ڰ� �̿��� �� �ִ� ����(PUBLIC) ���Ǿ��
-- ���� ����ڰ� �̿��ϴ� �����(PRIVATE) ���Ǿ ����.
-- ���� ���Ǿ� �ۼ� : 
-- CREATE PUBLIC SYNONYM ���ǾĪ FOR ����ڰ���.��ü��;

-- SYSTEM �������� --------------------------------

-- ���̺� �����
DROP TABLE SYSTBL;

CREATE TABLE SYSTBL(
    SNAME VARCHAR2(20)
);

-- �� �߰� (������ ��� ����)
INSERT INTO SYSTBL VALUES ('ȫ�浿');
INSERT INTO SYSTBL VALUES ('����ġ');

SELECT * FROM SYSTBL;

COMMIT;

-- ��ü ������ �ο���
-- C##STUDENT ���� SYSTBL ���̺��� SELECT �� �� �ִ� ���� �ο���
GRANT SELECT ON SYSTBL TO C##STUDENT;

-- C##STUDENT �������� ----------------------------------
-- ������ ������ �ִ� SYSTBL ���̺��� SELECT ��ȸ Ȯ��
SELECT * FROM SYSTEM.SYSTBL;

-- ���Ǿ� �����
CREATE SYNONYM STB FOR SYSTEM.SYSTBL;

-- Ȯ��
SELECT * FROM STB;

-- ���Ǿ� �����ϱ�
-- ����� ���Ǿ� : �ش� ����ڰ������� ����
-- ���� : DROP SYNONYM ���ǾĪ;

-- C##STUDENT ��������  ------------------------
DROP SYNONYM EP;
DROP SYNONYM STB;

-- ���� ���Ǿ� : SYSTE M����(������ ����)���� �����ؾ���.
-- ���� : DROP PUBLIC SYNONYM �������Ǿ�;








