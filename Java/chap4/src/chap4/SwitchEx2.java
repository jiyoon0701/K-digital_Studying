package chap4;
/*
 * switch(조건값) :
 *   조건값으로 사용할 수 있는 변수의 자료형은
 *   byte,short,int,char,String  만 가능함
 *   
 * 조건문 : if, switch
 * 1. 모든 switch 구문은 if 구문으로 변경 가능  
 * 2. 모든 if문은 switch 문으로 변경이 가능한것은 아님.
 */
public class SwitchEx2 {
	public static void main(String[] args) {
		String value="0";
		switch(value) {
		  case "1" : System.out.println(value);
		  default :
			System.out.println(value);
		}
	}
}
