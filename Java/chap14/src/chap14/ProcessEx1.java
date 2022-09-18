package chap14;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ProcessEx1 {
	public static void main(String[] args) throws IOException {
		/*
		 * Runtime.getRuntime() : win10(OS)로부터 프로세스의 실행 권한 받음
		 * exec(프로세스명) : 프로세스 실행.
		 * p : ping 127.0.0.1 프로세스 
		 */
		Process p = Runtime.getRuntime().exec("ping 127.0.0.1");
		//p.getInputStream() : 프로세스의 결과를 읽기 위한 입력 스트림.
		//p.getInputStream(),"EUC-KR"
		//  Reader 변경시 데이터를 EUC-KR로 인식.
		// EUC-KR : 한글완성형 코드.
		Reader r = new InputStreamReader(p.getInputStream(),"EUC-KR");
		int data = 0;
		while((data=r.read()) != -1)
			System.out.print((char)data);
		p = Runtime.getRuntime().exec("notepad.exe");
	}
}
