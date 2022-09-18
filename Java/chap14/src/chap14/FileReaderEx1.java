package chap14;

import java.io.FileReader;
import java.io.IOException;

/*
 * FileReader 예제 
 *   파일에서 텍스트 데이터를 읽기 위한 클래스.
 *   
 * 주요메서드
 *   int read()
 *       : 1 char씩 내용을 읽어 리턴
 *   int read(char[] buf)
 *       : buf의 크기만큼 읽어서 buf 변수에 저장. 실제 읽은 바이트수 리턴
 *   int read(char[] buf,int start,int len)
 *       : buf의 len만큼 읽어서 buf 변수에 start 인덱스 부터 저장. 
 *         실제 읽은 바이트수 리턴
 */

public class FileReaderEx1 {
	public static void main(String[] args) throws IOException {
		String src = "src/chap14/InputStreamEx1.java";
		int data = 0;
		System.out.println("1. read() 메서드로 읽기 =========");
		FileReader fr = new FileReader(src);
		while((data = fr.read()) != -1) {
			System.out.print((char)data);
		}
		fr.close();
		char[] buf = new char[1024];
		System.out.println
		("2. read(char[] buf) 메서드로 읽기 =========");
		fr = new FileReader(src);
		while((data = fr.read(buf)) != -1) {
			System.out.print(new String(buf,0,data));
		}
		fr.close();
		System.out.println
    ("3. read(char[] buf,int sr, int len) 메서드로 읽기 =========");
		fr = new FileReader(src);
		while((data = fr.read(buf,0,buf.length)) != -1) {
			System.out.print(new String(buf,0,data));
		}
		fr.close();
	}
}
