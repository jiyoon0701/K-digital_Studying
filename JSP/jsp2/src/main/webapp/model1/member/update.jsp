<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%-- /jsp2/src/main/webapp/model1/member/update.jsp

 1. 모든 파라미터 정보를 Member 객체에 저장
 2. 입력된 비밀번호와, db에 저장된 비밀번호 비교 => db에서 읽기
    관리자인경우 관리자비밀번호로 비교하기.
    본인인 경우 본인의 비밀번호로 비교하기
    - 비밀번호가 틀린 경우 : "비밀번호 오류" 메세지 출력 
                         updateForm.jsp 페이지 이동
 3. 비밀번호가 맞는 경우
    입력된 내용을 저장하고 있는 Member 객체를 이용하여 db 정보 수정.
    boolean MemberDao.update(Member)
    결과가 true 면 수정성공 info.jsp 페이지 이동
    결과가 false면 수정실패 메세지 출력후 , updateForm.jsp 페이지 이동
--%>
<%
request.setCharacterEncoding("UTF-8");
// session에 저장되어 있는 id값과 parameter로 받아온 id값이 동일하다면
String login = (String) session.getAttribute("login");
String id = request.getParameter("id"); //id 파라미터 저장
String pass = request.getParameter("pass");
boolean result = false;
Member member = new Member();

//2.Member 객체의 내용을 db에 값 가져오기&업데이트
MemberDao dao = new MemberDao();
Member mem = dao.selectOne(login);
if ((login.equals("admin") && pass.equals("1234")) || login.equals(mem.getId()) && pass.equals(mem.getPass())) {
	member.setId(request.getParameter("id"));
	member.setPass(request.getParameter("pass"));
	member.setName(request.getParameter("name"));
	member.setGender(Integer.parseInt(request.getParameter("gender")));
	member.setTel(request.getParameter("tel"));
	member.setEmail(request.getParameter("email"));
	member.setPicture(request.getParameter("picture"));
	
	result = dao.update(member);// 업데이트 성
	
	if(result == true){
	%>
	<script type="text/javascript">
		alert("수정 성공")
		location.href = "info.jsp?id=<%=id%>";
	</script>
	<%
	} else if(result == false) { %>
	<script type="text/javascript">
		alert("수정 실패")
		location.href = "updateForm.jsp?id=<%=id%>";
	</script>
	<%}
} 
else { %>
<script type="text/javascript">
	alert("비밀번호 오류")
	location.href = "updateForm.jsp?id=<%=id%>";
</script>
<%
}
%>

<!-- String url = "updateForm.jsp?id="+mem.getId();
   //mem.getPass() : 입력된 비밀번호
   //dbMem.getPass() : db 등록된 비밀번호 
   if(mem.getPass().equals(dbMem.getPass())) {
	   //mem : 입력된 파라미터 정보를 저장
	  if(dao.update(mem)) {
		  msg = "회원 정보 수정이 완료되었습니다.";
		  url = "info.jsp?id="+mem.getId();
	  } else {
		  msg = "회원 정보 수정시 오류발생.";
	  }
   } -->