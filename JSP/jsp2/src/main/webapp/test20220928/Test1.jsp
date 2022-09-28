<%@page import="javax.swing.text.Document"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 select 구문 실행 결과 확인</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>

	<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection
		   ("jdbc:oracle:thin:@localhost:1521:xe","kic","1234"); 
Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
);
%>

	<form method="post">
		<textarea cols="60" rows="5" name="sql"></textarea>
		<input type="submit" value="실행">
	</form>
	<%
String res_sql = request.getParameter("sql");
	ResultSet rs = stmt.executeQuery(res_sql);
//ResultSetMetaData : 조회된 컬럼의 정보 저장
	rs.last();
	int a = rs.getRow();
	rs.first();
	ResultSetMetaData rsmt = rs.getMetaData();
%>
	<table>
		<tr>
			<td colspan="<%=rsmt.getColumnCount()%>">조회된 레코드 갯수 : <%=a%></td>
		</tr>
		<tr>
			<%
  for(int i=1;i<=rsmt.getColumnCount();i++) {
%>
			<th><%=rsmt.getColumnName(i) %></th>
			<%-- 컬럼명 출력 --%>
			<% } %>
		</tr>
		<%-- 데이터 부분 출력 --%>
		<% while(rs.next())  {%>
		<tr>
			<%-- 컬럼값 출력 --%>
			<% for(int i=1;i<=rsmt.getColumnCount();i++) {%>
			<td><%=rs.getString(i) %></td>
			<%-- rs.getString(컬럼순서) --%>
			<% } %>
		</tr>
		<% 
} %>
	</table>
</body>
</html>