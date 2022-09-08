package chap10;
class Outer4 {
	public int iv=10;
	void method() {
//		int iv=20;
		iv++;
		LambdaInterface1 f = ()->{
			System.out.println("iv="+iv);
			System.out.println("this.iv="+this.iv); //외부클래스의 멤버
			System.out.println("Outer4.this.iv="+Outer4.this.iv);//외부클래스의 멤버
		};
		f.method();
	}
}
public class LambdaEx5 {
	public static void main(String[] args) {
		new Outer4().method();
	}
}
