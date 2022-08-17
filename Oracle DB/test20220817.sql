/*
1. 학과별로 평균 몸무게와 학생 수를 출력하되 평균 몸무게의  내림차순으로 정렬하여라.


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
select * from student;
select deptno1, avg(weight) 평균몸무게, count(*) from student group by deptno1 order by 평균몸무게 desc ;
/*
2.  학생테이블의 birthday를 기준으로 월별로 태어난 인원수 출력하기

[결과]

   합계      1월   2월        3월     4월      5월     6월       7월      8월     9월      10월      11월      12월
------- ------- -------- -------- -------- -------- -------- -------- -------- -------- --------- --------- ---------
     20        3        3         2        2        0         1        0         2          2         2          1         2
*/
select * from student;
select count(*) 합계,
count(decode(to_char(birthday,'mm'),'01',0)) "1월",
count(decode(to_char(birthday,'mm'),'02',0)) "2월",
count(decode(to_char(birthday,'mm'),'03',0)) "3월",
count(decode(to_char(birthday,'mm'),'04',0)) "4월",
count(decode(to_char(birthday,'mm'),'05',0)) "5월",
count(decode(to_char(birthday,'mm'),'06',0)) "6월",
count(decode(to_char(birthday,'mm'),'07',0)) "7월",
count(decode(to_char(birthday,'mm'),'08',0)) "8월",
count(decode(to_char(birthday,'mm'),'09',0)) "9월",
count(decode(to_char(birthday,'mm'),'10',0)) "10월",
count(decode(to_char(birthday,'mm'),'11',0)) "11월",
count(decode(to_char(birthday,'mm'),'12',0)) "12월"
from student ;

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
select * from professor;
select deptno, count(*) from professor group by deptno having count(*) <= 2;

/*
4.직급별로 평균 급여가 320보다 크면 '우수', 작거나 같으면 '보통'을 출력하여라

[결과]
POSITION                                 급여
---------------------------------------- ------------
정교수                                ㅁ   우수
전임강사                                 보통
조교수                                   우수
*/
select position, 
case when avg(pay) > 320 then '우수'
else '보통'
end 급여
from professor group by position;
/* 
5. 부서중 최대인원을 가진 부서의 인원수와 최소인원을 가진 부서의 인원수 출력하기

[결과]
최대인원 최소인원
---------- ----------
   3            1
*/
select max(count(name)) 최대인원, min(count(name))최소인원 from professor group by deptno;

/*
6. 교수테이블에서 평균 급여가 350이상인 부서의   부서코드, 평균급여, 급여합계를 출력하기

[결과]
 부서코드   평균급여   급여합계
---------- ---------- ----------
       102 363.333333       1090
       201        450        900
       101        400       1200
       203        500        500
       103 383.333333       1150
*/
select deptno, round(avg(pay),6) 평균급여, sum(pay) 급여합계 from professor group by deptno having avg(pay) >= 350;
-- 7. 4학년 학생의 이름 학과번호, 학과이름 출력하기
select * from student;
select * from department;

select s.name, s.deptno1, d.dname from student s, department d where s.grade = 4 and s.deptno1 = d.deptno;

-- 8. 오나라 학생의 이름, 학과코드1,학과이름,학과위치 출력하기
select * from student;
select * from department;

select s.name, s.deptno1, d.dname, d.build from student s, department d where s.name = '오나라' and s.deptno1 = d.deptno;

-- 9. 학번과 학생 이름과 소속학과이름을 학생 이름순으로 정렬하여 출력
select s.studno, s.name, d.dname from student s, department d where s.deptno1 = d.deptno order by s.name;

-- 10. 교수별로 교수 이름과 지도 학생 수를 출력하기.
select * from student;
select * from professor;
select p.name, count(*) "지도 학생 수" from professor p ,student s where p.profno = s.profno group by p.name ;

-- 11. 성이 김씨인 학생들의 이름, 학과이름 학과위치 출력하기
select s.name, d.dname, d.build from student s, department d where name like '김%' and s.deptno1 = d.deptno;
