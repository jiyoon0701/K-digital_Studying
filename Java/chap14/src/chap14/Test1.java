package chap14;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 생성할 파일이름을 입력받고, 파일에 저장할 내용을 콘솔에서 내용을 입력
 * 입력받은 파일명의 파일에 저장하는 프로그램작성하기.  
 * exit 문자를 입력받으면 입력을 종료한다.
 * 단 FileOutputStream을 이용한다.
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		//1. 파일이름 입력받기
				System.out.println("저장할 파일의 이름을 입력하세요");
				Scanner scan = new Scanner(System.in);
				//String nextLine() : 한줄 전체를 읽기
				String file = scan.nextLine();
				//2. FileOutputStream 객체 생성
				FileOutputStream fos = new FileOutputStream(file);
				//3. 내용을 입력받아, 파일에 저장. => 반복. exit까지
				System.out.println(file+"파일에 저장할 내용 입력");
				String data = null;
				while(true) {
					data = scan.nextLine(); //키보드에서 데이터 입력 
					if(data.equals("exit")) break;
					fos.write((data+"\n").getBytes());
				}
				//4. flush, close
				fos.flush();
				fos.close();
	}
}
