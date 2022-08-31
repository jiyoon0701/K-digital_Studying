package chap6;
/*
 * 오버로딩의 조건
 * 1. 메서드의 이름이 같다
 * 2. 매개변수(자료형기준) 목록이 다르다. : 순서, 갯수,종류 달라야 한다.
 * 3. 그외 리턴타입, 접근제어자는 상관없다.
 * 
 * 오버로딩된 메서드의 선택 기준
 * 1. 호출시 입력된 값의 자료형과 선언부에 선언된 자료형이 동일한 경우 우선 선택.
 * 2. 1번이 없는 경우
 *    자동형변환이 최소화 되는 매개변수를 가진 메서드 선택
 * 3. 주의사항.
 *    최소 갯수로 자동형변환되는 매개변수를 가진 메서드가 2개이상 존재하면 오류 발생   
 */
class Math4 {
	/*
	int add(int x, int y) {
		System.out.print("1:");
		return x+y;
	}
    */
	int add(int a, int b) {
		System.out.print("1:");
		return a+b;
	}
	long add(long a, int b) {
		System.out.print("2:");
		return a+b;
	}
	long add(int a, long b) {
		System.out.print("3:");
		return a+b;
	}
	long add(long a, long b) {
		System.out.print("4:");
		return a+b;
	}
	
}
public class OverloadingEx2 {
	public static void main(String[] args) {
		Math4 m = new Math4();
		System.out.println(m.add(10, 20)); 
		System.out.println(m.add(10, 20L));
		System.out.println(m.add(10L, 20));
		System.out.println(m.add(10L, 20L));
	}
}
