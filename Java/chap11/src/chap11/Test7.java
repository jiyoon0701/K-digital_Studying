package chap11;
/*
다음의 결과가 나오도록 프로그램을 수정하기
[결과]
fullPath:c:/jdk17/work/Test.java
path:c:/jdk17/work
fileName:Test.java
*/
public class Test7 {
	public static void main(String[] args) {
		String fullPath = "c:/jdk17/work/Test.java";
		String path="";
		String fileName = "";

		//lastIndexOf("/") : 뒤쪽 우선 / 의 위치인덱스 리턴
		int idx = fullPath.lastIndexOf("/"); //마지막 /의 인덱스 값 
		path = fullPath.substring(0,idx); //c:/jdk17/work
		fileName = fullPath.substring(idx+1); //Test.java
		
		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);
	}

}
