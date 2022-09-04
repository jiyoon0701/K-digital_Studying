package chap7.test;

public class Modifier2 {
   private int v1=10;
    int v2=20;
   protected int v3=30;
   public int v4=40;
   public String toString() { //Modifier2 클래스의 멤버이므로 v1 접근허용
	   return v1+","+v2+","+v3+","+v4;
   }
}
