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
	request.setCharacterEncoding("euc-kr");

	String sh = request.getParameter("sh");
	String what = request.getParameter("what");
	String loc = request.getParameter("locate");
	String [] park = request.getParameterValues("cb");
	String wi = request.getParameter("wi");
	
	String parkStr = "";
	if(park != null){
		for(int i=0 ; i<park.length ; i++){
			parkStr = park[i]+" ";
		}
	}
%>
<h2>======사용자가 입력한 값======</h2>
<p>상호: <%=sh%></p>
<p>업종: <%=what%></p>
<p>지역: <%=loc%></p>
<p>위치: <%=wi%></p>
<p>기타옵션: <%=parkStr%></p>
<hr>
<h2>데이터베이스에 저장합니다.</h2>

</body>
</html>