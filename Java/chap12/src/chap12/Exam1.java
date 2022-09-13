package chap12;

import java.util.Random;

/*
 * Random 클래스의 nextBoolean 함수를 이용하여 사용자1,사용자2의 난수를 발생하여
 * 3번 연속으로 true가 먼저나오는 쪽이 승리하도록 프로그램 구현하기
 */
public class Exam1 {
	public static void main(String[] args) {
		Random rand1 = new Random();
		rand1.setSeed(System.currentTimeMillis());
		Random rand2 = new Random();
		rand2.setSeed(System.currentTimeMillis()+100);
		int user1=0,user2=0;
		while(true) {
			if(rand1.nextBoolean()) { //true
				user1++;
				System.out.print("user1 true");
			} else {                  //false
				user1=0;
				System.out.print("user1 false");
			}
			if(rand2.nextBoolean()) { //true
				user2++;
				System.out.println("\tuser2 true");
			} else {                  //false
				user2=0;
				System.out.println("\tuser2 false");
			}
			if(user1==3 || user2==3) break;
		}
		if(user1==3 && user2==3) System.out.println("\n비김");
		else if (user1==3) System.out.println("\nuser1 승리");
		else System.out.println("\nuser2 승리");
	}
}
