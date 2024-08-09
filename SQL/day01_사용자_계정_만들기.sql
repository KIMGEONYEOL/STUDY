-- day01 : 관리자계정(system/oracle) 에서 일반 사용자계정 관리하기

-- 현재 접속된 사용자의 계정을 볼 때 사용.
show user;
SHOW USER;
sHoW uSeR;

/*
11g 까지는 오라클 설치시 스터디를 위한 계정이 제공이 되었음
scott/tiger, hr/hr => 샘플 테이블과 데이터들이 제공이 됨
18c 부터는 제공이 안 됨.
*/

-- 사용자 계정 만들기
-- create user 아이디명 identified by 암호;
-- 12c 부터는 사용자계정(아이디) 만들 때, 아이디 글자 앞에 반드시 c## 을 붙여야 함.

-- 데이터 베이스는 사용자 계정과 암호 생성 후에 권한을 부여해야 함.
-- 권한 부여 명령 구문 :
-- grant 권한종류1, 권한종류2, ... to 사용자계정;
-- 권한종류 : create session (로그온 권한), create table, insert into, update, delete, select 등등
-- 여러 권한들을 모아놓은 객체를 이용할 수도 있음 : 롤(Role) 이라고 함.
-- 오라클이 제공하는 롤을 이용할 수도 있음 : connect 롤, resource 롤 등
-- 명령 구문 : grant 롤이름1, 롤이름2 ... to 사용자계정;


-- 수업용 계정 만들고, 권한과 테이블 스페이스 할당
create user c##student identified by student;
grant connect, RESOURCE to c##student;
alter user c##student quota 1024M on users;

-- 오라클 12c 까지는 권한(grant)만 부여하면 테이블 생성과 데이터 기록 저장 가능했음.
-- 18c 부터는 권한 부여 후에 테이블 스페이스(table space)를 할당받아야
-- 테이블 생성과 데이터 저장 기록이 가능해졌음.
-- 사용자 정보 변경으로 설정함
-- 명령구문 :
-- alter user 사용자계정 quota 할당받을크기 on users;

-- 사용자 계정 : c##scott, 암호 : tiger
-- 사용자 추가 생성하고, 접속 및 자원 사용 롤(Role)을 이용해서 권한부여
-- 테이블 스페이스 할당함 : 1024M

create user c##scott identified by tiger;
grant connect, RESOURCE to c##scott;
alter user c##scott quota 1024M on users;

/*
여러 줄 
코멘트는 
자바와 
동일한 형식.
과제용 계정 : c##homework, 암호 : homework
권한 부여 : role 을 이용 - connect, resource
테이블 스페이스 할당 : 1024M
*/

create user c##homework identified by homework;
grant connect, RESOURCE to c##homework;
alter user c##homework quota 1024M on users;


-- 사용자 계정 제거하기
-- 사용자 계정에 문제가 있을 시, 제거하고 다시 만들기함.
-- 구문 : drop user 사용자계정 [cascade];

create user c##ttt identified by ttt;

drop user c##ttt;
drop user c##ttt cascade;

-- 데이터베이스 접속시 계정 또는 암호를 오타로 몇 번 에러를 발생시키거나
-- 자바 또는 파이썬의 코드로 SQL 구문을 데이터베이스로 전송해서 실행 요청할 경우
-- SQL 구문 에러가 있을 경우 (몇 번 반복될 경우)
-- 데이터베이스가 해당 사용자 계정을 잠글 수 있음(Lock)
-- 관리자계정에서 잠긴 사용자계정을 Lock 해제 처리해야 함.
-- 구문 : alter user 사용자계정 identifited by 암호  account unlock;

-- 사용자계정 잠그기 (Lock)
alter user c##student identified by student account lock; -- 잠금
alter user c##student identified by student account unlock; -- 해제

-- 암호 변경시 
-- alter user 사용자계정 identified by 바꿀암호;

create user c##ttt identified by ttt;
grant connect to c##ttt;
conn c##ttt/ttt;

alter user c##ttt identified by s123; -- 암호 변경
conn c##ttt/ttt; -- 접속 에러 확인
drop user c##ttt;








