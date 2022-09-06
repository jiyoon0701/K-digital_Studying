package chap9;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1. 화면에서 1부터 10까지의 숫자를 입력받아 숫자만큼 *출력하는 프로그램 작성하기
 * 입력값이 숫자가 아닌경우 InputMismatchException 예외가 발생됨.
 * 숫자만 입력하세요 메서지 출력하고, 다시 입력받도록 구현하기 
 * catch 블럭 scan.next(); 추가
 * 
 * 2. 입력값이 1 ~ 10사이의 숫자가 아닌경우 예외 발생
 */
public class Exam1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		boolean endable = false;
		while(!endable) {
			try {
				System.out.println("1~10사이의 숫자를 입력하세요");
				num = scan.nextInt(); //InputMismatchException 
				if(num < 1 || num > 10) {
					throw new Exception("1에서 10사이의 숫자만 가능합니다."); //예외 강제 발생 
				}
				for(int i=0;i<num;i++) {
					System.out.print("*");
				}
				System.out.println();
				endable=true;
			} catch (InputMismatchException  e) {
				scan.next(); //잘못된 문자 입력.
				System.out.println("숫자만 입력하세요");
			} catch(Exception e) {
				// e.getMessage() : 1에서 10사이의 숫자만 가능합니다.
				System.out.println(e.getMessage());
			}
		}
		System.out.println("프로그램 종료");
	}
}
