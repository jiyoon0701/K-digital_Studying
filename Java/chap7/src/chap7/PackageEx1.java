package chap7;

import java.util.Date;

//import chap7.test.Pack2;
import chap7.test.*;  //chap7.test 패키지에 속한 모든 클래스들은 패키지명 생략

/*
 * 패키지 예제
 * 
 * package
 *  1. 클래스들의 모임.
 *  2. 클래스의 이름은 패키지명을 포함한다.
 *  3. package 설정은 파일의 처음에 한번만 가능하다.
 *     => 하나의 파일에 구현된 모든 클래스는 같은 패키지의 클래스다
 *  4. 자바에서 패키지는 폴더로 구분된다.
 *  
 *  클래스의 패키지명을 생략가능한 경우
 *  1. 같은 패키지에 속한 클래스의 이름은 패키지명을 생략 가능 
 *  2. java.lang 패키지에 속한 클래스들은 패키지명을 생략 가능
 *  3. import 구문으로 설정된 클래스는 패키지명 생략 가능
 */
class A {}  // chap7.A
class Pack1 {
	void method() {
		System.out.println("chap7.Pack1 클래스의 method 메서드");
	}
}
public class PackageEx1 {  //chap7.PackageEx1 클래스명
	public static void main(String[] args) {
		Pack1 p = new Pack1(); //PackageEx1 클래스와 같은 패키지에 속한 클래스 
		p.method();
		
		Date today = new Date();
		System.out.println(today);
		
		Pack2 p2 = new Pack2();
		p2.method();
	}
}