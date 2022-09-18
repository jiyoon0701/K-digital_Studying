package chap14;

import java.io.IOException;
import java.io.InputStream;

/*
 * InputStream 예제
 * InputStream : 바이트형 입력 스트림의 최상단 클래스.
 *    1.FileInputStream, DataInputStream, ObjectInputStream....
 *      등의 클래스의 부모 클래스임. 
 *    2.추상클래스임.
 *    3.System.in(표준입력스트림)의 자료형임.
 *    4.바이트형 입력스트림은 1바이트단위로 읽음
 *    
 * 자바에서 제공하는 표준 입출력스트림 객체
 * 1. 표준입력스트림 : InputStream System.in => 키보드입력     
 * 2. 표준출력스트림 : PrintStream System.out => 화면출력
 * 3. 표준오류스트림 : PrintStream System.err => 화면출력
 */
public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int data = 0;
		//in.read() : 키보드 입력값 읽기
		while((data=in.read()) != -1) //ctrl+z
			System.out.print((char)data);//한글출력시 깨짐. 
                                //바이트형스트림은 1바이트단위로 읽기
	}
}
