package chap11;
/*
 * hashCode() : 원래의 의미는 객체를 구분하기 위한 참조값
 *              내용이 같다는 기능 => 논리적인 동등성.
 *              - equals 결과가 true
 *              - hashCode 값이 동일함.
 * 권장사항 : equals 메서드 오버라이딩을 하는 경우 hashCode 메서드도 함께 오버라이딩하도록
 *         권장함.             
 */
public class ObjectEx2 {
	public static void main(String[] args) {
		Equal e1 = new Equal(10);
		Equal e2 = new Equal(10);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(System.identityHashCode(e1)); //실제 hashcode값
		System.out.println(System.identityHashCode(e2)); //실제 hashcode값
	}
}