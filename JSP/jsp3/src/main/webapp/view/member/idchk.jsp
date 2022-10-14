<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- /jsp3/src/main/webapp/view/member/idchk.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복검색</title>
<link rel="stylesheet" href="../css/main.css">
<style type="text/css">
   .able { color:green; font-size: 15px;}
   .disable { color:red; font-size: 20px;}
</style>
<body><table> <tr><td>아이디</td><td>${param.id}</td></tr>
  <tr><td colspan="2"><div id="msg">${msg}</div></td></tr>
  <tr><td colspan="2"><input type="button" value="닫기"  
      onclick="self.close()"></td></tr>
</table>    
<script>
  if (${able}) {
	opener.document.f.id.style.color="green"
	document.querySelector("#msg").setAttribute("class","able")
  } else {
	opener.document.f.id.value=""
	document.querySelector("#msg").setAttribute("class","disable")
  }
</script></body></html>