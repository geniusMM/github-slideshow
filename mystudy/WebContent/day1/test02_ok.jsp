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
	//test02.jsp ���� post������� ����� ��
	
	//��û �Ķ���Ϳ� ���� �ѱ� ���ڵ� ó��=>�Է°��� �ѱ��̶� �ѱ۷� ���ڵ��Ѵ�
	//�޼��带 post�� ������ ���� �ѱ۷� ���ڵ���
	//�Ź� �ؾߵ�
	request.setCharacterEncoding("euc-kr");
	

	//��û �Ķ���� �о����(����ڰ� �Է��� ��)
	String name = request.getParameter("name");//�Ű������� name, ��ҹ��� �������
	String address = request.getParameter("address");
	String agree = request.getParameter("agree");
	String[] pet = request.getParameterValues("pet");
	
	String petStr = "";
	if(pet != null){//checkbox ���� ���ϸ� null, �׷��� �� nullüũ �ؾ���
		for(int i=0 ; i<pet.length ; i++){
			petStr += pet[i]+" ";
		}
	}
	
%>
<h1>��û �Ķ���� ��</h1>
<p>�̸�: <%=name%></p>
<p>�ּ�: <%=address%></p>
<p>���ǿ���: <%=agree%></p>
<p>����: <%=petStr%></p><!-- <= ǥ����, ����϶�� �� -->
</body>
</html>












