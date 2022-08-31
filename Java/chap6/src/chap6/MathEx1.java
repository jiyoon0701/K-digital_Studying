package chap6;
/*
 * 메서드(함수) 구성
 * [접근제어자] 리턴타입 메서드이름 (매개변수 목록) => 선언부
 * {
 *     문장들;                           => 구현부
 * }
 * 
 * 리턴타입 : 메서드 종료 후 전달되는 값의 자료형 설정
 *     void : 메서드 종료 후 전달 되는 값이 없는 경우
 *     자료형 : 메서드 종료 후 전달 되는 값 자료형 설정
 * 매개변수 : 메서드 호출시 전달되는 값의 자료형과 변수명을 설정  
 *         매개변수가 없는 경우 ()로 표현함.
 *         
 * return : 메서드 종료.
 *    리턴타입이 void인경우 생략가능함. 메서드의 끝 } 를 만나면 메서드 종료.
 *    리턴타입이 void가 아닌경우 반드시 사용해야함.
 *       return 리턴값;  => 리턴값을  리턴타입과 동일하거나, 자동형변환이 가능하면 됨.           
 */
class Math1 {
	int add1(int a, int b) { //add1 함수호출시 정수형값2개 입력. int값을 리턴
		//a=15
		//b=20
		return a+b; //35 리턴. 호출한 메서드(main)로 값전달
	}
	long add2(int a, int b) {
		//a=10
		//b=20
		return a+b; //30 결과는 int형 => long형으로 자동형변환되어 리턴됨.
	}
	void add3(int a, int b) {
		System.out.println(a+b);
		return;
	}
}
public class MathEx1 {
	public static void main(String[] args) {
		Math1 m1 = new Math1(); //객체화
		//a1 = 35
		int a1 = m1.add1(15,20); //메서드 호출. 메서드 실행
		System.out.println(a1); //35
		System.out.println(m1.add1(15,20)); //35
		
		long a2 = m1.add2(10, 20); //long 형 30
		System.out.println(a2); //30
		int a3 = (int)m1.add2(10, 20); //long 형 30
		System.out.println(a3); //30
		m1.add3(15,25);	//40
//		System.out.println(m1.add3(15,25));//오류.리턴타입이 void인 함수 출력 불가
	}
}
