package chap13;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/*
 * TreeMap 예제 : key 객체로 정렬됨
 */
public class MapEx2 {
	public static void main(String[] args) {
		TreeMap<Integer,String> scores = new TreeMap<>();
//		NavigableMap<Integer,String> scores = new TreeMap<>();
		scores.put(87, "홍길동");scores.put(98, "이몽룡");
		scores.put(75, "임꺽정");scores.put(94, "김삿갓");
		scores.put(80, "성춘향");scores.put(88, "향단이");
		System.out.println(scores);
		System.out.println("첫번째 key :"+scores.firstKey());
		//Map.Entry : (key,value) 쌍인 객체의 자료형
		System.out.println("첫번째 entry :"+scores.firstEntry());
		System.out.println("첫번째 entry key:"
		             +scores.firstEntry().getKey()); //75
		System.out.println("첫번째 entry value:"
	             +scores.firstEntry().getValue()); //임꺽정
		System.out.println("마지막 entry :"+scores.lastEntry());
		
		System.out.println("94점 아래 점수:");
		System.out.println(scores.lowerEntry(94));
		System.out.println("95점 위 점수:");
		System.out.println(scores.higherEntry(95));
		System.out.println("95점 아래 점수 95점 포함:");
		System.out.println(scores.floorEntry(95));
		System.out.println("95점 위 점수 95점 포함:");
		System.out.println(scores.ceilingEntry(95));
		
	}
}
