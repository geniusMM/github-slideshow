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
		//test02.jsp에서 get 방식으로(a태그)로 이동함
		//=>http://localhost:9090/mystudy/day1/test03.jsp?no=7&name=김동율
		//												 ↑파라미터 이름은?
		//									물음표 뒤에 오는것들이 파라미터 이름
		//한글인코딩은 servers/server.xml에서 고침 65번째 줄 URIEncoding="euc-kr"/>
		//요청 파라미터 읽어오기
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		
	%>
	<h1>get방식</h1>
	<h2>요청 파라미터 값</h2>
	<p>번호: <%=no %></p>
	<p>이름: <%=name %></p>
</body>
</html>