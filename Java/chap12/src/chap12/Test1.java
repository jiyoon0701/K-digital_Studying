package chap12;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 년도와 월을 입력받아 해당월의 달력을 출력하기
 * 
[결과]
년도와 월를 입력하세요
2022 09
	2022년 9월
  일 월  화 수  목 금 토
              1  2  3
  4  5  6  7  8  9 10
 11 12 13 14 15 16 17
 18 19 20 21 22 23 24
 25 26 27 28 29 30
*/
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("년도와 월를 입력하세요");
		int year = scan.nextInt();
		int mon = scan.nextInt();		
		Calendar cal = Calendar.getInstance();
		cal.set(year,mon-1,1); //입력한 년월의 1일로 cal 객체 설정 
		//firstWeek : cal 의 요일 저장 (1(일)~7(토))
		int firstWeek = cal.get(Calendar.DAY_OF_WEEK);
		//입력월의 마지막일자.
		int lastday = cal.getActualMaximum(Calendar.DATE);
		System.out.println("\t"+year + "년 " + mon + "월");
		//String[] "일,월,화,수,목,금,토,일".split(",") 
		System.out.printf("%3s%2s%3s%2s%3s%3s%3s\n",
				          "일,월,화,수,목,금,토,일".split(","));
		//day : 일자
		// i  : 자리수
		for(int i=1,day=1;day<=lastday;i++) {
			if(i < firstWeek) System.out.printf("%3s"," ");
			else System.out.printf("%3d",day++);
			if(i%7==0)System.out.println();
		}
	}
}
