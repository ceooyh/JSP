
create table member(
	id varchar2(25byte) primary key,
	pass varchar2(50byte) not null,
	name varchar2(30byte),
	age number
);


select * from member where name like '홍길동' and id like 'A0001';

select * from member;

alter table member add grade number default 1;

