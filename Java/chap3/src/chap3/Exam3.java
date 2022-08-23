package chap3;

import java.util.Scanner;

/*
 * 화면에서 3자리 정수를 입력받아 100자리 미만 버리고 출력하기
 * 
 * [결과]
 * 세자리 정수를 입력하세요
 * 321
 * 300
 * 
 * 세자리 정수를 입력하세요
 * 599
 * 500
 * */
public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int result = num / 100 * 100;
		System.out.println(result);
	}

}
