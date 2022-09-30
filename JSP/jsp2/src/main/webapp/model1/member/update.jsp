<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
