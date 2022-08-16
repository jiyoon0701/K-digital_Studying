--1. 학생 테이블에서 학생 이름과 키,몸무게, 표준체중을 출력하기
-- 표준 체중은 키에서 100을 뺀 값에 0.9를 곱한 값이다.
select name, height, weight, (height - 100) * 0.9 표준체중 from student;
--2. 101 번 학과 학생 중에서 3학년 이상인 학생의 이름, 아이디, 학년을 출력하기
select name, id, grade from student where deptno1 = 101 and grade >=3;
--3. 키가  165 이상 175 이하인 학생의 이름, 학년, 키를 출력하여라.
select name, grade, height from student where height between 165 and 175;
--4. 학생 중 이름의 끝자가 '훈'인 학생의 학번, 이름, 부서코드 출력하기
desc student;
select * from student;
select studno, name, deptno1 from student where name like '%훈';
--5.  학생 중 전화번호(tel)가 서울지역인 학생의 이름, 학번, 전화번호 출력하기 
select name, studno, tel from student where substr(tel,1,2) = '02';
select name, studno, tel from student where tel like '02%';
--6. 학생 중  id에 'M'문자를 가지고 있는 학생의 이름,  id,  학과번호1을 출력하기
-- 대소문자 구분 x
select name, id, deptno1 from student where upper(id) like '%M%';

--7. 학생 테이블에서 학년이 2학년과 3학년이고, 학과가 101이거나 201인 학생의
--    학번, 이름, 학년, 학과를 출력하기.
--     단  between  과  in 연산자를 사용하여 출력하기
select studno, name, grade, deptno1 from student where grade between 2 and 3 and deptno1 in ('101', '201');

--8. EMP 테이블에서 급여가 1300에서 1700 사이인 사원의 성명, 업무, 급여, 부서번호(deptno)를 출력하여라.
select * from EMP;
select ename, job, sal, deptno from emp where sal between 1300 and 1700;

--9. EMP테이블에서 사원번호(empno)가 7902, 7788, 7566 인 사원의 사원번호, 성명, 업무(job), 급여, 입사일자(hiredate)를 출력하여라.
select empno, ename, job, sal, hiredate from emp where empno in ('7902', '7788', '7566');

--10. EMP테이블에서 입사일자가 92년도에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where substr(HIREDATE,1,2) = '92';

--11. EMP 테이블에서 이름의 첫 글자가 ‘M’인 사원의 이름, 급여를 조회하라.
select ename, sal from emp where substr(ename,1,1) = 'M';

--12. EMP 테이블에서 이름의 두 번째 글자가 ‘L’인 사원의 이름, 업무를 조회하라.
select ename, job from emp where substr(ename,2,1) = 'L';
select ename, job from emp where ename like '_L';
--13. EMP 테이블에서 보너스(comm)가 NULL인 사원의 사원번호, 이름, 업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where comm is null;

--14. EMP 테이블에서 급여가 1100 이상이고, JOB이Manager인 사원의 
-- 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where sal >= 1100 and initcap(JOB) = 'Manager';

--15. EMP 테이블에서 급여가 1100 이상이거나, 이름이 M으로 시작하지 않는 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where sal >= 1100 and ename not like 'M%';

--16. EMP 테이블에서 JOB이 Manager, Clerk, Analyst가 아닌 사원의 사원번호, 성명, 업무, 급여, 부서번호를 출력하여라.
select empno, ename, job, sal, deptno from emp where initcap(job) not in('Manager', 'Clerk', 'Analyst');

--17. EMP 테이블에서 JOB이 PRESIDENT이고 급여가 1500 이상이거나 업무가 SALESMAN인 사원의 사원번호, 이름, 업무, 급여를 출력하여라
select empno, ename, job, sal from emp where (sal >= 1500 and job = 'PRESIDENT') or job = 'SALESMAN';

--18. 교수 테이블에서 급여가 450 이상인 경우는 5%를 인상하고 450 미만인 경우는 10%가 인상되도록
--교수번호, 교수이름, 현재급여, 인상예정급여 을 출력하기
-- 인상예정 급여의 내림차순으로 정렬하기
select * from professor;

select profno, name, pay, pay * 1.05 인상예정급여 from professor where pay >= 450
union
select profno, name, pay, pay * 1.1 인상예정급여 from professor where pay < 450 order by 인상예정급여 desc;

--19.학생 테이블에 1학년 학생의 이름과 주민번호기준생일,
-- 키와 몸무게를 출력하기. 
--  단 생일이 빠른 순서대로 정렬
select * from student;
select name, substr(jumin,3,4) 주민번호기준생일 , height, weight from student where grade = 1 order by substr(jumin,3,4);

--20. 교수테이블(professor)급여가 300 이상이면서 
--   보너스(bonus)을 받거나 
--   급여가 450 이상인 교수 이름, 급여, 보너스을 출력하여라.
select * from professor;
select name, pay, bonus from professor where (pay >= 300 and bonus is not null) and pay >= 450;

--21. 201번 학과에 소속된 교수와 학생의 번호와 이름을 출력하여라.
select * from student;
select * from professor;

select name, studno  from student where deptno1 in ('201')
union
select name, profno from professor where profno in ( select profno from student where deptno1 in ('201') );

--22. 교수테이블에서 교수의 성이 ㅈ이 포함된  교수의 이름 출력하기 (between 연산자 사용)
select name from professor where substr(name,1,1) between '자' and '짛';

--23. EMP 테이블에서 부서번호(deptno)로 정렬한 후 부서번호가 같을 경우 급여(sal)가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라.
select * from emp;
select empno, ename, job, deptno, sal from emp order by 4, 5 desc;

--25. 1학년 학생중 몸무게가 60kg보다 작은 학생과  3학년 학생중 키가 170보다 큰 학생의 학번, 이름, 키,몸무게를 출력하라.
select * from student;
select studno, name, height, weight from student where (grade = 1 and weight < 60) or (grade = 3 and height > 170);

--26. 교수테이블에서 교수번호, 교수이름, 학과코드, 급여, 보너스, 연봉을 출력하기
-- 연봉은 보너스가 있는 경우 pay * 12 + bonus로 계산하고,
-- 보너스가 없는 경우는 pay * 12로 계산하여 출력하기
-- 단 학과코드로 정렬하고, 연봉이 큰순으로 정렬하기
select * from professor;

select profno, name, deptno, pay, bonus, pay * 12 + bonus 연봉 from professor where bonus is not null
union
select profno, name, deptno, pay, bonus, pay * 12 연봉 from professor where bonus is null order by deptno, 연봉 desc;

--27. emp테이블에서 사원번호, 사원명, 급여를 출력하는데 부서코드(deptno)가 10인 부서 제외하여 출력하기
select * from emp;
select empno, ename, sal from emp where deptno not in (10);

--28. 학생의 id의 길이가 7개이상 10개 이하인 학생의  
--    학번, 이름, id, id의 글자수를 출력하기
select studno, name, id, length(id) "id 글자수" from student where length(id) between 7 and 10;

--29. 학생의 생년월일을 '98년 03월 20일' 의 형식으로,
--   이름과 생년월일을   월로 정렬하여 출력하기.
--   단 생년월일은 주민번호(jumin)을 기준으로 한다.
select * from student;
select name, substr(jumin,1,2) || '년 ' || substr(jumin,3,2) || '월 ' || substr(jumin,5,2) || '일' 생년월일 from student order by substr(jumin,3,2);

--30. EMP 테이블에서 scott의 사원번호, 성명, 담당업무(소문자로),  담당업무(대문자로), 첫 글자만 대문자로 변환하여 출력하여라.
select empno, ename, lower(job) "담당업무(소문자)", upper(job) "담당업무(대문자)" , initcap(job) from emp where lower(ename) = 'scott';
--31. EMP 테이블에서 이름의 첫 글자가 ‘K’보다 큰 사원의 사원번호,  이름, 업무를 출력하여라.
select empno, ename, job from emp where upper(substr(initcap(ename),1,1)) >= 'K';

--32 EMP 테이블에서 이름이 6자리 이상인 사원의 이름과 업무를  출력하여라.
select ename, job from emp where length(ename) >= 6;