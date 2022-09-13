package chap12;

import java.util.Calendar;

/*
 * Calendar 클래스
 *  추상클래스임 
 *    1. 추상메서드를 멤버로 가질수있다.
 *    2. 객체화 불가. new Calendar() 오류.
 *  getInstance() static 메서드를 통해서 객체 전달   
 */
public class CalendarEx1 {
	public static void main(String[] args) {
//		Calendar now = new Calendar();
		Calendar now = Calendar.getInstance(); //현재일시
		System.out.println(now);
		//get(상수값) : 지정된 상수값에 맞는 값을 리턴 
		System.out.println("년도:" + now.get(Calendar.YEAR));
		System.out.println("월(0 ~ 11):" 
		                + (now.get(Calendar.MONTH) + 1));
		System.out.println("일:" + now.get(Calendar.DATE));
		System.out.println("일:" + now.get(Calendar.DAY_OF_MONTH));
		System.out.println("년도기준일자:" + now.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1:일~7:토):"
		         + now.get(Calendar.DAY_OF_WEEK));
		System.out.println("월기준 몇째주:" + now.get(Calendar.WEEK_OF_MONTH));
		System.out.println("년기준 몇째주:" + now.get(Calendar.WEEK_OF_YEAR));
		System.out.println("월기준 몇째요일:" 
		     + now.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전0/오후1:" + now.get(Calendar.AM_PM));
		System.out.println("시간(0~11):" + now.get(Calendar.HOUR));
		System.out.println("시간(0~23):" + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59):" + now.get(Calendar.MINUTE));
		System.out.println("초(0~59):" + now.get(Calendar.SECOND));
		System.out.println("밀리초(0~999):" + now.get(Calendar.MILLISECOND));
		System.out.println("TimeZone(밀리초):" + now.get(Calendar.ZONE_OFFSET));
		System.out.println("TimeZone(시간):"   //시간대
		   + (now.get(Calendar.ZONE_OFFSET))/(1000*60*60));
		System.out.println("이번달의 마지막일자:" 
		           + now.getActualMaximum(Calendar.DATE));
		
	}
}
