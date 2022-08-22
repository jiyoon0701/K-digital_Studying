package chap2;
/*
 * 식별자(클래스, 변수, 메서드, 상수이름) 규칙
 *   -- 권장사항
 *   1. 클래스명 : 대문자 시작. 의미변경부분은 대문지(Camel 방식)
 *     String, StringBuffer
 *   2. 변수명 : 첫자는 소문자, 의미변경부분은 대문자.
 *     maxNum, maxScore, num
 *   3. 메서드 명 : 첫자는 소문자, 의미변경부분은 대문자.
 *     setName(), getNum()
 *   4. 상수명 : 모두 대문자 의미변경 _로 처리 (Snack방식)
 *     MAX_NUMBER
 *   -- 식별자 규칙
 *   1. 문자와 숫자만 가능. _, $만 가능함
 *   2. 숫자 시작해서는 안됨
 *   3. 예약어 사용 안됨
 * 
 * */
public class VarEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Number = 100;
		System.out.println("변수명은 소문자로 시작하세요:" + Number);
		int num1 = 10; // 정상
		// int 7up = 7; // 숫자로 시작하는 식별자 불가
		// int java-test = 100; // - 사용불가
		int java_test = 100; // _사용 가능
		int $hape = 100;
		//boolean true = false // 예약어는 식별자로 사용 불가
		// true : 예약어
		// True : 식별자. 예악어 아님. 권장사항은 아님
		boolean True = false; // 예약어는 식별자로 사용불가
		
		int 점수 = 30; // 한글 변수는 사용가능. 권장하지 않음
		// 자바는 유니코드(16비트, 2바이트)로 설정되었으므로 한글 가능.
		// char 형 변수는 2바이트임
	}

}
