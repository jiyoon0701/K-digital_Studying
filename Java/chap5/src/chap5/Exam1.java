package chap5;
/*
 * 1. 정수형(int) 배열 5개를 생성 
 * 2. 1 ~ 10사이의 임의수를 5개를 저장
 * 3. 배열의 숫자의 합계, 평균을 출력하기
 */
public class Exam1 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10) + 1;
			System.out.print(arr[i]+",");
			sum += arr[i];
		}
		System.out.println();
		System.out.println("합계:" + sum);
		System.out.println("평균:" + (double)sum/arr.length);
	}
}
