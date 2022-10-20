<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /ajax1/src/main/webapp/20221020/test3.jsp 
     0~ 99 사이의 임의의 값을 10개생성하여
	 ,를 이용하여 문자열 변환하여 전달 --%>    
<%
   String result = "";
   for(int i=1;i<=10;i++) {
	   int n = (int)(Math.random()*100);
	   result += n+((i==10)?"":",");
   }
//   out.println(result);
%>
<%=result%>