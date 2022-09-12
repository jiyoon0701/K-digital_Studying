package chap11;
// String 클래스의 메서드들
public class StringEx3 {
	public static void main(String[] args) {
		String s = new String("ABCDEFGH");
		//s.charAt(4) : s 문자열에서 4번인덱스에 해당하는 문자 한개 리턴.
		System.out.println("s.charAt(4):" + s.charAt(4)); //E
		//s.compareTo("abc") : 정렬에서 사용되는 메서드. 대소문자 구분
		//              결과 음수 : s 문자열이 abc 문자열 보다 앞쪽
		//              결과 양수 : s 문자열이 AAA 문자열 보다 뒤쪽
		System.out.println("s.compareTo('abc'):" + s.compareTo("abc"));
		System.out.println("s.compareTo('AAA'):" + s.compareTo("AAA"));
		//IgnoreCase : 대소문자 상관없음
		//s.compareToIgnoreCase("abc") : 대소문자 구문없이 정렬에 사용됨
		System.out.println("s.compareToIgnoreCase('abc'):"
		              + s.compareToIgnoreCase("abc"));
		//s.endsWith("GH") : s 문자열의 끝이 GH? 여부
		System.out.println("s.endsWith('GH'):"+s.endsWith("GH")); //true
		//s.startsWith("GH") : s 문자열의 시작이 AB? 여부
		System.out.println("s.startsWith('AB'):"+s.startsWith("AB")); //true
		//s.equals("ABCDEFGH") : s 문자열이 "ABCDEFGH" 문자열과 같은지 여부
		System.out.println("s.equals('ABCDEFGH'):"+s.equals("ABCDEFGH")); //true
		//s.equalsIgnoreCase("ABCDEFGH") : s 문자열이 대소문자 상관없이
		//                      "abcdefgh" 문자열과 같은지 여부
		System.out.println("s.equalsIgnoreCase('abcdefgh'):"
		        +s.equalsIgnoreCase("abcdefgh")); //true
		
		s = "This is a String";
		//s.indexOf('i') : i 문자의 위치(인덱스) 리턴
		System.out.println("s.indexOf('i'):" + s.indexOf('i'));//2
		//s.indexOf('i',3) : 3번인덱스부터 i 문자의 위치(인덱스) 리턴
		System.out.println("s.indexOf('i',3):" + s.indexOf('i',3));//5
		// 해당 문자가 없는 경우 -1 리턴
		System.out.println("s.indexOf('Q'):" + s.indexOf('Q'));//-1
		//s.lastIndexOf('i') : 뒤쪽에서 i 문자의 위치. 
		//                     리턴 인덱스값은 앞부터 시작
		System.out.println("s.lastIndexOf('i'):" + s.lastIndexOf('i'));//13
		//s.length() : 문자열의 길이 리턴
		System.out.println("s.length():" + s.length());
		//s.replace("is","QR") : 문자열 치환
		System.out.println("s.replace('is','QR'):" + s.replace("is","QR"));
		System.out.println("s.replace('is',''):" + s.replace("is",""));
		//substring : 부분문자열
		//s.substring(5) : 5번 인덱스 부터 이후 부분만 리턴
		System.out.println("s.substring(5):" + s.substring(5));//is a String
		//s.substring(5,13) : 5번 인덱스부터 13번인덱스 앞까지 부분만 리턴
		//                    5번 인덱스부터 12번인덱스까지 부분만 리턴
		System.out.println("s.substring(5,13):" + s.substring(5,13));//is a Str
		//toUpperCase : 대문자 변경
		System.out.println("s.toUpperCase():" + s.toUpperCase());
		//toLowerCase : 소문자 변경
		System.out.println("s.toLowerCase():" + s.toLowerCase());
		
		s = "  문자열 trim 메서드   ";
		System.out.println("s:"+s);
		//s.trim() : 양쪽 공백 제거
		System.out.println("s.trim():"+s.trim());
		System.out.println("s.length():" + s.length());
		System.out.println("s.trim().length():" + s.trim().length());
		s = "홍길동,이몽룡,김삿갓";
		String[] arr = s.split(",");
		for(String sr : arr) System.out.println(sr);
	}
}
