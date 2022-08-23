package chap3;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		
		// ++ 연산자를 이용하여 결과가 x=10이 나오도록 수정
		System.out.println("x=" + x++);
		// -- 연산자를 이용해서 결과가 x=10이 나오도록 수정
		System.out.println("x=" + --x);
		
		// 화면에 입력받은 숫자를 증감연산자(++,--)를 사용해도 같은 값이 나오도록 프로그램 작성
		// 화면에서 데이터 입력받기
		Scanner scan = new Scanner(System.in);
		// System.in : 키보드 입력객체
		// nextInt() : 숫자값 입력받아 x에 저장
		System.out.println("숫자를 입력하세요");
		x = scan.nextInt();
		// ++ 연산자를 이용하여 결과가 입력받은 값 출력
		System.out.println("x=" + x++);
		// -- 연산자를 이용해서 결과가 입력받은 값 출력
		System.out.println("x=" + --x);
	}

}
