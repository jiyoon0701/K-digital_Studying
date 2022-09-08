package chap11;
/*
 * toString() : 객체를 문자열로 리턴하는 메서드
 *              참조변수를 출력하면 자동으로 toString() 메서드가 호출됨.
 *     Object 클래스 : 클래명@16진수해쉬코드 출력되도록 구현됨.
 *        => 각각의 클래스에서 내용출력하기 위해서는 오버라이딩 필요         
 */
public class ObjectEx3 {
	public static void main(String[] args) {
		Equal e1 = new Equal(10);
		Equal e2 = new Equal(20);
		System.out.println(e1); //toString() 메서드 호출
		System.out.println(e2); //toString() 메서드 호출
	}
}