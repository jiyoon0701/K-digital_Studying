package chap5;

import java.util.Scanner;

/*
 * 10진수를 2,8,10,16 진수로 변경하기
 * [결과]
10진수 값을 입력하세요
16
16의 2진수 :10000
16의 8진수 :20
16의 10진수 :16
16의 16진수 :10
*/

public class Test8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("10진수를 2, 8, 10, 16 진수로 변경하기");
		String nums = "0123456789ABCDEF";
		int[] jinsu = {2,8,10,16};
		int num = scan.nextInt();
		
		char[] hexa = new char[30];
		char[] numarr = nums.toCharArray();
		for(int c : jinsu) {
			int divnum = num, index = 0;
			int[] binary = new int[30];
				while(divnum!=0) {
					if (c == 16) {
						hexa[index++] = numarr[divnum%16]; //02
						divnum /= 16; //0
						
					}
					else {
					binary[index++] = divnum%c;
					divnum /= c;
					}
				}
	
			System.out.println(num+"의 "+ c+"진수:");
			for(int i = index -1; i>=0; i--) {
				System.out.print((c==16)?hexa[i]-'0':binary[i]);
			}
			System.out.println();
		}
	}
}
