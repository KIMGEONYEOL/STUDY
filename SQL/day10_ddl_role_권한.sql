-- day10_ddl_role_����.sql

-- �����ͺ��̽� ��(ROLE)
-- �����(USER)���� ������ �ϳ��� ������ �ο��ϴ� ���� ���ŷο�.
-- �����ϰ� ������ �ο��� �� �ִ� ������� ROLE �� ������
-- ROLE :
-- ���� ���� ���ѵ��� ���� ���� �����ͺ��̽� ��ü��
-- ����� ���� ������ ���� �����ϰ� ȿ�������� ó���� �� �ְ� ��
-- �ټ��� ����ڿ��� �������� �ʿ��� ���ѵ��� �ѿ� �ϳ��� �׷����� ����ΰ�, ����ڸ��� Ư�� �ѿ� ���� ������ �ο�

-- ����ڿ��� �ο��� ������ �����ϰ��� �� ���� ������ ����ڸ��� ���� �������� �ʰ�
-- �Ѹ� �����ϸ� �ش� �ѷ� ������ �ο����� ����ڵ��� ������ �ڵ� ������

-- ���� Ȱ��ȭ �ϰų� (���� �ο�) ��Ȱ��ȭ �ϰų� (���� ȸ��) �ؼ� �Ͻ������� ���� ���� ������

-- ���� ���� : 
-- ���� ���ǵ� �� (�����Ǵ� ��)
-- ����ڰ� ������ ��(�ʿ��� ������ ���Ƿ� ���� ��)

/*
* ���� ���ǵ� ROLE :
        ����Ŭ ��ġ�� �ý��ۼ� �⺻������ ������
        
        - CONNECT ROLE : 
                ����ڰ� �����ͺ��̽��� ������ �� �ֵ��� �ý��� ���� 8������ ��������
                CREATE SESSION, ALTER SESSION, 
                CREATE TABLE, CREATE VIEW, CREATE SYNONYM,
                CREATE SEQUENCE, CREATE CLUSTER, CREATE DATABASE LINK
        
        - RESOURCE ROLE : 
                ����ڰ� ��ü�� ������ �� �ֵ��� �ϴ� ���ѵ��� �������
                CREATE CLUSTER, CERATE PROCEDURE, CREATE SEQUENCE,
                CREATE TABLE, CREATE TRIGGER
                
        - DBA ROLE :
                ����ڰ� ������ �����ͺ��̽� ��ü�� �����ϰ�
                ����ڰ��� ���� / ���� / ���� �� �� �ִ� ��� ������ ����
                �ý��۱����� �ο��ϴ� ������ ROLE
*/

-- �����ڰ��� (SYSTEM/ORACLE) ���� -----------------------

-- �� ����� ���� ����
CREATE USER C##USER33 IDENTIFIED BY PASS33;

-- ���� �õ��� ERROR : ���� ���� ����
CONNECT C##USER33/PASS33

-- ���� �ο�
GRANT CONNECT TO C##USER33;
GRANT RESOURCE TO C##USER33;
-- �Ǵ�
GRANT CONNECT, RESOURCE TO C##USER33;

-- ����
CONN C##USER33/PASS33

-- ROLE ���� ��ųʸ� : ROLE�� Ȯ���ϱ� ���� ������ ��ųʸ��� ���� ����
SELECT * FROM DICT
WHERE TABLE_NAME LIKE '%ROLE%';

-- ����ڵ鿡�� �ο��� �� Ȯ���ϱ� : USER_ROLE_PRIVS
SELECT * FROM USER_ROLE_PRIVS;

-- ROLE_SYS_PRIVS : ROLE �� �ο��� �ý��� ���� ����
-- ROLE_TAB_PRIVS : ROLE �� �ο��� TABLE ���� ���� ����
-- USER_ROLE_PRIVS : ���� ������(����) ROLE ����
-- USER_TAB_PRIVS_MADE : �ش� ����� ������ ��ü ���� ����
-- USER_TAB_PRIVS_RECD : ����ڿ��� �ο��� ��ü ���� ����
-- USER_COL_PRIV_MADE : �ش� ����� ������ �÷� ��ü ���� ����
-- USER_COL_PRIVIS_RECD : ����ڿ��� �ο��� Ư�� �÷��� ���� ��ü ���� ����

-- ����� ���� �� ����� :
-- CREATE ROLE ������� ������
-- �� ������ �ݵ�� DBA ROLE ������ �ִ� ����ڸ� �� �� ����.
/*
�ۼ����� : 
CREATE ROLE ���̸�;        -- 1. ROLE ����
-- 2. ������ ROLE �� ���� �߰� (�ο�)
GRANT �������� TO ���̸�;
GRANT ��������, ��������, ... TO ���̸�;

-- 3. �� ���
GRANT ���̸� TO ����ڰ���;
*/

-- �����ڰ������� �� ���� : -----------------------------------
-- ����Ŭ 12C ���ʹ� ���� �����տ� C## ���̵��� ���̹� ��Ģ�� ������ ����
-- ���̸����� C## ����

-- 1. �� ��ü ����
CREATE ROLE C##MYROLE;
-- 2. �ѿ� ���� �߰� (���� �ο�)
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO C##MYROLE;
-- 3. �� ���
CREATE USER C##MYMY IDENTIFIED BY PASS;
GRANT C##MYROLE TO C##MYMY;

-- �α��� Ȯ��
CONNECT C##MYMY/PASS
SHOW USER

-- ����ڿ��� �ο��� ���� Ȯ��
SELECT * FROM USER_ROLE_PRIVS;


/*
[����] ----------------------------------------------
        ������ �������� 
        ROLE �̸� : C##MYROLE02
        ROLE �� �ο��� ��ü ���� : C##STUDENT.EMPLOYEE ���̺� ���� SELECT 
        ROLE �ο��� ����� : C##MYMY
        =>SQL PLUS���� Ȯ��
        =>C##MYMY �α����ؼ� EMPLOYEE ���̺� SELECT ���� ��� Ȯ����
        --------------------------------------------------
*/
-- 1. ROLE ����
CREATE ROLE C##MYROLE02;
-- 2. ������ ROLL �� ���� �ο�
GRANT SELECT ON C##STUDENT.EMPLOYEE TO C##MYROLE02;
-- 3. �ش� ROLE�� ����ڿ��� �ο�.
GRANT C##MYROLE02 TO C##MYMY;

-- ���� ȸ�� (ROLE ȸ��) ------------------------------
-- REVOKE ���̸� FROM ����ڰ���;

-- �ý��� �������� �ο��� ���� �ý��� �������� ȸ���ؾ� ��
REVOKE C##MYROLE02 FROM C##MYMY;

-- C##MYMY �������� �ڽſ��� �־��� �� ���� Ȯ�� : SQL PLUS ���� Ȯ��
CONN C##MYMY/PASS
SELECT * FROM USER_ROLE_PRIVS;

-- �� ���� -------------------------
-- DROP ROLE ���̸�;
DROP ROLE C##MYROLE02;
































