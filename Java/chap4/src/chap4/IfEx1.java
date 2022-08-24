package chap4;

import java.util.Scanner;

/*
 * if 조건문 예제 : 
 *   if(조건식) {
 *      조건식의 결과가 참인 경우 실행 되는 문장들...
 *   } else {
 *      조건식의 결과가 거짓인 경우 실행 되는 문장들...
 *   }
 *   
 *   if(조건식1) {
 *      조건식1의 결과가 참인 경우 실행 문장
 *   } else if(조건식2) {
 *     조건식1의 결과가 거짓, 조건식2의 결과가 참인 경우 실행 문장 
 *   } else if(조건식3) {
 *     조건식1,조건식2의 결과가 거짓, 조건식3의 결과가 참인 경우 실행 문장 
 *   } else {
 *     모든 조건식이 거짓인 경우 실행 문장
 *   }
 *
 * 블럭 : {}   
 * if,else 블럭에 실행되는 문장이 한개인 경우 {} 생략 가능  
 */
public class IfEx1 {
	public static void main(String[] args) {
		System.out.println("점수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt(); //85
		if(score >= 60) { //참
			//if(조건식) : 조건식의 결과가 참인 경우 실행 영역
			System.out.println("합격입니다.");
		} else {
			//if(조건식) : 조건식의 결과가 거짓인 경우 실행 영역
			System.out.println("불합격입니다.");
		}
		if(score >= 60) //{} 생략가능.
			System.out.println("합격입니다.");
		else
			System.out.println("불합격입니다.");

		//점수의 학점 출력하기
		if (score >= 90 ) {
			System.out.println("A학점");
		} else if(score >= 80) {
			System.out.println("B학점");
		} else if(score >= 70) {
			System.out.println("C학점");
		} else if(score >= 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}
	} //프로그램 종료
}
