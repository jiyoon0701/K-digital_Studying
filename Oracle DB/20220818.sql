/*
1. 학과별로 평균 몸무게와 학생 수를 출력하되 
   평균 몸무게의  내림차순으로 정렬하여라.

[결과]
  학과코드 평균몸무게     학생수
---------- ---------- ----------
       201         67          6
       102      64.25          4
       202       62.5          2
       101         60          4
       301         60          2
       103       51.5          2
*/

select deptno1 학과코드, avg(weight) 평균몸무게 ,count(*) 학생수 
from student
group by deptno1
order by avg(weight) desc

/*
2.  학생테이블의 birthday를 기준으로 월별로 태어난 인원수 출력하기

[결과]
   합계      1월   2월        3월     4월      5월     6월       7월      8월     9월      10월      11월      12월
------- ------- -------- -------- -------- -------- -------- -------- -------- -------- --------- --------- ---------
     20        3        3         2        2        0         1        0         2          2         2          1         2
*/

select count(*) 합계,
 sum(decode(to_char(birthday,'mm'),'01',1,0)) "1월",
 sum(decode(to_char(birthday,'mm'),'02',1,0)) "2월",
 sum(decode(to_char(birthday,'mm'),'03',1,0)) "3월",
 sum(decode(to_char(birthday,'mm'),'04',1,0)) "4월",
 sum(decode(to_char(birthday,'mm'),'05',1,0)) "5월",
 sum(decode(to_char(birthday,'mm'),'06',1,0)) "6월",
 sum(decode(to_char(birthday,'mm'),'07',1,0)) "7월",
 sum(decode(to_char(birthday,'mm'),'08',1,0)) "8월",
 sum(decode(to_char(birthday,'mm'),'09',1,0)) "9월",
 sum(decode(to_char(birthday,'mm'),'10',1,0)) "10월",
 sum(decode(to_char(birthday,'mm'),'11',1,0)) "11월",
 sum(decode(to_char(birthday,'mm'),'12',1,0)) "12월"
from student;

select count(*) 합계,
 count(decode(to_char(birthday,'mm'),'01',1)) "1월",
 count(decode(to_char(birthday,'mm'),'02',1)) "2월",
 count(decode(to_char(birthday,'mm'),'03',1)) "3월",
 count(decode(to_char(birthday,'mm'),'04',1)) "4월",
 count(decode(to_char(birthday,'mm'),'05',1)) "5월",
 count(decode(to_char(birthday,'mm'),'06',1)) "6월",
 count(decode(to_char(birthday,'mm'),'07',1)) "7월",
 count(decode(to_char(birthday,'mm'),'08',1)) "8월",
 count(decode(to_char(birthday,'mm'),'09',1)) "9월",
 count(decode(to_char(birthday,'mm'),'10',1)) "10월",
 count(decode(to_char(birthday,'mm'),'11',1)) "11월",
 count(decode(to_char(birthday,'mm'),'12',1)) "12월"
from student;

/*
3. 학과별 교수 수가 2명 이하인 학과 번호, 교수 수를  출력하여라
[결과]
    DEPTNO   COUNT(*)
---------- ----------
     201        2
     301        2
     202        2
     203        1
*/
select deptno,count(*) from professor 
group by deptno 
having count(*) <= 2

/*
4.직급별로 평균 급여가 320보다 크면 '우수', 작거나 같으면 '보통'을 출력하여라

[결과]
POSITION                                 급여
---------------------------------------- ------------
정교수                                   우수
전임강사                                 보통
조교수                                   우수
*/
select position, avg(pay),
      case when avg(pay) > 320 then '우수'
           else '보통' end 급여 
from professor 
group by position;

select position, avg(pay),
      case when avg(pay) > 320 then '우수'
           when avg(pay) <= 320 then '보통' end 급여 
from professor 
group by position;

/* 
5.교수테이블의 부서중 최대인원을 가진 부서의 인원수와 최소인원을 가진 부서의 인원수 출력하기

[결과]
최대인원 최소인원
---------- ----------
   3            1
*/

select max(count(*)) 최대인원 , min(count(*)) 최소인원 
from professor group by deptno

/*
6. 교수테이블에서 평균 급여가 350이상인 부서의   
   부서코드, 평균급여, 급여합계를 출력하기

[결과]
 부서코드   평균급여   급여합계
---------- ---------- ----------
       102 363.333333       1090
       201        450        900
       101        400       1200
       203        500        500
       103 383.333333       1150
*/

select deptno 부서코드, avg(pay) 평균급여, sum(pay) 급여합계
from professor
group by deptno
having avg(pay) >= 350


-- 7. 4학년 학생의 이름 학과번호, 학과이름 출력하기
-- 오라클방식
select s.name, s.deptno1, d.dname from student s, department d
where s.deptno1 = d.deptno
and s.grade = 4
--ANSI 방식
select name, deptno1, d.dname 
from student s join department d
on s.deptno1 = d.deptno
where s.grade = 4

-- 8. 오나라 학생의 이름, 학과코드1,학과이름,학과위치 출력하기
-- 오라클 방식
select  s.name, s.deptno1, d.dname,d.build 
from student s, department d
where s.deptno1 = d.deptno
and s.name='오나라'
-- ANSI 방식
select  s.name, s.deptno1, d.dname,d.build 
from student s join department d
on s.deptno1 = d.deptno
where s.name='오나라'

-- 9. 학번과 학생 이름과 소속학과이름을 학생 이름순으로 정렬하여 출력
select s.studno, s.name, d.dname from student s, department d
where s.deptno1 = d.deptno
order by s.name

select s.studno, s.name, d.dname 
from student s join department d
on s.deptno1 = d.deptno
order by s.name

-- 10. 교수별로 교수 이름과 지도 학생 수를 출력하기.

-- 교수별 지도학생이름 조회
select p.name, s.name,s.studno,s.weight from professor p, student s
where p.profno = s.profno
order by p.name

select p.name, count(*) from professor p, student s
where p.profno = s.profno
group by p.name

select p.name, count(s.name) from professor p, student s
where p.profno = s.profno
group by p.name

select p.name, count(*) from professor p join  student s
on p.profno = s.profno
group by p.name

-- 11. 성이 김씨인 학생들의 이름, 학과이름 학과위치 출력하기
select s.name,  d.dname,d.build from student s, department d
where s.deptno1 = d.deptno
and s.name like '김%'

select s.name,  d.dname,d.build from student s, department d
where s.deptno1 = d.deptno
and substr(s.name,1,1) = '김'

select s.name,  d.dname,d.build 
from student s join department d
on s.deptno1 = d.deptno
where s.name like '김%'

/*
group 함수 : 레코드들 기준컬럼||전체 로 그룹화 하여 원하는
            정보를 구하는 함수들
            null 값은 제외됨.

         관련 예약어
            group by 컬럼명 : 컬럼명의 값으로 그룹화. 
            having 그룹함수 조건문 : 그룹의 조건문
              
 count : 레코드의 건수 리턴, null 값은 제외
      count(컬럼명) : 해당 컬럼의 값이 null아닌 갯수
      count(*) : 조회된 전체 레코드의 갯수

 sum   : 컬럼값들의 합계 리턴.  sum(숫자형컬럼명)
 avg   : 컬럼값들의 평균 리턴. null값인 경우는 평균산출시 제외.
         null이 아닌 값의 평균.
        avg(숫자형컬럼명), avg(nvl(컬럼명,0))=> null인 경우도 평균산출시 처리됨
 max   : 컬럼값들 중 최대값 리턴. 
 min   : 컬럼값들 중 최소값 리턴
 stddev : 컬럼값들의 표준편차 값 리턴
 variance : 컬럼값들의  분산 값 리턴
 
join : 두개 이상의 테이블을 연결하여 조회
  cross join : 사용시 주의를 요함. 결과가 m*n개의 갯수로 리턴. 조인컬럼이 없음
  Equi Join : 조인조건이 조인컬럼의 값이 같은 경우인 조인을 등가조인이라함.
*/
-- 비등가 조인 : Non Equi Join
--              조인컬럼의 조건이 =이 아닌 조인
select * from gogak  -- 고객테이블
select * from gift   -- 상품테이블

-- 고객테이블과 상품테이블을 이용하여, 고객의 포인트로 받을 수 있는
-- 상품을 조회하기
-- 고객의 이름,포인트, 상품명 조회하기
select g1.gname 고객명, g1.point 포인트, g2.gname,
       g2.g_start,g2.g_end
from gogak g1, gift g2
where g1.point between g2.g_start and g_end

select g1.gname 고객명, g1.point 포인트, g2.gname,g2.g_start,g2.g_end
from gogak g1 join gift g2
on g1.point between g2.g_start and g_end

select * from exam_01  -- 점수테이블
select * from hakjum   -- 학점테이블
-- 학생의 이름(student),점수(exam_01),학점(hakjum)조회하기
-- 오라클 방식
select s.name 학생명, e.total 점수,h.grade 학점
from student s, exam_01 e, hakjum h
where s.studno = e.studno
  and e.total between h.min_point and h.max_point
-- ANSI  방식
select s.name 학생명, e.total 점수,h.grade 학점
from student s join  exam_01 e
on s.studno = e.studno join hakjum h
on e.total between h.min_point and h.max_point

-- 고객이 자기 포인트 보다 낮은 포인트 상품 중 한가지를 선택
-- 할 수 있다고 할때, 산악용 자전거를 선택할 수 있는
-- 고객명,포인트, 상품명을 조회하기
select g1.gname 고객명, g1.point 포인트, g2.gname
from gogak g1, gift g2
where g1.point >= g2.g_start
 and g2.gname='산악용자전거'

select g1.gname 고객명, g1.point 포인트, g2.gname
from gogak g1 join gift g2
on g1.point >= g2.g_start
where g2.gname='산악용자전거'

 
-- 고객이 자기 포인트 보다 낮은 포인트 상품 중 한가지를 선택
-- 할 수 있다고 할때,고객이 선택할 수 있는 상품의 갯수 출력하기
-- 고객명과 선택가능한 상품 갯수 출력하기
select g1.gname 고객명, g1.point 포인트, g2.gname
from gogak g1, gift g2
where g1.point >= g2.g_start
order by 1

select * from gift
select g1.gname 고객명, count(*) 상품건수
from gogak g1, gift g2
where g1.point >= g2.g_start
group by g1.gname
order by 1
/*
 outer join
   조인조건을 만족하지 않아도 한쪽테이블의 모든 정보를 조회
   1. left outer join : 왼쪽테이블의 모든 정보 조회
      오라클방식 : 조인컬럼에 오른쪽에(+) 표시함
      ANSI 방식 : 테이블 조인시 left outer join 명시
   2. right outer join : 오른쪽 테이블의 모든 정보 조회
      오라클방식 : 조인컬럼에 왼쪽에(+) 표시함
      ANSI 방식 : 테이블 조인시 right outer join 명시
   3. full outer join : 양쪽 테이블의 모든 정보 조회.
      오라클방식 : left outer join과 right outer join을 union 함
      ANSI 방식 : 테이블 조인시 full outer join 명시
*/
-- left outer join
-- 학생의이름과 지도교수의 이름을 조회하기
-- 단 지도교수가 없는 학생도 조회하기
select s.name,p.name from student s, professor p
where s.profno = p.profno(+)

select s.name,p.name from student s left outer join professor p
on s.profno = p.profno

-- right outer join
-- 학생의이름과 지도교수의 이름을 조회하기
-- 단 지도학생이 없는 교수도 조회하기
select s.name,p.name from student s, professor p
where s.profno(+) = p.profno

select s.name,p.name from student s right outer join professor p
on s.profno = p.profno

-- full outer join
-- 학생의이름과 지도교수의 이름을 조회하기
-- 단 지도교수가 없는 학생, 지도학생이 없는 교수도 조회하기
-- 오라클방식 조인 오류 발생 => union 방식 이용
select s.name,p.name from student s, professor p
where s.profno(+) = p.profno(+)

select s.name,p.name from student s, professor p
where s.profno = p.profno(+)
union
select s.name,p.name from student s, professor p
where s.profno(+) = p.profno

select s.name,p.name from student s full outer join professor p
on s.profno = p.profno

-- 교수별로 교수이름과 지도학생수를 출력하기
-- 지도학생이 없는 교수도 조회하도록 하기
select p.name, count(s.name) from professor p, student s
where p.profno = s.profno(+)
group by p.name
order by p.name

/*
  self join : 조인되는 테이블이 같은 경우. 
              같은 테이블의 다른 컬럼을 조인컬럼으로 설정함
  --  테이블 이름은 반드시 별명을 설정해야함.
  --  조회되는 모든 컬럼은 별명을 붙여야 함
*/
select * from dept2
-- dept2 테이블에서 부서코드, 부서명, 상위부서코드,상위부서명을 출력
select d1.dcode 부서코드, d1.dname 부서명, 
       d1.pdept 상위부서코드, d2.dname 상위부서명
from dept2 d1, dept2 d2
where d1.pdept = d2.dcode
order by d1.dcode

-- dept2 테이블에서 부서코드, 부서명, 상위부서코드,상위부서명을 출력
-- 모든 부서 조회하기
-- 오라클 방식
select d1.dcode 부서코드, d1.dname 부서명, 
       d1.pdept 상위부서코드, d2.dname 상위부서명
from dept2 d1, dept2 d2
where d1.pdept = d2.dcode(+)
order by d1.dcode
-- ANSI 방식
select d1.dcode 부서코드, d1.dname 부서명, 
       d1.pdept 상위부서코드, d2.dname 상위부서명
from dept2 d1 left outer join dept2 d2
on d1.pdept = d2.dcode
order by d1.dcode

-- dept2 테이블에서 상위부서명, 하위부서의 갯수 출력
-- 모든 부서 조회하기
--오라클 방식
select d2.dname, count(d1.dcode)
from dept2 d1, dept2 d2
where d1.pdept(+) = d2.dcode
group by d2.dname
order by 2 desc
--ANSI 방식
select d2.dname, count(d1.dcode)
from dept2 d1 right outer join dept2 d2
on d1.pdept = d2.dcode
group by d2.dname
order by 2 desc

/*
   sub query : select 구문 내부에 존재하는 select 구문
    단일행서브쿼리 : 서브쿼리의 결과가 1개인 경우.
       사용가능연산자 : =,>,<,>=,<=
    다중행서브쿼리 : 서브쿼리의 결과가 여러개인 경우.
       사용가능연산자 : =,>,<,>=,<= 연산자 사용불가
                      in,[any,all]
*/
-- 단일행 서브쿼리 
--emp 테이블에서 SCOTT 사원보다 급여가 많은 사람의 이름과 급여 출력하기
select sal from emp where ename='SCOTT'
select ename,sal from emp where sal > 3000

select ename,sal from emp 
where sal > (select sal from emp where ename='SCOTT')

-- 김진욱 학생보다 높은 학년의 이름,학년,학과번호,학과명 출력하기
select s.name,s.grade,s.deptno1,d.dname
from student s, department d
where s.deptno1 = d.deptno
 and s.grade > (select grade from student where name='김진욱')
 
-- 교수테이블에서 김현정 교수보다 나중에 입사한 교수의 
-- 이름,입사일,학과명 출력하기
select p.name, p.hiredate,d.dname 
from professor p, department d
where p.deptno = d.deptno
  and hiredate >
    (select hiredate from professor where name='김현정')
    
-- 다중행 서브쿼리
select * from dept2
select * from emp2
-- emp2, dept2 테이블을 이용하여 근무지역이 서울지사인 모든사원의
-- 사번,이름,부서번호 조회하기
-- join 사용
select e.empno,e.name,e.deptno
from emp2 e, dept2 d
where e.deptno = d.dcode
 and d.area = '서울지사'
-- sub query 사용
select empno,name,deptno from emp2
where deptno in (select dcode from dept2 where area='서울지사')
--오류 : 다중행 서브쿼리에서는 =,>,< ... 연산자 사용불가
select empno,name,deptno from emp2
where deptno > (select dcode from dept2 where area='서울지사')

-- emp2 테이블에서 과장직급의 최소 연봉자보다 연봉이 높은사람의
-- 이름,직급,연봉(pay) 조회하기
select name,position,pay from emp2
where pay >
 (select min(pay) from emp2 where position = '과장')
-- 학생 각 학년의 최대키를 가진 학생의 학년과 이름 키를 출력하기
--1학년 중 최대키를 가진 학생의 이름 키 출력
select grade,name,height from student
where height = (select max(height) from student where grade = 1)
 and grade = 1
--2학년 중 최대키를 가진 학생의 이름 키 출력
select grade,name,height from student
where height = (select max(height) from student where grade = 2)
 and grade = 2 
 -- 3,4 ....
 /*
 다중컬럼 서브쿼리 : 비교대상 컬럼이 여러개인 경우
 */
 -- 1 ~ 4학년 까지 한번 조회
 select grade,name,height from student
 where (grade,height) in 
 (select grade, max(height) from student group by grade)
 
-- 교수중 학과별로 입사일이 가장 빠른 교수의 교수번호,이름,학과명 출력
-- 학과명으로 정렬하기
select p.profno,p.name,d.dname ,p.hiredate
from professor p, department d
where p.deptno = d.deptno
 and (p.deptno, p.hiredate) in
 (select deptno,min(hiredate) from professor group by deptno)
order by d.dname     
