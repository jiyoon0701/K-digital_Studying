package chap5;

public class ArrEx3 {
	public static void main(String[] args) {
		//배열의 초기화
		// int[] arr = new int[5];
		// 각 요소에 값을 저장
		int[] arr = {10,20,30,40,50}; //배열선언, 생성, 요소초기화
		                              // arr.length = 5. arr[0] ~ arr[4]
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
		int[] arr2 = {100,200,300}; //배열선언, 생성, 요소초기화
/*
		int[] arr2; //배열 선언
	    arr2 = new int[3]; //배열 생성
	    arr2[0] = 100; //배열 요소의 초기화		
	    arr2[1] = 200;		
	    arr2[2] = 300;		
*/
	    for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2[" + i + "]=" + arr2[i]);
		}
	    System.out.println("arr2=arr ===========");
	    arr2 = arr;
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	    for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2[" + i + "]=" + arr2[i]);
		}
	    System.out.println("arr2[0]=1000 ===========");
	    arr2[0] = 1000;
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	    for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2[" + i + "]=" + arr2[i]);
		}
	}
}

