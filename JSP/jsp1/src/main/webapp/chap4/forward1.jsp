<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /jsp1/src/main/webapp/chap4/forward1.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 하는 페이지</title>
</head>
<body>
<h2>forward 하는 페이지 입니다. 이내용은 화면에 출력되지 않습니다.</h2>
<% pageContext.forward("forward2.jsp"); %>
http://localhost:8088/jsp1/chap4/forward1.jsp?name=test
</body>
</html>