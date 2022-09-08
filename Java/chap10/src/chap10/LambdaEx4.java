package chap10;
interface LambdaInterface4 {
	int method(int x, int y);
}
public class LambdaEx4 {
	public static void main(String[] args) {
		LambdaInterface4 f = (x,y)-> {
			return x+y;
		};
		System.out.println(f.method(10,20));
		f = (x,y)->x+y;
		System.out.println(calc(f,10,20)); //30
		System.out.println("두수의 곱:"+calc((x,y)->x*y,10,20));
		System.out.println("두수의 차:"+calc((x,y)->x-y,10,20));
		System.out.println("두수의 몫:"+calc((x,y)->x/y,100,20));
		System.out.println("두수의 나머지:"+calc((x,y)->x%y,10,20));
		System.out.println("두수 중 큰수:"+calc((x,y)->(x>y)?x:y,10,20));
		System.out.println("두수 중 작은수:"+calc((x,y)->(x<y)?x:y,10,20));
		//LambdaInterface4를 이용하여 배열 중 최소/최대값을 구해주는 함수 calc 함수
		int[] arr = {1,21,3,45,5,0,7,8,91,10};
		System.out.println("arr 배열 중 최대값:" +
		             calc(arr,(x,y)->(x>y)?x:y)); //10
		System.out.println("arr 배열 중 최소값:" +
	                 calc(arr,(x,y)->(x<y)?x:y));//1
	}
	static int calc(LambdaInterface4 f, int x, int y) {
		return f.method(x, y);
	}
	static int calc(int[] arr,LambdaInterface4 f) {
		//(x,y)->(x<y)?x:y
		int result = arr[0]; //1
		for(int i : arr) result = f.method(result, i);//1
		return result;
	}	
}
