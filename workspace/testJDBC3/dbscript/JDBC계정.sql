-- ������ ��������
create user c##jdbc identified by jdbc;
grant connect, resource to c##jdbc;
alter user c##jdbc quota 1024M ON users;

grant create view to c##jdbc;

-- ��� �ڵ� �߻� ������ ����
CREATE SEQUENCE SEQ_EMPID
START WITH 211
INCREMENT BY 1
MAXVALUE 999
NOCYCLE
NOCACHE;

select distinct mgr_id
from employee;

select * from employee
while EMP_NO = 208;