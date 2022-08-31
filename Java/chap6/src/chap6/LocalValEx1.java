package chap6;
/*
 * 지역변수 : 메서드 내부에서 선언됨. 선언된 블럭 내부에서만 사용 가능함.
 *         매개변수는 지역변수임.
 *         반드시 초기화 필요함
 */
public class LocalValEx1 {
	static int cv;
	public static void main(String[] args) {
      //클래스변수,인스턴스변수는 초기화 필요없음. 기본값으로 자동 초기화
		System.out.println(cv); //0
		int num = 200;  //지역변수
		System.out.println(num);
		int lv=0;
		//System.out.println(lv); //초기화 필요
		if(num==200) lv=10;
		else if(num > 200) lv=20;
		System.out.println(lv);
		String grade="F";
		int score = 80;
		switch(score/10) {
		case 10:
		case 9 : grade="A";break;
		case 8 : grade="B";break;
		case 7 : grade="C";break;
		case 6 : grade="D";break;
//		default : grade="F";
		}
		System.out.println(score + "점의 학점:" + grade); //switch 블럭 수정
	}
}
