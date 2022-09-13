package chap12;

import java.util.Calendar;

/*
 * Calendar 객체로 날짜 설정하기
 */
public class CalendarEx2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); //현재일시
		//2022년 12월 31일로 설정
		cal.set(2022,(12-1),31); //날짜 설정
		System.out.print("날짜:"
		  +cal.get(Calendar.YEAR)+"년" 
		  +(cal.get(Calendar.MONTH) + 1) + "월"
		  + cal.get(Calendar.DATE) + "일 "); 
		//cal 요일 출력하기
		String week = "일월화수목금토일";
		System.out.println
		(week.charAt(cal.get(Calendar.DAY_OF_WEEK)-1) + "요일");
		
	}
}
