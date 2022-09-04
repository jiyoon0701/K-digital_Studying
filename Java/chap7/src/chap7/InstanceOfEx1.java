package chap7;
/*
 * instanceof 연산자 예제 
 */
class Super3 {
	int x=10;
	void method() {
		System.out.println("Super3 메서드");
	}
}
class Child3 extends Super3 {
	int x= 20;
	int y= 100;
	void method() {
		System.out.println("Child3 메서드");
	}
}
public class InstanceOfEx1 {
	public static void main(String[] args) {
		Super3 s = new Child3();
		Child3 c;
		/*
		 * s 참조변수가 참조하는 객체를 Child3타입으로 형변환 가능?
		 */
		if(s instanceof Child3) {
		    c = (Child3)s;
		    System.out.println("s 객체는 Child3 타입의 참조변수로 참조 가능" );
		    System.out.println("s 객체는 Child3 객체임" );
		    System.out.println(c.x); //20
		    System.out.println(c.y); //100
		    c.method(); //Child3 메서드
		}
		if(s instanceof Super3) {
		    System.out.println("s 객체는 Super3 타입의 참조변수로 참조 가능" );
		    System.out.println("s 객체는 Super3 객체임" );
		    System.out.println(s.x); //10
		    //System.out.println(s.y); //오류. y멤버는 Super3의 멤버가 아님.
		    s.method(); //Child3 메서드
		}
		/*
		 * 모든 클래스는 Object 클래스를 상속받는다.
		 * => 모든 객체는 Object 객체를 포함한다.
		 * => 모든 객체는 Object 타입의 참조변수로 참조가 가능하다.
		 */
		if(s instanceof Object) {
		    System.out.println("s 객체는 Object 타입의 참조변수로 참조 가능" );
		    System.out.println("s 객체는 Object 객체임" );
		    Object o = s;
		    //System.out.println(o.x);//오류. Object의 멤버가 아님 
		    //System.out.println(o.y);//오류. Object의 멤버가 아님 
		    //o.method();//오류. Object의 멤버가 아님
		}
		  
		
	}
}
