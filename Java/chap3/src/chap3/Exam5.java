package chap3;

import java.util.Scanner;

/*
 * 화면에서 금액입력받아서 500,100,50,10,1원 동전으로 바꾸기.
 * 필요한 동전의 갯수 출력하기. 전체동전은 최소 갯수로 바꾼다.
 * [결과]
 * 금액을 입력하세요
 * 5641
 * 500원 : 11개
 * 100원 : 1개
 * 50원  : 0개
 * 10원 : 4개
 * 1원  : 1개
 */
public class Exam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println("500원 : " + num/500);
		num %= 500;
		System.out.println("500원 : " + num/100);
		num %= 100;
		System.out.println("500원 : " + num/50);
		num %= 50;
		System.out.println("500원 : " + num/10);
		num %= 10;
		System.out.println("500원 : " + num/1);
		
		
	}

}
