package chap5;

/*
1. 방정식 2x+4y=10의 모든 해를 구하는 프로그램을 작성하시오.
    단 x와 y는 정수이고  각각의 범위는 0<=x<=10, 0<=y<=10임 
[결과]
x=1,y=2
x=3,y=1
x=5,y=0
 */

public class Test3 {
	public static void main(String[] args) {
				// x = 5 - 2y
		
		for(int i = 10; i>=0; i--) {
			int x = 5 - 2*i;
			if (x<0) {
				continue;
			}
			else {
				System.out.println("x="+x + " y="+i);
				
			}
		}
	}
}
