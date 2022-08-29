package chap5;
/*
 * arr 배열의 행의 합, 열의합,전체합 출력하기
 */
public class Exam5 {
	public static void main(String[] args) {
		int[][] arr= {{1},{10,20},{30,40,5,6,7},{50,60,70}};
		/*
		 * 0행 : 1
		 * 1행 : 30
		 * 2행 : 88
		 * 3행 : 180
		 * 1열 : 91
		 * 2열 : 120
		 * 3열 : 75
		 * 4열 : 6
		 * 5열 : 7
		 * 전체합 : xxx
		 */
		int maxcol = 0;
		for(int i=0;i<arr.length;i++) {
			if(maxcol < arr[i].length)
				maxcol = arr[i].length;
		}
		int[] colsum = new int[maxcol];
		int totsum = 0;
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=0;j<arr[i].length;j++) {
				sum += arr[i][j];
				colsum[j] +=arr[i][j];
				totsum += arr[i][j];
			}
			System.out.println(i+"행의 합:" + sum);
		}
		for(int i=0;i<colsum.length;i++) {
			System.out.println(i + "열의 합:" + colsum[i]);
		}
		System.out.println("전체합:"+totsum);

	}

}
