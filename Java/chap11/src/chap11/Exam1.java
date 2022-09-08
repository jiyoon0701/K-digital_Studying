package chap11;
class Card {
	String kind;
	int number;
	Card(String kind,int number) {
		this.kind = kind;
		this.number = number;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
		  Card c = (Card)obj;
		  return kind.equals(c.kind) && number == c.number;
		} else {
			return false;
		}
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Card c1 = new Card("Spade",1);
		Card c2 = new Card("Spade",1);
		if(c1==c2)
			System.out.println("c1과 c2는 같은 객체임");
		else
			System.out.println("c1과 c2는 다른 객체임"); //출력
		if(c1.equals(c2))
			System.out.println("c1과 c2는 같은 내용의 카드임"); //출력
		else
			System.out.println("c1과 c2는 다른 내용의 카드임");
	}
}