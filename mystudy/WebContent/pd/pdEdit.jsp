<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@page import="java.sql.SQLException"%>
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
		//pddetail ���� ���� Ŭ��, get������� �Ѿ��
		//http://localhost:9090/mystudy/pd/pdEdit.jsp?no=2
		//1. ��û �Ķ���� �о����
		String no = request.getParameter("no");

		//2. dbó��
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//3. ��� ���
		//��ǰ��, ���� �±� value�� ǥ���� �߰�
		
	%>
	<h1>��ǰ ����</h1>
	<form name="frmwrite" method="post" action="pdEdit_ok.jsp">
		<!-- �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڼ����� no�� �ʿ��ϹǷ� hidden �ʵ忡 �־���  �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�-->
		<input type = "hidden" name = "no" value =  "<%=dto.getNo()%>">
		<label for="pdName">��ǰ��</label> 
		<input type="text" name="pdName" id="pdName" value = "<%=dto.getPdName()%>"><br> 
		<label for="price">����</label> 
		<input type="text" name="price" id="price" value = "<%=dto.getPrice()%>"><br><br> 
		<input type="submit" value="����"> <input type="reset" value="���">
	</form>
	<hr>
	<a href="pdList.jsp">��ǰ ���</a>
</body>
</html>