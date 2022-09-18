package chap14;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * Reader 클래스 : 문자형입력스트림의 최상위 클래스 
 *    1. FileReader, StringReader 등의 부모클래스 
 *    2. 추상클래스
 *    3. 문자형 입력스트림은 2바이트단위(1char 단위)로 읽음
 */
public class ReaderEx1 {
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		int data = 0;
		while((data=in.read()) != -1) //ctrl+z (-1값)
			System.out.print((char)data);
	}
}
