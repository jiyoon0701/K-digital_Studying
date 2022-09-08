package chap10;

import java.util.Scanner;

/*
 * 숫자를 입력받아서 입력받은 숫자까지의 합출력하기
 * LambdaInterface1 인터페이스를 이용하여 람다방식으로 구현하기
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		//합
		LambdaInterface1 f = ()->{
			int sum=0;
			for(int i=1;i<=num;i++) sum += i;
			System.out.printf("1~%d까지의 합:%d\n",num,sum);
		};
		f.method();
		//짝수 합
		f = ()->{
			int sum=0;
			for(int i=0;i<=num;i+=2) sum += i;
			System.out.printf("1~%d까지의 짝수합:%d\n",num,sum);
		};
		f.method();
	}
}
