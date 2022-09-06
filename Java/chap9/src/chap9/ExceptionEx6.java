package chap9;
/*
 * 오버라이딩에서의 예외처리 : 부모클래스의 예외처리와 같거나 작은범위(하위예외객체) 가능 
 */
class Parent {
	public void method() throws RuntimeException {
		System.out.println("Parent 클래스의 method()");
	}
}
class Child extends Parent {
	public void method() throws ArithmeticException {
		System.out.println("Child 클래스의 method()");
	}
}
public class ExceptionEx6 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}
}
