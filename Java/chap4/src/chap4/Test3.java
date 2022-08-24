package chap4;

import java.util.Scanner;

/*
   화면에서 한개의 문자를 입력받아  대문자인 경우는 소문자로, 
   소문자인 경우는 대문자로  숫자인 경우는 20을 더한 값을   출력하기
   그외의 문자는 기타 문자 를 출력하세요
   
   [결과]
 한개의 문자를 입력하세요
 A
 a   
   [결과]
 한개의 문자를 입력하세요
 a
 A   

   [결과]
한개의 문자를 입력하세요
1
21

*/
public class Test3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		int ch = num.charAt(0);
		if(ch >=97 && ch <= 122) {
			System.out.println((char)(ch-32));
		}
		else if(ch >=65 && ch <= 90) {
			System.out.println((char)(ch+32));
		}
		else {
			System.out.println((ch-'0')+20);
		}
		
	}
}
