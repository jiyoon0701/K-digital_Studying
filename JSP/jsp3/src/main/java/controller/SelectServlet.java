package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8088/jsp3/select
// kiclayout.jsp 에서 ajax로 요청 되는 페이지.
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String si;
	private String gu;
    public SelectServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//BufferedReader : 필터 입력스트림
		//                 입력스트림에 버퍼를 할당함. 성능 향상 스트림
		//                 readLine() 메서드를 멤버로 가짐.
		//FileReader : 파일에서 문자형 데이터를 읽기위한 스트림
		BufferedReader fr = new BufferedReader
       (new FileReader(request.getServletContext().getRealPath("/")
		 +"file/sido.txt"));
       si = request.getParameter("si");
       gu = request.getParameter("gu");
       //LinkedHashSet : 추가한 순서를 유지. 중복불가.
       Set<String> set = new LinkedHashSet<>();
       String data = null;
       if(si == null  && gu==null) {
    	   //data : 서울특별시	종로구	청운동
    	   while((data = fr.readLine()) != null) {
    		   // \\s+ : 정규화식. 공백문자 1개 이상 의미
    		   // \\s : 공백의 정규식 표현
    		   //  +  : 1개이상.
    		   //arr[0] : 서울특별시
    		   //arr[1] : 종로구
    		   //arr[2] : 청운동    		   
    		   String[] arr = data.split("\\s+");
    		   if(arr.length >= 3) set.add(arr[0].trim());
    	   }
       } else if (gu==null) {  //si 파라미터 존재.
    	 si = si.trim();
    	 while((data=fr.readLine()) != null) {
    		 String[] arr = data.split("\\s+");
    		 //si : 서울특별시
    		 if(arr.length >= 3 && arr[0].equals(si) && 
    				 !arr[0].equals(arr[1])) {
    			 set.add(arr[1].trim()); //구정보 저장
    		 }
    	 }
       } else { //si,gu 파라미터가 둘다 존재.
      	 si = si.trim();
      	 gu = gu.trim();
      	 while((data=fr.readLine()) != null) {
      		 String[] arr = data.split("\\s+");
      		 //si : 서울특별시
      		 if(arr.length >= 3 && arr[0].equals(si) &&
  				 arr[1].equals(gu) && !arr[0].equals(arr[1]) &&
  				!arr[1].equals(arr[2])) {
      			 if(arr.length > 3) arr[2] += " " + arr[3];
      			 set.add(arr[2].trim()); //동정보 저장
      		 }
      	 }    	   
       }
       //text/plain : 순수 문자열
       //charset=utf-8 : 한글 인식 
       response.setContentType("text/plain; charset=utf-8");
       List<String> list = new ArrayList<>(set);
       Collections.sort(list);
       response.getWriter().println(list);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
