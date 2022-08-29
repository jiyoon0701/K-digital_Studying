package chap5;
/*
 * Commend 숫자를 입력받아 자리수의 합을 출력하기
 * 
 * */
public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = args[0].toCharArray();
		int sum = 0;
        for (char c : charArray) {
            sum += c-'0';
        }
        System.out.println(sum);
	}
}