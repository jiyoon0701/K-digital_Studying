package chap8;
/*
 * Animal 클래스는 다음과 같다. 구동 클래스를 실행했을때 다음의 결과나 
 * 나오도록 프로그램 구현하기  
 * [결과]
 * 비둘기는 작은 벌레를 잡아 먹는다.
 * 비둘기는 날아 다니는 새입니다.
 * 원숭이는 나무에서 열매를 따서 먹는다
 * 독수리는 작은 새를 잡아 먹는다.
 * 독수리는 엄청 높이 날아 다닌다.
 */

interface Flyable {
	void fly();
}


abstract class Animal {
	String name;
	Animal(String name){
		this.name = name;
	}
	abstract void eat();
}


class Dove extends Animal implements Flyable{

	Dove() {
		super("비둘기");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(name +"는 날아 다니는 새입니다.");
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println("비둘기는 작은 벌레를 잡아 먹는다.");
	}
	
}

class Monkey extends Animal{

	Monkey() {
		super("원숭이");
		// TODO Auto-generated constructor stub
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println(name+"나무에서 열매를 따서 먹는다.");
	}
	
}

class Eagle extends Animal implements Flyable{

	Eagle() {
		super("독수리");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(name +"엄청 높이 날아 다닌다.");
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println(name+"는 작은 벌레를 잡아 먹는다.");
	}
	
}
public class Exam1 {

	public static void main(String[] args) {
		Animal[] arr = new Animal[3];
		arr[0] = new Dove();
		arr[1] = new Monkey();
		arr[2] = new Eagle();
		for(Animal a : arr) {
			a.eat();
			if(a instanceof Flyable) { // Dove 객체는 Flyable 형변환 가능
				Flyable f = (Flyable)a; // 자동형변환 불가
				// a.fly();
				f.fly(); // Flyable 타입의 참조변수로 fly()
			}
		}
	}

}
