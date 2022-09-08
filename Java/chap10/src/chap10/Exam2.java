package chap10;

import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		LambdaInterface3 f = x->{
			int sum=0;
			for(int i=1;i<=x;i++) sum += i;
			System.out.printf("1~%d까지의 합:%d\n",num,sum);
		};		
		f.method(num);
	}
}
