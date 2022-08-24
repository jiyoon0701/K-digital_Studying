package chap4;
/*
 * switch(변수) {
 *    case 값1 : 문장1;break;
 *    case 값2 : 문장2;break;
 *    default : 그외문장
 * } 
 * break : switch 구문에서 빠짐.
 */
public class SwitchEx1 {
	public static void main(String[] args) {
		int score = 100;
		String grade;
		switch(score/10) {  //10
		case 10:
		case 9 : grade="A";
		         break;
		case 8 : grade="B";
		         break;  //switch 구문밖으로 제어 이동
		case 7 : grade="C";break;
		case 6 : grade="D";break;
		default : grade = "F";  //그외
		}
		System.out.println(score + "=" + grade+"학점");
	}
}
