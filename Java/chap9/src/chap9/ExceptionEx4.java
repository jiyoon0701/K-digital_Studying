package chap9;
/*
 * throws : 예외 처리 
 *          예외던지기 : 현재메서드를 호출한 메서드로 예외 전달. 
 *                    호출한 메서드로 예외 발생 전달
 */
public class ExceptionEx4 {
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
		   System.out.println(Integer.parseInt("abc"));//NumberFormatException 발생
		} catch (Exception e) {
			System.out.println("second:숫자만 입력하세요");
		}
	}
}
