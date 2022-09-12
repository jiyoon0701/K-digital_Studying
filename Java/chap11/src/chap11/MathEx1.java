package chap11;
/*
 * Math 클래스 : 수치계산 관련 클래스 
 *  1. final 클래스 
 *  2. 생성자의 접근제어자는 private임 => 객체 생성 불가. 
 *     => 모든 멤버가 클래스 멤버임. 객체 생성 필요 없음.
 *  3. 상수   
 *     - Math.PI : 원주율
 *     - Math.E  : 자연로그
 */
public class MathEx1 {
	public static void main(String[] args) {
		//abs : 절대값
		System.out.println("Math.abs(5)="+Math.abs(5)); //5
		System.out.println("Math.abs(-5)="+Math.abs(-5)); //5
		System.out.println("Math.abs(3.14)="+Math.abs(3.14)); //3.14
		System.out.println("Math.abs(-3.14)="+Math.abs(-3.14)); //3.14
		//근사 정수 : 가장 가까운 정수
		//ceil 메서드 : 큰수 중 가까운 정수
		System.out.println("Math.ceil(5.4)="+Math.ceil(5.4)); //6
		System.out.println("Math.ceil(-5.4)="+Math.ceil(-5.4));//-5
		//floor 메서드 : 작은 수 중 가까운 정수
		System.out.println("Math.floor(5.4)="+Math.floor(5.4));//5
		System.out.println("Math.floor(-5.4)="+Math.floor(-5.4));//-6
		//rint : 가까운 정수
		System.out.println("Math.rint(5.4)="+Math.rint(5.4)); //5
		System.out.println("Math.rint(-5.4)="+Math.rint(-5.4)); //-5
		System.out.println("Math.rint(5.5)="+Math.rint(5.5)); //6
		System.out.println("Math.rint(-5.5)="+Math.rint(-5.5)); //-6
		//최대값, 최소값
		System.out.println("Math.min(5,4)="+Math.min(5,4)); //4
		System.out.println("Math.min(5.4,5.3)="+Math.min(5.4,5.3)); //5.3
		System.out.println("Math.max(5,4)="+Math.max(5,4)); //5
		System.out.println("Math.max(5.4,5.3)="+Math.max(5.4,5.3)); //5.4
		//반올림. long round() => 정수값 리턴.
		System.out.println("Math.round(5.4)="+Math.round(5.4)); //5
		System.out.println("Math.round(5.5)="+Math.round(5.5)); //6
		
		// 0 <= Math.random() < 1.0 임의의 수(난수) 리턴 
		System.out.println("Math.random()="+Math.random());
		
		//삼각함수 : 각도 단위는 라디안 임.
		//  Math.PI/2 => 90도
		System.out.println ("Math.sin(Math.PI/2)="+Math.sin(Math.PI/2));
		//Math.toRadians(60) : 라디안단위로 변형 <= 60도 
		System.out.println("Math.cos(Math.toRadians(60))="
		                     +Math.cos(Math.toRadians(60)));
		System.out.println("Math.tan(Math.PI/4)="+Math.tan(Math.PI/4));
		// toDegrees(Math.PI/2) : 도 <= 라디안
		System.out.println("Math.toDegrees(Math.PI/2)=" +Math.toDegrees(Math.PI/2));
		
		//log : 로그함수
		System.out.println("Math.log(Math.E)=" +Math.log(Math.E));
		//sqrt : 제곱근 
		System.out.println("Math.sqrt(25)="+Math.sqrt(25)); //5
		//pow : 제곱
		System.out.println("Math.pow(5,3)="+Math.pow(5,3)); //5*5*5=125

	}

}
