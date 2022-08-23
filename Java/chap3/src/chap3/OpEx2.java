package chap3;
/*
 * 단항연산자 :
 *   1. 논리부정 : !
 *   2. 부호연산자 : +, -
 *   	+ : 현재 부호를 유지.
 *   	- : 현재 부호를 변경. 양수 => 음수, 음수 => 양수
 * */

public class OpEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("true=" + !false);
		System.out.println("true=" + !true);
		System.out.println("1==1:" + (1==1));
		System.out.println("1!=2:" + (1!=2));
		
		int x = -10;
		System.out.println("+x=" + +x); // -10
		System.out.println("+x=" + -x); // 10
		
		x=10;
		System.out.println("+x=" + +x); // 10
		System.out.println("+x=" + -x); // -10
		
		
	}

}
