package chap7;
/*
 * 다형성 예제
 * 1. 참조변수의 형변환
 */
class Bike2 {
	int wheel;
	Bike2(int wheel) {
		this.wheel = wheel;
	}
	void drive() {
		System.out.println("패달을 밟는다");
	}
	void stop () {
		System.out.println("브레이크를 잡는다");
	}
}
class AutoBike2 extends Bike2 {
	boolean power;
	AutoBike2(int wheel) {
		super(wheel);
	}
	void power() {
		power = !power;
		if(power)  System.out.println("전원이 켜졌습니다.");
		else 	   System.out.println("전원이 꺼졌습니다.");
	}
}
public class AutoBikeEx2 {
	public static void main(String[] args) {
		AutoBike2 ab =new AutoBike2(2);
		Bike2 b;
		ab.power();
		ab.drive();
		ab.stop();
		b = ab; //형변환
//		b.power(); //자손클래스의 멤버는 접근 불가
		System.out.println(ab.power);
		b.drive();
		b.stop();
	}
}
