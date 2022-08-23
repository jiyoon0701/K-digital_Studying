package chap3;
/*
 * 단항연산지 : 연산자에 피연산자가 한개인 연산자.
 * 			대부분 우선 순위가 높다
 * 1. 증감연산자 : ++, --
 * 		++ : 변수의 값을 1증가
 * 		-- : 변수의 값을 1감소
 *
 *
 */

public class OpEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=5 ,y=5;
		// 후위형 : 우선순위가 낮다
		x++;
		y--;
		System.out.println("x="+x+"y"+y);
		// 전위형 : 우선순위가 높다
		++x;
		--y;
		System.out.println("x="+x+"y"+y);
		
		x = y= 5;
		y = ++x; // 1. ++x, 2.y값에 대입
		System.out.println("x="+x+"y"+y); // 6,6
		y = x++; // 1. y값에 대입, 2. x++
		System.out.println("x="+x+"y"+y); // 7, 6
		
		x = y= 5;
		y = x++; // 1. ++x, 2.y값에 대입
		System.out.println("x="+x+"y"+y); // 6, 5
		y = ++x; // 1. y값에 대입, 2. x++
		System.out.println("x="+x+"y"+y); // 7, 7
		
		x = 5;
		System.out.println("x="+ x++); // x = 5
		System.out.println("x="+ ++x); // x = 7
	}

}
