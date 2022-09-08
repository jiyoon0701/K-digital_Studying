package chap11;
/*
 * Outer10클래스의 내부 클래스 Inner1, Inner2 의 멤버변수 iv,cv의 값 출력되도록
 * 구동 클래스를 완성하시오
 [결과]
Outer10.Inner1.iv:100
Outer10.Inner1.cv:10
Outer10.Inner2.iv:200
Outer10.Inner2.cv:20
*/

class Outer10 {
	class Inner1 {
		int iv = 100;
		static int cv = 10;
	}
  static class Inner2 {
		int iv = 200;
		static int cv = 20;
	}
}

public class Test1 {
	public static void main(String[] args) {
		Outer10.Inner1 ii = new Outer10().new Inner1();
		System.out.println("Outer10.Inner1.iv:" + ii.iv);
		System.out.println("Outer10.Inner1.cv:" + Outer10.Inner1.cv);
		Outer10.Inner2 ii2 =new  Outer10.Inner2();
		System.out.println("Outer10.Inner2.iv:" + ii2.iv);
		System.out.println("Outer10.Inner2.cv:" + Outer10.Inner2.cv);
	}
}