package chap9;
/*
 * throws : 예외처리. 발생된 예외를 처리
 * throw  : 예외발생. 없는 예외를 발생
 */
public class ExceptionEx5 {
	public static void main(String[] args) {
		try {
			first();
		} catch(Exception e) {
			System.out.println("숫자만 가능합니다.");
			e.printStackTrace();
		}
	}
	private static void first() throws Exception{
		System.out.println("first 메서드");
		second();
	}
	//throws Exception : 예외가 발생하면 나를 호출한 메서드로 예외 전달. 
	private static void second() throws Exception {
		System.out.println("second 메서드");
		//int <= Integer.parseInt(숫자문자열)
		try {
		   System.out.println(Integer.parseInt("abc"));
		} catch (Exception e) {
			System.out.println("second:숫자만 입력하세요");
			throw e; //e객체를 강제 다시 발생
		}
	}
}
