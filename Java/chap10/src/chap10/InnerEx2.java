package chap10;
class Outer2 {
	private int outeriv = 10;
	private static int outercv = 20;
	class InstanceInner {
		int iiv = outeriv; //외부클래스의 private 멤버 접근 가능
		int iiv2 = outercv;
	}
	static class StaticInner {
//		int siv = outeriv; //클래스 멤버에서 인스턴스멤버 호출
//		int siv = new Outer2().outeriv;
		int siv = outercv;
		static int scv = outercv; 
	}
	void method(int pv) {
		int n = 0;
//		pv += 1;
//		n = 100;
/*
 * 지역 내부클래스의 멤버 메서드내에서 메서드의 지역 변수 접근시
 * 지역변수는 상수화 되어야 한다.
 * 지역변수의 변경이 없다면 상수로 취급함 	
 * 지역변수가 변경이 되면 상수로 취급하지 않으므로 오류 발생 	
 */
		class LocalInner {
			int liv = outeriv; //외부클래스의 private 멤버에 접근 가능
			int lcv = outercv;
			void method(int num) { //지역내부클래스의 멤버 메서드
				num += 10;
				liv += 100;
				System.out.println("num="+num);
				System.out.println("liv="+liv);
				System.out.println("lcv="+lcv);
				System.out.println("n="+n);
				System.out.println("pv="+pv);
				outeriv++;
				System.out.println("outeriv="+outeriv);
			}
		}
		//LocalInner 객체화. method 호출
		LocalInner li = new LocalInner();
		li.method(100);
	}
}
public class InnerEx2 {
	public static void main(String[] args) {
		//InstanceInner, StaticInner, method() 호출하기
		Outer2 o = new Outer2();
		Outer2.InstanceInner ii = o.new InstanceInner();
		Outer2.StaticInner si = new Outer2.StaticInner();
		o.method(10);
	}
}
