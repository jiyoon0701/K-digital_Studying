package chap11;
/*
 * String.format 메서드 : 형식화된 문자열 리턴. 
 *                      static 메서드 => 객체화 상관없음
 * String String.format ("형식화문자사용한문자열",값들,...)
 * 형식화문자 : %d,%c,%s,%f,%x,%o....
 * 
 *         => System.out.printf() 함수에서 사용법과 동일
 */
public class StringEx4 {
	public static void main(String[] args) {
		//%f : 부동소숫점숫자표시. 실수형식 
		//%.2f : 소숫점이하 2자리만 출력. 소숫점이하 3번쨰 자리에서 반올림 출력 
		String sf = String.format("%.2f", 0.142); // 문자열
		System.out.println(sf);  //0.14
		sf = String.format("%.2f", 0.145); 
		System.out.println(sf);  //0.15
		//%d : 10진 정수 출력
		System.out.println(String.format("%d", 12345));
		System.out.printf("%d\n", 12345);
		//%10d : 최소 10자리 확보하여 10진정수 우측 정렬 출력
		System.out.println(String.format("%10d", 12345));
		System.out.printf("%10d\n", 12345);
		System.out.println(String.format("%3d", 12345)); //5자리 출력

		//%-10d : 최소 10자리 확보하여 10진정수를 좌측 정렬 출력
		System.out.println(String.format("%-10d", 12345));
		System.out.printf("%-10d\n", 12345);
		
		//%010d : 최소 10자리 확보하여 10진정수를 빈자리는 0을 채워 출력. -표시못함 
		System.out.println(String.format("%010d", 12345));
		System.out.printf("%010d\n", 12345);
		//%,10d : 최소 10자리 확보하여 세자리 마다 , 표시하여 10진정수를 출력
		System.out.println(String.format("%,10d", 12345));
		System.out.printf("%,10d\n", 12345);

		//%-,10d : 최소 10자리 확보하여 세자리 마다 , 표시하여 좌축 정렬하여 10진정수를 출력
		System.out.println(String.format("%-,10d", 12345));
		System.out.printf("%-,10d\n", 12345);

		//%X,%x : 16진 정수 출력. X:대문자표시, x:소문자표시
		System.out.printf("%X\n", 255); //FF
		System.out.printf("%x\n", 255); //ff

		//%o : 8진 정수 출력.
		System.out.printf("%o\n",10);
		//%s : 문자열 출력
		System.out.printf("%s\n","홍길동");
		//%c : 문자 출력
		System.out.printf("%c%c%c\n",'홍','길','동');
		System.out.printf("%2c%2c%2c\n",'홍','길','동');
		
		System.out.printf("%s의 학점은 %c입니다. 점수는 %d입니다.\n", 
				                            "홍길동",'A',95);
		System.out.println
	 (String.format("%s의 학점은 %c입니다. 점수는 %d입니다.\n", "홍길동",'A',95));
	}
}
