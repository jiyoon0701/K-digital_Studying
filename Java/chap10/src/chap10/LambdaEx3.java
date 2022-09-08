package chap10;
// 매개변수가 있는 메서드
// (매개변수명,매개변수명)-> {   }
// 매개변수명 한개인 경우 () 생략 가능
interface LambdaInterface3 {
	void method(double d);
}
public class LambdaEx3 {
	public static void main(String[] args) {
		LambdaInterface3 f = new LambdaInterface3() {
			@Override
			public void method(double d) {
				System.out.println(d*5);
			}
		};
		f.method(10); //50.0
		f = (abc)-> System.out.println(abc*10);
		f.method(10); //100.0
		calc(f,10);//100.0
		calc(f,20);//200.0
		//입력값의 제곱값 출력하기
		calc((x)->System.out.println(x*x),100);
		calc(x->System.out.println(x+x),100);
	}
	static void calc(LambdaInterface3 f,double x) {
		f.method(x);
	}
}
