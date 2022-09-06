package chap9;
/*
 * 다중 catch 구문
 * 	- 한개의 try 블럭에 여러개의 catch 블록이 존재
 * 	- try 블럭 내에 발생가능한 예외가 여러개 있는 경우, 예외별로 다른 예외처리 가능
 * 	- 상위 예외 클래스는 catch 구문의 하단에 배치해해야한다.
 * */
public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(args[0]); // try 구문 밖에서 발생된 예외는 catch 구문을 실행하지 못함
		try {
			System.out.println(args[0]);
			System.out.println(10/0); // ArithmeticException
			String s = null;
			System.out.println(s.trim());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("command 라인을 입력해주세요");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누지 마세요");
		}catch(NullPointerException e) {
			System.out.println("전산부로 연락하세요");
		}catch(Exception e) { // 그 외 모든 예외 처리
			System.out.println("그 외 예러");
			e.printStackTrace();
		}
	}

}
