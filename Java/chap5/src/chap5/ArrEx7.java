package chap5;
/*
 * 다차원 배열 : 배열의 배열로 표시함.
 *           
 * 2차원배열 : 1차원배열의 참조변수의 배열.
 *          1차원 배열의 배열.          
 */
public class ArrEx7 {
	public static void main(String[] args) {
		//배열의 선언
		int[][] arr;  //2차원배열
		//배열의 생성
		arr = new int[3][2]; //3행2열 배열. 
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		arr[2][0] = 50;
		arr[2][1] = 60;
		//arr.length : 3
		//arr[0].length : 2 : arr[0] : int[] => 1차원배열의 참조변수
		//arr[1].length : 2 
		for(int i=0;i<arr.length;i++) { //i:3
			for(int j=0;j<arr[i].length;j++) { //j:1 
				System.out.println("arr["+i+"]["+j+"]=" + arr[i][j]);
			}
		}
		//------------
		int[] arr1 = {100,200,300};
		arr[1] = arr1;
		System.out.println("arr[1] = arr1;");
		for(int i=0;i<arr.length;i++) { 
			for(int j=0;j<arr[i].length;j++) {  
				System.out.println("arr["+i+"]["+j+"]=" + arr[i][j]);
			}
		}
		
		
		
	}
}
