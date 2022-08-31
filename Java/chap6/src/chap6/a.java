package chap6;

public class a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 2부터 50까지의 숫자 중 소수와 갯수를 구하는 프로그램 작성하기

		// [결과]
		// 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,=>소수갯수:15
		int len = 0;
		boolean flag = false;
		
		for (int i = 2; i <= 50; i++) {
			flag = false;

			for (int j = 2; j <= i; j++) {
				if (i != j && i % j == 0) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}

			if (flag == true) {
				len++;
				System.out.print(i + ",");
			}
		}
		System.out.println("=>소수갯수:" + len);
	}
}
