package chap6;
/*
 * 선언 위치에 따른 변수의 종류
 *                 선언위치     선언방법                할당되는메모리영역
 * 1. 클래스 변수    클래스 내부    static 자료형 변수명;   클래스 영역
 *                           static int cv;       클래스 정보 로드시 
 *          특징 : 클래스의 모든 객체의 공통변수로 사용됨.  
 *                객체화와 상관이 없다.
 *                클래스명.변수명 사용됨.               
 * 2. 인스턴스 변수   클래스 내부   자료형 변수명;           힙영역
 *                           int iv;              객체화시
 *          특징 : 객체별로 메모리 할당됨. 반드시 객체화가 되어야 변수임.
 *                참조변수명.변수명 사용됨                  
 * 3. 지역변수      메서드 내부    자료형 변수명;           스택영역
 *                           int lv;              선언문 실행시
 *          특징 : 선언된 이후부터 메서드(블럭) 내부에서만 사용가능한 변수
 *                변수명 사용됨. lv=100;
 *                매개변수도 지역변수임. 
 *                반드시 초기화 해야 사용할 수 있음                
 */
class Card {
	String kind; //인스턴스변수  c1.kind
	int number;  //인스턴스변수  c1.number
	static int width = 250; //클래스변수  Card.width
	static int height =100; //클래스변수  Card.height
}
public class CardEx1 {
	public static void main(String[] args) {
		System.out.println("카드의 크기:" + Card.width + "," + Card.height );
//     	System.out.println("카드의 종류:" + Card.kind + "," + Card.number );
		Card c1 = new Card();
		System.out.println("카드의 종류:" + c1.kind + "," + c1.number );
		c1.kind = "Spade";
		c1.number = 1;
		Card c2 = new Card();
		c2.kind = "Heart";
		c2.number = 10;
		System.out.println("c1카드:" + c1.kind + "," + c1.number +
				           ",("+Card.width+","+Card.height+")" );
		System.out.println("c2카드:" + c2.kind + "," + c2.number+
                           ",("+c2.width+","+c2.height+")" );
		c1.width = 100;
		c1.height = 50;
		System.out.println("c1카드:" + c1.kind + "," + c1.number +
		           ",("+c1.width+","+c1.height+")" );
        System.out.println("c2카드:" + c2.kind + "," + c2.number+
                ",("+c2.width+","+c2.height+")" );
	}
}
