package chap5;
/*
 * arr 배열의 행의 합, 열의합,전체합 출력하기
 */
public class Exam4 {
	public static void main(String[] args) {
		int[][] arr= {{10,20},{30,40},{50,60}};
		/*
		 * 0행 : 10+20 = 30
		 * 1행 : 30+40 = 70
		 * 2행 : 50+60 = 110
		 * 0열 : 10+30+50 = 90
		 * 1열 : 20+40+60 = 120
		 * 전체합 : 210
		 */
		int[] colsum = new int[2]; //40,20
		int totsum = 0;  //0
		for(int i=0;i<arr.length;i++) { //i:1
			int sum = 0; //10
			for(int j=0;j<arr[i].length;j++) { //j:1
				sum += arr[i][j]; //arr[1][0]
				colsum[j] +=arr[i][j];
				totsum += arr[i][j];
			}
			System.out.println(i+"행의합:"+sum); //30
		}
		for(int i=0;i<colsum.length;i++) {
			System.out.println(i+"열의 합:"+colsum[i]);
		}
		System.out.println("전체 합:"+totsum);
	}
}
