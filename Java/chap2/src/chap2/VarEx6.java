package chap2;
/*
 * String 연산
 * 1. 참조자료형. String 클래스
 * 2. 대입연산자로 문자열 객체 생성 가능
 * 3. + 연산이 가능한 유일한 클래스
 * String = String + 기본형
 * */
public class VarEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc"; // 대입연산자로 객체 생성 가능
		String str2 = str1 + 100;
		System.out.println(str2); // abc100
		str2 = str1 + true;
		System.out.println(str2); // abctrue
		str2 = str1 + 1+2+3;
		System.out.println(str2); // abc123
		str2 = 1+2+3+str1;
		System.out.println(str2); // 6abc

	}

}
