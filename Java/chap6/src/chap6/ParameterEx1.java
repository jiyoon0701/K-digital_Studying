package chap6;
/*
 * 매개변수의 자료형
 *   기본형 매개변수
 *   참조형 매개변수
 */
class Value {
	int val;
}
public class ParameterEx1 {
	public static void main(String[] args) {
		Value v = new Value();
		v.val = 100;
		change1(v.val); //값전달
		System.out.println("change1() 이후:" + v.val);
		change2(v);  //참조값
		System.out.println("change2() 이후:" + v.val);
	}
	static void change1(int val) {
		val += 100;
		System.out.println("change1() :" + val);
	}
	static void change2(Value v) {
		v.val += 100;  //main에서 생성된 객체의 참조값으로 객체의 값을 수정.
		System.out.println("change2() :" + v.val);
	}
}
