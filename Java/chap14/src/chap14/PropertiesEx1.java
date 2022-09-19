package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * Properties 클래스
 *  1. Hashtable 클래스의 하위 클래스. 
 *  2. (key<String>,value<String>) 쌍인 객체로 저장 => 제네릭 표현 안함
 *  3. FileInputStream에서 Properties 형태의 내용을 Map객체로 load 할 수 있음.
 */
public class PropertiesEx1 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		System.out.println(pr);
		//a.properties : chap14 프로젝트 폴더에 생성 
		FileInputStream fis = new FileInputStream("a.properties");
		pr.load(fis); //a.properties 파일의 내용을 Properties 객체의 요소 저장
		pr.put("addr", "서울");
		System.out.println(pr);
		System.out.println(pr.get("name")); //홍길동
		System.out.println(pr.get("tel")); //1234
	}
}