package chap2;
/*
 * 연산 결과에 따른 형변환
 * 	- 큰 자료형 = 작은자료형 + 큰자료형
 * 	- 단 int보다 작은 자료형간의 연산결과는 int
 * 	  int = byte + byte 
 * */
public class VarEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 10;
		int i1 = 20;
		int i2 = b1 + i1; // int = byte + int
		float f1 = 10.5F;
		float f2 = i1 + f1; // float = int + float
		short s1 = b1;
		int i3 = s1 + b1; // int = short + byte
		
		// short = short + byte 저장 ?
		short s2 = (short)(s1 + b1);
		
		// char 연산
		char c1 = 'A'; // A; 01000001 = 65
		char c2 = (char) (c1 + 1);
		System.out.println("c2="+c2+"c2의 코드 값 :" + (int)c2); // B, 66;
		System.out.println((char)65); // A
	}

}
