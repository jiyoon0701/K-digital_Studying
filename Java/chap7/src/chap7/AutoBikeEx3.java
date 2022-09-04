package chap7;
/*
 * - 부모클래스의 멤버와 자손클래스의 멤버 같은 경우
 *   멤버 변수는 참조변수의 자료형을 따른다.
 *   멤버 메서드는 객체에 최종 오버라이딩된 메서드가 호출된다.
 *   
 * - 객체와 참조 변수의 관계
 *   부모 클래스의 객체는 자손클래스의 참조변수로 참조할 수 없다.
 *   자손클래스의 객체는 부모클래스의 참조변수로 참조 할 수 있다.
 *   
 * - 참조변수와 객체의 자료형이 틀린 경우는 ClassCastException 발생함.
 *   instanceof 연산자를 이용하여 미리 객체와 참조변수의 관계 확인할 수 있다.
 */
class Bike3 {
	int wheel;
	int price=10;
	Bike3(int wheel) {
		this.wheel = wheel;
	}
	void drive() {
		System.out.println("패달을 밟는다");
	}
	void stop() {
		System.out.println("브레이크를 잡는다");
	}
}
class AutoBike3 extends Bike3 {
	boolean power;
	int price = 200;
	AutoBike3(int wheel) {
		super(wheel);
	}
	void power() {
		power = !power;
		if(power) System.out.println("전원이 켜졌습니다.");
		else System.out.println("전원이 꺼졌습니다.");
	}
	void drive() {
		if(!power) power();
		System.out.println("출발버튼을 누른다");
	}
}
public class AutoBikeEx3 {
	public static void main(String[] args) {
		AutoBike3 ab = new AutoBike3(2);
		System.out.println("가격:" + ab.price); //200
		ab.drive();
		ab.stop();
		Bike3 b = (Bike3)ab; //형변환  부모클래스 <= 자손클래스 : 형변환 연산자 생략 가능
		System.out.println("가격:" + b.price); //10
		b.drive();
		b.stop();
		
//		Bike3 b2 = new Bike3(2);
		Bike3 b2 = new AutoBike3(2);//java.lang.ClassCastException 발생 안함
		//형변환이 가능.
		// 부모클래스의 자료형,자손클래스의 자료형간의 형변환 가능.
		//자손클래스 <= 부모클래스 형변환시 형변환 연산자 생략 불가
		AutoBike3 ab2 = (AutoBike3)b2;//java.lang.ClassCastException 오류발생
		System.out.println(b2.price);
		System.out.println(ab2.price);
	}

}
