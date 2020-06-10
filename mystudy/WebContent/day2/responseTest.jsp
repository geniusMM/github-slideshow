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
		//test.jsp 로 이동
		response.sendRedirect("test.jsp");
		/* response.sendRedirect("test.jsp?no=6&address=서초"); 
		      파라미터 있는 경우*/
      /* responseTest 페이지는 못봄, 바로 이동함
      	=>sendRedirect*/
	%>
</body>
</html>