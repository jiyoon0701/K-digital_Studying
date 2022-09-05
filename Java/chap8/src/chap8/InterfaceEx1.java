package chap8;
/*
 * 인터페이스
 * 1. 인터페이스 멤버는 상수, 추상메소드, default메소드, static 메서드만 가능함.
 * 2. 인터페이스의 모든 멤버의 접근제한자는 public임.
 * 3. 객체화 불가 => 구현클래스의 객체화를 통해서 객체화 됨.
 * 4. 인터페이스간의 상속은 다중 상속이 가능
 * 클래스간의 상속은 단일 상속임.
 * 5. 클래스와 인터페이스의 관계는 구현(implements)으로 표현함.
 * 	=> 다중 구현이 가능함
 * 6. 구현클래스의 객체는 구현된 인터페이스의 형으로 형변환이 가능함.
 * */
interface Printerable { // interface의 모든 접근제한자는 public이다.
	// public static final int INK = 100; // 상수. 인터페이스를 사용하지 않을 시 작성법
	int INK = 100; // 상수. public static final 생략됨
	// public abstract void print();
	void print(); // 추상메소드 public abstract 생략됨
}

interface Scannerable {
	void scan();
}

interface Faxable {
	String FAX_NO = "02-1234-5678";
	void send(String no);
	void receive(String no);
}

interface Complexerable extends Printerable, Scannerable, Faxable {}
// Complexer : 구현클래스.
//			추상메서드 구현해야함.
class Complexer implements Complexerable {
	int ink;
	Complexer(){
		this.ink = INK;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("종이에 출력합니다. 남은 잉크량 :" + --ink);
	}

	@Override
	public void scan() {
		// TODO Auto-generated method stub
		System.out.println("이미지를 스캔하여 파일에 저장합니다.");
	}

	@Override
	public void send(String no) {
		// TODO Auto-generated method stub
		System.out.println(FAX_NO + "에서"+ no + "번호로 FAX를 전송합니다.");
	}

	@Override
	public void receive(String no) {
		// TODO Auto-generated method stub
		System.out.println(no+"에서"+ FAX_NO + "로 FAX를 받았습니다.");
	}
	
}

public class InterfaceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Printerable.INK);
		// Printerable.INK = 200; 상수 변경 불가
		// Complexerable c1 = new Complexerable(); 인터페이스는 직접 객체화 불가
		
		Complexer c1 = new Complexer();
		System.out.println(c1.ink); // 100
		c1.print();
		System.out.println(c1.ink); // 99
		c1.scan();
		c1.receive("02-5678-1234");
		c1.send("02-5678-1234");
		System.out.println(c1.INK); // 100
		if (c1 instanceof Complexerable) {
			System.out.println("c1 객체는 Complexerable 객체임");
			Complexerable c = (Complexerable)c1; // 자동형변환. 형변한 연산자 생략 가능
			c.print();
			c.scan();
			c.receive("02-5678-1234");
			c.send("02-5678-1234");
			//System.out.println(c.ink); ink는 Complexerable 인터페이스의 멤버가 아니다.
		}
		
		if (c1 instanceof Printerable) {
			System.out.println("c1 객체는 Printerable 객체임");
			Printerable p = c1;
			p.print();
			// p.scan(); Scannerable 멤버임
			//p.receive("02-5678-1234"); // Faxable 멤버
			//p.send("02-5678-1234"); Faxable 멤버
			System.out.println(p.INK);
			//System.out.println(p.ink); ink는 Printerable 인터페이스의 멤버가 아니다.
		}
		
		if (c1 instanceof Scannerable) {
			System.out.println("c1 객체는 Scannerable 객체임");
			Scannerable s = c1;
			//p.print(); Printerable 멤버임
			 s.scan(); 
			//p.receive("02-5678-1234"); // Faxable 멤버
			//p.send("02-5678-1234"); Faxable 멤버
			//System.out.println(s.INK); Printerable
			//System.out.println(s.ink); ink는 Printerable 인터페이스의 멤버가 아니다.
		}
		
		
		if (c1 instanceof Faxable) {
			System.out.println("c1 객체는 Faxable 객체임");
			Faxable f = c1;
			//f.print(); Printerable 멤버임
			 //f.scan(); 
			f.receive("02-5678-1234"); 
			f.send("02-5678-1234");
			//System.out.println(s.INK); Printerable 멤버
			//System.out.println(s.ink); ink는 Printerable 인터페이스의 멤버가 아니다.
		}
	}

}
