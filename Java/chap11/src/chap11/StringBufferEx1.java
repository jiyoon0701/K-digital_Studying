package chap11;
/*
 * StringBuffer 클래스
 *  1. 동적문자열. 변경 가능한 문자열
 *  2. equals 메서드를 오버라이딩 안함. => 내용 비교 안됨.
 *     => 내용 비교를 위해서는 String 객체로 비교해야 함.
 *  3. String 클래스의 보조 역할   
 *  4. = 대입연산자로 객체 생성 불가
 *  5. StringBuilder 클래스와 같은 기능
 */
public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("abc");
		StringBuffer s2 = new StringBuffer("abc");
		if(s1 == s2) System.out.println("s1 == s2 : 같은 객체임");
		else System.out.println("s1 != s2 : 다른 객체임");
		if(s1.equals(s2)) System.out.println("s1.equals(s2) : 같은 내용임");
		else System.out.println("s1.equals(s2) : 다른 내용임");
		//내용 비교
		if(s1.toString().equals(s2.toString()))
	 System.out.println("s1.toString().equals(s2.toString()) : 같은 내용임");
		else System.out.println("s1.equals(s2) : 다른 내용임");
		
	}
}
