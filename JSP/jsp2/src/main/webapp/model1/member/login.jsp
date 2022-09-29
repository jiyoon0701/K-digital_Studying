<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /jsp2/src/main/webapp/model1/member/login.jsp 
  1. 아이디, 비밀번호 파라미터를 변수 저장 
  2. db 정보를 읽기. id에 해당하는 db정보를 읽어서 Member 객체에 저장 
     Member MemberDao.selectOne(id);
  3. 아이디와 비밀번호 검증. 
    - 아이디가 없는 경우      
       아이디가 없습니다. 메세지확인. loginForm.jsp 페이지 이동
    - 아이디 존재. 비밀번호가 틀린경우   
       비밀번호오류 메세지확인. loginForm.jsp 페이지 이동
    - 아이디 존재. 비밀번호가 맞는경우 => 정상적인 로그인.
      session 객체에 로그인 정보 저장.
      main.jsp로 페이지 이동.    
--%>    
<%
  //1아이디, 비밀번호 파라미터를 변수 저장
  String id = request.getParameter("id");
  String pass = request.getParameter("pass");
  //2. db 정보를 읽기. id에 해당하는 db정보를 읽어서 Member 객체에 저장
  MemberDao dao = new MemberDao();
  Member mem = dao.selectOne(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= mem %>
</body>
</html>