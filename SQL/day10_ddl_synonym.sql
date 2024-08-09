-- day10_ddl_synonym.sql

-- 동의어(SYNONYM)
-- 다른 사용자계정에 있는 객체에 대한 ALIAS (별칭, 줄임말) 임
-- 여러 사용자가 테이블을 공유할 경우, 다른 사용자가 테이블에 접근할 때 사용자명.테이블명 으로 표기해야 함
-- 이 때 동의어를 적용하면 간단하게 표기할 수 있게 됨.

-- 작성 형식 :
-- CREATE SYNONYM 줄임말 FOR 사용자명.객체명;
-- 예 : 
CREATE SYNONYM EP FOR C##STUDENT.EMPLOYEE; -- 차음 사용시 권한 불충분 ERROR
-- 관리자 계정에서 CREATE SYNONYM 권한을 부여받고 사용해야 함
-- GRANT CREATE SYNONYM TO C##STUDENT; <-- 관리자 계정에서 실행

-- 확인
SELECT * FROM C##STUDENT.EMPLOYEE;
-- 본인 계정 안에서는 사용자명 생략함
SELECT * FROM EMPLOYEE;
-- 동의어 사용
SELECT * FROM EP;

-- 동의어 사용예 :
SELECT * FROM SYS.DUAL;
SELECT * FROM DUAL; 
SELECT * FROM C##SCOTT.EMP; -- 다른 계정의 객체에 접근 (단, 권한 부여가 필요함)

-- 동의어는 모든 사용자가 이용할 수 있는 공개(PUBLIC) 동의어와
-- 개별 사용자가 이용하는 비공개(PRIVATE) 동의어가 있음.
-- 공개 동의어 작성 : 
-- CREATE PUBLIC SYNONYM 동의어별칭 FOR 사용자계정.객체명;

-- SYSTEM 계정에서 --------------------------------

-- 테이블 만들기
DROP TABLE SYSTBL;

CREATE TABLE SYSTBL(
    SNAME VARCHAR2(20)
);

-- 행 추가 (데이터 기록 저장)
INSERT INTO SYSTBL VALUES ('홍길동');
INSERT INTO SYSTBL VALUES ('전우치');

SELECT * FROM SYSTBL;

COMMIT;

-- 객체 권한을 부여함
-- C##STUDENT 에게 SYSTBL 테이블을 SELECT 할 수 있는 권한 부여함
GRANT SELECT ON SYSTBL TO C##STUDENT;

-- C##STUDENT 계정에서 ----------------------------------
-- 관리자 계정에 있는 SYSTBL 테이블을 SELECT 조회 확인
SELECT * FROM SYSTEM.SYSTBL;

-- 동의어 만들기
CREATE SYNONYM STB FOR SYSTEM.SYSTBL;

-- 확인
SELECT * FROM STB;

-- 동의어 제거하기
-- 비공개 동의어 : 해당 사용자계정에서 제거
-- 구문 : DROP SYNONYM 동의어별칭;

-- C##STUDENT 계정에서  ------------------------
DROP SYNONYM EP;
DROP SYNONYM STB;

-- 공개 동의어 : SYSTE M계정(관리자 계정)에서 제거해야함.
-- 구문 : DROP PUBLIC SYNONYM 공개동의어;








