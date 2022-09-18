package chap14;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * Writer 클래스 : 문자형 출력 스트림의 최상위 클래스. 
 *   1. FileWriter, StringWrtier, JspWriter,....
 *      등의 클래스의 부모 클래스.
 *   2. 추상클래스    
 *   3. 문자형 출력 스트림은 2바이트단위(1char)로 출력.
 */
public class WriterEx1 {
	public static void main(String[] args) throws IOException {
		/*
		 * System.out 은 PrintStream  객체임
		 * PrintStream은 OutputStream 의 하위 클래스 임.
		 * 바이트형출력스트림을 문자형출력스트림으로 변환 필요.
		 * OutputStreamWriter
		 */
		Writer out = new OutputStreamWriter(System.out);
		out.write('1');	out.write('2');	out.write('3');
		out.write('a');	out.write('b');	out.write('c');
		out.write('가');	out.write('나');	out.write('다');
		out.flush(); //버퍼의 내용을 목적지로 강제 전송		
	}
}
