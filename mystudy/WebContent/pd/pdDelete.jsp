<%@page import="java.sql.SQLException"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//pdDetail에서 삭제 버튼 클릭 get방식으로 넘어옴
	//=>http://localhost:9090/mystudy/pd/pdDelete.jsp?no=1
	
	//1 파라미터 
	String no = request.getParameter("no");
	
	//2 db처리
	PdDAO dao = new PdDAO();
	try{
		int cnt = dao.deletePd(Integer.parseInt(no));
		
		if(cnt>0){
			System.out.println("삭제 성공");
			response.sendRedirect("pdList.jsp");
		}else{
			System.out.println("삭제 실패");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	//3 결과 출력
%>
</body>
</html>