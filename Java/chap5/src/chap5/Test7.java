package chap5;
/*
[결과]
  
길이를 홀수로 입력하세요
5

*****
 ***
  *
 ***
*****
  
 */

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i=num/2+1; i>0; i--) {
			for(int j = 0; j<(num/2+1)-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		for(int i = 1; i<=num/2; i++) {
			for(int j=1; j<=num/2 - i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
