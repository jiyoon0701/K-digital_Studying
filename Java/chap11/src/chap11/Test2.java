package chap11;
/*
 * 결과가 다음과 같이 나오도록 프로그램 완성하기
 * 
[결과] 
지역 변수 value=30
내부클래스 객체의 멤버 value=20
외부클래스 객체의 멤버 vlaue=10
 */


class Outer11 {
	int value = 10;
	class Inner {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println("지역 변수 value="+value);
			System.out.println("내부클래스 객체의 멤버 value="+this.value);
			System.out.println("외부클래스 객체의 멤버 vlaue=" + Outer11.this.value);
		}
	}
}

public class Test2 {
	public static void main(String[] args) {
		new Outer11().new Inner().method1();
	}
}