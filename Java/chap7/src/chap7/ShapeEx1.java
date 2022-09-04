package chap7;
/*
 * 추상클래스
 *  - 추상메서드를 가질 수 있는 클래스. abstract 예약어 사용함.
 *  - 객체화 불가 => 객체화는 상속을 통해서 자손클래스의 객체로 객체화 가능.
 *  - 객체화되는 자손클래스는 반드시 추상메서드를 오버라이딩해야함.
 *  - 그외는 일반클래스와 동일 (생성자, 멤버변수, 멤버메서드,...)
 *  
 *  추상메서드 : 선언부만 존재하는 메서드. 구현부가 없다.
 *            자손클래스에서 오버라이딩 필수
 */
abstract class Shape {  //추상클래스 
	String type;
	Shape(String type) {
		this.type = type;
	}
	abstract double area();  //추상메서드
	abstract double length();//추상메서드
}
class Circle extends Shape {
	int r;
	Circle(int r) {
		super("원");
		this.r = r;
	}
//	@Override
	double area() {
		return Math.PI*r*r;
	}
//	@Override
	double length() {
		return Math.PI*r*2;
	}
	public String toString() {
		return "반지름="+r+",넓이="+area() + ",둘레="+length();
	}
}
class Rectangle extends Shape {
	int width,height;
	Rectangle(int width,int height) {
		super("사각형");
		this.width= width;
		this.height = height;
	}
//	@Override
	double area() {
		return width*height;
	}
//	@Override
	double length() {
		return (width+height) * 2;
	}
	public String toString() {
		return "가로="+width + ",세로="+height 
				+",면적="+area()+",둘레="+length();
	}
}
public class ShapeEx1 {
	public static void main(String[] args) {
//		Shape s = new Shape("도형"); //추상클래스는 객체화 불가
		Shape[] arr = new Shape[2];
		arr[0] = new Circle(10);
		arr[1] = new Rectangle(5,5);
		for(Shape s : arr) {
			System.out.println(s);
		}
		//도형의 면적의 합과, 둘레합 출력하기
		//arr[0] : Shape타입의 참조변수 
		//arr[0].area() : Circle 객체의 area() 메서드 호출
		//arr[1].area() : Rectangle 객체의 area() 메서드 호출
		System.out.println("면적의합:"+(arr[0].area() + arr[1].area()));
		System.out.println("둘레의합:"+(arr[0].length() + arr[1].length()));
	}

}
