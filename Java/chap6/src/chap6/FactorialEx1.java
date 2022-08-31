package chap6;
/*
 * stack 영역 예제.
 * 재귀메서드 : 자신의 메서드를 호출하는 메서드
 *           스택영역이 있으므로 가능함
 */
public class FactorialEx1 {
	public static void main(String[] args) { //클래스 멤버
		System.out.println("4!="+factorial(4)); //4*3*2*1
	}
	private static  int factorial(int i) {
		return (i==1)?1:i*factorial(i-1);
	}
}
