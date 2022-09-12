package chap11;
/*
 * StringBuffer 클래스의 메서드
 */
public class StringBufferEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		//sb.append() :sb 객체에 값을 뒤쪽 추가 
		sb.append("abc").append(123).append('A').append(false);
		System.out.println(sb);
		//delete(2,4) :2번인덱스 부터 3번인덱스까지 문자 제거
		sb.delete(2, 4);
		System.out.println(sb); //ab23Afalse
		//4번 인덱스 글자 제거
		sb.deleteCharAt(4);
		System.out.println(sb); //ab23false
		//5번인덱스에 == 추가
		sb.insert(5, "==");
		System.out.println(sb); //ab23f==alse
		sb = new StringBuffer("ABCDEFG");
		//0번인덱스부터 2번인덱스까지 abc 치환
		sb.replace(0, 3, "abc");
		System.out.println(sb); //abcDEFG
		//역순 변경
		sb.reverse();
		System.out.println(sb);
	}
}
