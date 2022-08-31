package chap6;
/*
 * Circle1 클래스의 객체 3개를 배열로 저장하고 원의 면적의 합과 둘레합 출력하기 
 */
public class CircleEx1 {
	public static void main(String[] args) {
		//1. Circle1 클래스의 배열 선언
		Circle1[] arr = new Circle1[3]; //Circle1 클래스를 참조할 참조변수 3개 생성
		double sumArea = 0;
		double sumLength = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Circle1();
			sumArea += arr[i].area((i+1)*10);
			sumLength +=arr[i].length((i+1)*10);
		}
		System.out.println("원 면적의 합:" + sumArea);
		System.out.println("원 둘레의 합:" + sumLength);
	}
}