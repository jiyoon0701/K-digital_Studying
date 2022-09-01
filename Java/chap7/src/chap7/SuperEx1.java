package chap7;
/*
 * super() 생성자 : 부모클래스의 생성자 호출 . 첫번째 줄에 구현해야 함.
 */
class Super {
	int x;
	Super() {
		this(0);
	}
	Super(int x) {  //생성자
		this.x = x;
	}
}
class Child extends Super { //기본생성자 제공. 
	int y;
	public Child() {
		super(10);  //
		System.out.println("생성자 호출");
	}
}
public class SuperEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.x);
		System.out.println(c.y);
	}
}
