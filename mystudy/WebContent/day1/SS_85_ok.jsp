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
<h2>======����ڰ� �Է��� ��======</h2>
<p>��ȣ: <%=sh%></p>
<p>����: <%=what%></p>
<p>����: <%=loc%></p>
<p>��ġ: <%=wi%></p>
<p>��Ÿ�ɼ�: <%=parkStr%></p>
<hr>
<h2>�����ͺ��̽��� �����մϴ�.</h2>

</body>
</html>