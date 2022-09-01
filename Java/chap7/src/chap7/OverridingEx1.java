package chap7;
/*
 * 오버라이딩 예제
 * 
 * 오버라이딩 : 메서드의 재정의
 * 1. 상속관계에서 부모의 메서드를 자손클래스에서 재정의함.
 * 2. 부모클래스 메서드의 선언부와 자손클래스의 메서드의 선언부가 같아야 함.
 * 3. 접근제어자는 넓은범위로 가능.
 * 4. 예외처리는 좁은 범위로 가능
 * 
 * 오버로딩 : 메서드의 다형성
 * 1. 같은 클래스내에 같은이름의 메서드 존재. 단 매개변수가 달라야 한다.
 * 2. 리턴타입, 접근제어자, 예외처리등은 상관없다. 
 */
class Bike {
	int wheel;
	Bike(int wheel) {
		this.wheel = wheel;
	}
	String drive() {
		return "페달을 밟는다";
	}
	String stop() {
		return "브레이크를 잡는다";
	}
}
class AutoBike extends Bike {
	boolean power;
	AutoBike(int wheel) {
		super(wheel); //부모클래스의 생성자에 맞도록 호출
	}
	void power() {
		power = !power;
	}
	/*
	 * 어노테이션 : 알고리즘과 관계없이 검증, 실행을 위한 보조 도구
	 * 
	 */
	@Override  //오버라이딩이 정확하게 코딩됐는지를 검증하는 어노테이션
	String drive() {
		return "출발버튼을 누른다";
	}
}
public class OverridingEx1 {
	public static void main(String[] args) {
		AutoBike ab = new AutoBike(2);
		System.out.println(ab.drive());
		System.out.println(ab.stop());
		Bike b = new Bike(2);
		System.out.println(b.drive());
		System.out.println(b.stop());
	}
}
