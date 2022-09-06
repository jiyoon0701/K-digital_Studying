package chap9;
/*
 * finally 블럭
 *     try 블럭에서 정상/예외 모두 실행 되는 블럭. 중간에 return이 실행 되도 finally 블럭은 실행됨.
 *     
 *     
 * [결과]
 * 1456 => 2/0
 * 12356 => 2/1
 * 
 * 1235 => 정상 return
 * 145  => catch 블럭 return
 */
public class ExceptionEx3 {
	public static void main(String[] args) {
		try {
			System.out.print(1);
			System.out.print(2/0);
//			System.out.print(2/1);
			System.out.print(3);
//			return; //함수 종료 
		} catch(Exception e) {
			System.out.print(4);
			return;
		} finally {
			System.out.print(5);
		}
		System.out.println(6);
	}
}
