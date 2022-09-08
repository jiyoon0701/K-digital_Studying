package chap9;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 1부터 100까지 중 임의의 숫자를 컴퓨터가 저장하고, 
 * 값을 입력받아 저장된 값을 맞추는 프로그램을 작성하기
 *
 * 단 1 부터 100까지의 숫자가 아닌 경우에는 1 과 100사이의 숫자만 입력하세요를 출력
 * 숫자가 입력이 안된 경우는 숫자만 입력하세요 를 출력하고 계속 입력을 받는다.
 * 정답을 맞춘경우 프로그램을 종료
 * 종료 전 몇번의 입력만에 숫자를 맞추었는지 출력하기.
 * 단 입력 오류된 입력도 입력 건수에 포함된다.
*/       

public class Test2 {
	public static void main(String[] args) {
		//1~100사이의 임의의 정수 저장
		int answer = (int)(Math.random() * 100) + 1;
		int cnt = 0;  //입력 횟수 
		int num = 0;  //입력값
		Scanner scan = new Scanner(System.in);
		while(true) { //반복문 중간에 break 반복문 종료
			System.out.println("1부터 100까지의 숫자를 입력하세요");
			try {
			 num = scan.nextInt(); //정수값 입력
			 cnt++;
			 if(num < 1 || num > 100) 
				 throw new Exception("1부터 100까지의 숫자만 입력하세요"); //예외발생
			} catch(InputMismatchException e) {
				String d = scan.next();
				cnt++;
				System.out.println(d + "는 숫자가 아닙니다.");
				continue;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			//1~100사이의 값이 입력된 경우만 실행
			if(num == answer) break;
			else if(num > answer) 
				System.out.println("작은수를 입력하세요");
			else 
				System.out.println("큰수를 입력하세요");
		}
		System.out.println(num + ":정답입니다. 입력 횟수:" + cnt);
	}
}