package chap2;

public class Test1 {
	public static void main(String[] args) {
     //1. 잘못된 문장을 골라내고 그 이유를 설명하시오.		
	    char       a='a';   
	    //char       b="a";  char은 문자형이므로 ""가 아닌 ''를 사용해여한다
	    String     c="a";   
	    //String     d='a'; String은 문자열 객체 이므로 문자형은 안된다.  
	   // char       e='ab'; char은 문자형이므로 두개 이상의 문자가 결합이 되어있으면 안된다.
	    String     f="ab"; 
	   // char       g = ''; // char은 유니코드의 정수형태로 저장이 되는데, ''은 정수형태로 표현할 수 없기때문에
	    // 아무것도 저장하지 않는 것 안됨. 공백 하나라고 집어넣어줘야함.
	    String     h = ""; 

	    //byte   var1 = 128; //-128 ~ 127까지
		short  var2 = 128; 
		//int    var3 = 28L; L은 long형
		long   var4 = 128L;
		//float  var5 = 1.2;  float는 뒤에 F or f를 붙인다.
		double var6 = 1.2; 
	    float var9 = '1';   // '1'이 실수형으로

	}
}
/*
2.   변수를 선언하기 위해서는 자료형과 변수의 이름을 결정해야합니다. 
      변수 이름으로 사용할 수 있는 것을 고르시오.
      변수이름으로 사용할 수 없는 이유를 작성하시오
      A. false  예약어
      B. default  예약어
      C. _var
      D. a-class -(하이픈) 는 안됨
      => C번이 정답이다. 예약어와 특수문자는 _, $를 제외하고는 변수명에 사용할 수 없다.
      
3. 변수를 선언하기 위해서는 자료형과 변수의 이름을 결정해야합니다.
   변수 이름으로 사용할 수 있는 것을 고르시오.
    A. s#arp  
    B. static  
    C. _class 
    D. class 
    => C  
    
4. byte 형을 저장할 수 있는 데이터 값의 허용 범위는 얼마입니까?
     => -128 ~ 127 256가지 값 가능 
 
5. float 형 변수 선언이 올바르게 된 것을 모두 고르시오.
   A. float f1 = 1F; 
   B. float f2 = 1.0; 
   C. float f3 = '1';  
   D. float f4 = "1";  참조형은 기본형으로 형변환이 안됨
   E. float f5 = 1.0d;      
   => A, C, 
*/
