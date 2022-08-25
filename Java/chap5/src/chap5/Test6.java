package chap5;

import java.util.Scanner;

/*
삼각형의 높이를 입력하세요
3
  *  
 *** 
*****

 */

public class Test6 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i=1; i<=num; i++) {
			
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			
			for(int j =1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
