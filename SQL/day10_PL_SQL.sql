-- day10_PL_SQL.sql

-- PL/SQL
-- SQL �� ������ ���α׷��� ��Ҹ� �߰��� ����Ŭ ���� �����ͺ��̽� ���α׷��� ���

-- PL/SQL ���� 3���� (�����)
-- �̸����� (ANONYMUS) PL/SQL �� => PL/SQL �ڵ� �ۼ��ؼ� �ٷ� ���� Ȯ�ο����� �����
-- PL/SQL ���� �����ؼ� ��� ��� ������ => ���ν��� (PROCEDURE), �Լ� (FUNCTION) ��ü�� ������
-- ���ν����� ���� ��� ����, �Լ��� ���� ��� ����

-- 1. PL/SQL �� -----------------------------------------
SHOW SERVEROUTPUT; 
-- �Ķ���� ���� ���� Ȯ�� : OFF �̸� ON���� �ٲ�

SET SERVEROUTPUT ON;
-- PL/SQL �� ����Լ��� �۵���

-- ���� ����
DECLARE
        -- ���� ����� : ������ �ڷ���;
        BOX CHAR(3);
BEGIN  -- �ڵ� �ۼ��� ����
        -- SQL ������ ����ؼ� ������ �� ����, ���ǹ�, �ݺ��� �� ���
        SELECT EMP_ID
        INTO BOX        -- BOX = EMP_ID ����
        FROM EMPLOYEE
        WHERE EMP_NAME = '�Ѽ���';
        
        -- ��� Ȯ��
        DBMS_OUTPUT.PUT_LINE(BOX);
        
END;  -- ���� ��
/      
-- �ٷ� ������

-- �ǽ� :
-- '������' �� ����� �̸��� ��ȸ�ؼ� ������ �����ϰ� ������ ���
-- ���� : ���(VEMPID), �̸�(VENAME) �����ϰ� ���
CREATE TABLE EMPCPY
AS
SELECT EMP_ID, EMP_NAME, DEPT_ID
FROM EMPLOYEE;

-- PL/SQL �� �ۼ� :
DECLARE
        --VEMPID CHAR(3);
        --VENAME VARCHAR2(20);
        VEMPID EMPCPY.EMP_ID%TYPE;
        VENAME EMPCPY.EMP_NAME%TYPE;
BEGIN
        SELECT EMP_ID, EMP_NAME
        INTO VEMPID, VENAME
        FROM EMPCPY
       -- ���� �̸��� �Է¹޾Ƽ� ��� : '&�޼���'
        WHERE EMP_NAME = '&�̸�';
        
        SYS.DBMS_OUTPUT.PUT_LINE('���    �̸�');
        DBMS_OUTPUT.PUT_LINE('---------------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMPID || '    ' || VENAME);
END;
/

-- �ǽ� : 
-- ����� �Է¹޾Ƽ� ('&���') �ش� ����� ���� ������ ����ϴ� PL/SQL �� �ۼ��ϱ�
-- ���, �̸�, �޿�, �Ի��� ��ȸ
-- ���� ���� : �ڷ����� �÷��� �ڷ����� ����
-- ��ȸ�� ����� ������ �����ؼ� ���������� ���
DECLARE
    VEMPID EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
    VSAL EMPLOYEE.SALARY%TYPE;
    VHIREDATE EMPLOYEE.HIRE_DATE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    INTO VEMPID, VENAME, VSAL, VHIREDATE
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    SYS.DBMS_OUTPUT.PUT_LINE('���    �̸�     �޿�           �Ի���');
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
    DBMS_OUTPUT.PUT_LINE(VEMPID||'   '||VENAME||'     '||VSAL||'        '||VHIREDATE);
END;
/

-- �ǽ� : ���ǹ� ���
-- IF ���� THEN �� ó������ ELSE ���� ó������ END IF;
-- ������ �̸��� �Է¹޾�, �ش� ������ ������ ���ϴ� PL/SQL �� �ۼ��Ͻÿ�.
SET SERVEROUTPUT ON;

DECLARE
        VEMP EMPLOYEE%ROWTYPE;   -- �� �������� (�� ���� ������)
        ANNSAL NUMBER(15, 2);
BEGIN
        SELECT * 
        INTO VEMP
        FROM EMPLOYEE
        WHERE EMP_NAME = '&�̸�';
        
        IF (VEMP.BONUS_PCT IS NULL) THEN
            ANNSAL := VEMP.SALARY * 12;
        ELSE
            ANNSAL := (VEMP.SALARY + (VEMP.SALARY * VEMP.BONUS_PCT)) * 12;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('���    �̸�  ����');
        DBMS_OUTPUT.PUT_LINE('--------------------');
        DBMS_OUTPUT.PUT_LINE(VEMP.EMP_ID || '   ' || VEMP.EMP_NAME || '   ' || ANNSAL);
END;
/

-- �ǽ� : IF ���� THEN �� ELSE ���� END IF;
-- ����� �Է¹޾� �ش� ������ ��ü ������ ��ȸ�ؼ� �Ҽ� �μ��ڵ带 �̿��ؼ� �μ����� ��ȸ
-- ���, �̸�, �μ��ڵ�, �μ��� ��� ó��
-- �ش� ������ �μ��ڵ尡 NULL�̸� '�ҼӺμ� ����' ��µǰ� ��
-- �� �������� �����
DECLARE
        VEMP EMPLOYEE%ROWTYPE;
        DEPTID VARCHAR2(20);
BEGIN
        SELECT *
        INTO VEMP
        FROM EMPLOYEE LEFT JOIN DEPARTMENT USING (DEPT_ID)
        WHERE EMP_ID = '&���';
        
        IF (VEMP.DEPT_ID IS NULL) THEN 
            DEPTID := '�ҼӺμ� ����';
        ELSE
            DEPTID := DEPARTMENT.DEPT_ID;
            
            DBMS_OUTPUT.PUT_LINE(VEMP.EMP_ID || '   ' || VEMP;
END;
/

DECLARE
        VEMP EMPLOYEE%ROWTYPE;
        VDNAME DEPARTMENT.DEPT_NAME%TYPE;
BEGIN
        SELECT *
        INTO VEMP
        FROM EMPLOYEE
        WHERE EMP_ID = '&���';
        
        IF VEMP.DEPT_ID IS NULL THEN
            VDNAME := '�ҼӺμ� ����';
        ELSE
            SELECT DEPT_NAME
            INTO VDNAME
            FROM DEPARTMENT
            WHERE DEPT_ID = VEMP.DEPT_ID;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(VEMP.EMP_ID || ', ' || VEMP.EMP_NAME || ', ' || VEMP.DEPT_ID || ', ' || VDNAME);
END;
/








