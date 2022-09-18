package chap14;

import java.io.IOException;
import java.io.OutputStream;

/*
 * OutputStream 클래스 : 바이트형출력스트림의 최상단 클래스
 *  1. PrintStream, FileOutputStream, 
 *     DataOutputStream, ObjectOutputStream...
 *     등의 부모클래스
 *  2. 추상클래스 
 *  3. 바이트형출력스트림은 1바이트단위로 출력.   
 */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write('1');	out.write('2');	out.write('3');
		out.write('a');	out.write('b');	out.write('c');
		out.write('가');	out.write('나');	out.write('다');
		out.flush(); //버퍼의 내용을 목적지로 강제 전송
	}
}

