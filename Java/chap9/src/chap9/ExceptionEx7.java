package chap9;

import java.util.Scanner;

public class ExceptionEx7 {
	public static void main(String[] args) {
		try {
			String id= "hong";
			String pw = "1234";
			Scanner scan = new Scanner(System.in);
			System.out.println("id를 입력하세요");
			String inId = scan.next();
			System.out.println("비밀번호를 입력하세요");
			String inPw = scan.next();
			if(id.equals(inId) && pw.equals(inPw)) {
				System.out.println("로그인 성공");
			} else if(!id.equals(inId)) {
				throw new LoginFailException("ID 확인하세요");
			} else {
				throw new LoginFailException("비밀번호를 확인하세요");
			}
		} catch (LoginFailException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class LoginFailException extends Exception{
	LoginFailException(String msg) {
		super(msg);
	}
}
