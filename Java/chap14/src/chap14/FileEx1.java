package chap14;

import java.io.File;

/*
 * File 클래스
 *  1. 파일,폴더의 정보를 관리하는 클래스.없는 파일도 관리가 가능.
 *  2. 폴더 구분자 : 폴더를 구분하는 문자.
 *     윈도우 : \,/ =>  c:\, c:/
 *     리눅스,맥 : /
 */
public class FileEx1 {
	public static void main(String[] args) {
		String filepath = "c:/";
		//f1 : c:드라이브의 root 폴더 관리 
		File f1 = new File(filepath);
		//f1.list() : f1 파일의 하위 폴더/파일의 이름 배열로 리턴 
		String[] files = f1.list();
		for(String f : files) {
			//f : c:\의 하위 폴더/파일 한개의 이름
			File f2 = new File(filepath,f);//filepath 폴더 중 f이름을 가진 파일
			if(f2.isDirectory()) //폴더니?
				System.out.printf("%s:디렉토리\n",f);
			else //파일?
				//f2.length() : 파일의 크기 바이트로 리턴
				//%,d : 세자리마다 ,를 찍어 10진정수로 출력
				System.out.printf("%s:파일(%,dbyte)\n",f,f2.length());
		}
	}
}