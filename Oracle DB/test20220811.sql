--1. 교수테이블(professor)의 전체 내용 출력하기
select * from professor;

--2. 교수테이블에서 교수이름(name), 학과코드(deptno)를 출력하기
select name, deptno from professor;

--3. dept테이블 deptno 부서#, dname 부서명, loc 부서위치 로 별명을 설정 하여 출력하기
select deptno 부서#, dname 부서명, loc 부서위치 from dept;

--4. 학생 테이블(student)에서 name, birthday, height, weight 컬럼을 출력하여라.
--단, name은 이름, birthday는 생년월일, height는 키(cm),weight 몸무게(kg) 으로 별명 주기
select name 이름, birthday 생년월일, height "키(cm)", weight "몸무게(kg)" from student;

--5. 학생테이블에서 학생의 이름 앞에 'grade 학년 학생'을 붙여서 출력하기
--    1학년 학생 홍길동 
select grade || '학년 학생 ' || name as "학년 학생" from student where grade = 1;
--6. 교수테이블에서 이름(name)과 직급(position) 사이에 공백 추가하여 출력하기
--   김명선 전임강사
select name ||' '||position as "이름 직급" from professor; 

--7. 학생테이블(student)에서 '학생이름(name) 의 키는 180(height) cm, 몸무게는 80(weight) kg 입니다.' 
--  라는 형식으로  출력하도록 sql구문 작성하기. 컬럼별명은 키와몸무게로 한다.
--  홍길동의 키는 180 cm, 몸무게는 80 kg 입니다. 
select name || '의 키는 ' || height || ' cm, 몸무게는 ' || weight || ' kg 입니다.' as "키와몸무게" from student;

-- 8. 사원의 급여가 3000 이하인 사원들만 급여를 5%인상하기로 한다. 
--    인상예정인 사원의
--    사원번호, 사원이름, 현재급여, 인상예상급여, 부서코드를 출력하기
desc emp;
select empno, ename, sal, sal * 1.05 인상예상급여, deptno  from emp where sal <= 3000;

--9. 사원의 이름이  SCOTT  인 사원의 이름,사원번호, 급여, 급여+100 조회하기
select ename, empno, sal, sal + 100 인상급여 from emp where ename = 'SCOTT';

--10.학생의 이름이 홍길동인 학생의 모든 컬럼을 조회하기
select * from student where name = '홍길동';

