package chap4;
/*
 * 1부터 100까지의 짝수의 합 구하기
 * for
 * while
 * do while
 */
public class Exam3 {
	public static void main(String[] args) {
		System.out.println("1. for 구문");
		int sum=0;
		int i=0;
		for(i=1;i<=100;i++) {
			if(i%2==0)	sum += i;
		}
		System.out.println("1~100까지의 짝수의 합 :" + sum);
		System.out.println("1. for 구문 2");
		sum=0;
		i=0;
		for(i=2;i<=100;i+=2) {
			sum += i;
		}
		System.out.println("1~100까지의 짝수의 합 :" + sum);

		System.out.println("2. while 구문");
		sum=0;
		i=0;
		while(i<=100) {
			if(i%2==0) sum += i;
			i++;
		}
		System.out.println("1~100까지의 짝수의 합 :" + sum);
		System.out.println("2. while 구문 2");
		sum=0;
		i=2;
		while(i<=100) {
			sum += i;
			i+=2;
		}
		System.out.println("1~100까지의 짝수의 합 :" + sum);
		System.out.println("3. do while 구문");
		sum=0;
		i=1;
		do{
			if(i%2==0) sum += i;
			i++;
		}while(i<=100); 
		System.out.println("1~100까지의 짝수의 합 :" + sum);
		System.out.println("3. do while 구문 2");
		sum=0;
		i=2;
		do{
			sum += i;
			i+=2;
		}while(i<=100); 
		System.out.println("1~100까지의 짝수의 합 :" + sum);
	}
}
