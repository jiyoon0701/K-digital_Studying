package chap7;
/*
 * 1. Animal 클래스 => 추상클래스
 *    멤버변수 : 동물의 종류, 다리수
 *    생성자 : 동물의 종류랑 다리수 입력받기.
 *    멤버메서드 :
 *        void eat(); => 추상메서드
 *        void sound(); => 추상메서드
 * 2. Dog클래스  :  Animal 클래스의 자손클래스
 *    생성자의 매개변수 없음.
 *    멤버메서드 :
 *        void eat() :  "주인이 주는대로 먹는다" 출력
 *        void sound(); "멍멍";
 * 3. Lion클래스  :  Animal 클래스의 자손클래스
 *    생성자의 매개변수 없음.
 *    멤버메서드 :
 *        void eat() :  "초식동물을 잡아 먹는다" 출력
 *        void sound(); "어흥";
 * 구동 클래스 실행시 다음의 결과가 나오도록 클래스 구현하기
 * 
  [결과]
강아지=>멍멍
주인이 주는대로 먹는다
사자=>어흥
초식동물을 잡아먹는다
 */

abstract class Animal{
	String type;
	int leg;
	
	
	Animal(String type, int leg){
		this.type = type;
		this.leg = leg;
	}
	
	abstract void eat();
	abstract void sound();
	
}

class Dog extends Animal{
	
	Dog(){
		super("강이지", 4);
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println("주인이 주는대로 먹는다");
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}

}

class Lion extends Animal{
	
	Lion(){
		super("사자", 4);
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println("초식동물을 잡아 먹는다");
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		System.out.println("어흥");
	}

}


public class Test3 {
	public static void main(String[] args) {
		Animal[] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Lion();
		for(Animal a : animal) {
			System.out.print(a.type + "=>");
			a.sound();
			a.eat();
		}

	}

}
