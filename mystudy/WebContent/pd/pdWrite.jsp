<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>��ǰ ���</h1>
<form name = "frmwrite" method = "post" action="pdWrite_ok.jsp">
	<label for = "pdName">��ǰ��</label>
	<input type = "text" name = "pdName" id = "pdName"><br>
	<label for = "price">����</label>
	<input type = "text" name = "price" id = "price"><br><br>
	<input type = "submit" value = "���">
	<input type = "reset" value = "���">
</form>
<hr>
<a href = "pdList.jsp">��ǰ ���</a>	
</body>
</html>