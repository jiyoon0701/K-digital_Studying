package chap7;
/*
 * 상속예제
 * 
 * 1. 자손클래스의 객체를 생성시 부모 객체를 먼저 생성함
 * 2. 자손객체는 부모 클래스의 멤버에 접근이 가능하다.
 * 3. 클래스 간의 상속은 단일 상속만 가능하다.
 *    클래스의 부모클래스는 한개만 가능. 
 * 4. 모든클래스는 Object 클래스를 상속받는다.   
 * 5. Object 클래스는 모든 클래스의 부모클래스임
 *    - 모든 객체는 Object 클래스의 객체 포함한다.
 *    - 모든 객체는 Object 클래스의 멤버에 접근이 가능하다. 
 *    
 */
class Phone extends Object {
	boolean power;
	int number;
	void power() {
		power = !power;
	}
	void send() {
		if(power) 
			System.out.println("전화걸기");
	}
	void receive() {
		if(power) 
			System.out.println("전화받기");
	}
}
class SmartPhone extends Phone{
	void setApp(String name) {
		if (power)
			System.out.println(name + "앱 설치 중");
	}	
}
public class PhoneEx1 {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.power = true;
		sp.send();
		sp.receive();
		sp.setApp("크롬");
	}
}
