package chap10;
//매개변수로 사용하기 
public class LambdaEx2 {
	public static void main(String[] args) {
		LambdaInterface1 f = ()->System.out.println("람다 방식 코딩 1");
		execute(f);
		execute(()->System.out.println("람다 방식 코딩 2"));
		//1부터 100까지의 합 출력하기
		f = ()->{
			int sum=0;
			for(int i=1;i<=100;i++) sum += i;
			System.out.println("1~100까지의 합:"+sum);
		};
		execute(f);
		execute(()->{
			int sum=0;
			for(int i=1;i<=100;i++) sum += i;
			System.out.println("1~100까지의 합:"+sum);
		});
		
	}
	static void execute(LambdaInterface1 f) {
		f.method();
	}
}
