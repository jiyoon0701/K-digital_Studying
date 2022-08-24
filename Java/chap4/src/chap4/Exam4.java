package chap4;

import java.util.Scanner;

/*
 * 화면에서 자연수를 입력받아서 각 자리수의 합을 구하기
 *
 * [결과]
 * 자연수를 입력
 * 123
 * 6
 *
 * [문제분석]
 * 123 => 123 % 10 => sum +=3
 * 123/10 => 12 % 10 => sum += 2
 * 12/10  => 1 % 10  => sum += 1
 * 1/10 => 0 반복 종료
 */
public class Exam4 {
	public static void main(String[] args) {
		System.out.println("자연수를 입력");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int temp = num; //555
		int sum = 0;
		while(temp > 0) {
			sum += temp%10; //5+5+5
			temp /= 10; //0
		}
		System.out.println(num + "자리수의 합 :" + sum);
		
	}
}
