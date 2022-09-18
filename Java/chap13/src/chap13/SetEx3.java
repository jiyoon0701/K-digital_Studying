package chap13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * LinkedHashSet : Set 구현 클래스
 *                 중복불가, 순서유지
 */
public class SetEx3 {
	public static void main(String[] args) {
//		Set<Integer> set = new LinkedHashSet<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			int num = (int)(Math.random()*10); //0~9사이의 임의의 수
			System.out.println("임의의 수:" + num);
			set.add(num);
		}
		System.out.println(set);
		//개선된 for구문을 이용하여 출력하기 
		//개선된 for구문 : 배열, Collection 객체
		for(Integer i : set) {
			System.out.println(i);
		}
		//index(첨자)를 이용하여 객체 조회 => Set 객체는 인덱스 사용 불가
		//List 객체 <= Set 객체
		List<Integer> list = new ArrayList<>(set);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.println();
		
	}
}
