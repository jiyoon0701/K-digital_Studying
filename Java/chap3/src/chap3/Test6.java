package chap3;

import java.util.Scanner;

//  반지름을 입력받아 원의 둘레와 면적을 구하시오
public class Test6 {
	public static void main(String[] args) {
		double pi = 3.141592;
		Scanner scan = new Scanner(System.in);
		System.out.println("반지름 입력");
		int radius = scan.nextInt();
		System.out.println("면적"+radius*radius*pi+"둘레"+2*pi*radius);
	}
}
