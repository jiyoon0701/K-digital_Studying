-- 숫자관련 함수
-- round함수 : 반올림 함수
-- round(컬럼||숫자, 표시되는 소수점이하 자리수)
select round(12.5123) r1, round(12.5123,0) r2, round(12.5123,1) r3, round(12.5123,2) r4, round(12.5123, -1) r5 from dual;

-- trunc함수 : 버림 함수
-- trunc(컬럼||숫자, 표시되는 소수점이하 자리수)
select trunc(12.5123) r1, trunc(12.5123,0) r2, trunc(12.5123,1) r3, trunc(12.5123,2) r4, trunc(12.5123, -1) r5 from dual;

-- mod 함수 : 나머지 함수
select mod(12,10) from dual; --2

-- 근사 정수 : ceil(큰근사정수), floor(작은근사정수)
select ceil(12.345), floor(12.345), ceil(-12.345), floor(-12.345) from dual;

-- power : 제곱함수
select power(2,3) from dual;

-- abs : 절대값함수
select abs(-5) from dual;

-- sign : 부호. 1 : 양수, -1 : 음수, 0 : 0
select sign(10), sign(-10), sign(0) from dual;

-- 문제
-- 교수의 급여를 15% 인상하여 정수로 출력하기
-- 교수이름, 현재급여, 반올림 된 예상급여, 버림된 예상급여를 출력
select name, pay, round(pay * 1.15) "반올림 된 예상급여", trunc(pay * 1.15) "버림된 예상급여" from professor;

-- 날짜 관련 함수
-- sysdate : 현재 날짜를 리턴. 예약어
select sysdate from dual;

-- months_between : 두 날짜 사이의 개월 수 리턴, 소수점 표현됨
-- months_between(날짜1, 날짜2) : 날짜1 - 날짜2 차이의 개월 수
select months_between(sysdate,'22/01/01') from dual;

-- 학생의 이름, 생일(birthday), 개월 수, 나이를 출력하기
-- 개월 : 현재 날짜에서 생일까지의 개월 수를 반올림하여 정수 출력
-- 나이 : 개월/12 나누어서 버림하여 정수로 출력
select name, birthday, round(months_between(sysdate, birthday)) "개월 수", trunc(months_between(sysdate, birthday)/12) 나이 from student;
select round(months_between(sysdate, '99/07/01')) "개월 수", trunc(months_between(sysdate, '99/07/01')/12) 나이 from dual;

-- add_modual : 개월수를 더한 후의 날짜 리턴
-- 현재일 기준 3개월 후, 3개월 전의 날짜 출력하기
select sysdate, add_months(sysdate, 3) "3개월 후", add_months(sysdate, -3) "3개월 전" from dual;

-- 현재일 기준 3일 후, 3일 전의 날짜 출력하기
select sysdate, sysdate + 3 "3일 후", sysdate -3 "3일 전" from dual;

-- 날짜1 - 날짜2 : 두 날짜 사이의 일자
select ename, hirenate, sysdate-hirdate from emp;

-- round, trunc함수 기능
select round(sysdate), trunc(sysdate) from dual;

-- next_day 함수 : 날짜 다음의 지정한 요일에 해당하는 날짜 리턴
-- 일 : 1, 월 : 2, 화 : 3, ... 토 : 7
select sysdate, next_day(sysdate, '토'), next_day(sysdate, 7) from dual;
select sysdate, next_day(sysdate, '월'), next_day(sysdate, 2) from dual;

-- last_day : 해당 월의 마지막 날짜 리턴
select sysdate, last_day(sysdate) from dual;
select '22/02/01', last_day('22/02/01') from dual;

-- 문제
-- 1. 사원테이블에서 사원의 이름, 직업, 입사일(hiredate), 근무일수 출력하기
-- 근무일수는 버림하여 정수로 출력
select ename, job, hiredate, trunc(sysdate - hiredate) 근무일수 from emp;

-- 2. 사원테이블에서 입사 후 3개월을 수습기간이라고 가정할 때 수습 종료일 출력하기
-- 사원이름, 직업, 입사일, 수습종료일 출력
select ename, job, hiredate, add_months(hiredate, 3) 수습종료일 from emp;

-- 3. 사원테이블의 이름, 입사일, 휴가보상일 출력하기
-- 휴가보상일 : 입사월의 마지막 일자
select ename, hiredate, last_day(hiredate) 휴가보상일 from emp;

-- 형변환 함수
-- 묵시적형변환 : 오라클이 자동으로 변환함
select 1 + '1' from dual; -- 실행됨. 성능취약
select 1 + 'a' from dual; -- a를 숫자로 바꿀 수 없음. 오류

-- to_char() : 숫자나 날짜형을 지정된 형식에 맞도록 문자열로 변형하는 함수
-- 날짜를 문자열로 변경

/*
   날짜 형식 문자
   yyyy : 연도를 4자리로 표시.
   yy   : 연도를 2자리로 표시.
   rrrr : 2000년 이후에 Y2K버그로 인해 추가된 연도 4자리로 표시.
   rr   : 2000년 이후에 Y2K버그로 인해 추가된 연도 2자리로 표시.
   year : 영문으로 년도 표시
   
   mm    : 월을 2자리로 표시
   mon   : 영문표시 할때 약자표시. FEB  한글은 상관없다
   month : 영문표시 할때 전체 월 표시. 한글은 상관없다
   
   dd    : 일을 2자로 표시
   day   : 요일 표시. 
   ddth  : 몇번째 날짜인지 표시
   
   시간
   hh   : 하루 12시간.
   hh24 : 하루 24시간
   mi   : 분
   ss   : 초
   am   : 오전/오후
*/

select sysdate, to_char(sysdate,'yyyy-mm-dd hh:mi:ss am day') from dual;

-- 학생의 이름과 생일(birthday)을 yyyy-mm-dd 요일 형식으로 출력하기
select name, to_char(birthday, 'yyyy-mm-dd day') birthday from student;

select to_char(sysdate, 'yyyy') 년도1,  
       to_char(sysdate, 'rrrr') 년도2,
       to_char(sysdate, 'yy') 년도3,    
       to_char(sysdate, 'year') 년도4,
       to_char(sysdate, 'rr') 년도5,
       to_char(sysdate, 'mm') 월1,
       to_char(sysdate, 'mon') 월2, --약자표시
       to_char(sysdate, 'month') 월3, 
       to_char(sysdate, 'dd') 일1, -- 일자
       to_char(sysdate, 'day') 일2, --요일
       to_char(sysdate, 'ddth') 일3, --
       to_char(sysdate, 'hh') 시간1, -- 1 ~ 12
       to_char(sysdate, 'hh24') 시간2, -- 0 ~ 23
       to_char(sysdate, 'mi') 분1,   -- 분
       to_char(sysdate, 'ss') 초1,   -- 초
       to_char(sysdate, 'am') AM     -- 오전,오후
    from dual;
    
-- 문제
-- 오늘 '2022-08-16 12:03:55 월요일' 형식으로 출력하기
select to_char(sysdate, 'rrrr-mm-dd hh:mi:ss day') 오늘 from dual;

select to_char(1234.56,'9999999') 숫자1, --정수 7자리. 반올림
       to_char(1234.56,'0999999') 숫자2, --정수 7자리 빈자리 0으로 채움
       to_char(12.3456,'$9999.99') 숫자3, -- $표시, 소숫점이하 2자리출력      
       to_char(12.3456,'9999.99') 숫자4,  -- 소숫점이하 2자리출력            
       to_char(1234.3456,'9,999.99') 숫자5 -- 세자리마다 , 표시하고 소숫점이하 2자리 출력
from dual;

-- 교수의 이름, 현재 급여, 연봉 출력하기
-- 연봉은 급여 * 12이고, 출력시 세자리마다 , 표시하기
select name, pay, to_char(pay*12,'99,999') 연봉 from professor; 

-- to_number : 문자 -> 숫자형
select '12' + 10 from dual; -- 묵시적형변환
select to_number('12') + 10 from dual; -- 명시적형변환

-- to_date : 문자 -> 날짜형
-- '20220816' => 날짜형태로변환
select to_date('20220816', 'yyyymmdd') from dual;

-- '20220817' 날짜를 '2022-08-17 수요일' 형태로 출력하기
select to_char(to_date('20220817', 'yyyymmdd'),'yyyy-mm-dd day') 날짜 from dual;

-- 문제
-- 교수테이블에서 입사일 2개월 후 다음달 1일을 정식 입사일로 한다.
-- 교수이름, 입사일, 정식입사일을 출력하기
-- 단, 정식입사일의 요일도 표시하기
select name, hiredate, to_char(last_day(add_months(hiredate, 2))+1, 'yyyy-mm-dd day') from professor;

-- 일반함수
-- nvl : null 값을 다른 값으로 변환해주는 함수
-- 교수의 이름, 연봉(급여 * 12 + 보너스 ) 출력하기
select name, pay*12+bonus 연봉 from professor where bonus is not null
union
select name, pay*12 연봉 from professor where bonus is null;

-- nvl(bonus,0) : bonus 컬럼의 값이 null인 경우는 0으로 변환
-- null이 아니면 bonus값
select name, pay*12+nvl(bonus,0) 연봉 from professor;

-- 문제
-- 1. 학생의 이름과 지도교수번호(profno) 출력하기
-- 단 지도교수가 없는 학생의 지도교수번호는 9999로 출력한다.
select name, nvl(profno,9999) 지도교수번호 from student;
-- 2. 부서테이블(department)에서 부서코드(deptno)와 부서명(dname), 건물명(build) 출력하기
-- 단 건물명이 없는 학과는 건물없음으로 출력하기
select deptno, dname, nvl(build, '건물없음') 건물명 from department;

-- 교수의 이름, 급여, 보너스, 성과급 출력하기
-- 성과급 : 보너스가 있는 경우 보너스 * 3
--        보너스가 없는 경우 50
select name, pay, nvl(bonus,0) bonus, nvl(bonus*3,50) 성과급 from professor;

-- 조건함수 : decode함수
-- decode(컬럼명, 값, 참, 거짓)
-- 교수테이블에서 교수이름, 학과번호, 학과명 출력하기
select name, deptno, decode(deptno, 101, '컴퓨터공학', '') 학과명 from professor;
-- 교수테이블에서 교수이름, 학과번호, 학과명 출력하기
-- 학과명이 101인 경우, '컴퓨터공학'으로 그 외는 '기타학과'로 출력하기
select name, deptno, decode(deptno, 101, '컴퓨터공학', '기타학과') 학과명 from professor;
-- 조건을 이어서 값을 출력할 수 있음
-- 101 인 경우 '컴퓨터공학'
-- 102 인 경우 '멀티미디어공학'
-- 201 인 경우 '기계공학'
-- 그 외는 '기타학과'로 출력
select name, deptno, decode(deptno, 101, '컴퓨터공학', 102, '멀티미디어공학', 201, '기계공학', '기타학과') 학과명 from professor;

-- 문제
-- 1. 학생의 주민번호 7번째 자리가 1, 3인 경우는 남자, 2, 4인경우는 여자로 출력하기
-- 학생 이름, 주민번호, 성별 조회
select name, jumin , decode(substr(jumin,7,1), 1, '남자', 3, '남자', 2, '여자',4,'여자','성별오류') from student;

-- 2. 학생의 이름, 전화번호, 지역명 출력하기
-- 지역명 : 전화번호의 지역구분이 02 : 서울, 051 : 부산, 052 : 울산 그 외는 기타로 출력
select name, tel, decode(substr(tel,1,instr(tel,')')-1), '052', '울산', '02', '서울', '051', '부산','기타' ) from student;

-- case 구문 : 조건문. decode 함수와 같은 기능.
-- 범위지정가능 
-- 학생의 이름, 전화번호, 지역명 출력하기
-- 지역명 : 전화번호의 지역구분이 02 : 서울, 051 : 부산, 052 : 울산 그 외는 기타로 출력
select name, tel, case substr(tel, 1, instr(tel,')')-1) 
        when '02' then '서울'
        when '051' then '부산'
        when '052' then '울산'
        else '기타' end 지역명
from student;

-- 학생의 주민번호 7번째 자리가 1, 3인 경우는 남자, 2, 4인경우는 여자로 출력하기
-- 학생 이름, 주민번호, 성별 조회하기. case 구문
select name, jumin ,case substr(jumin,7,1)
        when '1' then '남자'
        when '2' then '여자'
        when '3' then '남자'
        when '4' then '여자'
        end 성별
from student;

select name, jumin ,case 
        when substr(jumin,7,1) in (1, 3) then '남자'
        when substr(jumin,7,1) in (2, 4) then '여자'
        end 성별
from student;

-- 문제
-- 학생의 생일이 1~3월인 경우 1분기 4~6 2분기, 7~9 3분기, 10 ~ 12 4분기가 출생분기
-- 학생의 이름, 주민번호, 출생분기를 출력
-- 단 생일은 주민번호 기준으로 한다.
select name, jumin ,case 
        when substr(jumin,3,2) between '01' and '03' then '1분기'
        when substr(jumin,3,2) between '04' and '06' then '2분기'
        when substr(jumin,3,2) between '07' and '09' then '3분기'
        when substr(jumin,3,2) between '10' and '12' then '4분기'
        end 출생분기
from student;

-- 학생의 생일이 1~3월인 경우 1분기 4~6 2분기, 7~9 3분기, 10 ~ 12 4분기가 출생분기
-- 학생의 이름, 주민번호, 출생분기를 출력
-- 단 생일은 birthday 기준으로 한다.
-- birthday 출력 시 yyyy-mm-dd 형태로 출력

select name, to_char(birthday,'rrrr-mm-dd') ,case 
        when substr(birthday,4,2) between '01' and '03' then '1분기'
        --  when to_char(birthday, 'mm') between '01' and '03' then '1분기'
        when substr(birthday,4,2) between '04' and '06' then '2분기'
        when substr(birthday,4,2) between '07' and '09' then '3분기'
        when substr(birthday,4,2) between '10' and '12' then '4분기'
        end 출생분기
from student;



