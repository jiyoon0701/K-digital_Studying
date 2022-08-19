/*
 1. 고객테이블과 상품테이블을 조인하여 준비할 상품의 이름과, 필요수량을 출력하기.
  단 수량이 많은 순으로 정렬하기

[결과]
상품명                                                         상품수량
------------------------------------------------------------ ----------
샴푸세트                                                              3
참치세트                                                              3
세차용품세트                                                          3
벽걸이TV                                                              2
주방용품세트                                                          2
산악용자전거                                                          2
노트북                                                                2
LCD모니터                                                             2
양쪽문냉장고                                                          1
*/
select  g1.gname 고객명,g2.gname 상품명
from gogak g1, gift g2
where g1.point between g2.g_start and g2.g_end
order by g2.gname;

select  g2.gname 상품명,count(*) 상품수량
from gogak g1, gift g2
where g1.point between g2.g_start and g2.g_end
group by g2.gname
order by 상품수량 desc;

/*
2.  교수테이블에서 교수번호, 교수이름,입사일 자신보다 입사일이 빠른사람의 인원수를 출력하기
    모든 교수정보가 조회되도록 하고, 입사일이 빠른순으로 정렬하기

[결과]
   PROFNO NAME                                     HIREDATE COUNT(P2.NAME)
---------- ---------------------------------------- -------- --------------
      1001 김명선                                   90/06/23              0
      3001 김도형                                   91/10/23              1
      4001 심슨                                     91/10/23              1
      2013 이창익                                   92/04/29              3
      4005 바비                                     95/09/18              4
      2012 장혜진                                   95/11/30              5
      1002 김명신                                   97/01/30              6
      3002 나한열                                   07/07/01              7
      1003 김자바                                   08/03/22              8
      4003 나몰라                                   09/12/01              9
      4006 비                                       10/06/28             10
      4007 김태희                                   11/05/23             11
      2011 엄호선                                   11/09/01             12
      3003 김현정                                   12/02/24             13
      4004 아이유                                   19/01/28             14
      4002 최슬기                                   19/08/30             15
*/
select p1.profno,p1.name,p1.hiredate,p2.name,p2.hiredate
from professor p1, professor p2
where p1.hiredate > p2.hiredate(+)
order by p1.hiredate;

select p1.profno,p1.name,p1.hiredate,count(p2.name)
from professor p1, professor p2
where p1.hiredate > p2.hiredate(+)
group by p1.profno,p1.name,p1.hiredate
order by p1.hiredate;

/*
3. emp 테이블에서 사원번호,사원명,직업,상사번호,상사이름,상사의직업을 출력하기.
   모든 사원이 조회되도록 한다.
  [결과]
  사원번호 사원명               사원직업             상사번호      상사명               상사직업
---------- -------------------- ------------------ ---------- -------------------- ------------------
      7369 SMITH                CLERK                    7902        FORD                 ANALYST
      7499 ALLEN                SALESMAN              7698       BLAKE                MANAGER
      7521 WARD                SALESMAN             7698        BLAKE                MANAGER
      7566 JONES                MANAGER               7839       KING                 PRESIDENT
      7654 MARTIN              SALESMAN              7698       BLAKE                MANAGER
      7698 BLAKE                MANAGER               7839       KING                 PRESIDENT
      7782 CLARK                MANAGER               7839      KING                 PRESIDENT
      7788 SCOTT                ANALYST                 7566      JONES                MANAGER
      7839 KING                 PRESIDENT
      7844 TURNER               SALESMAN             7698      BLAKE                MANAGER
      7876 ADAMS                CLERK                    7788     SCOTT                ANALYST
      7900 JAMES                CLERK                     7698      BLAKE                MANAGER
      7902 FORD                 ANALYST                  7566     JONES                MANAGER
      7934 MILLER               CLERK                    7782       CLARK                MANAGER
*/
select e1.empno,e1.ename,e1.job,e1.mgr,e2.ename,e2.job
from  emp e1, emp e2
where e1.mgr = e2.empno(+)
order by e1.empno;

/*
4. 부서테이블(department)에서 공과대학에 소속된 학과이름을 출력
[결과]
DNAME
------------------------
소프트웨어공학과
컴퓨터공학과
멀티미디어공학과
화학공학과
전자공학과
기계공학과
*/
select * from department;

select d1.dname
from department d1, department d2,department d3
where  d1.part = d2.deptno and d2.part = d3.deptno
 and d3.dname = '공과대학';

select d1.dname
from department d1, department d2
where  d1.part = d2.deptno
 and d2.part = (select deptno from department where dname = '공과대학');

select dname from department
where  part in (select deptno from department 
                where part =
               (select deptno from department where dname = '공과대학'));

/*
5.학생테이블에서 전공학과가 101번인 학과의 평균몸무게보다  몸무게가 많은 
  학생들의 이름과 몸무게, 학과명 출력
[결과]
NAME                     WEIGHT   DNAME
-------------------- ----------  -------------------------------------
홍길동                       72       컴퓨터공학과
이사랑                       64       멀티미디어공학과
나학생                       83       전자공학과
누구야                       70       기계공학과
일지매                       72       컴퓨터공학과
김진욱                       70       멀티미디어공학과
안광훈                       82       전자공학과
노정호                       62       문헌정보학과
안은수                       63       전자공학과
인영민                       69       전자공학과
김주현                       81       멀티미디어공학과
*/
select s.name, s.weight,d.dname 
from student s, department d
where s.deptno1 = d.deptno
and weight > (select avg(weight) from student where deptno1 = 101);
/*
6. 교수테이블의 심슨교수와 같은 입사일에 입사한 교수 중  
   김명선교수 보다 월급을 적게받는 교수의 이름, 급여, 입사일 출력
[결과]
NAME                                            PAY HIREDATE
---------------------------------------- ---------- --------
김도형                                          530 91/10/23
*/
select name,pay,hiredate from professor
where hiredate = (select hiredate from professor where name='심슨')
and pay < (select pay from professor where name='김명선');

/*
7.101번 학과 학생들의 평균 몸무게 보다  몸무게가 적은 학생의  학번과,이름과, 학과번호, 몸무게를 출력
[결과]
    STUDNO NAME                    DEPTNO1     WEIGHT
---------- -------------------- ---------- ----------
      9413 조아해                      103         52
      9511 이서진                      101         48
      9512 유해진                      102         42
      9513 오나라                      202         55
      9514 구유미                      301         58
      9515 몰라두                      201         54
      9614 김문호                      201         51
      9711 이윤나                      101         48
      9715 허우                        103         51
*/
select studno,name,deptno1,weight from student
where weight < (select avg(weight) from student where deptno1= 101);

/*
8.  9712학생과 학년이 같고 키는 9713학생보다  큰 학생의 이름, 학년, 키를 출력
[결과]
NAME                      GRADE     HEIGHT
-------------------- ---------- ----------
안은수                        1        175
김주현                        1        179
*/
select name, grade ,height from student
where grade = (select grade from student where studno=9712)
and height > (select height from student where studno = 9713);

/*
9. 컴퓨터정보학부에 소속된 모든 학생의 학번,이름, 학과번호 출력
   학과번호 순으로 정렬하여 출력하기
[결과]
      학번 이름                   학과번호
---------- -------------------- ----------
      9511 이서진                      101
      9411 홍길동                      101
      9611 일지매                      101
      9711 이윤나                      101
      9412 이사랑                      102
      9512 유해진                      102
      9612 김진욱                      102
      9714 김주현                      102
      9413 조아해                      103
      9715 허우                        103
*/
select * from department;

select studno 학번, name 이름, deptno1 학과번호
from student 
where deptno1 in 
(select d1.deptno from department d1, department d2  
 where d1.part = d2.deptno and d2.dname = '컴퓨터정보학부')
 order by 학과번호;

select studno 학번, name 이름, deptno1 학과번호, d.dname 학과명
from student s, department d
where s.deptno1 = d.deptno 
 and  deptno1 in 
(select d1.deptno from department d1, department d2  
 where d1.part = d2.deptno and d2.dname = '컴퓨터정보학부')
 order by 학과번호;

/*
10. 4학년학생 중 키가 제일 작은 학생보다 키가 더 작은 학생의 학번,이름,키를 출력
[결과]
    STUDNO NAME                     HEIGHT
---------- -------------------- ----------
      9511 이서진                      164
      9512 유해진                      161
      9514 구유미                      160
      9614 김문호                      166
      9711 이윤나                      162
      9715 허우                         163
*/
select studno, name, height  from student 
where height < (select min(height)  from student where grade=4);

/*
11. 학생 중에서 생년월일이 가장 빠른 학생의 학번, 이름, 생년월일을 출력
[결과]
    STUDNO NAME                 BIRTHDAY
---------- -------------------- --------
      9412 이사랑               75/02/24
*/
select studno, name, birthday
 from student 
where birthday=(select min(birthday) from student);

/*
12.학년별로 평균체중이 가장 적은 학년의 학년과 평균 몸무게를 출력
[결과]
     GRADE AVG(WEIGHT)
---------- -----------
         3        51.4
*/
select grade, avg(weight) from student 
group by grade ;

select grade, avg(weight) from student 
group by grade 
having avg(weight) = 
(select min(avg(weight)) from student group by grade);

/*
 Join 구문 : 여러개의 테이블을 연결하여 조회.
     Cross join : m*n개의 레코드로 조회됨. 주의필요

     등가조인 : 조인컬럼의 값이 같은 경우로 조인 대상 레코드 조회
     비등가조인 : 조인컬럼의 값이 같은 경우가 아닌 범위지정으로 레코드 조회

     self 조인 : join 대상 테이블이 같은 테이블인 경우
                 반드시 테이블의 별명을 지정해야 함.
                 
     inner join: 양쪽 테이블의 조인 컬럼 조건이 맞는 경우만 조회됨. 기본적인 조인.
     outer join: 조건에 맞지 않아도 한쪽 테이블의 모든 레코드의 조회됨
           left outer join : 왼쪽 테이블의 모든 레코드를 조회
           right outer join : 오른쪽 테이블의 모든 레코드를 조회
           full outer join : 양쪽 테이블의 모든 레코드를 조회
           
   subquery : select 구문 내부에 select 구문 존재함.
     단일행 subquery : where 조건문의 select 구문 결과가 한개인 경우
        사용가능 연산자 : =, >=, <=,....
     복수행 subquery : where 조건문의 select 구문 결과가 여러개인 경우
        사용가능 연산자 : in
     
     다중 컬럼 서브 쿼리 : 비교대상 컬럼이 두개 이상임.
     
     서브쿼리 위치
      1. where 조건문
      2. having 조건문
      3. 컬럼부분  : 스칼라 서브쿼리
      4. from 구문 : inline view
*/
select name, (select dname from department where deptno=101)
from student;
-- 평균 모무게가 60보다 큰 학년의 학년과 평균몸무게 출력하기
select grade,avg(weight) from student
group by grade having avg(weight) > 60;
-- inline view
select grade, 몸무게 
from (select grade,avg(weight) 몸무게 from student group by grade)
where 몸무게 > 60;

/*
 DML : Data Manipulation Language. 데이터 조작어.
   1. insert : 테이블에 새로운 레코드 추가시 사용되는 명령어. (C)reate
   2. update : 테이블에 기존 레코드 변경시 사용되는 명령어    (U)pdate
   3. delete : 테이블에 기존 레코드 제거시 사용되는 명령어    (D)elete 
   4. merge : 두개의 테이블의 내용 병합시 사용되는 명령어
   
   select : (R)ead
   CRUD : Create, Read, Update, Delete
 TCL : Transaction Control Language
   1. commit   : DML 명령문 실행완료. 트랜젝션 종료
   2. rollback : DML 명령문 취소. 트랜젝션 종료
   
   Transaction : all or nothing. 업무상태에 따라서 하나의 논리적인 업무지정
*/
-- insert
/* 레코드를 테이블에 추가 명령어
  insert into 테이블명 [(컬럼명1, 컬럼명2,...)] values (값1,값2,....)

  컬럼명 부분 생략 가능. => 모든 컬럼에 데이터를 추가하는 경우.
                   desc 테이블명에 조회된 컬럼(스키마)의 순서대로 값을 설정
                         => 권장하지 않음.
  컬럼명을 기술해야 하는 경우
   1. 모든 컬럼에 값을 설정하지 않는 경우
   2. 스키마 순서와 상관없이 순서를 개발자가 지정할때
   3. db구조가 자주 변경되는 경우 컬럼명을 기술하는 것이 안전함
*/
-- dept2 테이블에 9000번 부서 추가하기
select * from dept2;

insert into dept2 (dcode,dname,pdept,area) 
values (9000,'특수판매팀',1000,'임시지역');

select * from dept2;
-- dept2 테이블에 9001번 부서 추가하기 : 컬럼부분 생략
insert into dept2 values(9001,'특수판매1팀',9000,'임시지역');

select * from dept2 where dcode >= 9000;
-- dept2 테이블에 9002번 부서 추가하기
-- 코드:9002, 부서명:특수판매2팀
insert into dept2 (dcode,dname) values(9002,'특수판매2팀');

select * from dept2 where dcode >= 9000;
-- dept2 테이블에 9003번 부서 추가하기
-- 코드:9003, 부서명:특수판매3팀
insert into dept2  values(9003,'특수판매3팀','','');
select * from dept2 where dcode >= 9000;

-- dept2 테이블에 9004번 부서 추가하기
-- 코드:9004, 부서명:특수판매4팀
insert into dept2  values(9004,'특수판매3팀',null,null);
select * from dept2 where dcode >= 9000;

-- null 값 입력방법
-- 1. 컬럼을 기술하지 않기
-- 2. 빈문자열값을 설정
-- 3. null, NULL로 직접 입력하기

select * from dept2 where dcode >= 9000;

COMMIT;

-- dept2 테이블에 9005번 부서 추가하기
-- 코드:9005, 부서명:특수판매5팀
insert into dept2  values(9005,'특수판매5팀',null,null);
select * from dept2 where dcode >= 9000;
ROLLBACK;
select * from dept2 where dcode >= 9000;

/*
 update : 기존의 레코드를 컬럼의 값을 수정하기
 
 update 테이블명 set 컬럼1=값1,컬럼2=값2....
 [where 조건문] => 변경되는 레코드를 선택 조건.
                  where 조건문이 구현되지 않으면 모든 레코드의 기술된 컬럼이 변경
*/
-- 교수 테이블에서 직급이 조교수인 교수의 보너스를 99로 변경하기
select name,bonus from professor where position='조교수';

update professor set bonus=99  where position='조교수';
rollback;

-- 장혜진교수와 같은 직급의 교수 중 급여가 300 이하인 교수의 급여만 15% 인상하기
-- 수정전 조회
select name,pay,position from professor 
 where position = (select position from professor where name='장혜진')
  and pay <= 300;
-- 수정  
update professor set pay = pay * 1.15
 where position = (select position from professor where name='장혜진')
  and pay <= 300;

-- 수정후 조회
select name,pay,position from professor 
 where position = (select position from professor where name='장혜진');

rollback;
-- 학생 테이블에서 지도교수가 없는 학생의 지도교수를 이서진학생의 지도교수로 변경하기
-- 수정전 조회 : 지도교수가 없는 학생 
select name,grade,profno from student where profno is null;
-- 지도교수 수정
update student 
set profno = (select profno from student where name='이서진')
where profno is null;
-- 수정후 조회 : 지도교수가 이서진학생과 같은 학생 
select name,grade,profno from student 
where profno = (select profno from student where name='이서진');
rollback;

-- 전임강사의 보너스를 조교수의 평균 보너스의 50%로 변경하기.
-- 조교수의 보너스가 없는 경우는 0으로 계산하기. 
-- 소숫점이하는 절삭한 보너스로 변경하기.
-- 수정전 조회 : 전임강사의 보너스 조회, 조교수의 평균 보너스 조회
select name,bonus from professor where position='전임강사';
select trunc(avg(nvl(bonus,0)) * 0.5) 
from professor where position='조교수';
-- 수정
update professor set bonus = (select trunc(avg(nvl(bonus,0)) * 0.5) 
from professor where position='조교수')
where position='전임강사';

-- 수정후 조회 : 전임강사의 보너스 조회
select name,bonus from professor where position='전임강사';
rollback;

/*
  delete : 레코드 삭제 명령어
  
  delete [from] 테이블명
  [where 조건문] => 삭제될 레코드 조건. 없는 경우는 모든 레코드 삭제. 주의필요
*/
-- dept2 테이블의 dcode의 값이 9000번인 레코드 삭제하기
-- 삭제전 조회
select * from dept2 where dcode=9000;
-- 삭제
delete from dept2 where dcode=9000;
-- 삭제후 조회
select * from dept2 where dcode >=9000;
rollback;
-- 교수테이블에서 심슨교수와 같은 부서의 교수를 퇴직시키기.
-- 삭제전 조회
select name,deptno from professor 
where deptno = (select deptno from professor where name='심슨');
-- 삭제-
delete from professor 
where deptno = (select deptno from professor where name='심슨');
-- 삭제후 조회
select name,deptno from professor 
where deptno = 201;
rollback;
/*
   DDL : Data Definition Language 데이터 정의어
         객체를 생성,변경,제거 기능을 담당하는 명령어
         객체 : table,index,user,sequence,....
         table 생성 : create table 테이블명....
         index 생성 : create index 인덱스명....
         user 생성 : create user 유저명...
         
     DDL 명령어
       1. create : 객체(table) 생성
       2. alter  : 객체 수정
       3. drop   : 객체 제거
       4. truncate : 객체와 데이터 분리
     DDL 명령어 특징
       1. commit, rollback 의미가 없다.
       2. DDL 명령어가 실행되면, 자동 commit됨.
         => rollback을 하고싶으면, rollback 먼저실행하고, ddl 명령어를 실행 해야함
*/
-- ddl_test 테이블 생성하기
create table ddl_test 
(
  no number(3),       -- 최대 숫자 3자리 형태로 데이터 저장
  name varchar(10),   -- 최대 10 바이트 문자 형태 데이터 저장. 한글:3바이트
  birth date default sysdate --날짜시간 데이터 저장. 기본값을 현재일시로 저장
);
/*
  자료형
    number,integer : 숫자형태의 데이터 저장 자료형
    char,varchar,varchar2 : 문자형태의 데이터 저장 자료형
    date  : 날짜시간정보를 저장 자료형
*/
select lengthb('가') from dual;
select * from ddl_test;
-- ddl_test 테이블에 데이터 추가하기
insert into ddl_test (no, name) values (1,'홍길동');
select * from ddl_test;
insert into ddl_test (no, name) values (2,'남궁길동');

-- ddl_test2 테이블 생성하기
-- no : number, name: varchar 기본값 '홍길동', birth : 날짜. 기본값 오늘
create table ddl_test2 
(
  no number(3),
  name varchar(10) default '홍길동',
  birth date default sysdate
);
desc ddl_test2;
insert into ddl_test2 (no) values (1);
select * from ddl_test2;
-- ddl_test2 테이블에 no:2, name:김삿갓, birth:90-01-01 데이터 추가하기
insert into ddl_test2 values (2,'김삿갓','90-01-01');
select * from ddl_test2;

-- DDL 명령어를 실행하면 자동 commit 됨.
-- primary key : 기본키. 레코드내용을 유일한 의미를 가지는 컬럼
--               컬럼의 값은 테이블내에서 유일함. 중복안됨.
create table ddl_test3  
(
  no number(3) primary key,
  name varchar(10) default '홍길동',
  birth date default sysdate
);
insert into ddl_test2 (no) values(1);
select * from ddl_test2 ; -- => no 컬럼의 값이 중복 가능;
insert into ddl_test3 (no) values(1);
select * from ddl_test3;
insert into ddl_test3 (no) values(1);

/*
   alter : 기존 객체의 구조를 변경하는 명령어
           컬럼을 추가 또는 삭제 변경등이 가능함
*/
-- dept2 테이블을 dept3 테이블 복사하기
create table dept3 as select * from dept2 ;
select * from dept3;
-- dept3 테이블에 tel 컬럼 추가하기
alter table dept3 add tel varchar(20);
select * from dept3;
-- dept3 테이블에 tel 컬럼을 phone 으로 변경하기
alter table dept3 rename column tel to phone;
select * from dept3;
desc dept3;
-- dept3 테이블에 area 컬럼의 크기를 30으로 변경하기
alter table dept3 modify area varchar(30);
desc dept3;
-- dept3 테이블에 area 컬럼의 크기를 10으로 변경하기:오류
--       저장된 데이터의 크기가 10보다 큰경우 작아지는 쪽으로 크기변경 안됨.
alter table dept3 modify area varchar(10);
-- area에 저장된 데이터의 최대 크기 조회하기
select max(lengthb(area)) from dept3 ;--=> 12까지 크기를 줄일수 있음
alter table dept3 modify area varchar(12);

desc dept3;
-- dept3 테이블에 phone 컬럼의 크기를 10으로 변경하기
alter table dept3 modify phone varchar(10);
desc dept3;

-- 컬럼제거
alter table dept3 drop column phone;
desc dept3;

/*
  drop : 객체 제거
        객체 제거되면, 내용도삭제됨. 복구불가
*/
-- dept3 테이블 제거하기
drop table dept3;
desc dept3;

-- ddl_test 테이블 제거하기
drop table ddl_test;

/*
  truncate : 내용 제거하기
     delete 명령어는 rollback 가능. 
     truncate 명령어는 rollback  불가능. 삭제 속도가 빠르다
*/
select * from ddl_Test2;
truncate table ddl_Test2;
select * from ddl_Test2;
select * from ddl_Test3;
delete from ddl_test3;
select * from ddl_Test3;
rollback;
select * from ddl_Test3;
truncate table ddl_Test3;
select * from ddl_Test3;
rollback;
select * from ddl_Test3;