/*
숫자 관련 함수
  round : 반올림 함수
          round(숫자||컬럼,숫자) : 0인경우 정수로 표시
                                 1 인경우 소숫점이하 한자리만 표시
                                 -1 인경우 10자리까지만 표시
  trunc : 버림함수 
  ceil : 근사정수. 숫자보다큰 근사정수
        ceil(숫자||컬럼) : 
  floor : 근사정수. 숫자보다 작은 근사정수
  mod : 나머지 함수. mod(숫자1,숫자2) 숫자1 에서 숫자2로 나눈 나머지
  power : 제곱 power(3,3) : 3 * 3 * 3
  abs : 절대값.
  sign : 부호 리턴. 양수:1, 음수:-1, 영:0

날짜 관련 함수  
  sysdate : 현재일시
  months_between : 두날짜 사이의 개월수
  add_months : 날짜 + 개월수 이후의 날짜 리턴
  round : 날짜관련 반올림.
  trunc : 날짜관련 버림
  next_day : next_day(날짜,요일) 다음 돌아올 요일에 해당하는 날짜를 리턴.
     요일 : 1:일,2:월,...7:토
  last_day : last_day(날짜). 날짜의 월의 마지막 날자 리턴
 
 변환함수
 to_char : 날짜=>문자열, 숫자=>문자열 
       패턴: 날짜인경우=>yyyy,mm,dd,hh .......
            숫자인경우=> 9, 0,  ,(천단위콤마), .(소숫점표시) 
 to_number : 숫자형문자 => 숫자. 
 to_date : 문자열=>날짜  패턴: 날짜인경우=>yyyy,mm,dd,hh .......
 
일반함수
  nvl : nvl(컬럼,기본값) : 컬럼의 값이 null인 경우는 기본값으로 치환.
  조건함수                       
    decode : decode(컬럼,값,참인경우,거짓인경우)
    case 조건값
       when  값  then 문자열
       ...
       else 문자열 end 

    case 
      when  조건문  then 문자열
         ...
      else 문자열 end 
*/
/*
  그룹함수 : 복수행 함수
            여러행에 대한 정보를 조회하는 함수
   count() : 레코드 건수. null값 제외한 건수         
*/
-- 교수 테이블에서 교수전체의 인원수와 교수중 보너스받는 교수의 인원수
-- 조회하기
--count(bonus) : bonus 컬럼의 값이 null이 아닌 레코드 갯수
select count(*) 전체인원수, count(bonus) 보너스를받는인원수,
       count(*)-count(bonus) 보너스없는인원수
from professor;

select * from professor where bonus is null;



-- 학생의 전체인원수와 지도교수가 배정된인원수, 지도교수가 없는 인원수
-- 조회하기
select count(*) 학생수, count(profno) 배정된인원수,
       count(*)-count(profno) 배정안된인원수
from student       ;

-- 학년별 학생의 인원수 조회하기
select grade, count(*) from student
group by grade
order by grade
-- group by : 컬럼의 값을 기준으로 레코드를 그룹화
--            그룹함수와 컬럼의값을 조회하기 위해서는 반드시
--            조회되는 컬럼으로 group by를 설정해야 함
-- 학과1(deptno1)별 학생의 인원수 조회하기
select deptno1,count(*) from student
group by deptno1
order by deptno1
-- 학생의 학년별 전체인원수, 지도교수가 배정된인원수를 조회하기
select grade, count(*), count(profno) from student
group by grade

-- 교수 중 직급(position)별 교수의 인원수 조회하기
-- 인원수가 많은 순으로 정렬하기
select position,count(*) from professor
group by position
order by count(*) desc

select position,count(*) from professor
group by position
order by 2 desc

-- sum():합계 
-- avg():평균
-- 교수들에게 지급되는 전체 급여 합계 출력하기
select sum(pay) from professor
-- 교수들에게 지급되는 부서(deptno)별 전체 급여 합계 출력하기
-- 급여합계가 많은 순으로 정렬
select deptno,sum(pay) from professor
group by deptno
order by sum(pay) desc

-- 교수들에게 지급되는 부서(deptno)별 전체 급여 합계,급여평균 출력하기
-- 급여평균이 많은 순으로 정렬
select deptno,sum(pay) 합계, avg(pay) 평균 from professor
group by deptno
order by 평균 desc
--교수의 부서별 인원수, 급여평균,보너스평균 조회하기
-- 모든 그룹함수는 null 제외함. 평균산출에서도 null값은 제외됨.
-- 100,null,50,50 => 200/3 => 평균값으로 계산됨. 
--                   200/4 => 평균값에서도 null 포함되는 경우
select deptno,count(*),avg(pay),avg(bonus),avg(nvl(bonus,0)) 
from professor
group by deptno

select name,bonus from professor where deptno=103
-- 문제
--1. 학생의 학년별 키와 몸무게 평균출력하기. 학년별로 정렬
select grade,avg(height),avg(weight) from student
group by grade
order by grade
--2. 교수들에 지급되는 부서별 연봉의 합과 평균 구하기
-- 연봉:급여*12+보너스.
-- 합 과 평균은 세자리마다 , 표시하고,반올림하여 정수로 출력하기
-- 보너스가 없는 경우는 0으로 처리한다.
select deptno,to_char(sum(pay*12+nvl(bonus,0)),'99,999') 합,
       to_char(round(avg(pay*12+nvl(bonus,0))),'9,999') 평균
from professor
group by deptno
-- max(),min() : 최대값,최소값
-- 학생 중 가장 키가 큰학생의 키와, 가장 작은 학생의키, 평균키 조회하기
select max(height),min(height),avg(height) from student
-- 학과별 학생 중 가장 키가 큰학생의 키와, 
--  가장 작은 학생의키, 평균키 조회하기
select deptno1,max(height),min(height),avg(height) from student
group by deptno1
-- having  구문 : 그룹함수의 조건문
-- 학년별 학생 중 키가큰학생의 키와 가장작은학생의 키, 평균키를 조회하기
-- 평균키가 170이상인 학년만 조회하기
select grade,max(height),min(height),avg(height) from student
group by grade
having avg(height) >= 170
/*
  select 컬럼명들 || *(모든컬럼) from 테이블명 => 필수
  [where  조건문]  => 레코드 선택의 조건
  [group by 컬럼]  => 그룹함수사용시 그룹화 기준 컬럼
  [having 조건문]  => 그룹함수의 조건문
  [order by 컬럼명||별명||컬럼순서 [asc|desc]]
*/ 
-- 1.주민번호를 기준으로 남학생와 여학생의 
--   최대키, 최소키, 평균키를 출력하기
--   주민번호의 7번째 자리가 1:남학생, 2:여학생
select decode(substr(jumin,7,1),1,'남학생',2,'여학생') 성별,
     max(height),min(height),round(avg(height),2)
from student
group by substr(jumin,7,1);
-- 1.주민번호를 기준으로 여학생의 
--   최대키, 최소키, 평균키를 출력하기
--   주민번호의 7번째 자리가 1:남학생, 2:여학생
select decode(substr(jumin,7,1),1,'남학생',2,'여학생') 성별,
     max(height),min(height),round(avg(height),2)
from student
where substr(jumin,7,1) = 2
group by substr(jumin,7,1)

select max(height),min(height),round(avg(height),2)
from student
where substr(jumin,7,1) = 2

select * from gogak
--1. 주민번호 기준 월별 인원수 조회하기
select substr(jumin,3,2) 월, count(*)  갯수 from gogak
group by substr(jumin,3,2)
order by 월

select substr(jumin,3,2), count(substr(jumin,3,2)) 갯수 from gogak
group by substr(jumin,3,2)

--2. 주민번호 기준 성별 인원수 조회하기
select case substr(jumin,7,1)
        when '1' then '남성'
        when '2' then '여성' end 성별,
     count(*) from gogak
group by substr(jumin,7,1)
order by 성별

-- stddev() : 표준편차 함수
-- variance() : 분산함수
select stddev(height) 키편차, stddev(weight) 체중편차,
       variance(height) 키분산, variance(weight) 체중분산
from student       
-- 1. 학생들의 전화번호의 지역번호 조회하기
select distinct substr(tel,1,instr(tel,')')-1) from student;
-- 전화번호의 지역번호 기준으로 학생수 출력하기
-- 학생 수가 3명이상인 지역 조회하기
select substr(tel,1,instr(tel,')')-1), count(*) from student
group by substr(tel,1,instr(tel,')')-1)
having count(*) >= 3
-- 지역번호별로 인원수 조회하기. 가로출력
select count(*) 합계,
sum(decode(substr(tel,1,instr(tel,')')-1),'02',1,0)) "02",
sum(decode(substr(tel,1,instr(tel,')')-1),'031',1,0)) "031",
sum(decode(substr(tel,1,instr(tel,')')-1),'051',1,0)) "051",
sum(decode(substr(tel,1,instr(tel,')')-1),'053',1,0)) "053",
sum(decode(substr(tel,1,instr(tel,')')-1),'055',1,0)) "055"
from student

select name,tel,
decode(substr(tel,1,instr(tel,')')-1),'02',1,0) "02",
decode(substr(tel,1,instr(tel,')')-1),'031',1,0) "031",
decode(substr(tel,1,instr(tel,')')-1),'051',1,0) "051",
decode(substr(tel,1,instr(tel,')')-1),'053',1,0) "053",
decode(substr(tel,1,instr(tel,')')-1),'055',1,0) "055"
from student

--rownum : 레코드 조회 순서. 1부터 읽을 수 있다.
--    order by 구문 이전에 미리 설정. order by 구문으로 값 변경 안됨
--    그룹함수에서 사용불가
--rowid : 레코드를 구분할 수 있는 고유의 id. 
--        rowid가 다른 경우는 다른 레코드임.
select name,grade,rownum,rowid from student
-- 학생 정보를 5건만 조회하기
select * from student where rownum <= 5 
-- 학생 테이블의 rownum값이 6이상인 레코드 조회하기
select * from student where rownum > 5 
-- 학생이름,학년, 레코드순서를 조회하기.
-- 학생의 이름순으로 정렬
select name,grade,rownum from student
order by name
-- 학생의 학년별 인원수,레코드 순서 조회하기 
--   -> 오류 발생. 그룹함수에서 사용불가
select grade,count(*) , rownum from student
group by grade

------------------------------------
- join : 여러개의 테이블을 연결하여 조회.
------------------------------------
-- cross join (카티션곱) : 사용시 주의
-- 두개의 테이블의 모든 레코드의 곱의 갯수로 레코드 조회됨.
-- 조회되는 레코드 갯수가 두테이블의 레코드의 곱이므로 사용시 주의함.
select count(*) from emp  -- 14건
select count(*) from dept --  4건
select * from emp
select * from dept
select * from emp,dept  -- cross join. 14 * 4 = 56
--두개테이블의 컬럼명이 같은 경우 반드시 테이블명을 명시해야 함.
-- 컬럼이 다른경우 테이블명을 생략할 수 있다
select emp.ename,emp.deptno,dept.deptno,dname from emp,dept
--테이블명을 별명을 지정할 수 있다
-- 오라클 조인 방식
select e.ename,e.deptno,d.deptno,d.dname from emp e,dept d
-- ANSI 조인방식
select e.ename,e.deptno,d.deptno,d.dname 
from emp e cross join dept d

-- 등가조인(Equi join) : 두개의 테이블을 연결해주는 컬럼으로 레코드
--                      조회. 연결컬럼의 값이 같은 경우 연결
-- 학생테이블(student), 학과테이블(department)를 사용하여
-- 학생이름,전공학과1, 전공학과이름 출력하기
select name,deptno1 from student
select * from department
-- 오라클 방식
select s.name,s.deptno1,d.dname 
from student s, department d
where s.deptno1 = d.deptno
-- ANSI 방식
select s.name, s.deptno1,d.dname
from student s join department d
on s.deptno1 = d.deptno

--emp테이블의 사원이름,부서코드(deptno)와 dept테이블의 부서이름 조회하기
--오라클 방식
select e.ename,e.deptno,d.dname
from emp e,dept d
where e.deptno = d.deptno
-- ANSI 방식
select e.ename,e.deptno,d.dname
from emp e join dept d
on e.deptno = d.deptno

-- 학생테이블과교수테이블을 이용하여 학생의이름,지도교수번호,지도교수이름
-- 조회하기. 지도교수가 없는 학생은 조회하지 않는다.
select s.name, p.profno, p.name from student s, professor p where s.name = '오나라'
and s.profno = p.profno;

select s.name, p.profno, p.name from student s join professor p on s.name = '오나라'
and s.profno = p.profno;

-- 학생의 이름, 학과 이름, 지도교수이름을 조회하기
select s.name 학생이름, d.dname 학과이름, p.name 지도교수이름
from student s, department d, professor p
where s.deptno1 = d.deptno and s.profno = p.profno;