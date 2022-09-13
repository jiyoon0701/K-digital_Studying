package chap12;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 년도와 월을 입력 받아 해당월의 마지막 일자와 요일 출력하기
 * Calendar클래스 이용
 */
public class Exam3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("년도와 월을 입력");
		int year = scan.nextInt();
		int mon = scan.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(year,mon-1,1); //입력년월의 첫번째일자 설정.
		int lastday = cal.getActualMaximum(Calendar.DATE);
		cal.set(year,mon-1,lastday); //입력년월의 마지막일자 설정.
		String week = "일월화수목금토";
		System.out.print(year+"년"+mon+"월의 마지막 날짜:"
	  +cal.get(Calendar.YEAR)+"년" 
	  +(cal.get(Calendar.MONTH) + 1) + "월"
	  + cal.get(Calendar.DATE) + "일 "
	  + week.charAt(cal.get(Calendar.DAY_OF_WEEK)-1)+"요일"); 
	}
}
