 package chap9;
/* 
 * UnsupportFunctionException 클래스 구현하기
 * 1. 멤버변수 : private final int ERR_CODE;
 * 2. 멤버메서드 : 
 *     public int getErrCode() : ERR_CODE 값 반환
 *     public String getMessage() : 오버라이딩 메서드.
 *          부모클래스의 message 값과 ERR_CODE 값 반환.
 * 3. 예외처리를 안해도 되도록 구현.
 * 4. 생성자는 구동클래스의 호출에 맞도록 구현         
 */
class UnsupportFunctionException extends RuntimeException {
	private final int ERR_CODE;
	UnsupportFunctionException(String msg, int code) {
		super(msg);
		ERR_CODE = code;
	}
	public int getErrCode() {
		return ERR_CODE;
	}
	@Override
	public String getMessage() {
		return super.getMessage() + ",오류코드:" + ERR_CODE;
	}
}

public class Test1{
	public static void main(String[] args) {
		try {
			throw new UnsupportFunctionException("지원하지 않는 기능입니다.", 200);
		} catch (UnsupportFunctionException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrCode());
			e.printStackTrace();
		}
	}

}