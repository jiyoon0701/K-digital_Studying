package chap4;

import java.util.Scanner;

/*
 * 한개의 문자를 입력받아서 숫자,대문자,소문자,그외문자 출력하기
 */
public class IfEx2 {
	public static void main(String[] args) {
		System.out.println("한개의 문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		//scan.next() : 키보드 입력을 받아서 문자열 전달
		String str = scan.next(); // "" <-"" 가
		//charAt(index) : index에 해당하는 문자 리턴
		// index는 0부터 시작함
		//charAt(0) : 문자열중 첫번째 문자(char)를 리턴
		//str = "A9a"
		// charAt(0) : 문자열중 첫번째문자 : A 
		// charAt(1) : 문자열중 두번째문자 : 9 
		// charAt(2) : 문자열중 두번째문자 : a 
		char ch = str.charAt(0); //'d'
		if (ch >= '0' && ch <= '9') 
			System.out.println("숫자임");
		else if (ch >= 'A' && ch <= 'Z') 
			System.out.println("대문자임");
		else if (ch >= 'a' && ch <= 'z') 
			System.out.println("소문자임");
		else
			System.out.println("그외문자임");
		
		//대문자와 소문자의 코드 차이는 32임
		System.out.println((char)('A'+32)); //a
		System.out.println((char)('a'-32)); //A
		// A : 01000001 : 65
		// a : 01100001 : 97
		System.out.println((char)('T'+32)); //t
		System.out.println((char)('t'-32)); //T
		
		
	}
}
