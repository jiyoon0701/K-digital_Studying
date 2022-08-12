/*
연산자
  연결연산자 : ||
  산술연산자 : + - * /
  
  where 조건문에서 사용되는 연산자
  비교연산자 : =(같다), >, <, >=, <=
*/

-- distinct : 중복제거
-- 교수가 속한 부서코드(deptno) 조회하기
select distinct deptno from professor;

-- 교수가 속한 직급과 부서코드를 조회하기
select distinct position, distinct deptno from professor; -- 이건 오류 발생 distinct는 한번만 사용
select distinct position, deptno from professor;

-- between 연산자
-- where 컬럼명 between A and B : 컬럼의 값이 A이상 B이하인 값
-- where 컬럼명 >=A and 컬럼명 <= B

-- 학생의 몸무게가 60이상 80이하인 학생의 이름, 몸무게, 학년 조회하기
select name, weight, grade from student where weight between 70 and 80; -- 이 방법이 가독성(보기 쉬우)이 좋다.
select name, weight, grade from student where weight >= 70 and weight <= 80;

-- 교수의 급여(pay)가 300이상 500이하인 교수의
-- 교수번호, 이름, 급여, 보너스 출력하기
desc professor;
select profno, name, pay, bonus from professor where pay between 300 and 500;
select profno, name, pay, bonus from professor where pay >= 300 and pay <= 500;

-- in 연산자 : 조회 대상이 되는 값을 선택
-- 학생 중 101 학과, 201 학과 학생의 이름, 부서코드, 학년 출력하기
select name, deptno1, grade from student where deptno1 = 101 or deptno1 = 201;
select name, deptno1, grade from student where deptno1 in (101, 201);

-- 문제 : 101, 201 학과 학생 중 키가 170이상 180이하인 학생의 학번, 이름, 몸무게, 키 학과코드, 조회하기
select studno, name,weight, height, deptno1 from student where deptno1 in (101, 201) and height between 170 and 180;

-- like 연산자
-- % : 임의의 문자 0개 이상
-- _: 임의의 문자 1개
-- 학생 중 이름에 '진'글자를 가진 학생의 이름과 부서코드 조회하기
select name, deptno1 from student where name like '%진%';
-- 학생 중 성씨가 김 학생의 이름과 부서코드 조회하기
select name, deptno1 from student where name like '김%';
-- 학생 중 이름이 두자인 학생의 이름과 부서코드 조회하기
select name, deptno1 from student where name like '__';
-- not like 연산자
-- 학생 중 성이 김이 아닌 학생의 학번, 이름, 학과코드 조회하기
select studno, name, deptno1 from student where name not like '김%';
-- not in 연산자
-- 사원테이블에서 부서코드가 10, 30이 아닌 부서에 근무하는 사원의 이름, 부서코드, 급여 조회하기
select ename, deptno, sal from emp where deptno not in (10, 30);

-- null : 값이 없음. 비교대상 아님, 연산 대상도 아님
-- 교수 중 상여금이 없는 교수의 교수번호, 이름, 급여, 보너스를 조회하기
select profno, name, pay, bonus from professor where bonus = null; -- 결과 없음
-- is null , is not null
select profno, name, pay, bonus from professor where bonus is null; -- 보너스가 null인 값을 가져와라
select profno, name, pay, bonus from professor where bonus is not null; -- 보너스가 null이 아닌 값을 가져와라

-- 교수의 교수번호, 이름, 급여, 상여금, 합계(급여 + 상여금) 출력하기
select profno, name, pay, bonus , pay + bonus "합계" from professor;

/*
order by : 정렬하기. select 구문의 마지막에 작성해야함.
[order by 컬럼명 [asc|desc]] : asc(오름차순, 생략 가능), desc(내림차순)

[group by 컬럼명] : 그룹함수에서 다시 설명
[having 조건문] : 그룹함수의 조건문
*/
-- 1학년 학생의 이름, 키를 조회하기 단, 키가 작은 순으로 출력
select name, height from student where grade = 1 order by height asc;

-- 학생의 이름, 키, 몸무게, 학년을 조회하기
-- 단 학년 순, 키가 큰 순, 몸무게 작은 순으로 조회
select name, height, weight, grade from student order by grade asc, height desc, weight;

select name, height, weight, grade from student order by 4, 2, 3; -- 숫자는 조회되는 컬럼의 순서

-- 문제 : 교수의 급여를 10% 인상 예정임. 교수번호, 교수 이름, 학과코드, 급여, 예상급여(10% 인상) 조회하기
-- 단 학과코드 순으로 예상급여의 역순으로 조회하기
desc professor;
select profno, name, deptno, pay, pay * 1.1 "예상급여" from professor order by deptno, 예상급여 desc;

-- 문제2 : 학생테이블에서 지도교수가 배정되지 않은 학생의 학번, 이름, 지도교수번호, 학과코드 출력
-- 단 학과코드 순으로 정렬하기
desc student;
select * from student;
select studno, name, profno, deptno1 from student where profno is null order by deptno1;

/*
합집합 : union, union all
union : 합집합. 중복되는 결과가 있다면 중복을 제거함
union all : 합집합. 두개의 쿼리 결과를 합하여 출력함. 중복데이터 조회
두개 쿼리의 결과 컬럼의 개수가 같아야한다.
*/
-- 교수중 상여금이 있는 경우는 급여합계(급여 + 상여금)
-- 상여금이 없는 경우는 급여합계(급여)로 조회하기
-- 교수의 교수번호, 이름, 부서코드, 급여, 급여합계를 출력하기
-- 부서코드 순으로 정렬하기
select profno, name, deptno, pay, pay + bonus 급여합계 from professor where bonus is not null
union
select profno, name, deptno, pay, pay from professor where bonus is null order by deptno;

select profno, name, deptno, pay, pay + bonus 급여합계 from professor where bonus is not null
union all
select profno, name, deptno, pay, pay from professor where bonus is null order by deptno;

-- 문제
desc student;
-- 101 학과 학생의 학번, 이름, 학과번호1와
-- 101 학과 교수의 교수번호, 이름, 학과번호를 출력
select studno, name, deptno1 from student where deptno1 = 101
union all
select profno, name, deptno from professor where deptno = 101

/*
 단일행 함수
  - 문자함수 : 대문자변경, 소문자변경....
  - 숫자함수 : 반올림, 버림, ....
  - 날짜함수 : 개월수, ...
  - 변환함수 : 문자 -> 날짜형태, 문자 -> 숫자
  - 일반함수 : null 값 처리, 조건 함수...
*/

desc professor
select * from professor
where deptno = '101'

-- 문자함수
-- 대소문자 변환함수
-- initcap : 첫문자만 대문자로 변환
-- upper : 대문자로 변환
-- lower : 소문자로 변환
-- 학과 번호1이 101학과 학생의 이름, id를 출력하기
-- id는 첫문자만 대문자로, 전부 대문자 , 전부 소문자로 출력하기
select name, id, initcap(id), upper(id), lower(id) from student where deptno1 = 101;

-- emp 테이블에서 사원의 이름이 smith인 사원의 이름, 급여, 부서코드 조회하기
-- smith이름은 대소문자 상관없이 조회하도록 함
select ename, sal, deptno from emp where lower(ename) = 'smith';
-- smith값을 입력 받아야 할 때
select ename, sal, deptno from emp where lower(ename) = lower('smith');

-- 문제 : 학생 중 id값에 M문자를 가지고 있는 학생의 이름, id, 학과번호1을 조회
-- 단, id의 내용은 대소문자 상관없이 조회가 되어야한다.
select name, id, deptno1 from s tudent where upper(id) like '%M%';

-- 문자열의 길이
-- length : 문자열길이
-- lengthb : 필요한 바이트수.
-- 한글 저장시 3바이트가 필요함 => 시스템별로 다르다.
select name, length(name), lengthb(name) from student;
select name, length(name), lengthb(name), id, length(id), lengthb(id) from student;

-- dual 테이블 : 더미테이블. 오라클에서만 의미없는 테이블로 사용할 수 있도록 생성된 테이블
select lengthb('홍길동') from dual;

-- substr : 부분문자열 함수
-- substr(컬럼명, 1부터 시작하는 시작 인덱스, 글자수)
-- substr(컬럼명, 음수 시작 인덱스(뒤부터), 글자수)
--  시작인덱스 : -1 => 뒤에서 첫번째
--             -2 => 뒤에서 두번째
-- 오라클은 인덱스가 1부터 시작한다.
select substr('안녕 나는 홍길동이야',7,3) from dual;
-- 학생 중 생일이 3월인 학생의 이름, 생년월일 조회하기
-- 생일은 주민번호를 기준으로 한다.
select name, substr(jumin, 1, 6) 생년월일 from student where substr(jumin, 3, 2) = '03';

-- 학생의 이름, 생년월일 조회하기. 생년월일은 주민번호를 기준으로 한다.
-- 생일의 월을 기준으로 정렬하여 출력하기
select name, substr(jumin,1,6) 생년월일 from student order by substr(jumin, 3, 2) 
-- 음수면 인덱스가 뒤에서부터 시작
select name, substr(jumin,-13,6) 생년월일 from student order by substr(jumin, 3, 2) 

-- instr : 문자열(컬럼값)에서 해당 문자의 위치값 리턴 
select instr('A*B*C','*') from dual;
-- insrt(문자열, '찾을문자값', [시작인덱스, 번째])
-- instr : 문자열(컬럼값)에서 해당문자의 위치값 리턴
-- 'A*B*C'에서 첫번째 '*'문자의 위치 리턴 :2

select instr('A*B*C','*') from dual;
-- 'A*B*C'에서 두번째 '*'문자의 위치 리턴 :4
select instr('A*B*C','0') from dual;
-- 'A*B*C'에서 '0'문자의 위치 리턴 : 0. 문자검색실패
-- 결과 : 0 -> 해당 문자 없음

select instr('A*B*C','*',1,2) from dual;
-- 인덱스 1부터 찾기 시작 2번째 별 찾기
-- 'A*B*C'문자열에서 '*'문자를 뒤부터 4번째 인덱스부터 검색하여 1번째 있는 위치 리턴 : 4

select instr('A*B*C','*',1,3) from dual;
-- 'A*B*C'문자열에서 3번째 '*'문자위치 리턴 : 0
-- 결과 : 0 -> 해당 문자 없음

select instr('A*B*C','*',-4) from dual;
-- 'A*B*C'문자열에서 '*'문자를 뒤부터 1번째 인덱스부터 검색하여 2번째 있는 위치 리턴 : 4
select instr('A*B*C','*',-1,1) from dual;

-- 학생테이블에서 이름,전화번호(tel),tel ) 컬럼의 문자의 위치를 출력하기
select name,tel,instr(tel,')') from student; 

-- 문제 : 학생테이블에서 이름, 전화번호, 지역번호를 출력하기
-- 지역번호 : 055)123-4567 055가 지역번호
-- instr(tel, ')') : ) 의 위치값
-- substr(컬럼명, 시작인덱스, 글자 개수)
select name, tel, substr(tel,1,instr(tel,')')-1) 지역번호 from student;

-- 문자추가함수 (자리 수를 채워주는)
-- lpad : 왼쪽에 문자 추가 
--        lpad(문자열(컬럼), 전체자리 수, 왼쪽 채워지는 문자)
-- rpad : 오른쪽에 문자 추가
--        rpad(문자열(컬럼), 전체자리 수, 오른쪽 채워지는 문자)
-- 학생의 id를 10자리로 출력하기
-- 빈자리는 왼쪽에 $로 채워, 이름과 학년, id 출력하기
select name, grade,lpad(id, 10, '$') from student;

-- 문자 제거하기 : ltrim, rtrim, trim
-- ltrim : 왼쪽에 지정된 문자를 제거
--        ltrim(컬럼, 제거할문자), 제거할 문자가 생략되는 공백
-- rtrim : 오른쪽에 지정된 문자를 제거
--        rtrim(컬럼, 제거할문자), 제거할 문자가 생략되는 공백
-- trim : 양쪽에 공백을 제거

-- 교수테이블에서 hpage 컬럼의 http:// 문자를 제거하여 url 만 출력하기
-- 교수이름, hpage, url 컬럼 출력
select name, hpage, ltrim(hpage, 'http://') url from professor where hpage is not null;
select hpage is not null
select ltrim('   AAAAA      ') a from dual
select rtrim('   AAAAA      ') a from dual
select trim('   AAAAA      ') a from dual

-- 문자열 치환함수 : replace
-- replace(컬럼명, '문자1', '문자2') : 컬럼의 값을 문자1을 문자2로 치환
select replace('1234','12','ab') from dual;

-- 문제. 학생테이블에서 학생의 이름의 첫자만 #이라는 문자열로 치환
select replace(name, substr(name,1,1),'#') , grade from student;