--创建用户以及赋权限
create user muke identified by a;
grant resource,connect to vote;

--管理员表
drop table admin;
drop sequence seq_admin_aId;

create table admin(
       aId varchar2(20) primary key,          --管理员编号
       aName varchar2(20) not null,           --管理员名字
       aPwd varchar2(20) not null,            --管理员密码
       aRetain1 varchar2(100),                --保留字段 
       aRetain2 varchar2(100),                --保留字段
       aRetain3 varchar2(100),                --保留字段
       aStatus int                            --删除标记  0已被删除 1为存在
                constraint CK_admin_aStatus check(aStatus in(1,0))
)

create sequence seq_admin_aId
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个

insert into admin values(seq_admin_aId,'a','a','','','',1);
select * from  admin;
select * from admin where aName='a' and aPwd='a'


--用户信息表
drop table users;
drop sequence seq_users_uNo;

create table users(
       uNo varchar(20) primary key,         --用户编号
       uName varchar2(20) not null,         --用户名
       uPwd varchar2(20) not null,          --用户密码
       uAddress_prov varchar2(50),          --省
       uAddress_city varchar2(50),          --市
       uAddress_county varchar2(50),        --县
       uSex varchar2(20) default '男'       --性别
              constraint CK_users_uSex check(uSex in('男','女')),
       uUsign varchar2(200),                --个性签名
       uPic varchar2(200),                  --头像
       uTel varchar2(20),                   --手机
       uIsTeacher int,                      --0表示不是教师 1表示为是教师
       uStudytime int,                      --学习时间
       uRetain1 varchar2(100),              --保留字段 
       uRetain2 varchar2(100),              --保留字段
       uRetain3 varchar2(100),              --保留字段
       uStatus int                          --删除标记  0已被删除 1为存在
               constraint CK_users_uStatus check(uStatus in(1,0))
)

create sequence seq_users_uNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个

select * from users;


--课程类别表
drop table ctype;
drop sequence seq_ctype_ctNo;

create table ctype(
       ctNo varchar2(20) primary key,   --类别编号
       ctName varchar2(20) not null,    --类别名
       ctDirname varchar2(20) not null, --方向名称
       ctRetain1 varchar2(100),         --保留字段 
       ctRetain2 varchar2(100),         --保留字段
       ctRetain3 varchar2(100),         --保留字段
       ctStatus int                     --删除标记  0已被删除 1为存在
              constraint CK_ctype_ctStatus check(ctStatus in(1,2))
)

create sequence seq_ctype_ctNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个

select * from ctype;


--课程难易表
drop table deeply;
drop sequence seq_deeply_dNo;

create table deeply(
       dNo varchar2(20) primary key,       --难易度编号
       dName varchar2(15) not null unique, --难易度名称
       dRetain1 varchar2(100),             --保留字段 
       dRetain2 varchar2(100),             --保留字段
       dRetain3 varchar2(100),             --保留字段
       dStatus int                         --删除标记  0已被删除 1为存在
              constraint CK_deeply_dStatus check(dStatus in(1,2))
)

create sequence seq_deeply_dNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1    -- 每次加1个
       
select * from deeply;


--课程信息表(course)
drop table course;
drop sequence seq_course_cNo;

create table course(
      cNo varchar2(20) primary key,       --课程编号
      cName varchar2(25) not null unique, --课程名
      dNo varchar2(20)                    --难易度
                constraint FK_course_dNo references deeply(dNo),
      ctNo varchar2(20)                   --类别
                constraint FK_course_ctNo references ctype(ctNo),
      cUpdatetime varchar2(20),           --更新时间
      cUpstatus int                      --是否更完 0更完 1未更完
                constraint CK_course_cUpstatus check(cUpstatus in(1,2)),
      cPic varchar2(100),                 --课程图片的路径
      cRetain1 varchar2(100),             --保留字段 
      cRetain2 varchar2(100),             --保留字段
      cRetain3 varchar2(100),             --保留字段
      cStatus int                         --删除标记  0已被删除 1为存在
                constraint CK_course_cStatus check(cStatus in(1,2))
)

create sequence seq_course_cNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个

select * from course;


--用户学习的课程表
drop table ucourse;

create table ucourse(
       uNo varchar2(20)                      --用户
                constraint FK_ucourse_uno references users(uNo),
       cNo varchar2(20)                      --课程
                constraint FK_ucourse_cno references course(cNo),
       ucAttention int                     --1表示已关注，0表示未关注
                constraint CK_ucourse_ucAttention check(ucAttention in(1,2)),
       ucLearnstatus int                    --学习状态 1正在学 0已学完
                constraint CK_ucourse_ucLearnstatus check(ucLearnstatus in(1,2)),
       ucNowChNo varchar2(100),        --现在学习到的章节数
       ucRetain1 varchar2(100),              --保留字段 
       ucRetain2 varchar2(100),              --保留字段
       ucRetain3 varchar2(100),              --保留字段
       ucStatus int                          --删除标记  0已被删除 1为存在
                constraint CK_ucourse_ucStatus check(ucStatus in(1,2))
)

select * from (select a.*,rownum rn from (select r.*,uname,cname,cpic,updatetime from ucourse r, course d,users e where r.status!=0 and r.uno=e.uno and r.cno=d.cno and r.attention=1 and r.uno=1000 order by r.uno) a where rownum<=5) b where rn>0;
select * from ucourse;

--章节类型表
drop table chapter;
drop sequence seq_chapter_chapterno;

create table chapter(
       chNo varchar2(20) primary key,            --章节编号
       chName varchar2(200) not null,            --章节名
       cNo varchar2(20)                          --课程
              constraint FK_chapter_cNo references course(cNo),
       chContent varchar(200),                   --章节内容
       chOrder int,                              --章节的顺序
       chRetain1 varchar2(100),                  --保留字段 
       chRetain2 varchar2(100),                  --保留字段
       chRetain3 varchar2(100),                  --保留字段
       chStatus int                              --删除标记  0已被删除 1为存在
              constraint CK_chapter_chStatus check(chStatus in(1,2))
)

create sequence seq_chapter_chNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个

select * from chapter;


--评论表
drop table comments;
drop sequence seq_comments_coNo;

create table comments(
       coNo varchar2(20) primary key,        --评论编号
       uNo varchar2(20)                      --用户
           constraint FK_comments_uNo references users(uNo),
       chNo varchar2(20)                     --章节
           constraint FK_comments_chNo references chapter(chNo),
       coContent clob,                       --评论内容
       coTime varchar2(200),                          --评论时间
       coDianzannum int,                     --点赞数
       coPic varchar2(200),                  --评论截图
       coRetain1 varchar2(100),              --保留字段 
       coRetain2 varchar2(100),              --保留字段
       coRetain3 varchar2(100),              --保留字段
       coStatus int                          --删除标记  0已被删除 1为存在
           constraint CK_comments_coStatus check(coStatus in(1,2))
)

create sequence seq_comments_coNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1    -- 每次加1个
       
select * from comments;

--问题表
drop table ask;
drop sequence seq_ask_aNo;

create table ask(
       aNo varchar2(20) primary key,       --问答编号
       ctNo varchar2(50)                   --类型
           constraint FK_ask_ctNo references ctype(ctNo),
       uNo varchar2(20)                    --提问者
           constraint FK_ask_uNo references users(uNo),
       aTitle varchar2(50),                 --问题标题
       aContent clob,                       --问题内容
       aTime varchar2(200),              --提问时间
       aRetain1 varchar2(100),              --保留字段 
       aRetain2 varchar2(100),              --保留字段
       aRetain3 varchar2(100),              --保留字段
       aStatus int                          --删除标记  0已被删除 1为存在
           constraint CK_ask_aStatus check(aStatus in(1,2))   
)

create sequence seq_ask_aNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1    -- 每次加1个
       
select * from ask;


--回答表
drop table answer;
drop sequence seq_ask_aNo;

create table answer(
       anNo varchar2(20) primary key,              --回答编号
       aNo varchar2(20)                          --问题
           constraint FK_answer_aNo references ask(aNo),
       anContent clob,                         --回答内容
       uNo varchar2(20)                            --回答者
           constraint FK_answer_uno references users(uNo),
       anTime varchar2(200),                   --回答时间
       anRetain1 varchar2(100),                    --保留字段 
       anRetain2 varchar2(100),                    --保留字段
       anRetain3 varchar2(100),                    --保留字段
       anStatus int                                --删除标记  0已被删除 1为存在
           constraint CK_ask_anStatus check(anStatus in(1,2))      
)

create sequence seq_ask_aNo
       START WITH 1000    -- 从1000开始计数 
       INCREMENT BY 1     -- 每次加1个
       
select * from answer;

