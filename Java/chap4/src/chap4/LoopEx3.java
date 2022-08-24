package chap4;

import java.util.Scanner;

/*
 * 화면에서 999숫자가 입력될때까지 숫자 입력받아 총 입력된 숫자의 합을 출력하기
 * 
 * [결과]
 * 숫자를 입력(종료:999)
 * 1 2 3 4 5 6 999
 * 21
 * 
 * 1+2+3+4+5+6 출력
 */
public class LoopEx3 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력(종료:999)");
		Scanner scan = new Scanner(System.in);
		int num=0;
		int sum=0;
		while(true) {  //무조건 반복. 반복문장 내부에 break 문장 사용
			num = scan.nextInt();
			if(num == 999)
				break; //반복 강제 종료. 반복문 밖으로 제어 이동
			sum += num;
		}
		System.out.println("입력된 수의 합:"+sum);
	}
}
