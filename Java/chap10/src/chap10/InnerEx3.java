package chap10;
/*
 * 내부클래스의 객체에서 this.: 내부클래스의 객체를 참조
 * 외부클래스의 멤버 접근
 *   외부클래스명.this.멤버명 으로 호출 
 */
class Outer3 {
	int iv = 10;
	int iv2 = 20;
	class InstanceInner {
		int iv= 100;
		void method1() {
			int iv = 300;
			System.out.println("iv="+iv);
			System.out.println("iv2="+iv2); //외부클래스의 멤버.
//			System.out.println("this.iv2="+this.iv2); //외부클래스의 멤버는 this 사용 불가.
			System.out.println("this.iv="+this.iv);
			System.out.println("Outer3.this.iv="+Outer3.this.iv);//외부클래스의 멤버.
			System.out.println("Outer3.this.iv2="+Outer3.this.iv2);//외부클래스의 멤버.
		}
	}
}
public class InnerEx3 {
	public static void main(String[] args) {
		Outer3.InstanceInner ii = new Outer3().new InstanceInner();
		ii.method1();
	}
}
