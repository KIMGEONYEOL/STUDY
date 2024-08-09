-- day10_PL_SQL.sql

-- PL/SQL
-- SQL 에 절차적 프로그래밍 요소를 추가한 오라클 전용 데이터베이스 프로그래밍 언어

-- PL/SQL 유형 3가지 (결과물)
-- 이름없는 (ANONYMUS) PL/SQL 블럭 => PL/SQL 코드 작성해서 바로 실행 확인용으로 사용함
-- PL/SQL 구문 저장해서 계속 사용 가능함 => 프로시저 (PROCEDURE), 함수 (FUNCTION) 객체로 저장함
-- 프로시저는 리턴 기능 없음, 함수는 리턴 기능 있음

-- 1. PL/SQL 블럭 -----------------------------------------
SHOW SERVEROUTPUT; 
-- 파라매터 변수 상태 확인 : OFF 이면 ON으로 바꿈

SET SERVEROUTPUT ON;
-- PL/SQL 의 출력함수가 작동됨

-- 블랙의 시작
DECLARE
        -- 변수 선언부 : 변수명 자료형;
        BOX CHAR(3);
BEGIN  -- 코드 작성부 시작
        -- SQL 구문을 사용해서 변수에 값 대입, 조건문, 반복문 등 사용
        SELECT EMP_ID
        INTO BOX        -- BOX = EMP_ID 대입
        FROM EMPLOYEE
        WHERE EMP_NAME = '한선기';
        
        -- 출력 확인
        DBMS_OUTPUT.PUT_LINE(BOX);
        
END;  -- 블럭의 끝
/      
-- 바로 실행함

-- 실습 :
-- '강증훈' 의 사번과 이름을 조회해서 변수에 저장하고 변수값 출력
-- 변수 : 사번(VEMPID), 이름(VENAME) 선언하고 사용
CREATE TABLE EMPCPY
AS
SELECT EMP_ID, EMP_NAME, DEPT_ID
FROM EMPLOYEE;

-- PL/SQL 블럭 작성 :
DECLARE
        --VEMPID CHAR(3);
        --VENAME VARCHAR2(20);
        VEMPID EMPCPY.EMP_ID%TYPE;
        VENAME EMPCPY.EMP_NAME%TYPE;
BEGIN
        SELECT EMP_ID, EMP_NAME
        INTO VEMPID, VENAME
        FROM EMPCPY
       -- 직원 이름을 입력받아서 사용 : '&메세지'
        WHERE EMP_NAME = '&이름';
        
        SYS.DBMS_OUTPUT.PUT_LINE('사번    이름');
        DBMS_OUTPUT.PUT_LINE('---------------------------------');
        DBMS_OUTPUT.PUT_LINE(VEMPID || '    ' || VENAME);
END;
/

-- 실습 : 
-- 사번을 입력받아서 ('&사번') 해당 사번의 직원 정보를 출력하는 PL/SQL 블럭 작성하기
-- 사번, 이름, 급여, 입사일 조회
-- 변수 선언 : 자료형은 컬럼의 자료형에 맞춤
-- 조회한 결과를 변수에 저장해서 변수값들을 출력
DECLARE
    VEMPID EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
    VSAL EMPLOYEE.SALARY%TYPE;
    VHIREDATE EMPLOYEE.HIRE_DATE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    INTO VEMPID, VENAME, VSAL, VHIREDATE
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    SYS.DBMS_OUTPUT.PUT_LINE('사번    이름     급여           입사일');
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
    DBMS_OUTPUT.PUT_LINE(VEMPID||'   '||VENAME||'     '||VSAL||'        '||VHIREDATE);
END;
/

-- 실습 : 조건문 사용
-- IF 조건 THEN 참 처리내용 ELSE 거짓 처리내용 END IF;
-- 직원의 이름을 입력받아, 해당 직원의 연봉을 구하는 PL/SQL 블럭 작성하시오.
SET SERVEROUTPUT ON;

DECLARE
        VEMP EMPLOYEE%ROWTYPE;   -- 행 참조변수 (한 행을 참조함)
        ANNSAL NUMBER(15, 2);
BEGIN
        SELECT * 
        INTO VEMP
        FROM EMPLOYEE
        WHERE EMP_NAME = '&이름';
        
        IF (VEMP.BONUS_PCT IS NULL) THEN
            ANNSAL := VEMP.SALARY * 12;
        ELSE
            ANNSAL := (VEMP.SALARY + (VEMP.SALARY * VEMP.BONUS_PCT)) * 12;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('사번    이름  연봉');
        DBMS_OUTPUT.PUT_LINE('--------------------');
        DBMS_OUTPUT.PUT_LINE(VEMP.EMP_ID || '   ' || VEMP.EMP_NAME || '   ' || ANNSAL);
END;
/

-- 실습 : IF 조건 THEN 참 ELSE 거짓 END IF;
-- 사번을 입력받아 해당 직원의 전체 정보를 조회해서 소속 부서코드를 이용해서 부서명을 조회
-- 사번, 이름, 부서코드, 부서명 출력 처리
-- 해당 직원의 부서코드가 NULL이면 '소속부서 없음' 출력되게 함
-- 행 참조변수 사용함
DECLARE
        VEMP EMPLOYEE%ROWTYPE;
        DEPTID VARCHAR2(20);
BEGIN
        SELECT *
        INTO VEMP
        FROM EMPLOYEE LEFT JOIN DEPARTMENT USING (DEPT_ID)
        WHERE EMP_ID = '&사번';
        
        IF (VEMP.DEPT_ID IS NULL) THEN 
            DEPTID := '소속부서 없음';
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
        WHERE EMP_ID = '&사번';
        
        IF VEMP.DEPT_ID IS NULL THEN
            VDNAME := '소속부서 없음';
        ELSE
            SELECT DEPT_NAME
            INTO VDNAME
            FROM DEPARTMENT
            WHERE DEPT_ID = VEMP.DEPT_ID;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(VEMP.EMP_ID || ', ' || VEMP.EMP_NAME || ', ' || VEMP.DEPT_ID || ', ' || VDNAME);
END;
/








