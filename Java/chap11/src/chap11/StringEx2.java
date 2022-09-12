package chap11;
/*
 * String 정적인 문자열임
 * => main 메서드에서 change 메서드 이후에 ABC123456 출력되도록 프로그램 수정 
 */
public class StringEx2 {
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println("main change 전 :" + str);
		str = change(str);
		System.out.println("main change 후 :" + str);
	}

	private static String change(String str) {
		str += "456";
		System.out.println("change : " + str);
		return str;
	}
}
