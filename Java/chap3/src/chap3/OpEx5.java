package chap3;
/*
 * 비트 연산자 : &(AND), |(OR), ~(NOT), ^(XOR)
 * */
public class OpEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(6 & 3);
		/*
		 * 6 : 00000110
		 * 3 : 00000011
		 * & : 00000010 => 2
		 * */
		System.out.println(6 | 3);
		/*
		 * 6 : 00000110
		 * 3 : 00000011
		 * & : 00000111 => 7
		 * */
		System.out.println(6 ^ 3);
		/*
		 * XOR : 배타적 OR. 두개 값이 다른 경우 TRUE(1), 같은 경우 FALSE(0)
		 * 6 : 00000110
		 * 3 : 00000011
		 * & : 00000101 => 5
		 * */
		System.out.println(~10);
		/*
		 * ~ : not : 0 -> 1, 1-> 0
		 * 10 : 00001010
		 * ~ : 11110101  => 음수. 2의 보수로 표현. -11의 표현
		 * 
		 * 2의 보수 : 1의 보수 + 1
		 * */
		System.out.println(true & false);
	}

}
