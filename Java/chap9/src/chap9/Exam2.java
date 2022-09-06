package chap9;
/*   컴파일 오류 수정하기
 * 1. try catch 구문으로 예외 처리하기
 * 2. throws 구문으로 예외 처리하기 
 * 3. 예외처리 생략 가능하도록 RuntimeException 클래스의 하위클래스로 생성 
 */
class MyException extends RuntimeException { //=> RuntimeException 하위클래스
	int pos;
	MyException(String msg,int pos) {
		super(msg);
		this.pos = pos;
	}
	public int getPos() {
		return pos;
	}
	//getMessage() 메서드를 오버라이딩. => pos의 값을 출력하기.
//	@Override
//	public String getMessage() {
//		return super.getMessage() + ":"+pos + "라인";
//	}
	@Override
	public String getMessage() {
		return super.getMessage() + ":"+pos + "라인";
	}
	
}
public class Exam2 {
	public static void main(String[] args) {
		first();
	}
	private static void first() {
/* 1		
		try {
		   throw new MyException("예외 강제 발생");
		}catch(MyException e) {
			e.printStackTrace();
		}
*/	
		throw new MyException("예외 강제 발생",29); //예외처리 생략 가능 예외클래스로 생성
	}
}
