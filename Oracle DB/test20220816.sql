--1. 2022년 8월 11일 부터 2023년 1월 16일까지  개월수를 반올림해서 소숫점이하 한자리로 출력하기
select round(months_between('20230116','20220811'),1) from dual;

--2. 교수테이블에서 교수명과 입사일, 현재연봉, 3%인상 후 연봉을 출력하기
--  단 연봉은 pay * 12로 하고, 인상후 연봉은 소숫점 이하 삭제함
select name, hiredate, pay * 12 연봉,trunc(pay * 12 *1.03) "인상 후 연봉" from professor;

--3. EMP 테이블에서 사원이름, 입사일, 근무개월수, 현재까지 근무일수를 출력하기
--     근무개월수는 소숫점이하 1자리로 반올림하여 출력하고, 근무일수는 버림하여 정수로 출력하기.
--     단, 근무일수가 많은 사람 순으로 정렬하여 출력하기
select * from emp;
select ename, hiredate, round(months_between(sysdate, hiredate)) 근무개월수, 
        trunc(sysdate - hiredate) 근무일수 
        from emp order by 근무일수 desc;
--4. EMP 테이블에서 10번 부서원의 현재까지의 근무 월수를 계산하여  출력하여라.
--    근무월수는 반올림하여 정수로 출력하기
select round(months_between(sysdate, hiredate)) "근무 월수" from emp where deptno = 10;
--5.  교수이름, 입사일, 입사년도의 휴가보상일, 올해의 휴가보상일 출력하기
--    휴가보상일 : 입사월의 마지막 일자 
select round((sysdate - hiredate) / 365)*12 from professor;
select name, hiredate, last_day(hiredate) 휴가보상일, add_months(last_day(hiredate), round((sysdate - hiredate) / 365)*12) "올해의 휴가보상일" from professor;
--6. 교수테이블에서 2000년 이전에 입사한 교수명과 입사일, 현재연봉
--  10%인상 후 연봉을 출력하기
--  단 연봉은 pay * 12로 하고, 인상후 연봉은 소숫점 이하 삭제함
--  연봉, 인상후연봉 출력시 천단위로 구분하여 ,를 넣어 출력하기
select name, hiredate, to_char(pay*12,'99,999') "현재연봉", to_char(trunc(pay*12*1.1),'99,999') "인상 후 연봉" from professor where to_number(to_char(hiredate,'yyyy')) < 2000;

--7. 교수의 이름, 부서번호와, 교수의 이름이 김도형이면 '석좌교수후보' 출력하고,
--   김도형 교수가 아니면 '출마안함' 출력하기
select * from professor;
select name, deptno, decode(name,'김도형','석좌교수후보','출마안함') 출마교수 from professor;
--8. 학생의 이름과, 체중 ,키 ,비만도를 출력하기
--  비만도 :( (실제체중 - 표준체중) / 표준체중 ) * 100
--  표준체중 : (키 - 100) * 0.9
--  비만도 10미만 은 '정상'
--         10 ~ 20미만  '과체중'
--         20이상 '비만' 으로 출력하기
select * from student;
select name, weight, height, case 
  when (((weight - ((height - 100) * 0.9)) / ((height - 100) * 0.9)))* 100 < 10 then '정상'
  when (((weight - ((height - 100) * 0.9)) / ((height - 100) * 0.9)))* 100 between 10 and 19 then '과체중'
  when (((weight - ((height - 100) * 0.9)) / ((height - 100) * 0.9)))* 100 > 19 then '비만'
end 비만도
from student;

--9. 학생을 3개 팀으로 분류하기 위해 학번을 3으로 나누어 
--   나머지가 0이면 'A팀', 1이면 'B팀', 2이면 'C팀'으로 
--   분류하여 학생 번호, 이름, 학과 번호, 팀 이름을 출력하여라
select studno, name, deptno1, case mod(studno,3) 
  when 0 then 'A팀'
  when 1 then 'B팀'
  when 2 then 'C팀'
end 팀
from student;
--10. 학생의 이름, 지도 교수 번호를 출력하여라. 
--   단, 지도 교수가 배정되지 않은 학생은 지도교수 번호를 
--   0000으로 출력하여라

select name, to_char(nvl(profno, 0),'0000') 지도교수 from student;
--11.주민등록번호를 기준으로 학생들의 이름, 사용자 아이디,
--   생년월일을 출력하여라. 
--   단, 사용자 아이디는 소문자로, 생년월일은 '1985/02/01' 형식으로 출력하여라
select name, lower(id) id,  to_char(to_date(substr(jumin,1,6),'rrmmdd'),'rrrr/mm/dd') 생년월일 from student; 

--12. 학생 테이블에서 이름, 키, 키의 범위에 따라 A, B, C ,D등급을 출력하기
--    160 미만 : A등급
--    160 ~ 169까지 : B등급
--    170 ~ 179까지 : C등급
--    180이상       : D등급

select name, height, case  
  when height < 160 then 'A등급'
  when height between 160 and 169 then 'B등급'
  when height between 170 and 179 then 'C등급'
  else 'D등급'
end 등급
from student;