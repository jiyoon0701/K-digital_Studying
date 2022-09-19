package chap14;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
 * File 클래스의 주요 메서드
 *  getAbsolutePath() : File 객체의 절대 경로
 *  getName() : 파일의 이름
 *  boolean mkdir() : 폴더 생성. 하위폴더 1개
 *  boolean mkdirs() : 폴더 생성. 하위폴더의 하위폴더...단계 1개
 *  boolean createNewFile() : 파일 생성. IOException 예외 처리
 *                     권한이 없는 경우 예외 발생.
 *  boolean renameTo(File)  : 파일의 이름 변경
 *  long lastModified() : 최종 수정시간.
 *                     1970이후부터 파일수정시간까지 밀리초로 리턴
 *  boolean delete() : 파일삭제                   
 */
public class FileEx2 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("c:/temp1");
		System.out.printf
		("%s 폴더생성 : %b%n",f1.getAbsolutePath(),f1.mkdir());
		File f2 = new File("c:/temp1/test.txt");
		System.out.printf("%s 파일 생성:%b%n",
				f2.getAbsolutePath(),f2.createNewFile());
		File f3 = new File("c:/temp1/test2.txt"); //test2.txt 파일 없음
		System.out.printf("%s->%s 이름변경:%b%n",
				f2.getName(),f3.getName(),f2.renameTo(f3));
		System.out.printf("%s 파일 최종 수정시간:%s%n",
				f3.getName(),new Date(f3.lastModified()));
		System.out.printf("%s 파일삭제:%b%n",f3.getName(),f3.delete());
	}
}