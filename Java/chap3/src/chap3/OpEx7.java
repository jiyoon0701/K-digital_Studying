package chap3;
/*
 * 대입연산자 : =, +=,-=,*=,....
 * 
 * a = 10  : a변수에 10값을 대입하여 저장.  
 * a == 10 : a변수의 값이 10이니?  
 */
public class OpEx7 {
	public static void main(String[] args) {
		int num=100;
		System.out.println(num); //100
		num += 10;   //num = num + 10 
		System.out.println(num); //110
		num = num + 10;
		System.out.println(num); //120
		num /= 10; //num = num / 10
		System.out.println(num); //12
		num *= 5;
		System.out.println(num); //60
		num -= 2+3;  //num = num - (2+3)
		System.out.println(num); //55
		num %= 10; //num = num % 10
		System.out.println(num); //5
				
	}
}
