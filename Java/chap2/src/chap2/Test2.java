
package chap2;
/*
5. 다음결과가 나오도록 Test2 프로그램 수정하기
[결과]
c=30
ch=C
f=1.5
l=27000000000
result=true 
*/
public class Test2 {
	public static void main(String[] args) {
		   byte a = 10;
		   byte b = 20;
		   byte c = (byte)(a + b); 
		   char ch = 'A';
		   ch = (char)(ch + 2);
		   float f = 3.0f / 2.0f;
		   long l= 3000 * 3000 * 3000L;
		   float f2 = 0.1f;
		   double d = 0.1f;
		   boolean result = d==f2;
		   System.out.println("c="+c);
		   System.out.println("ch="+ch);
		   System.out.println("f="+f);
		   System.out.println("l="+l);
		   System.out.println("result="+result);
	}
}