package chap6;
/*
 *  구동클래스가 정상적으로 실행 되도록 Animal3 클래스 구현하기
 *  Animal3 클래스의 멤버
 *    멤버 변수 : name,age
 *    멤버 메서드 : toString() 
 *    생성자
 */ 
class Animal3 {
	String name;
	int age;
	Animal3(String n, int a) { //생성자
		name=n;
		age=a;
	}
	public String toString() {
		return name + ":" + age;
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Animal3 a =new Animal3("원숭이",20);
		System.out.println(a); //원숭이:20
	}
}
