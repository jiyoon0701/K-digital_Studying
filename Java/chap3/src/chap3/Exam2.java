package chap3;

import java.util.Scanner;

/*
 * 초를 입력받아 몇시간몇분몇초인지 출력하기
 * 1. Scanner 생성
 * 2. second = scan.nextInt()
 * 3. h = second/3600
 * 4. m = (second%3600)/60
 * 5. s = (second%3600)%60
 * 
 * 초를 입력하세요
 * 3662
 * 1시간1분2초
 * */

public class Exam2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int second = scan.nextInt();
		System.out.println(second/3600+"시간"+(second%3600)/60+"분"+(second%3600)%60+"초");
	}
}