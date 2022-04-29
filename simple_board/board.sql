create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

-- oracle 페이지 나누기

-- 더미 데이터
insert into spring_board(bno,title,content,writer) 
(select seq_board.nextval, title,content,writer from spring_board);

select count(*) from SPRING_BOARD;

-- rownum 사용하기

select rownum, bno, title from board;

-- rownum 은 order by 절과 함께 사용할 때 주의
-- order by 절에서 사용하는 컬럼이 index 가 아닐 때 주의
-- 임의로 행을 가지고 나온 후 번호를 붙임 => 인라인 쿼리
--select rownum,.....
--from(select * from board where bno>0 order by re_ref desc);

-- 1) rownum 사용 방식
select rownum, bno, title, writer
from (select bno,title,writer,regdate,updatedate from spring_board order by bno desc)
where rownum <= 10;

-- 2) order by 컬럼이 인덱스라면 오라클 힌트 이용가능
select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum, bno, title, writer
from spring_board
where rownum <= 10;


-- 1page 최신글 가져오기
select bno,title,writer,regdate,updatedate
from (select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn, bno, title, writer,regdate,updatedate
	  from spring_board
	  where rownum <= 10)
where rn > 0;

-- 2page 최신글 가져오기
select bno,title,writer,regdate,updatedate
from (select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum rn, bno, title, writer,regdate,updatedate
	  from spring_board
	  where rownum <= 20)
where rn > 10;














