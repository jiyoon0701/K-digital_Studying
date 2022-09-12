package chap11;
/*
 * String 클래스
 *   1. 클래스 중 유일하게 대입연산자(=)로 객체 생성이 가능함.
 *   2. 클래스 중 유일하게 + 연산자 사용 가능.
 *   3. 정적인 문자열. 변경불가 문자열
 *   4. final 클래스임. => 다른 클래스의 부모 클래스 불가.
 */
// class MyString extends String {}  //상속불가
public class StringEx1 {
	public static void main(String[] args) {
		String s1 = "abc"; //대입연산자로 객체 생성
		String s2 = "abc"; //대입연산자로 객체 생성
		String s3 = new String("abc"); 
		String s4 = new String("abc");
		if(s1 == s2) System.out.println("s1 == s2 : 같은 객체"); //참조값 같다
		else System.out.println("s1 != s2 : 다른 객체");
		if(s3 == s4) System.out.println("s3 == s4 : 같은 객체");
		else System.out.println("s3 != s4 : 다른 객체");  //참조값이 다르다
		if(s1.equals(s2)) System.out.println("s1.equals(s2) : 같은 내용");
		else System.out.println("! s1.equals(s2) : 다른 내용");
		if(s3.equals(s4)) System.out.println("s3.equals(s4) : 같은 내용");
		else System.out.println("! s3.equals(s4) : 다른 내용");
	}
}
