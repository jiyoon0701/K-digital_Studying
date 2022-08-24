package chap4;

import java.util.Scanner;

/*
 * 화면에서 숫자형 문자열를 입력받아서 각 자리수의 합을 구하기
 *
 * [결과]
 * 숫자형 문자를 입력하세요
 * 123
 * 6
 * 
 * [문제해결]
 * '0' : 48, '1':49, '2':50
 * 
 * for(int i=0; i<len;i++) {
 *   ch = str.charAt(i)
 *   sum += ch - '0'
 * }
*/
public class Exam5 {
	public static void main(String[] args) {
		System.out.println("숫자형 문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		String str = scan.next(); //str : "123"
		int len = str.length();  //문자열의 길이 len:3
		System.out.println("입력된 문자열의 길이:" + len);
		/*
		 * str.charAt(0) : '1'
		 * str.charAt(1) : '2'
		 * str.charAt(2) : '3'
		 */
		int sum = 0;
		for(int i=0;i<len;i++) { //i:3
			//sum += 3 => sum=sum+('3'-'0')
			sum += str.charAt(i) - '0'; //1+2+3
		}
		System.out.println(str+"자리수의 합:" + sum);
	}
}
