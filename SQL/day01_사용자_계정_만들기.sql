-- day01 : �����ڰ���(system/oracle) ���� �Ϲ� ����ڰ��� �����ϱ�

-- ���� ���ӵ� ������� ������ �� �� ���.
show user;
SHOW USER;
sHoW uSeR;

/*
11g ������ ����Ŭ ��ġ�� ���͵� ���� ������ ������ �Ǿ���
scott/tiger, hr/hr => ���� ���̺�� �����͵��� ������ ��
18c ���ʹ� ������ �� ��.
*/

-- ����� ���� �����
-- create user ���̵�� identified by ��ȣ;
-- 12c ���ʹ� ����ڰ���(���̵�) ���� ��, ���̵� ���� �տ� �ݵ�� c## �� �ٿ��� ��.

-- ������ ���̽��� ����� ������ ��ȣ ���� �Ŀ� ������ �ο��ؾ� ��.
-- ���� �ο� ��� ���� :
-- grant ��������1, ��������2, ... to ����ڰ���;
-- �������� : create session (�α׿� ����), create table, insert into, update, delete, select ���
-- ���� ���ѵ��� ��Ƴ��� ��ü�� �̿��� ���� ���� : ��(Role) �̶�� ��.
-- ����Ŭ�� �����ϴ� ���� �̿��� ���� ���� : connect ��, resource �� ��
-- ��� ���� : grant ���̸�1, ���̸�2 ... to ����ڰ���;


-- ������ ���� �����, ���Ѱ� ���̺� �����̽� �Ҵ�
create user c##student identified by student;
grant connect, RESOURCE to c##student;
alter user c##student quota 1024M on users;

-- ����Ŭ 12c ������ ����(grant)�� �ο��ϸ� ���̺� ������ ������ ��� ���� ��������.
-- 18c ���ʹ� ���� �ο� �Ŀ� ���̺� �����̽�(table space)�� �Ҵ�޾ƾ�
-- ���̺� ������ ������ ���� ����� ����������.
-- ����� ���� �������� ������
-- ��ɱ��� :
-- alter user ����ڰ��� quota �Ҵ����ũ�� on users;

-- ����� ���� : c##scott, ��ȣ : tiger
-- ����� �߰� �����ϰ�, ���� �� �ڿ� ��� ��(Role)�� �̿��ؼ� ���Ѻο�
-- ���̺� �����̽� �Ҵ��� : 1024M

create user c##scott identified by tiger;
grant connect, RESOURCE to c##scott;
alter user c##scott quota 1024M on users;

/*
���� �� 
�ڸ�Ʈ�� 
�ڹٿ� 
������ ����.
������ ���� : c##homework, ��ȣ : homework
���� �ο� : role �� �̿� - connect, resource
���̺� �����̽� �Ҵ� : 1024M
*/

create user c##homework identified by homework;
grant connect, RESOURCE to c##homework;
alter user c##homework quota 1024M on users;


-- ����� ���� �����ϱ�
-- ����� ������ ������ ���� ��, �����ϰ� �ٽ� �������.
-- ���� : drop user ����ڰ��� [cascade];

create user c##ttt identified by ttt;

drop user c##ttt;
drop user c##ttt cascade;

-- �����ͺ��̽� ���ӽ� ���� �Ǵ� ��ȣ�� ��Ÿ�� �� �� ������ �߻���Ű�ų�
-- �ڹ� �Ǵ� ���̽��� �ڵ�� SQL ������ �����ͺ��̽��� �����ؼ� ���� ��û�� ���
-- SQL ���� ������ ���� ��� (�� �� �ݺ��� ���)
-- �����ͺ��̽��� �ش� ����� ������ ��� �� ����(Lock)
-- �����ڰ������� ��� ����ڰ����� Lock ���� ó���ؾ� ��.
-- ���� : alter user ����ڰ��� identifited by ��ȣ  account unlock;

-- ����ڰ��� ��ױ� (Lock)
alter user c##student identified by student account lock; -- ���
alter user c##student identified by student account unlock; -- ����

-- ��ȣ ����� 
-- alter user ����ڰ��� identified by �ٲܾ�ȣ;

create user c##ttt identified by ttt;
grant connect to c##ttt;
conn c##ttt/ttt;

alter user c##ttt identified by s123; -- ��ȣ ����
conn c##ttt/ttt; -- ���� ���� Ȯ��
drop user c##ttt;








