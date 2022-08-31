package chap6;
/*
 * 생성자 오버로딩
 */
class Card2 {
	String kind;
	int number;
	Card2(String k,int n) {
		kind = k;
		number = n;
	}
	Card2(int n) {
		kind = "Spade";
		number = n;
	}
	Card2(String k) {
		kind = k;
		number = 1;
	}
	Card2(Card2 c) {
		kind = c.kind;
		number = c.number;
	}
	public String toString() {
		return kind+":" + number;
	}
}
public class ConstructorEx2 {
	public static void main(String[] args) {
		Card2 c1 = new Card2("Spade",1);
		Card2 c2 = new Card2(10);
		Card2 c3 = new Card2("Heart");
		Card2 c4 = new Card2(c1);
		System.out.println(c1); //Spade:1
		System.out.println(c2); //Spade:10
		System.out.println(c3); //Heart:1
		System.out.println(c4); //Spade:1
	}
}
