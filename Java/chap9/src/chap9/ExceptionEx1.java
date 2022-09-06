package chap9;
/*
 * 예외처리 : 발생된 예외를 정상적으로 처리하는 방법
 * 
 * try catch 구문
 * 	try 블럭 : 예외 발생 가능성이 있는 문장을 가진 블럭
 * catch블럭 : catch 블록이 속한 try블럭에서 예외 발생시 실행 되는 블럭
 * 
 * [결과]
 * 145
 * 1235
 * */
public class ExceptionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(1);
			System.out.println(2/0);
			System.out.println(3);
		} catch(Exception e) {
			System.out.println(4);
		}
		System.out.println(5);
	}

}
