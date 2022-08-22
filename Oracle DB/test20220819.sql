/*
1. 학생이름과 지도교수이름 출력하기.단 지도학생이 없는 교수이름과,  
   지도교수가 없는 학생이름도 출력하기
   지도학생이 없는 교수의 경우 지도학생이름은 "****"로 표시하고 
   지도교수가 없는 학생의 지도교수는 '####'   으로 출력하기. 
  [결과]
지도학생             지도교수
--------------- -----------------
****                 김도형
****                 김자바
****                 김현정
****                 바비
****                 비
****                 아이유
****                 이창익
구유미               김태희
김문호               나몰라
김주현               ####
김진욱               엄호선
나학생               심슨
노정호               김태희
누구야               나몰라
몰라두               심슨
안광훈               최슬기
안은수               ####
오나라               나몰라
유해진               장혜진
이사랑               엄호선
이서진               김명신
이윤나               ####
인영민               ####
일지매               김명신
조아해               나한열
허우                 ####
홍길동               김명선
*/

select nvl(s.name,'****')  지도학생, nvl(p.name,'####') 지도교수 
from student s, professor p
where s.profno = p.profno(+)  
union
select nvl(s.name,'****'), nvl(p.name,'####')
from student s, professor p
where s.profno(+) = p.profno;

select nvl(s.name,'****')  지도학생, nvl(p.name,'####') 지도교수 
from student s full outer join professor p
on s.profno = p.profno;

/*
2.  학과별,학년별 성적이 가장 높은 성적을 받은 학생의 
    학과코드,학과명,학년,이름,점수 출력하기
[결과]

  학과코드 학과명                                  학년   이름                       점수
---------- ----------------------------   ---------- -------------------- ----------
       101 컴퓨터공학과                               1   이윤나                       91
       101 컴퓨터공학과                               2   일지매                       89
       101 컴퓨터공학과                               3   이서진                       92
       101 컴퓨터공학과                               4   홍길동                       97
       102 멀티미디어공학과                         1   김주현                       83
       102 멀티미디어공학과                         2   김진욱                       77
       102 멀티미디어공학과                         3   유해진                       87
       102 멀티미디어공학과                         4   이사랑                       78
       103 소프트웨어공학과                         1   허우                          84
       103 소프트웨어공학과                         4   조아해                       83
       201 전자공학과                                  1   안은수                       88
       201 전자공학과                                  2   안광훈                       86
       201 전자공학과                                  3   몰라두                       95
       201 전자공학과                                  4   나학생                       62
       202 기계공학과                                  3   오나라                       81
       202 기계공학과                                  4   누구야                       88
       301 문헌정보학과                               2   노정호                       87
       301 문헌정보학과                               3   구유미                       79
*/
select s.deptno1 학과코드, d.dname 학과명,s.grade 학년,s.name 이름,e.total 점수
from student s, department d,exam_01 e
where s.deptno1 = d.deptno and s.studno = e.studno
and (s.deptno1,grade,e.total) in (select s.deptno1,s.grade,max(e.total)
     from student s,exam_01 e 
     where s.studno = e.studno group by s.deptno1,s.grade)
order by s.deptno1,s.grade;

select s.deptno1 학과코드, d.dname 학과명,s.grade 학년,s.name 이름,e.total 점수
from student s join department d
on s.deptno1 = d.deptno join exam_01 e
on s.studno = e.studno
where (s.deptno1,grade,e.total) in (select s.deptno1,s.grade,max(e.total)
     from student s join exam_01 e on s.studno = e.studno group by s.deptno1,s.grade)
order by s.deptno1,s.grade;
/*
3. 학과별  생년월일이 가장 빠른 학생의 학번,  이름, 생년월일,학과명을 출력
    STUDNO NAME             BIRTHDAY   DNAME
---------- ---------------- --------   ---------------
      9412 이사랑            75/02/24   멀티미디어공학과
      9414 나학생            75/12/25   전자공학과
      9514 구유미            76/01/20   문헌정보학과
      9411 홍길동            75/10/23   컴퓨터공학과
      9415 누구야            75/03/03   기계공학과
      9413 조아해            75/06/15   소프트웨어공학과
*/
select studno,name,birthday, d.dname 
from student s, department d
where s.deptno1 = d.deptno
and (deptno1, birthday) in (select deptno1, min(birthday) 
     from student group by deptno1);
/*
4. 교수 테이블의 입사일을 2015년 1월 1일로 입력하기
   교수번호 : 6001 ,       교수명   : 최윤식
   직책     : 조교수,      id      : choiys 
   입사일   : 2015-01-01,  부서코드 : 501
   pay     : 400
   
   select * from professor where profno = 6001
*/
insert into professor (profno, name,position,id,hiredate,deptno,pay)
values (6001,'최윤식','조교수','choiys','15/01/01',501,400);
select * from professor where profno = 6001;
rollback;
insert into professor (profno, name,position,id,hiredate,deptno,pay)
values (6001,'최윤식','조교수','choiys',
       to_date('2015-01-01','yyyy-mm-dd'),501,400);
select * from professor where profno = 6001;
rollback;
/*
5. department 테이블에 메카트로닉스학부의 하위 학과로 메카트로닉스공학과를 
   401번 코드로 추가하기.
   건물명은 null로 추가한다.
   select * from department where part = 200
   [결과]
deptno   dname   part build
-------- ------ ----- -----
201	전자공학과	200	전자제어관
202	기계공학과	200	기계실험관
203	화학공학과	200	화학실습관
401	메카트로닉스공학과	200	   
*/
insert into department (deptno,dname,part) 
  values (401,'메카트로닉스공학과',200);
select * from department where part = 200;
rollback;
/*
6. department 테이블에서  공과대학 속한  데이터만 저장하는 
   department10 테이블 생성하기
select * from department10
[결과]
deptno  dname       part   build
------ --------   ------- -------
101   컴퓨터공학과	  100	   정보관
102 	멀티미디어공학과	100	   멀티미디어관
103	  소프트웨어공학과	100	   소프트웨어관
201	  전자공학과	    200	   전자제어관
202	  기계공학과	    200	   기계실험관
203	  화학공학과	    200	   화학실습관
*/
drop table department10;
select * From department10;

create table department10 as
select d1.*     -- d1 테이블의 모든 컬럼
from department d1, department d2,department d3
where  d1.part = d2.deptno and d2.part = d3.deptno
 and d3.dname = '공과대학';

select * from department10;


Select * from department
where deptno in (select d1.deptno from department d1 
    inner join department d2 on d1.part=d2.deptno 
    inner join department d3 on d2.part = d3.deptno 
    where d3.dname='공과대학');

/*
   DML : 트랜젝션 가능 (commit, rollback)
   insert : 데이터 추가 명령문. C
      insert into 테이블명 [(컬럼명1,컬럼명2,...)] values (값1,'값2',...)
   update : 데이터 변경 명령문. U  
      update 테이블명 set 컬럼1=값1,컬럼2=값2,...
      [where 조건문] => 조건을 만족하는 레코드만 수정
                       where 구문이 없는 경우 모든 레코드가 변경
   delete : 데이터 제거 명령문. D
      delete from 테이블
      [where 조건문] => 조건을 만족하는 레코드만 삭제
                       where 구문이 없는 경우 모든 레코드가 삭제
   select 컬럼명1,컬럼명2,.. || * 
   from 테이블명,뷰
   [where 조건문]
   [group by 컬럼1,....]
   [having 조건문]
   [order by 컬럼|별명|순서 [desc]]
   
   DDL : 테이블 객체를 생성,변경, 수정 명령어. 트랜젝션처리 불가. 자동commit
    create : 객체 생성
      create table  테이블이름 (
        컬럼명1 자료형 제약조건(기본키,기본값,NOT NULL,...),
        컬럼명2 자료형 제약조건(기본키,기본값,NOT NULL,...),
        ....
      )
    alter : 객체 수정.
      컬럼/제약조건 추가,삭제, 생성
    drop : 객체 제거
      drop table 테이블명
    truncate : 객체의 모든 내용 제거. rollback 불가.
*/