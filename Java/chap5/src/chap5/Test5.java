package chap5;
/* 
 * [결과]
 * (1)+(1+2)+(1+2+3)+ ... +(1+2+3+4+5+6+7+8+9)+(1+2+3+4+5+6+7+8+9+10)=220
 */

public class Test5 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=10; i++) {
			System.out.print("(");
			for(int j=1; j<=i; j++) {
				sum += j;
				if (j==i) {
					System.out.print(j);
				}
				else {
					System.out.print(j+"+");
				}
				
			}
			if (i==10) {
				System.out.print(")");
			}
			else {
				System.out.print(")+");
			}
			
		}
		System.out.print("="+sum);
	}
}
