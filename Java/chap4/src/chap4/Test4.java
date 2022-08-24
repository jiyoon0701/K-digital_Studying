package chap4;

import java.util.Scanner;

/*
 * 대칭수 구하는 프로그램을 작성하기
   대칭수란 숫자를 거꾸로 읽어도 앞으로 읽는 것과  같은 수를 말한다.
   12321 : 대칭수
   12345 : 대칭수 아님
 */
public class Test4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		int result = 0;
		
			for(int i=num.length()-1; i>=0; i--) {
				result += (((int)(num.charAt(i)-'0')) * (int)(Math.pow(10, i))) ;
			}
			
			if (Integer.parseInt(num) == result) {
				System.out.println("대칭수");
			}
			else {
				System.out.println("대칭수 아님");
			}
	}
}
