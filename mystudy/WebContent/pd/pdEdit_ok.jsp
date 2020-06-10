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
	//pdEdit.jsp에서 수정 클릭해서 넘어옴 post 방식으로 서브밋 됨
	//한국어 인코딩
	request.setCharacterEncoding("euc-kr");

	//1. 파라미터 읽어오기
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
		//3. 결과 화면 출력
		if(cnt>0){
			System.out.println("상품 수정 성공ㅋ!");
			response.sendRedirect("pdDetail.jsp?no="+no);//같은 언어끼리는 +로 연결 가능
		}else{
			System.out.println("상품 수정 실패ㅠㅠ");
			
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%>
</body>
</html>