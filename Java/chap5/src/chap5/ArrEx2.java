package chap5;
/*
 * 1. 정수형(int) 배열 10개를 생성
 * 2. 각각의 요소의 1 ~ 100사이의 임의의 수(난수)를 저장
 * 3. 배열의 요소의 합 출력하기
 */
public class ArrEx2 {
	public static void main(String[] args) {
		// 1. 정수형(int) 배열 10개를 생성
		int[] arr = new int[10];
		//2. 각각의 요소의 1 ~ 100사이의 임의의 수(난수)를 저장
		for(int i=0;i<arr.length;i++) {
			/*
			 *  0.0 <= Math.random() < 1.0 임의의수
			 *  0 <= Math.random() * 100 < 100.0
			 *  0 <= (int)(Math.random() * 100) <= 99 임의의 정수
			 *  1 <= (int)(Math.random() * 100) + 1 <= 100 임의의 정수
			 */
			arr[i] = (int)(Math.random() * 100) + 1;
			System.out.println(arr[i]);
		}
		// 3. 배열의 요소의 합 출력하기
		int sum = 0;  //합계 저장 변수 선언
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		System.out.println("배열 요소의 합:" + sum);
	}
}
