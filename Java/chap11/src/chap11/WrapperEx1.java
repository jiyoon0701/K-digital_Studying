package chap11;
/*
 * Wrapper 클래스 : 8개의 기본자료형을 객체화하기 위한 8개의 클래스 통칭
 * 
 * 기본자료형     Wrapper클래스
 * boolean     Boolean
 * char        Character
 * byte        Byte
 * short       Short
 * int         Integer
 * long        Long
 * float       Float
 * double      Double
 * 
 * 기본자료형과 참조자료형사이의 형변환은 불가
 * 단 기본자료형과 Wrapper 클래스간의 형변환은 가능함.
 * 
 * 기본형(변수) <- 참조형(객체) : auto UnBoxing
 * 참조형(객체) <- 기본형(변수) : auto Boxing 
 */
public class WrapperEx1 {

	public static void main(String[] args) {
		//deprecated됨. 사용을 권장하지 않음
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println("i1==i2 : "+(i1==i2)); //false
		System.out.println
		    ("i1.equals(i2) : "+(i1.equals(i2))); //true
		i1= 100; //참조형 <= 기본형 : Boxing
		i2= 100;
		System.out.println("i1==i2 : "+(i1==i2)); //true
		System.out.println
		    ("i1.equals(i2) : "+(i1.equals(i2))); //true
		System.out.println("i1==100 : "+(i1==100)); //i1객체가 unboxing
		//equals 메서드 오버라이딩시 hashCode() 도 오버라이딩하도록 권장
		System.out.println("i1.hashCode():" + i1.hashCode()); //100
		System.out.println("i2.hashCode():" + i2.hashCode()); //100
		System.out.println  //실제 hashCode값 : 객체의 참조값
	("System.identityHashCode(i1):" + System.identityHashCode(i1));
		System.out.println
	("System.identityHashCode(i2):" + System.identityHashCode(i2));
		//int 형 정보
		System.out.println("int 형의 최대값:" + Integer.MAX_VALUE);
		System.out.println("int 형의 최소값:" + Integer.MIN_VALUE);
		System.out.println("int 형의 bit수:" + Integer.SIZE);
		//long 형 정보
		System.out.println("long 형의 최대값:" + Long.MAX_VALUE);
		System.out.println("long 형의 최소값:" + Long.MIN_VALUE);
		System.out.println("long 형의 bit수:" + Long.SIZE);
		// 정수형<=문자열
		int num = Integer.parseInt("123");
		System.out.println(num+100);
		num = Integer.parseInt("123",16); //10진수<=16진수
		System.out.println(num);
		//10진수를 16진수 출력하기
		System.out.println(Integer.toHexString(num));
		//10진수를 8진수 출력하기
		System.out.println(Integer.toOctalString(num));
		//10진수를 2진수 출력하기
		System.out.println(Integer.toBinaryString(num));
		
	}

}
