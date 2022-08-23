package chap3;

import java.util.Scanner;

/*
 * 조건연산자 (삼항연산자) => 조건문 으로 변경 가능 
 * 
 * (조건문)?참:거짓
 * 
 * 조건문 : 결과가 boolean(true|false)인 문장
 */
public class OpEx6 {
	public static void main(String[] args) {
		System.out.println("점수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt(); //숫자입력 85
		System.out.println
    (score + "점은 " + ((score>=60)?"합격":"불합격") + "입니다.");

		String result = (score>=60)?"합격":"불합격";
		System.out.println
	    (score + "점은 " + result + "입니다.");
		
		//70점이상:합격입니다. 60점이상:재시험대상입니다.
		//60미만 : 탈락입니다.
		System.out.println
       ((score >= 70)?"합격입니다.":
    	   (score>=60)?"재시험대상입니다.":"탈락입니다.");
	}
}
