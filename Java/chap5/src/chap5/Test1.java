package chap5;

import java.util.Scanner;

/*
 * 강아지와 병아리 개체수의 합과 다리수의 합을 입력받아
 * 강아지,병아리의 각각의 개체수를 출력하는 프로그램 작성하기
 * 
 * [결과]
 * 강아지와 병아리 합
 * 10 
 * 강아지와 병아리 다리의 합
 * 30 
 * 강아지 5마리, 병아리 5마리
 * 
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("강아지와 병아리 합");
		int x = 0;
		int y = 0;
		int num = scan.nextInt();
		System.out.println("강아지와 병아리 다리의 합");
		int num2 = scan.nextInt();
		
		x = (num2 - (num*2))/2;
		y = num - x;
		
		System.out.println("강아지 "+x+"마리, 병아리 "+y+"마리");
	}
}
