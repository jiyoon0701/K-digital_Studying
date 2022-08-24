package chap4;
/*
 * 반복문 예제
 * 12345 출력하기
 */
public class LoopEx1 {
	public static void main(String[] args) {
		System.out.println("1.반복문 없이 출력");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
		System.out.println("2.for 구문으로 출력");
		/*
		 * 1. int i=1 : 초기값 실행
		 * 2. i<=5 : 조건문. i= 1 =>T
		 * 3. System.out.print(1);
         * 4. i++  i:2
		 * 2. i<=5 : 조건문. i= 2 =>T
		 * 3. System.out.print(2);
         * 4. i++  i:3
		 * 2. i<=5 : 조건문. i= 3 =>T
		 * 3. System.out.print(3);
         * 4. i++  i:4
		 * 2. i<=5 : 조건문. i= 4 =>T
		 * 3. System.out.print(4);
         * 4. i++  i:5
		 * 2. i<=5 : 조건문. i= 5 =>T
		 * 3. System.out.print(5);
         * 4. i++  i:6
		 * 2. i<=5 : 조건문. i= 6 =>F
		 */
		for(int i=1;i<=5;i++) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("while 구문으로 출력");
		int i =1; //1
		while(i<=5) { //F
			System.out.print(i);  //12345
			i++;  //6
		}
		System.out.println();
		System.out.println("do while 구문으로 출력");
		i=1; //1
		do {
			System.out.print(i); //12345
			i++; //6
		} while(i<=5);
		System.out.println();
	}
}
