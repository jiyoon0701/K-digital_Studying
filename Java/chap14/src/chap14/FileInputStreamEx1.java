package chap14;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream 예제 
 *   파일에서 데이터를 읽기 위한 클래스.
 * 주요메서드
 *   int read()
 *       : 1 byte씩 내용을 읽어 리턴
 *   int read(byte[] buf)
 *       : buf의 크기만큼 읽어서 buf 변수에 저장. 실제 읽은 바이트수 리턴
 *   int read(byte[] buf,int start,int len)
 *       : buf의 len만큼 읽어서 buf 변수에 start 인덱스 부터 저장. 
 *         실제 읽은 바이트수 리턴
 *   int available() 
 *       : 읽기 가능한 바이트 수 리턴. 
 */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		String src = "src/chap14/InputStreamEx1.java";
		FileInputStream fis = new FileInputStream(src);
		int data = 0;
		System.out.println("1.read() 메서드로 읽기=========");
		while((data=fis.read()) != -1) { //EOF(End Of File)
			System.out.print((char)data);
		}
		fis.close();
		System.out.println("2.read(byte[] buf) 메서드로 읽기=========");
		fis = new FileInputStream(src);
		//fis.available() : 읽기 가능 바이트.
		byte[] buf = new byte[fis.available()];
		while((data=fis.read(buf)) != -1) {
			// String <= byte[]
			// new String(buf,0,data)
			//      buf의 내용을 0번 인덱스 부터 data 길이 만큼 문자열로 생성.
			System.out.print(new String(buf,0,data));
		}
		System.out.println();
		fis.close();
		System.out.println
("3.read(byte[] buf,int start, int len) 메서드로 읽기=========");
		fis = new FileInputStream(src);
		/*
		 * buf :0번 인덱스 부터 fis.available() 갯수만크 데이터 저장.
		 * data : 실제로 읽은 바이트 
		 */
		while((data=fis.read(buf,0,fis.available())) != -1) {
			System.out.print(new String(buf,0,data));
		}
		System.out.println();
	}
}
