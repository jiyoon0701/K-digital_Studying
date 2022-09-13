package chap12;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx3 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		now.setTime(now.getTime() + (1000*60*60*24));
		cal.setTime(now);
		System.out.println(now);
		System.out.println("날짜:"
				  +cal.get(Calendar.YEAR)+"년" 
				  +(cal.get(Calendar.MONTH) + 1) + "월"
				  + cal.get(Calendar.DATE) + "일 ");
        		
		Date day = new Date();
		day.setTime(cal.getTimeInMillis());
		
		System.out.println(day);
		System.out.println("프로그램 종료");
	}
}
