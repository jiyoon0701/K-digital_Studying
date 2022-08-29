package chap5;

import java.util.Arrays;

/*1부터 100까지 임의의 수 10개를  배열에 저장하고, 정렬하여 출력하기
정렬 : java.util.Arrays.sort(arr)
[결과]
9,55,56,65,70,72,80,88,89,96,
 */
public class Test9 {
	public static void main(String[] args) {
		int[] num = new int[10];
		
		for(int i=0; i<10; i++) {
			int random = (int)(Math.random() * 100) + 1;
			num[i] = random;
		}
		
		Arrays.sort(num);
		for(int i=0; i<10; i++) {
			System.out.print((i==9)?num[i]:num[i]+",");
		}
	}
}