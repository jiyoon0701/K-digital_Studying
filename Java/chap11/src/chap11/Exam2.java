package chap11;
/*
 * count 메서드 구현하기
 * int count(문자열소스,찾는 문자열) : 문자열 소스에서 찾는 문자열의 갯수를 리턴
 */
public class Exam2 {
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","12"));//2
		System.out.println(count("12345AB12AB345AB","AB"));//3
		System.out.println(count("12345","6"));            //0
	}
	private static int count(String s1, String s2) {
		//"12345AB12AB345AB","AB"
		int cnt=0;
		int index = 0;
		while(true) {
			index = s1.indexOf(s2,index);//-1
			if(index < 0) break;
			cnt++; //3
			index++;//15
		}
		return cnt;
	}
}
