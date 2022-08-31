package chap6;

public class MemberCallEx1 {
    static int cv1 = 10; //클래스멤버
    static int cv2 = cv1;//클래스멤버간 호출
    int iv1 = 100;     //인스턴스 멤버
    int iv2=iv1;       //인스턴스 멤버간 호출
    int iv3 = cv1;     //인스턴스 멤버에서 클래스 멤버 호출
//  static int cv3 = iv1; //클래스멤버에서 인스턴스 멤버 호출
  //클래스멤버에서 인스턴스 멤버 호출시 객체화 필요
    static int cv3 = new MemberCallEx1().iv1;
    
    void method1() {   //인스턴스 멤버
    	System.out.println(cv1+cv2); //클래스 멤버 호출
    	System.out.println(iv1+iv2); //인스턴스 멤버 호출
    }
    static void method2() {  //클래스 멤버
    	System.out.println(cv1+cv2); //클래스 멤버 호출
//    	System.out.println(iv1+iv2); //인스턴스 멤버 호출시 객체화 필요
    	MemberCallEx1 m = new MemberCallEx1();
    	System.out.println(m.iv1 + m.iv2);
    }
	public static void main(String[] args) { //클래스멤버
		//cv2 = iv1; //클래스 멤버에서 인스턴스 멤버 호출시 객체화 필요
		cv2 = new MemberCallEx1().iv1;
		System.out.println(cv2); //100
		new MemberCallEx1().iv3 = cv2; //클래스메서드에서 iv2 변수 접근 불가.
		System.out.println(new MemberCallEx1().iv3);
//		method1(); //main 클래스 멤버에서 인스턴스멤버 호출
		//main 클래스 멤버에서 인스턴스멤버 호출 시 객체화 필요
		new MemberCallEx1().method1();
		method2();  //클래스멤버간 호출
	}

}
