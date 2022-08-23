package chap3;
/*
 * 비교연산자(관계연산자) : ==, !=, >, >= ... => 결과값은 boolean
 * 논리연산자 : &&(AND, ||(OR) => boolean && boolean
 * 	T && T => T
 *  T && F => F
 *  F && T => F
 *  F && F => F
 *  && 문장 : 앞쪽 구문의 결과가 F인경우 뒤쪽 문장하지 않음
 *  T || T => T
 *  T || F => T
 *  F || T => T
 *  F || F => F
 *  ||문장 : 앞쪽 구문의 결과가 T인 경우 뒤쪽 문장하지 않음
 * */

public class OpEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 1, y = 1;
		System.out.println("1 == 1 :" + (x == y)); // true
		System.out.println("1 != 1 :" + (x != y)); // false
		System.out.println("1 >= 1 :" + (x >= y)); // true
		System.out.println("1 > 1 :" + (x > y)); // false
		
		System.out.println("x == 1 && y == 2 :" + (x==1 && y==2)); // false
		System.out.println("x == 1 && y == 2 :" + (x==1 || y==2)); // true

	}

}
