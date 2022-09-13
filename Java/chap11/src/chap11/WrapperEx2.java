package chap11;

public class WrapperEx2 {

	public static void main(String[] args) {
		char[] data = {'A','a','가','9','-','_'};
		for(char c : data) {
			if (Character.isUpperCase(c))
				System.out.println(c+":대문자");
			else if (Character.isLowerCase(c))
				System.out.println(c + ":소문자");
			else if (Character.isDigit(c))
				System.out.println(c + ":숫자");
			else
				System.out.println(c + ":기타문자");
			if(Character.isAlphabetic(c))
				System.out.println(c + ":문자");
			else
				System.out.println(c + ":문자아님");
		}
	}

}
