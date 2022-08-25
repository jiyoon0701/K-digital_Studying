package chap5;
/*
 * 배열 예제
 * 배열 : 한개의 참조변수명에 여러개의 값을 저장 할 수 있는 자료 구조
 *      동일한 자료형의 값을 저장
 *      첨자(인덱스)로 요소(저장된값1개)에 접근.
 *      첨자는 0부터 시작함 
 *      arr.length : 배열의 크기. 요소의 갯수
 */
public class ArrEx1 {
	public static void main(String[] args) {
		int[] arr;  //배열의 선언
		arr = new int[5]; //배열객체의 생성. 기본값 초기화함.
		System.out.println(arr[0]+","+arr[1]);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		//요소에 값을 저장하기
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
//		arr[5] = 60; //오류. 배열의 크기가 5. 사용가능 첨자: 0 ~ 4
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		//배열의 선언과 생성(초기화).
		int  arr2[] = new int[5];
		for(int i=0;i<arr2.length;i++) {
			arr2[i] = (i+1) * 100;
		}
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}
	}
}
