package chap14;

import java.io.FileInputStream;
import java.io.IOException;

/*
bin/chap14/InputStreamEx1.class 파일을 읽어 다음 결과와 같이 출력하기 
[결과] 
 CA FE BA BE 00 00 00 3D 00 30 07 00 02 01 00 15
 63 68 61 70 31 34 2F 49 6E 70 75 74 53 74 72 65
 61 6D 45 78 31 07 00 04 01 00 10 6A 61 76 61 2F
 6C 61 6E 67 2F 4F 62 6A 65 63 74 01 00 06 3C 69
 6E 69 74 3E 01 00 03 28 29 56 01 00 04 43 6F 64
.... */
public class Test2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = 
		new FileInputStream("bin/chap14/InputStreamEx1.class");
		byte[] buf = new byte[16];//16바이트씩 읽기
		int len;
		while ((len = fis.read(buf)) != -1) {
			for (int i = 0; i < len; i++)
				System.out.printf(" %02X", buf[i]);
			System.out.println();
		}
	}
}