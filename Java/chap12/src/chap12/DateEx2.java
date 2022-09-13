package chap12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx2 {
	public static void main(String[] args) {
		Date now =new Date();
		//getTime() : 1970년 이후부터 현재까지를 밀리초로 리턴
		System.out.println(now.getTime());
		System.out.println(System.currentTimeMillis());
		System.out.println(now);
		//현재시간 한시간 이후를 Date로 생성하기
		Date h1 = new Date();
		h1.setTime(now.getTime() + (1000*60*60));
		System.out.println(h1);
		//현재부터 3일 이후의 날짜와 요일 출력하기
		Date d3 = new Date(now.getTime() + (1000*60*60*24*3));
		SimpleDateFormat sf = new SimpleDateFormat
				                         ("yyyy-MM-dd E요일");
		System.out.println(sf.format(d3));
	}
}
