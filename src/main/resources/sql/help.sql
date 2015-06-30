-------- notice----------
create table notice_board(
	article_no number primary key,
	writer varchar2(20) not null,
	title varchar2(50) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	constraint noticewriter_fk foreign key (writer) references member(id) on delete cascade
)
drop table notice_board;
create sequence notice_no_seq nocache;
drop sequence notice_no_seq;

select * from notice_board order by article_no desc;
delete from notice_board where article_no='79'


insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트1','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트2','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트3','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트4','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트5','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트6','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트7','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트8','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트9','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트10','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트11','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트12','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트13','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트14','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트15','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트16','테스트');
select * from notice_board
select * from (select rownum,n.* from notice_board n order by article_no desc) where rownum between #{beginRow} and #{endRow}
select * from member;
drop table member;

-------- Qna----------
create table qna_board(
	article_no number primary key,
	writer varchar2(20) not null,
	title varchar2(50) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	constraint qnawriter_fk foreign key (writer) references member(id) on delete cascade
)
drop table qna_board;
select * from qna_board;
create sequence qna_no_seq nocache;

insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트1','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트2','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트3','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트4','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트5','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트6','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트7','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트8','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트9','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트10','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트11','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트12','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트13','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트14','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트15','테스트');
insert into qna_board(article_no,writer, title, content)
values(qna_no_seq.nextval,'admin','테스트16','테스트');

-------- Qna reply----------
create table qna_reply(
	article_no number primary key,
	title varchar2(100) not null,
	writer varchar2(100) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	ref number not null, -- 답변글묶음 번호, 원게시글 번호 
	restep number not null, -- 답변글묶음내 글순서(정렬 오름차순)
	relevel number not null -- 답변글레벨 , 답변의 단계 
		
)
create sequence qna_reply_seq nocache; 
drop sequence qna_reply_seq;
drop table qna_reply;

insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test','tester','Test',1,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test','admin','Test',1,0,0);

 select * from (
			select rownum as rnum, t.*, m.*
			from (select * from qna_reply order by ref desc, restep asc) t, member m
			where t.writer=m.id
		) where rnum between 1 and 1
		
select * from qna_reply




















