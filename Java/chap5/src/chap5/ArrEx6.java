package chap5;

public class ArrEx6 {
	// String[] args : main실행 시 값을 전달
	// 				   commend line에서 파라미터 전달
	//				   공백기준으로 배열의 요소 분리
	//				   공백을 포함하는 경우 " "로 요소 분리 가능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("command line에 파라미터 입력 요망");
			System.out.println("Java Arrex6 홍길동 김삿갓");
			return;
		}
		System.out.println("=== 개선된 for 구문 방식 : 첨자(index)사용 불가 ===");
		for (String s : args) {
			System.out.println(s);
		}
		// args.length : 홍길동 김삿갓 입력시 2가 출력. 문자열 배열의 갯수
		System.out.println("=== 기존 for 구문 방식 ===");
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}

	}

}
