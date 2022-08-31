package chap6;
/*
 * 가로(width),세로(height)의 멤버변수를 가지고 있는 직사각형(Rectangle)클래스 구현하기
 * 멤버메서드는 void area(), void length() 를 가진다.
 */

class Rectangle {
	int width;
	int height;
	
	void area() {
		System.out.println("면적:"+ (width*height));
	}
	void length() {
		System.out.println("둘레:"+ (width+height)*2);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.width = 10;
		r1.height = 5;
		r1.area();  // 면적출력
		r1.length();// 둘레출력

		Rectangle r2 = new Rectangle();
		r2.width = 100;
		r2.height = 20;
		r2.area();  // 면적출력
		r2.length();// 둘레출력
		
	}
}
