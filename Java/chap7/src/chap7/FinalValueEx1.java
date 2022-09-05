package chap7;
/*
 * final 제한자 : 변경 불가의 의미
 * 
 * final(종단) 클래스 : 상속불가 클래스. 부모클래스가 될수 없다.
 * final(종단) 메서드 : 오버라이딩 불가 메서드. 
 * final 변수(상수) : 변경 불가 변수. 상수.
 *             const 예약어는 예약어 이기는 하지만 사용은 안함.
 *             final 멤버 변수는 생성자에서 한번 값을 설정 할 수 있다.
 *             => 명시적 초기화를 하면 안됨
 *             
 *  final, abstract는 반대의 의미를 가진다. => 동시 사용 안됨.             
 */
class FinalValue {
	final int NUM;
	final int[] ARR; //ARR 참조변수 상수
	FinalValue(int num) {
		this.NUM = num; //상수값 초기화. 객체별로 다른 상수값 설정
//		this.NUM = num+100;
		this.ARR = new int[5]; //다른 객체 참조 불가
		for(int i=0;i<ARR.length;i++) {
			ARR[i] = (i+1)*10;
		}
	}
}
public class FinalValueEx1 {
	public static void main(String[] args) {
		final int NUM = 100; //상수는 대문자로 정하는 것이 권장사항
		System.out.println(NUM);
		//NUM=200;  //NUM 상수의 값은 변경 불가
		System.out.println(NUM);
		FinalValue f1 = new FinalValue(10);
		FinalValue f2 = new FinalValue(20);
		System.out.println(f1.NUM);
		System.out.println(f2.NUM);
		for(int a : f1.ARR) System.out.print(a+",");
		System.out.println();
		f1.ARR[0]=100; //요소값 변경
		f1.ARR[1]=200;
		for(int a : f1.ARR) System.out.print(a+",");
	}
}