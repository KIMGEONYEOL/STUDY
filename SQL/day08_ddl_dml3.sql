-- day08_ddl_dml03.sql

-- DDL (데이터 정의어) 
-- 데이터베이스 객체를 생성(CREATE), 변경(ALTER), 제거(DROP)에 사용하는 구문

-- 테이블 수정 ------------------------------------------
-- 컬럼 추가/삭제, 자료형 변경, 기본값(DEFAULT) 변경
-- 제약조건 추가/삭제 
-- 이름 변경 : 테이블, 컬럼, 제약조건

-- 컬럼 추가
-- 테이블 만들 때 컬럼 설정과 동일하게 작성하면 됨
SELECT * FROM DCOPY;

ALTER TABLE DCOPY 
ADD ( LNAME VARCHAR2(40) );

-- 컬럼 추가 확인
DESC DCOPY;

ALTER TABLE DCOPY
ADD ( CNAME VARCHAR2(30) DEFAULT '한국' );

-- 제약조건 추가
-- 복사본 테이블 만들기
CREATE TABLE EMP2
AS
SELECT * FROM EMPLOYEE;

ALTER TABLE EMP2
ADD PRIMARY KEY (EMP_ID); -- 제약조건 이름 자동 부여됨 : SYS_C.......

-- 제약조건 추가 확인 : 제약조건 관련 딕셔너리 이용
SELECT * 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP2';

-- NOT NULL 은 ADD 로 추가하는 것이 아니라, NULL 에서 NOT NULL 로 변경하는 것임
ALTER TABLE EMP2
ADD NOT NULL (HIRE_DATE); -- ERROR

ALTER TABLE EMP2
MODIFY( HIRE_DATE NOT NULL );

ALTER TABLE EMP2
MODIFY( HIRE_DATE NULL );

-- 컬럼 자료형 변경
CREATE TABLE EMP4
AS
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE;

-- 테이블 구조 확인
DESC EMP4;
-- 기록된 데이터 확인
SELECT * FROM EMP4;

ALTER TABLE EMP4
MODIFY ( EMP_ID VARCHAR2(20)
            , EMP_NAME CHAR(20) ); -- 문자형 (CHAR <=> VARCHAR2) 끼리는 변경할 수 있음.
            -- 크기는 같거나 증가시킬 수 있음 (줄일 수는 없음 => ERROR)

-- DEFAULT 값 변경
CREATE TABLE EMP5(
    EMP_ID CHAR(3)
   ,EMP_NAME VARCHAR(20)
   ,ADDR1 VARCHAR2(20) DEFAULT '서울'
   ,ADDR2 VARCHAR2(100));

-- 데이터 기록(저장)
INSERT INTO EMP5
VALUES ('A10' , '임태희', DEFAULT, '청담동');
INSERT INTO EMP5
VALUES ('B10', '이병언', DEFAULT, '분당 정자동');

 SELECT * FROM EMP5;

ALTER TABLE EMP5
MODIFY ( ADDR1 DEFAULT '경기' );

-- DEFAULT 값 변경 이후에는 DEFALUT 사용시 바뀐 값 사용됨. -> 변경 이후 사용부터 적용.
INSERT INTO EMP5
VALUES ('C10', '임승우', DEFAULT, '분당 효자촌');

 SELECT * FROM EMP5;

-- 컬럼 삭제
ALTER TABLE DCOPY
DROP COLUMN CNAME; -- 컬럼 1개만 삭제함

DESC DCOPY;
ROLLBACK; -- 컬럼 삭제는 복구할 수 없음

ALTER TABLE DCOPY
DROP ( LOC_ID, LNAME ); -- 컬럼 여러 개 삭제

SELECT * FROM DCOPY; -- 데이터도 함께 삭제

-- 테이블의 컬럼은 모두 삭제할 수 없음.
-- 테이블은 최소 한 개의 컬럼은 있어야 함 => 컬럼 없는 빈 테이블은 존재할 수 없음.
CREATE TABLE TTT(); -- ERROR

ALTER TABLE DCOPY
DROP ( DID, DNAME ); -- ERROR 테이블의 모든 컬럼을 삭제 할 수 없음.

-- 외래키 (FOREIGN KEY) 제약조건으로 참조되는 컬럼(부모키)도 삭제 못 함
ALTER TABLE DEPARTMENT
--DROP ( DEPT_ID ); -- ERROR 
DROP (DEPT_ID) CASCADE CONSTRAINTS; -- OK : 컬럼에 설정된 제약조건들도 함께 삭제되게 하면 가능함.

DESC DEPARTMENT;

-- 약조건이 설정된 컬럼은 컬럼만 따로 삭제 할 수 없음 => 컬럼의 제약조건도 같이 삭제해야함.
CREATE TABLE TB1 (
        PK NUMBER PRIMARY KEY
        , FK NUMBER REFERENCES TB1
        , COL1 NUMBER
        -- 테이블레벨
        , CHECK ( PK > 0 AND COL1 > 0 )
); 
DESC TB1;

ALTER TABLE TB1
DROP (PK); -- ERROR 

ALTER  TABLE TB1
DROP (COL1); -- ERROR

-- 제약조건도 함께 삭제하면 됨 : CASCADE CONSTRAINTS
ALTER TABLE TB1
DROP (PK) CASCADE CONSTRAINTS; -- OK

ALTER TABLE TB1
DROP (COL1) CASCADE CONSTRAINTS; -- OK

DESC TB1;

-- 제약조건 삭제
-- 제약조건 저장한 딕셔너리에서 정보 확인
SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONSTRAINT_EMP';

-- 제약조건 1개 삭제
ALTER TABLE CONSTRAINT_EMP
DROP CONSTRAINT CHK;

-- 제약조건 여러 개 삭제
ALTER TABLE CONSTRAINT_EMP
DROP CONSTRAINT FKMID
DROP CONSTRAINT NENAME
DROP CONSTRAINT UEMAIL;

-- 제약조건 종류로 삭제
ALTER TABLE CONSTRAINT_EMP
DROP PRIMARY KEY;

ALTER TABLE CONSTRAINT_EMP
DROP UNIQUE (ENO);

-- NOT NULL 제약조건 삭제는 저장된 이름 삭제 또는 NULL 로 변경하는 방법이 있음
ALTER TABLE CONSTRAINT_EMP
--DROP CONSTRAINT NENO;
MODIFY (ENO NULL);

-- 테이블의 컬럼을 관리하는 데이터 딕셔너리 : USER_TAB_COLS
SELECT * FROM USER_TAB_COLS;
DESC USER_TAB_COLS;

-- 컬럼별 제약조건을 관리하는 데이터 딕셔너리 : USER_CONS_COLUMNS
CREATE TABLE TB_EXAM (
        COL1 CHAR(3) PRIMARY KEY
        , ENAME VARCHAR(20)
        , FOREIGN KEY (COL1) REFERENCES EMPLOYEE -- 기본키가 참조컬럼이 됨 (PRIMARY KEY)
);

-- 딕셔너리로 확인
SELECT CONSTRAINT_NAME 이름, 
          CONSTRAINT_TYPE 유형,
          COLUMN_NAME 컬럼,
          R_CONSTRAINT_NAME 참조,
          DELETE_RULE 삭제규칙
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'TB_EXAM';

-- 이름 바꾸기 ---------------------------------------------
-- 테이블명, 컬럼명, 제약조건 이름
DESC TB_EXAM;

-- 컬럼명 바꾸기
ALTER TABLE TB_EXAM
RENAME COLUMN COL1  TO EMPID;

-- 제약조건 이름 바꾸기
SELECT CONSTRAINT_NAME, COLUMN_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'TB_EXAM';

ALTER TABLE TB_EXAM
RENAME CONSTRAINT SYS_C007637 TO PK_EID;

ALTER TABLE TB_EXAM
RENAME CONSTRAINT SYS_C007638 TO FK_EID;

-- 테이블명 바꾸기
ALTER TABLE TB_EXAM RENAME TO TB_SAMPLE1;
-- 또는
RENAME TB_SAMPLE1 TO TB_SAMPLE;

-- 테이블 제거하기 ----------------------------------------------
-- DROP TABLE 테이블명 [CASCADE CONSTRAINTS];

CREATE TABLE DEPT (
        DID CHAR(2) PRIMARY KEY
        , DNAME VARCHAR2(10)
);

CREATE TABLE EMP6 (
        EID CHAR(3) PRIMARY KEY
        , ENAME VARCHAR2(10)
        , DID CHAR(2) REFERENCES DEPT 
);

-- 참조되는 테이블 (부모 테이블)은 삭제 못 함
DROP TABLE DEPT; -- ERROR  
DROP TABLE DEPT CASCADE CONSTRAINTS;
-- DEPT 에 대한 REFERENCES 제약조건도 함께 삭제됨















