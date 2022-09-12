package chap11;
// 숫자 <= 문자열
public class StringEx5 {
	public static void main(String[] args) {
		int i = Integer.parseInt("100"); //정수 <= 문자열
		System.out.println(i+200); //300
		float f = Float.parseFloat("100.5"); //실수 <= 문자열
		System.out.println(f+200); //300.5
		double d = Double.parseDouble("100.5"); //실수 <= 문자열
		System.out.println(d+200); //300.5
		long l = Long.parseLong("100");
		System.out.println(l+200); //300

		//16진수 "100" 정수로 변환
		i = Integer.parseInt("100",16);
		System.out.println(i);
		//16진수 "FF" 정수로 변환
		i = Integer.parseInt("FF",16); //16진수 -> 10진수
		System.out.println(i);
	}
}
