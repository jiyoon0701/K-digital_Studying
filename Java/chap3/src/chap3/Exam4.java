package chap3;

import java.util.Scanner;

/*
 * 1. 숫자를 입력받아서 양수인 경우 "양수",
 * 				음수인 경우 "음수",
 * 				0인 경우 "영" 출력하기
 * 
 * 2. 짝수인지 홀수인지 출력
 * */
public class Exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println((num>=0)?((num==0)?"영":"양수"):"음수");
		
		
		System.out.println((num%2 == 0)?"짝수":"홀수");
	}

}
