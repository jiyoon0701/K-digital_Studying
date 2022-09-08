package chap11;
/*
 * Object 클래스
 *  1. 모든 부모 클래스
 *  2. 모든 클래스의 객체는 Object 클래스에 객체를 포함한다. 
 *     => 모든 객체는 Object타입으로 참조가 가능하다.
 *  3. 모든 클래스의 객체는 Object 클래스의 멤버를 호출할 수 있음. 
 *  
 *    equals 메서드 : 동일성 판단 메서드. 객체의 내용비교를 위한 메서드
 *                  객체의 내용의 동일성 판단을 위해서는  equals 메서드를 호출해야함.
 */
class Equal extends Object{
	int value;
	Equal(int value) {
		this.value =value;
	}
	//내용 비교를 위해 equals 메서드를 오버라이딩 필요
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equal) {
			Equal e = (Equal)obj;
			return e.value == value; //true
		} else return false;
	}
	//논리적인 동등성을 위해 hashCode 메서드 오버라이딩
	@Override
	public int hashCode() {
		return value;
	}
	//내용 출력을 위한 toString() 메서드 오버라이딩
	@Override
	public String toString() {
		return "Equal[value="+value+"]";
	}
}
public class ObjectEx1 {
	public static void main(String[] args) {
		Equal e1 = new Equal(10);
		Equal e2 = new Equal(10);
		if(e1 == e2)  //참 : e1객체와 e2 객체가 동일한 경우
			System.out.println("e1 == e2: e1과 e2는 같은 객체임");
		else 
			System.out.println("e1 != e2: e1과 e2는 다른 객체임");
		//equals 메서드는 Object 멤버 메서드임.
		// => 모든 객체는 equals 메서드를 포함한다.
		// e1객체의 내용과 e2객체의 내용의 동일성 비교
		// => equals 메서드를 오버라이딩 필요
		if(e1.equals(e2))
			System.out.println("e1.equals(e2): e1과 e2는 같은 내용의 객체임");
		else
			System.out.println("!e1.euqlas(e2): e1과 e2는 다른 내용의 객체임");
	}
}