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
	//pdDetail���� ���� ��ư Ŭ�� get������� �Ѿ��
	//=>http://localhost:9090/mystudy/pd/pdDelete.jsp?no=1
	
	//1 �Ķ���� 
	String no = request.getParameter("no");
	
	//2 dbó��
	PdDAO dao = new PdDAO();
	try{
		int cnt = dao.deletePd(Integer.parseInt(no));
		
		if(cnt>0){
			System.out.println("���� ����");
			response.sendRedirect("pdList.jsp");
		}else{
			System.out.println("���� ����");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	//3 ��� ���
%>
</body>
</html>