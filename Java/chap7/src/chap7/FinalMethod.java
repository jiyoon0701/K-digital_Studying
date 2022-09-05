package chap7;
/*
 * final 제한자 : 변경 불가
 * 
 * final 메서드 : 재정의 불가 메서드. 오버라이딩 불가 메서드
 */
public  class FinalMethod {
    public final void method() { //final 메서드. 오버라이딩 불가 
    	System.out.println("FinalMethod 클래스의 method()");
    }
}
class SubMethod extends FinalMethod {
    public void method() {
    	System.out.println("SubMethod 클래스의 method()");
    }
}