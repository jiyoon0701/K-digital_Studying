package chap6;
/*
 * 추상화 : 클래스 생성과정. 
 * 클래스 : 사용자 정의 자료형.
 *    속성 : 멤버변수
 *    기능 : 멤버메서드
 * 
 * 객체화 : 클래스를 이용하여 메모리를 할당.
 *        객체에는 멤버(변수,메서드)값 가진다.   
 */
class Phone {
	String color;  //멤버변수
	boolean power; //멤버변수
	String no;     //멤버변수
	
	void power() { //멤버메서드
		power = !power;  //멤버변수
	}
	void send(String no) {  //멤버메서드
		System.out.println(no + "로 전화 거는 중"); //매개변수 no.
	}
	void receive(String no) { //멤버메서드
		System.out.println(no + "에서 전화 받는 중"); //매개변수 no
	}
}
//구동클래스 : main 메서드가 존재하는 클래스. 프로그램 실행
public class PhoneEx1 {
	public static void main(String[] args) {
		//p1 : 참조변수. Phone 객체를 참조하는 변수
		Phone p1 = new Phone(); //객체화, 인스턴스화.
		/*
		 * new 예약어 기능
		 * 1. 힙영역 메모리 할당
		 * 2. 멤버변수를 기본값으로 초기화
		 *    기본값 
		 *    참조변수 : null
		 *    boolean : false
		 *    숫자    : 0
		 * 3. 생성자 호출
		 * 
		 * = : 참조값을 참조변수에 저장. 
		 */
		p1.color = "검정";
		p1.power = true;
		p1.no = "01012345678";
		System.out.println(p1.color + "," + p1.power + "," + p1.no);
		//멤버 메서드 호출(실행)
		p1.send("01043215678");
		p1.receive("01043215678");
		Phone p2 = new Phone();
		p2.color = "분홍";
		p2.power = true;
		p2.no = "01043215678";
		System.out.println(p2.color + "," + p2.power + "," + p2.no);
		p2.send(p1.no);
		p2.receive(p1.no);
		p1 = p2;
		System.out.println(p1.color + "," + p1.power + "," + p1.no);
		System.out.println(p2.color + "," + p2.power + "," + p2.no);
		p1.color="파랑";
		System.out.println(p1.color + "," + p1.power + "," + p1.no);
		System.out.println(p2.color + "," + p2.power + "," + p2.no);
	}
}
