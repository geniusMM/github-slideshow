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
		//test02.jsp���� get �������(a�±�)�� �̵���
		//=>http://localhost:9090/mystudy/day1/test03.jsp?no=7&name=�赿��
		//												 ���Ķ���� �̸���?
		//									����ǥ �ڿ� ���°͵��� �Ķ���� �̸�
		//�ѱ����ڵ��� servers/server.xml���� ��ħ 65��° �� URIEncoding="euc-kr"/>
		//��û �Ķ���� �о����
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		
	%>
	<h1>get���</h1>
	<h2>��û �Ķ���� ��</h2>
	<p>��ȣ: <%=no %></p>
	<p>�̸�: <%=name %></p>
</body>
</html>