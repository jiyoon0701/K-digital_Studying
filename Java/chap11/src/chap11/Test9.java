package chap11;
/*
 * int getRand(f,t) : 함수 구현하기
 *   f ~ t 또는 t~ f 까지  범위에 숫자를 임의의 수로 리턴하는 함수
 *   f, t 값은 포함됨. 
 *   1 ~ 10 난수 (int)(Math.random() * (10-1 +1))  + 1
 */
public class Test9 {
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			System.out.print(getRand(1,-3)+",");
		}
		System.out.println();
		for(int i=0;i<20;i++) {
			System.out.print(getRand(-1,3)+",");
		}
	}
	static int getRand(int f,int t) {
		int min = Math.min(f,t);
//		int min = (f > t)?t:f;
		int max = Math.max(f,t);
		int cha = max - min;
		return (int)(Math.random() * (cha+1)) + min;
	}
}
