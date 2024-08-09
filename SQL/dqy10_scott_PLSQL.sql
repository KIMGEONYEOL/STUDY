-- C##SCOTT ����
-- PL/SQL ���ù� ���� (PL/SQL.pdf 12���������� �ݺ������� ����)

SET SERVEROUTPUT ON;

/*
IF ���� THEN
        ������ ���� �� ó������;
END IF;        
*/

DECLARE
        VEMPNO EMP.EMPNO%TYPE;
        VENAME EMP.ENAME%TYPE;
        VDEPTNO EMP.DEPTNO%TYPE;
        VDNAME VARCHAR2(20) := NULL;
BEGIN
        SELECT EMPNO, ENAME, DEPTNO
        INTO VEMPNO, VENAME, VDEPTNO
        FROM EMP
        WHERE EMPNO = &EMPNO;
        
        IF (VDEPTNO = 10) THEN
                    VDNAME := 'ACCOUNTING';
        END IF;
        IF (VDEPTNO = 20) THEN
                    VDNAME := 'RESEARCH';
        END IF;
        IF (VDEPTNO = 30) THEN
                    VDNAME := 'SALES';
        END IF;
        IF (VDEPTNO = 40) THEN
                    VDNAME := 'OPERATIONS';
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('���        �̸�      �μ���');
        DBMS_OUTPUT.PUT_LINE('------------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMPNO||'      '|| VENAME ||'    ' ||VDNAME);
END;
/

/*
IF ���� THEN
        ������ ������ ��� ó������;
ELSE
        ������ �������� ���� ��� ó������;
END IF;        
*/
DECLARE
        VEMP EMP%ROWTYPE;
        ANNSAL NUMBER(7,2);
BEGIN
        SELECT * INTO VEMP
        FROM EMP
        WHERE ENAME = '&ENAME';
        
        IF (VEMP.COMM IS NULL) THEN
                    ANNSAL := VEMP.SAL * 12;
        ELSE
                    ANNSAL := VEMP.SAL * 12 + VEMP.COMM;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('���        �̸�      ����');
        DBMS_OUTPUT.PUT_LINE('---------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||'  '||VEMP.ENAME||'        '|| ANNSAL);
END;
/

-- Ư�� ����� Ŀ�̼��� �޴��� �� �޴��� �����ؼ� ���

DECLARE
            VEMPNO EMP.EMPNO%TYPE;
            VCOMM EMP.COMM%TYPE;
            VENAME EMP.ENAME%TYPE;
BEGIN
            SELECT EMPNO, ENAME, COMM
            INTO VEMPNO, VENAME, VCOMM
            FROM EMP
            WHERE EMPNO = &EMPNO;
            
            IF (VCOMM IS NULL OR VCOMM = 0) THEN
                        DBMS_OUTPUT.PUT_LINE('���' || VEMPNO || '�� '|| VENAME|| '����̰� Ŀ�̼��� ���� �ʽ��ϴ�.');
            ELSE
                        DBMS_OUTPUT.PUT_LINE('���' || VEMPNO || '�� '|| VENAME||'����̰�'|| VCOMM ||'�� �޽��ϴ�.');
            END IF;                
END;
/

/*
IF ���� 1 THEN
        ���� 1�� ������ ��� ó������ 1;
ELSIF ����2 THEN
        ���� 2�� ������ ��� ó������ 2;
ELSIF ����3 THEN
        ���� 3�� ������ ��� ó������ 3;
ELSE
        ��� ������ �������� ���� ��� ó������;
END IF;        
*/
DECLARE
            VEMP EMP%ROWTYPE;
            VDNAME VARCHAR2(14);
BEGIN
            SELECT * INTO VEMP
            FROM EMP
            WHERE ENAME = '&ENAME';
            
            IF (VEMP.DEPTNO = 10) THEN
                        VDNAME := 'ACCOUNTING';
            ELSIF (VEMP.DEPTNO = 20) THEN
                        VDNAME := 'RESEARCH';
            ELSIF (VEMP.DEPTNO = 30) THEN
                        VDNAME := 'SALES';
            ELSIF (VEMP.DEPTNO = 40) THEN
                        VDNAME := 'OPERATIONS';
            END IF;            
            
            DBMS_OUTPUT.PUT_LINE('���        �̸�      �μ���');
            DBMS_OUTPUT.PUT_LINE('------------------------------');
            DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||'  '|| VEMP.ENAME||'       '||VDNAME);
END;
/

-- �ǽ� > score ������ 85�� �����ϰ�, ������ ���� ������ ����Ͻÿ�.
-- ��� �� : ����� SCORE �� 85 ���̰�, Grade �� B �Դϴ�.

DECLARE
            score int;
            grade varchar2(2);    
BEGIN
            score := &score;
            
            IF score >=90 THEN
                        GRADE := 'A';
            ELSIF score >=80 THEN
                        GRADE := 'B';
            ELSIF score >=70 THEN
                        GRADE := 'C';
            ELSIF score >=60 THEN
                        GRADE := 'D';            
            ELSE grade := 'F';
            END IF;
            
            DBMS_OUTPUT.PUT_LINE('����� SCORE �� ' || score || '���̰�,' || 'Grade�� ' || grade || '�Դϴ�.');
END;
/


-- CASE ��-------------------------------------
-- JAVA �� switch ���� ����.
-- ���� > �μ���ȣ�� �μ��� �˾Ƴ���
DECLARE
            vempno EMP.EMPNO%TYPE;
            vename EMP.ENAME%TYPE;
            vdeptno EMp.DEPTNO%TYPE;
            vdname VARCHAR2(20) := null;
BEGIN
            SELECT EMPNO, ENAME, DEPTNO
            INTO vempno, vename, vdeptno
            FROM EMP
            WHERE EMPNO= &EMPNO;
            
            vdname := CASE vdeptno
                                WHEN 10 THEN 'ACCOUNT'
                                WHEN 20 THEN 'RESEARCH'
                                WHEN 30 THEN 'SALES'
                                WHEN 40 THEN 'OPERATIONS'
                            END;
                    DBMS_OUTPUT.PUT_LINE (VEMPNO ||'  '|| VENAME ||' '||VDEPTNO||' '||VDNAME);        
END;
/

-- BASIC LOOP ��
-- �ڹ��� do ~ while ���� ���� ������.
/*
LOOP
        �ݺ� �����ų ����;
        ......;
        IF �ݺ��������� THEN
                    EXIT;
        END IF;
        �Ǵ�
        EXIT [WHEN    �ݺ���������];
END LOOP;        
*/

 DECLARE
            N NUMBER := 1;
 BEGIN
            LOOP
                    DBMS_OUTPUT.PUT_LINE(N);
                    N:=N+1;
                    IF N>5 THEN
                            EXIT;
                    END IF;
            END LOOP;                        
 END;
 /

-- FOR LOOP ��
-- FOR LOOP ������ ī��Ʈ�� ������ �ڵ� ����ǹǷ�, ���� ���� ������ �ʿ� ����.
-- ī��Ʈ ���� �ڵ����� 1�� ������.
-- REVERSE �� 1�� �������� �ǹ���

/*
FOR ī���Ϳ� ���� IN [REVERSE] ���۰�..���ᰪ LOOP
            �ݺ������� ����;
            .......;
END LOOP;            
*/

-- ����) FOR LOOP ������ 1 ���� 5���� ����ϱ�
DECLARE
BEGIN
FOR N IN 1..5 LOOP
DBMS_OUTPUT.PUT_LINE(N);
END LOOP;
END;
/

-- �ǽ� 1 > 1���� 10 ���� �ݺ��Ͽ� TEST1 ���̺� ����ǰ� �Ͻÿ�.
-- SCOTT �������� TEST1 ���̺� ����
-- SQL> create table test1(bunho number(3), irum varchar2(10));
CREATE TABLE test1(
        bunho number(3)
        ,irum varchar2(10)
);

DECLARE
BEGIN
FOR i IN 1..10 LOOP
INSERT INTO TEST1 VALUES(i, SYSDATE);
END LOOP;
END;
/

SELECT * FROM test1;

-- �ǽ�2 �������� Ȧ���ܸ� ��µǰ� �Ͻÿ�. (for ���� if �� ȥ��)
DECLARE
    RESULT NUMBER;
BEGIN
    FOR DAN IN 2..9 LOOP
        IF MOD(DAN, 2) = 1 THEN
            FOR N IN 1..9 LOOP
                RESULT := DAN * N;
                DBMS_OUTPUT.PUT_LINE(DAN||' * '||N||' = '||RESULT);
            END LOOP;
            DBMS_OUTPUT.PUT_LINE(' ');
        END IF;
    END LOOP;    
END;
/

-- WHILE LOOP ��
-- ���� ������ TRUE �� ���ȸ� ������ �ݺ� �����
-- LOOP �� ������ �� ������ ó���� FALSE �̸� �ѹ��� ������� ���� ��쵵 ����.
/*
WHILE �ݺ���ų ���ǽ� LOOP
         �ݺ������� ����;
         .........;
END LOOP;         
*/

-- ����> WHILE LOOP ������ 1���� 5���� ����ϱ�
DECLARE
            N NUMBER := 1;
BEGIN
            WHILE N <= 5 LOOP
                      DBMS_OUTPUT.PUT_LINE(N);
                      N := N + 1;
            END LOOP;
END;
/

-- �ǽ�> ������ 2~9 �ܿ��� ����� Ȧ���� �͸� ��µǰ� �Ͻÿ�.
-- (WHILE LOOP ���)
DECLARE
    RESULT NUMBER;
    DAN NUMBER := 2;
    SU NUMBER;
BEGIN
    WHILE DAN <= 9 LOOP
    SU:= 1;
    WHILE SU <= 9 LOOP
    RESULT := DAN * SU;
    IF MOD(RESULT, 2) = 1 THEN
        DBMS_OUTPUT.PUT_LINE(DAN||' * '||SU||' = '|| RESULT);
    END IF;
    SU := SU + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(' ');
    DAN := DAN + 1;
END LOOP;    
END;
/

COMMIT;











