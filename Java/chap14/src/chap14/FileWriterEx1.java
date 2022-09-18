package chap14;

import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter : 파일에 데이터 저장.
 *              파일이 존재하지 않으면 파일 생성.
 *              파일이 존재하면 기존파일에 내용 등록
 * 주요메서드
 *   void write(int data)
 *        : data의 2바이트(1char)를 출력
 *   void write(char[] buf)
 *        : buf의 내용을 출력                   
 *   void write(char[] buf,int start, int len)                   
 *        : buf의 start인덱스 부터 len개 내용을 출력
 *   void write(String str)
 *        : str의 문자열 내용을 출력                        
 */
public class FileWriterEx1 {
	public static void main(String[] args) throws IOException {
		System.out.println("out2.txt 파일에 출력");
		FileWriter fr = new FileWriter("out2.txt");
		fr.write('1');fr.write('2');fr.write('3');
		fr.write('a');fr.write('b');fr.write('c');
		fr.write('가');fr.write('나');fr.write('다');
		//toCharArray() : char[] <=문자열
		char[] buf = 
			"\n반갑습니다. FileWriter 예제 입니다.".toCharArray();
		fr.write(buf);
		fr.write(buf,4,6);
		fr.write("홍길동");
		fr.flush();
		fr.close();
	}
}

