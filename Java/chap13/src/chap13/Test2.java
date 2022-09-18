package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
화면에서 여러개의 자연수를 입력받아(0을 입력시 입력종료) 이들 중 
홀수 인 자연수들만 이루어진 List 객체를 생성하고 
합을 구하고,홀수 중 최대값과 최소값을 찾는 프로그램을 작성하기
단 문자가 입력되면 무시한다.
홀수 들로만 이루어진 List 객체를 생성하여 출력하기

최대값과 최소값은
Collections.max(list)와 Collections.min(list) 함수를 이용한다

 7개의 자연수 : 12 77 38 41 53 92 85 aaa 인 경우
 77 41 53 85 만 홀수 이므로
 77+41+53+85 = 합 
 홀 수의 최대값 : 85
 홀 수의 최소값 : 41
 입력된 홀수 : [77,41,53,85]
*/
public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("자연수를 입력하세요 종료(0)");
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		while(true) {
			try {
			   int num = scan.nextInt(); //12 77 38 41 53 92 85 aaa
			   if(num == 0) break;
			   if(num%2==0) continue;
			   list.add(num); //홀수인경우만 list에 추가
			   sum += num;
			} catch(InputMismatchException e) { //정수가 아닌 경우 예외발생
				scan.next();
			}
		}
		System.out.println(list + "의 합:" + sum);
		System.out.println("홀수의 최대값:" + Collections.max(list));
		System.out.println("홀수의 최소값:" + Collections.min(list));
		//indexOf(Object) : 객체의 위치값 리턴   
		System.out.println("홀수의 최대값 위치:" + list.indexOf(Collections.max(list)));
		System.out.println("홀수의 최소값 위치:" + list.indexOf(Collections.min(list)));
		System.out.println("입력된 홀수 :" + list);
	}
}
