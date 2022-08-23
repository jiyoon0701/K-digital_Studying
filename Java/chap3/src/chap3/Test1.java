package chap3;

import java.util.Scanner;

/*
 * 사과를 담기 위한 사과상자 갯수 구하기
 * 1개의 상자에 10개의 사과를 담을 수 있다고 할때 필요한 상자의 갯수를 출력하기
 * [결과]
 * 사과의 갯수를 입력하세요
 * 22
 * 필요한 상자의 갯수 : 3개
 * 
 * [결과]
 * 사과의 갯수를 입력하세요
 * 30
 * 필요한 상자의 갯수 : 3개
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("사과의 개수를 입력하세요");
		int num = 0;
		num = scan.nextInt();
		System.out.print("필요한 상자의 갯수:");
		System.out.println((num%10==0)?(num/10)+"개":(num/10+1)+"개");
	}
}
