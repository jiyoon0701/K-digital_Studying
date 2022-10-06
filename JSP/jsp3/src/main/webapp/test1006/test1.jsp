<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /jsp3/src/main/webapp/test1006/test1.jsp --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두개의 파라미터값을 계산하기</title>
</head>
<body>
<form method="post" >
  x:<input type="text" name="x" value=""><br>
  y:<input type="text" name="y" value="">
   <input type="submit" value="더하기"> 
</form> 
두수의 합계 : ${param.x + param.y}
<h3>if 태그를 이용하여 양수,음수, 0인지 출력하기</h3>
<c:if test = "${param.x + param.y < 0}">
	<p>${param.x+param.y} 은 음수입니다.</p>
</c:if>
<c:if test = "${param.x + param.y > 0}">
	<p>${param.x+param.y} 은 양수입니다.</p>
</c:if>
<c:if test = "${param.x + param.y == 0}">
	<p>${param.x+param.y} 은 0입니다.</p>
</c:if>
<h3>choose 태그를 이용하여 양수,음수, 0인지 출력하기</h3>  

<c:choose>
  <c:when test="${param.x + param.y > 0}">
     <p>${param.x + param.y}는 양수 입니다.</p>
  </c:when>
  <c:when test="${param.x + param.y < 0}">
     <p>${param.x + param.y}는 음수 입니다.</p>
  </c:when>
  <c:when test="${param.x + param.y == 0}">
     <p>${param.x + param.y}는 0 입니다.</p>
  </c:when>
</c:choose>
</body>
</html>