package chap6;

import java.util.Scanner;
/*
  삼각형의 높이를 입력받아, 다음과 같은 역 직각삼각형을 출력하기 
  
[결과] 
삼각형의 높이를 입력하세요
5
 15 14 13 12 11
    10  9  8  7
        6  5  4
           3  2
              1
 */
public class Test1_A {
	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		int sum = 0;
		for(int i=1;i<=len;i++) {
			sum += i;
		}
		int data = sum;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(j<i)
					System.out.printf("%3c",' ');
				else
				    System.out.printf("%3d",sum--);
			}
			System.out.println();
		}
		System.out.println("\n");

		sum = data;
		int[][] matrix = new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=i;j<len;j++) {
				matrix[i][j] = sum--;
			}
		}
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(matrix[i][j] == 0)
					System.out.printf("%3c",' ');
				else
				    System.out.printf("%3d",matrix[i][j]);
			}
			System.out.println();
		}

	}

}
