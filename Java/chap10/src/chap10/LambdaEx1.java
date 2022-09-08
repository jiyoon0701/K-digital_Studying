package chap10;
/*
 * 람다 예제 : jdk8 이후 버전에서 사용 가능함.
 *   람다에서 사용되는 인터페이스는 FunctionalInterface 여야함.
 *   FunctionalInterface : 추상 메서드가 한개만 존재하는 인터페이스.
 *   
 * 매개변수, 리턴타입이 없는 경우
 * ()-> {....} 구현.
 * 구현되는 문장이 한개인 경우 {} 생략 가능    
 */
@FunctionalInterface //어노테이션 
interface LambdaInterface1 {
	void method();
//	void method1(); 
}
public class LambdaEx1 {
	public static void main(String[] args) {
		int num = 100;
//		num = 200;
		//이름없는 내부클래스 
		LambdaInterface1 fi = new LambdaInterface1() {
			@Override
			public void method() {
				System.out.println("기존 방식으로 코딩:num="+num);
			}
		};
		fi.method();
		//람다 방식 코딩
		fi = ()-> {
			System.out.println("람다 방식으로 코딩1:num="+num);
		};
		fi.method();
		fi = () -> System.out.println("람다 방식으로 코딩2:num="+num);
		fi.method();
	}
}
