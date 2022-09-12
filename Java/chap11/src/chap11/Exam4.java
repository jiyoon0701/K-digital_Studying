package chap11;
/*
 * format 메서드 구현하기
 * 메서드명 : String format (String str,int len,int align)
 * 기능 : 주어진 문자열을 지정된 크기(len)의 문자열로 변환.
 *        나머지 공간은 공백으로채운다.
 *      (0 : 왼쪽 정렬, 1: 가운데 정렬, 2:오른쪽 정렬)       
 */
public class Exam4 {
	public static void main(String[] args) {
		String str = "가나다";
		System.out.println(format(str, 7, 0));//가나다
		System.out.println(format(str, 7, 1));//  가나다  
		System.out.println(format(str, 7, 2));//    가나다
		System.out.println(format(str, 2, 0));//가나
	}
	static String format (String str,int len,int align) {
		if(str.length() >= len)
			return str.substring(0,len);
		
		//str.length() < len 경우
		StringBuffer sb = new StringBuffer();
		//sb="       "
		for(int i=0;i<len;i++)
			sb.append(" ");
		
		int l = len - str.length(); //7 - 3 = 4
		switch(align) {
		case 0 : sb.replace(0, str.length(), str); break; //왼쪽 정렬
		case 1 : sb.replace(l/2, str.length()+l/2, str); break; //가운데
		case 2 : sb.replace(l, str.length()+l, str); break;  //오른쪽
		}
		return sb.toString();
	}
}
