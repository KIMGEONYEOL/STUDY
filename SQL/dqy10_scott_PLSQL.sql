-- C##SCOTT 계정
-- PL/SQL 선택문 연습 (PL/SQL.pdf 12페이지부터 반복문까지 연습)

SET SERVEROUTPUT ON;

/*
IF 조건 THEN
        조건이 참일 때 처리구문;
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
        
        DBMS_OUTPUT.PUT_LINE('사번        이름      부서명');
        DBMS_OUTPUT.PUT_LINE('------------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMPNO||'      '|| VENAME ||'    ' ||VDNAME);
END;
/

/*
IF 조건 THEN
        조건을 만족할 경우 처리구문;
ELSE
        조건을 만족하지 않을 경우 처리구문;
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
        
        DBMS_OUTPUT.PUT_LINE('사번        이름      연봉');
        DBMS_OUTPUT.PUT_LINE('---------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||'  '||VEMP.ENAME||'        '|| ANNSAL);
END;
/

-- 특정 사원이 커미션을 받는지 안 받는지 구분해서 출력

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
                        DBMS_OUTPUT.PUT_LINE('사번' || VEMPNO || '은 '|| VENAME|| '사원이고 커미션을 받지 않습니다.');
            ELSE
                        DBMS_OUTPUT.PUT_LINE('사번' || VEMPNO || '은 '|| VENAME||'사원이고'|| VCOMM ||'을 받습니다.');
            END IF;                
END;
/

/*
IF 조건 1 THEN
        조건 1을 만족할 경우 처리구문 1;
ELSIF 조건2 THEN
        조건 2를 만족할 경우 처리구문 2;
ELSIF 조건3 THEN
        조건 3을 만족할 경우 처리구문 3;
ELSE
        모든 조건을 만족하지 않을 경우 처리구문;
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
            
            DBMS_OUTPUT.PUT_LINE('사번        이름      부서명');
            DBMS_OUTPUT.PUT_LINE('------------------------------');
            DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||'  '|| VEMP.ENAME||'       '||VDNAME);
END;
/

-- 실습 > score 변수에 85를 대입하고, 점수에 대한 학점을 출력하시오.
-- 출력 예 : 당신의 SCORE 는 85 점이고, Grade 는 B 입니다.

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
            
            DBMS_OUTPUT.PUT_LINE('당신의 SCORE 는 ' || score || '점이고,' || 'Grade는 ' || grade || '입니다.');
END;
/


-- CASE 문-------------------------------------
-- JAVA 의 switch 문과 같음.
-- 예제 > 부서번호로 부서명 알아내기
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

-- BASIC LOOP 문
-- 자바의 do ~ while 문과 같은 형태임.
/*
LOOP
        반복 실행시킬 문장;
        ......;
        IF 반복종료조건 THEN
                    EXIT;
        END IF;
        또는
        EXIT [WHEN    반복종료조건];
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

-- FOR LOOP 문
-- FOR LOOP 문에서 카운트용 변수는 자동 선언되므로, 따로 변수 선언할 필요 없음.
-- 카운트 값은 자동으로 1씩 증가함.
-- REVERSE 는 1씩 감소함을 의미함

/*
FOR 카운터용 변수 IN [REVERSE] 시작값..종료값 LOOP
            반복실행할 문장;
            .......;
END LOOP;            
*/

-- 예제) FOR LOOP 문으로 1 부터 5까지 출력하기
DECLARE
BEGIN
FOR N IN 1..5 LOOP
DBMS_OUTPUT.PUT_LINE(N);
END LOOP;
END;
/

-- 실습 1 > 1에서 10 까지 반복하여 TEST1 테이블에 저장되게 하시오.
-- SCOTT 계정에서 TEST1 테이블 생성
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

-- 실습2 구구단의 홀수단만 출력되게 하시오. (for 문과 if 문 혼합)
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

-- WHILE LOOP 문
-- 제어 조건이 TRUE 인 동안만 문장이 반복 실행됨
-- LOOP 를 실행할 때 조건이 처음붜 FALSE 이면 한번도 수행되지 않을 경우도 있음.
/*
WHILE 반복시킬 조건식 LOOP
         반복실행할 문장;
         .........;
END LOOP;         
*/

-- 예제> WHILE LOOP 문으로 1부터 5까지 출력하기
DECLARE
            N NUMBER := 1;
BEGIN
            WHILE N <= 5 LOOP
                      DBMS_OUTPUT.PUT_LINE(N);
                      N := N + 1;
            END LOOP;
END;
/

-- 실습> 구구단 2~9 단에서 결과가 홀수인 것만 출력되게 하시오.
-- (WHILE LOOP 사용)
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











