package chap12;

import java.util.Random;

/*
 * Random 클래스 : 난수 발생을 위한 클래스
 *  1. 자료형별로 난수 발생을 위한 메서드 존재.
 *    nextInt() : 정수형 난수 리턴
 *    nextInt(n) : 0 <= n < n 정수형 난수 리턴
 *    nextDouble() : 0<= x < 1.0 실수형 난수 리턴. Math.random()
 *    nextBoolean() : true/false 중 하나 리턴
 *  2.seed 값 설정. : 발생된 난수 값을 재현 가능
 *    난수발생을 위한 값을 설정. seed 값이 같은 경우 같은 난수 발생 가능 => 재현가능   
 */
public class RandomEx1 {
	public static void main(String[] args) {
		Random rand1 = new Random();
		rand1.setSeed(1); //seed 설정
		Random rand2 = new Random();
		rand2.setSeed(2); //seed 설정
		//System.currentTimeMillis() :
		//       1970년 이후부터 현재까지의 시간을 밀리초로 리턴
		rand2.setSeed(System.currentTimeMillis()); //seed 설정 
		System.out.println("rand1 객체에서 난수 발생:");
		for (int i=0;i<5;i++)
			System.out.println(i+":" + rand1.nextInt(100));//0~99사이
		System.out.println("rand2 객체에서 난수 발생:");
		for (int i=0;i<5;i++)
			System.out.println(i+":" + rand2.nextInt(100));
	}
}
