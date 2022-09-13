package chap12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 년도와 월을 입력 받아 해당월의 마지막 일자와 요일 출력하기
 */
public class Exam2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("년도와 월을 입력하세요");
		int year = scan.nextInt();
		int mon = scan.nextInt();
		System.out.println(year+"-"+mon);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//마지막일자 : 마지막일자 = 다음1일 - 하루
		String sday = year+"-"   //다음1일
		             +String.format("%02d",(mon+1))+"-01";
		Date lday = null;
		try {
			lday = sf.parse(sday); //Date객체<=문자열. 다음달1일의 Date객체
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lday.setTime(lday.getTime()-(1000*60*60*24));//날짜의 마지막일자
		SimpleDateFormat sf2 = 
				     new SimpleDateFormat("yyyy-MM-dd E요일");
		System.out.println(sf2.format(lday));
	}
}
