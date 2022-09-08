package chap10;

/*
 * 내부클래스 : 클래스 내부에 존재하는 클래스
 *           자료형은 외부클래스명.내부클래스명 
 * 
 *   외부클래스 : 내부클래스가 멤버로 인식한다.
 *   내부클래스 : 
 *      1. 인스턴스내부클래스 : 객체화시 외부클래스의 객체화 먼저되어야 함.
 *      2. static내부클래스 : new 외부클래스명.내부클래스() 객체화 됨.
 *                         외부클래스의 객체화 필요없음.
 *      3. 지역내부클래스 : 메서드 내에 선언된 클래스. 메서드 내에서만 객체화 가능.                   
 */
class Outer1 { //외부클래스
	class InstanceInner extends Object { //인스턴스 내부클래스
		int iv = 100;
		static int cv=10;  //자바버전 확인. 
		final static int MAX=200;
	}
	static class StaticInner { //static 내부클래스
		int iv = 300;
		static int cv=20;
		final static int MAX=400;
	}
	void method() {
		class LocalInner { //지역내부클래스(Local Inner):메서드내부에서만 사용가능
			int iv = 500;
			static int cv=600;
			final static int MAX=700;
		}
		LocalInner lc = new LocalInner();
		System.out.println("LocalInner.iv:"+lc.iv);
		System.out.println("LocalInner.cv:"+LocalInner.cv);
		System.out.println("LocalInner.MAX:"+LocalInner.MAX);
	}
	void method2() {
//		LocalInner lc = new LocalInner();
		InstanceInner ii = new InstanceInner();
		System.out.println("InstanceInner.iv:"+ii.iv);
		System.out.println("InstanceInner.cv:"+InstanceInner.cv);
		StaticInner si = new StaticInner();
		System.out.println("StaticInner.iv:"+si.iv);
		System.out.println("StaticInner.cv:"+StaticInner.cv);
	}
}
public class InnerEx1 {
	public static void main(String[] args) {
		//InstanceInner 객체화
//		Outer1.InstanceInner ii = new Outer1().new InstanceInner();
		Outer1 out = new Outer1();
		out.method();
		out.method2();
		Outer1.InstanceInner ii = out.new InstanceInner();
		System.out.println("InstanceInner.iv:"+ii.iv);
		System.out.println("InstanceInner.cv:"+Outer1.InstanceInner.cv);
		System.out.println("InstanceInner.MAX:"+Outer1.InstanceInner.MAX);
		//StaticInner 객체화
		Outer1.StaticInner si = new Outer1.StaticInner();
		System.out.println("StaticInner.iv:"+si.iv);
		System.out.println("StaticInner.cv:"+Outer1.StaticInner.cv);
		System.out.println("StaticInner.MAX:"+Outer1.StaticInner.MAX);
		//내부 클래스의 객체도 Object클래스의 하위 클래스임.
		if(ii instanceof Object) {
			System.out.println("ii 객체는 Object 객체임");
		}
		if(si instanceof Object) {
			System.out.println("si 객체는 Object 객체임");
		}		 
	}
}
