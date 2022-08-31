package chap6;
/*
 * 가로(width),세로(height)의 멤버변수, 사각형 번호 sno, 클래스변수 cnt를 가지고 있는 
 * 직사각형(Rectangle2)클래스 구현하기
 * sno변수 : 사각형번호. 
 * cnt변수 : 사각형번호를 생성하기 위한 클래스변수
 * 멤버메서드는 int area(), int length(),String toString() 를 가진다.
 * 
 * toString()
 *   1번사각형 : 가로(10),세로(20),면적(200),둘레(60) 형태로 출력되도록 구현
 */
class Rectangle2 {
	int width,height,sno;
	static int cnt;
	int area() {
		return width*height;
	}
	int length() {
		return 2 * (width+height);
	}
	public String toString() {
		return sno+"번사각형 : " + "가로("+width+"), 세로("+height+
				"), 면적(" + area() + "), 둘레(" + length() + ")";
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Rectangle2 r1 = new Rectangle2();
		r1.width = 10;
		r1.height = 20;
		r1.sno = ++Rectangle2.cnt;
		// 1번사각형 : 가로(10),세로(20),면적(200),둘레(60)
		System.out.println(r1); 
		Rectangle2 r2 = new Rectangle2();
		r2.width = 5;
		r2.height = 5;
		r2.sno = ++Rectangle2.cnt;
		//2번사각형 : 가로(5), 세로(5), 면적(25), 둘레(20)
		System.out.println(r2); 
	}
}
