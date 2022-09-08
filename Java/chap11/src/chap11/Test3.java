package chap11;
/*
 * 학생클래스의 객체중 학번과 이름이 같다면 같은 학생임되도록 Student 클래스 수정하기
 * 
 [결과]
[학번=100, 이름=홍길동,전공=경영]과 [학번=100, 이름=홍길동,전공=컴공]는 다른 객체입니다.
[학번=100, 이름=홍길동,전공=경영]과 [학번=100, 이름=홍길동,전공=컴공]학생은 같은 학생입니다. 
 */
class Student2 {
	int studno;
	String name;
	String major;
	public Student2(int studno, String name, String major) {
		this.studno = studno;
		this.name = name;
		this.major = major;
	}
	@Override
	public String toString() {
		return "[학번=" + studno 
			 + ", 이름=" + name + ",전공=" + major + "]";
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student2) {
			Student2 s = (Student2)o;
			return studno == s.studno && name.equals(s.name);
		} else return false;
	}
	
}
public class Test3 {
	public static void main(String[] args) {
		Student2 s1 = new Student2(100,"홍길동","경영");
		Student2 s2 = new Student2(100,"홍길동","컴공");
		if(s1 == s2) {
			System.out.println(s1+"과 "+s2+"는 같은 객체입니다.");
		} else {
			System.out.println(s1+"과 "+s2+"는 다른 객체입니다.");
		}
		if(s1.equals(s2)) {
			System.out.println(s1+"과 "+s2+"학생은 같은 학생입니다.");
		} else {
			System.out.println(s1+"과 "+s2+"학생은 다른 학생입니다.");
		}
	}
}