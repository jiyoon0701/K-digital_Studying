package chap7;
/*
 * super 참조변수 : 부모클래스의 객체를 참조하는 참조변수
 *               부모 객체의 멤버 호출시 사용되는 참조변수
 *               
 * super 생성자
 *  1. 부모클래스의 생성자를 자손클래스의 생성자에서 호출
 *  2. 첫줄에서 호출해야 함.
 *  3. 부모클래스의 생성자에 매개변수가 있는 생성자만 있다면 
 *     자손클래스의 생성자에서 반드시 부모클래스의 생성자에 맞도록 호출해야함.
 *     super(매개변수)
 *  4. 부모클래스의 생성자에 매개변수가 없는 생성자가 있다면 super() 생략할 수 있음.                  
 */
class Super2 {
	int x = 10;
	void method() {
		System.out.println("Super2 클래스의 method()");
	}
}
class Child2 extends Super2 {
	int x = 20;
	void method() {
		super.method(); //부모클래스의 method() 호출
		System.out.println("Child2 클래스의 method()");
		int x = 30;
		System.out.println("x=" + x); //30
		System.out.println("this.x=" + this.x); //10
		System.out.println("super.x=" + super.x); //10
	}
}
public class SuperEx2 {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.method();
	}
}
