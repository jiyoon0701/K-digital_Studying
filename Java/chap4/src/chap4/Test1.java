package chap4;

import java.util.Scanner;

/*
1.  다음은 주어진 문자열(value)이 숫자인지를 판별하는  프로그램을 작성하시오.
  String 함수 charAt(i), length() 을 사용함.
  [결과]
숫자만 입력하세요
123
123는 숫자 입니다.
  
  [결과]
숫자만 입력하세요
123@12
123@12는 숫자가 아닙니다.

 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자만 입력하세요");
		boolean flag = true;
		String num = scan.next();
		for (int i =0; i< num.length(); i++) {
			int ch = num.charAt(i);
			if (ch <48 || ch >58) {
				flag = false;
				//System.out.println(num+"는 숫자가 아닙니다.");
				//break;
			}
		}
		if (flag) {
			System.out.println(num+"는 숫자입니다.");
		}
		else {
			System.out.println(num+"는 숫자가 아닙니다.");
		}
		
	}
}
