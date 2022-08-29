package chap5;
/*
 * 가변배열 : 다차원배열에서는 모든 요소의 갯수를 지정할 필요가 없음. 
 *         단 첫번째 배열의 갯수는 지정해야 함.
 */
public class ArrEx9 {
	public static void main(String[] args) {
		int arr[][] = new int[3][]; //가변배열
		arr[0] = new int[] {10,20}; //배열의 생성+초기화
		arr[1] = new int[] {30,40,50};
		arr[2] = new int[] {60};
		//요소 출력하기
		
		
	}
}

