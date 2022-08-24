package chap4;

import java.util.Scanner;

/*
 * 숫자를 입력받아서 
 * 1.양수,음수,영을 출력.
 * 2.짝수,홀수 여부 출력
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println("숫자 입력");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		//1.양수,음수,영을 출력.
		if(num > 0) 
			System.out.println("양수");
		else if (num < 0)
			System.out.println("음수");
//		else if(num == 0)
		else
			System.out.println("영");
		// 2.짝수,홀수 여부 출력
		if (num%2==0)
			System.out.println("짝수");
//		else if (num%2!=0)
		else
			System.out.println("홀수");

	}
}
