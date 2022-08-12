-- select : 테이블에 저장된 데이터 조회하는 명령문
-- select * : (모든 컬럼) from 테이블
-- where 조건문 >= row(행)선택의 조건, where 구문이 없는 경우 모든 레코드를 조회

-- emp테이블의 모든 컬럼과 모든 행 조회하기
select * from emp;

-- desc : 테이블의 구조(스키마) 조회 명령어
-- emp 테이블의 구조 조회하기
desc emp;

-- emt 테이블의 모든 행의 이름(ename), 번호(empno) 컬럼만 조회하기
select ename, empno from emp;

-- emp 테이블의 번호(empno), 이름(ename), 부서코드(deptno) 컬럼만 모든 행 조회하기
select empno, ename, deptno from emp;

-- 리터널(상수, 문자열)을 컬럼으로 생성하기
select empno, ename, 'very good ~~~' from emp;

-- 문제 : 교수테이블(professor)에서 교수번호(profno), 교수이름 (name) 컬럼을 조회
-- 교수이름 뒤에 '교수'라는 리터널 추가하기
select * from professor;
select profno, name, '교수' from professor;

-- 컬럼에 별명(alias)주기
-- professor 테이블의 name 컬럼을 교수이름, profno 컬럼을 교수번호로 조회하기
select name 교수이름, profno 교수번호 from professor;
-- 별명 사이에 공백을 추가하고 싶다면?
select name "교수 이름", profno "교수 번호" from professor;
select name as "교수 이름", profno as "교수 번호" from professor;

-- 문제 : emp테이블에서 empno는 사원번호로, ename 사원명, job은 직업으로 별명을 설정하여 조회
select empno 사원번호, ename 사원명, job 직업 from emp;

-- 컬럼에 사용되는 연산자
-- 연결연산자 : ||  
select name || position as 교수 from professor;

-- name 님은 position입니다. 형태로 교수정보 조회하기
select name || '님은' || position || '입니다.' 교수 from professor;
-- 산술연산자 : +, -, *, /
-- emp 테이블에서 사원의 급여를 10% 인상하기로 함.
-- 사원이름 (name), 현재급여(sal), 인상예상급여 조회
select ename 사원이름, sal 현재급여, sal*1.1 인상예상급여 from emp;

-- 문제 : 교수테이블(professor)에서 교수이름(name), 급여(pay), 연봉(pay*12)
-- 컬럼을 조회하기
select name 교수이름, pay 급여, pay * 12 연봉 FROM professor;

-- 행을 선택하기
-- where 조건문

-- 교수테이블에서 교수번호가 1001번인 교수의 모든 컬럼을 조회
select * from professor where profno = 1001;

-- 학생테이블(student) 테이블에서 1학년 학생의 모든 컬럼을 조회하기
-- 학년 컬럼(grade)
select * from student where grade = 1;

-- 문제 : 학생테이블(student) 테이블에서 1학년 학생의 학번(studno), 이름(name), 학년(grade) 컬럼을 조회하기
select studno, name, grade from student where grade = 1;

-- 문제 2 : 사원테이블에서 급여(sal)가 4000보다 큰 사람의 이름과 급여 조회하기
desc emp;
select ename, sal from emp where sal > 4000;

-- emp 테이블에서 사원의 급여를 10% 인상을 하기로함
-- 인상예상급여가 1000 미만인 사원의 이름, 현재급여, 인상예상급여 조회
select ename, sal, sal*1.1 from emp
where sal*1.1 < 1000;