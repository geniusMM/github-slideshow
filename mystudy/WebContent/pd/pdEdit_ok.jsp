<%@page import="com.mystudy.pd.model.PdDTO"%>
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
	//pdEdit.jsp���� ���� Ŭ���ؼ� �Ѿ�� post ������� ����� ��
	//�ѱ��� ���ڵ�
	request.setCharacterEncoding("euc-kr");

	//1. �Ķ���� �о����
	String pdname = request.getParameter("pdName");
	String price = request.getParameter("price");
	String no = request.getParameter("no");
	
	//2. db
	PdDAO dao = new PdDAO();
	try{
		PdDTO dto = new PdDTO();
		dto.setPdName(pdname);
		dto.setPrice(Integer.parseInt(price));
		dto.setNo(Integer.parseInt(no));
		
		int cnt = dao.updatePd(dto);
		//3. ��� ȭ�� ���
		if(cnt>0){
			System.out.println("��ǰ ���� ������!");
			response.sendRedirect("pdDetail.jsp?no="+no);//���� ������ +�� ���� ����
		}else{
			System.out.println("��ǰ ���� ���ФФ�");
			
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%>
</body>
</html>