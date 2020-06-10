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
	//pdWrite.jsp에서 post 방식으로 서브밋 됨
	//1. 요청 파라미터 읽어오기
	//요청 파라미터에 대한 한글 인코딩 처리
	request.setCharacterEncoding("euc-kr");

	String pdName = request.getParameter("pdName");
	String price = request.getParameter("price");
	
	//2. db작업
	PdDAO dao = new PdDAO();
	try{
		PdDTO dto = new PdDTO();
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));
		
		int cnt = dao.insertPd(dto);
		//3. 결과 처리
		if(cnt>0){
			System.out.println("상품 등록 성공!");
			response.sendRedirect("pdList.jsp");
		}else{
			System.out.println("상품 등록 실패!");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%>
</body>
</html>