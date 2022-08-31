package chap6;
/*
 * Circle1 클래스 구현하기
 * 1. 면적함수 : area(반지름) => Math.PI:원주율
 * 2. 둘레함수 : length(반지름)
 * 
 * 구동클래스
 * 1. Circle1 클래스 객체화
 * 2. 반지름이 10인 원의 넓이 둘레 화면출력하기 
 */
class Circle1 {
	double area(int r) {
		return r*r*Math.PI;
	}
	double length(int r) {
		return 2*r*Math.PI;
	}
	void area1(int r) {
		System.out.println("원의 면적:"+(r*r*Math.PI));
	}
	void length1(int r) {
		System.out.println("원의 둘레:"+(2*r*Math.PI));
	}
}
public class Exam3 {
	public static void main(String[] args) {
		Circle1 c1 = new Circle1();
		System.out.println("원의면적:"+c1.area(10));
		System.out.println("원의둘레:"+c1.length(10));
		c1.area1(10);
		c1.length1(10);
    }
}
/*		
이클립스 단축키 
  소스 정렬 : ctrl+shift+f : 
  주석처리 : ctrl+/   //로 처리. 토글키 : 한번더하면 주석 해제
  line 이동 : alt+화살표
*/
