package chap5;
import java.util.Scanner;

/*
 * 10진수를 입력받아 8진수로 변경하여 출력하기
 * */
public class Exam2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] octal = new int[32];
		Scanner scan = new Scanner(System.in);
		System.out.println("10진수를 입력하세요");
		int num = scan.nextInt();
		int divnum = num, index = 0; // 현재의 값이 저장된 배열의 인덱스 저장
		while(divnum != 0) {
			octal[index++] = divnum % 8;
			divnum /= 8; //0
		}
		System.out.println(num+"의 8진수");
		for(int i = index -1; i>=0; i--) {
			System.out.print(octal[i]);
		}
		System.out.println();
	}
}