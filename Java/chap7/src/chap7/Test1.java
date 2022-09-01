package chap7;
/*
Coin 클래스와 구동 클래스 구현하기
  Coin 클래스
   멤버변수 : int side (앞면:0, 뒷면:1), sno(동전번호), cnt(동전번호 생성을위한 클래스변수)
   생성자 : () : 매개변수 없는 생성자 앞면으로 등록
          (int side) : side(0|1) 로 동전의 면을 결정 
   멤버메서드 : void flip()
             Math.random() 메서드를 사용하여 side를 결정.=> 0,1 만 가능

  구동클래스
    Coin 클래스의 객체를 10개 생성하기.
    객체생성시, 동전번호를 입력하고, flip() 메서드를 이용하여 각각의 동전이 앞면인지 뒷면인지
    여부를 출력하기

  [결과]
1번동전 : 앞면
2번동전 : 뒷면
  ....

전체 앞면 동전의 갯수 :
전체 뒷면 동전의 갯수 : 
 */

class Coin {
	int side;
	int sno;
	static int cnt;
	
	 Coin() {
		this.side = 0;
	}
	 
	 Coin(int side) {
		 this.side = side;
	}
	 
	 public void flip() {
		 this.side = (int)(Math.random()*2);
	 }
	 
}


public class Test1 {
	public static void main(String[] args) {
		Coin[] coin = new Coin[10];
		int len = 0;
		for(int i = 0; i<coin.length; i++) {
			//System.out.println();
			coin[i] = new Coin();
			coin[i].sno = ++Coin.cnt;
			coin[i].flip();
			if(coin[i].side == 0) {
				System.out.println(coin[i].sno+"번 동전 : 앞면");
				len++;
			}
			else {
				System.out.println(coin[i].sno+"번 동전 : 뒷면");
			}
		}
		System.out.println("전체 앞면 동전의 개수 : "+len);
		System.out.println("전체 뒷면 동전의 개수 : "+ (10-len));
	}
}
