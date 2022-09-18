package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 1. 대한민국=서울,캐나다=오타와,영국=런던을 HashMap에 저장하고,
 *    화면에서 나라이름을 입력받아 해당 나라의 수도를 출력하는 프로그램 구현하기
 * 2. 나라이름 입력시 종료문자가 입력될때까지 계속 입력받기
 * 3. 등록된 나라가 아니면 등록된 나라아님 출력하기   
 * 4. 등록된 나라가 아닌 경우 수도를 입력받아 등록.
 * 5. 종료시 등록된 나라와 수도를 출력하기
 */    
public class Exam4 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("대한민국","서울");
		map.put("캐나다","오타와");
		map.put("영국","런던");
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("나라이름 입력(종료:종료):");
			String n = scan.next();
			if(n.equals("종료")) break;
			if(map.get(n) == null) { 
				System.out.println(n+"=>등록된나라아님");
			    System.out.println("수도를 입력하세요");
			    map.put(n, scan.next());
			} else
			    System.out.println(n+"의수도:"+map.get(n));
		}
		System.out.println("map에 등록된 정보:");
		for(String k : map.keySet()) {
			System.out.println(k + ":"+map.get(k));
		}
		for(Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ":"+e.getValue());
		}
		
	}
}
