create database site;

use site;

-- 회원 테이블
create table member (
	member_id varchar(20) primary key,
    password varchar(20) not null,
    name varchar(30) not null,
    gender int not null,
    age int,
    birth date,
    tel varchar(20),
    address varchar(100),
    regist_date date not null,
    last_access_time timestamp
);

drop table member;

-- 게시글 테이블
create table article (
	article_id int auto_increment primary key,
    member_id varchar(20),
    title varchar(100) not null,
	content varchar(1000) not null,
    write_time timestamp not null,
    last_update_time timestamp not null,
    read_count int not null,
    
    foreign key (member_id) references member (member_id)
);

-- 댓글 테이블
create table comment (
	comment_id int auto_increment primary key,
    article_id int,
    member_id varchar(20),
    content varchar(1000) not null,
    write_time timestamp not null,
    
    foreign key (article_id) 
		references article (article_id) on delete cascade,
        
    foreign key (member_id) 
		references member (member_id)
);

select * from member;
select * from article;
select * from comment;

create view simpleArticle
as
select article_id, title, m.member_id, name, write_time, read_count
	from article a inner join member m 
    on a.member_id = m.member_id;

select * from simpleArticle;


create view detailArticle
as
select article_id, m.member_id, name, title, content, write_time, last_update_time, read_count
	from article a inner join member m 
    on a.member_id = m.member_id;
    
select * from detailArticle;