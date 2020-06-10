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
		//pddetail 에서 수정 클릭, get방식으로 넘어옴
		//http://localhost:9090/mystudy/pd/pdEdit.jsp?no=2
		//1. 요청 파라미터 읽어오기
		String no = request.getParameter("no");

		//2. db처리
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//3. 결과 출력
		//상품명, 가격 태그 value에 표현식 추가
		
	%>
	<h1>상품 수정</h1>
	<form name="frmwrite" method="post" action="pdEdit_ok.jsp">
		<!-- ★★★★★★★★★★★★★★★★★★★★★★★★★★수정시 no가 필요하므로 hidden 필드에 넣어줌  ★★★★★★★★★★★★★★★★★★★★★★★-->
		<input type = "hidden" name = "no" value =  "<%=dto.getNo()%>">
		<label for="pdName">상품명</label> 
		<input type="text" name="pdName" id="pdName" value = "<%=dto.getPdName()%>"><br> 
		<label for="price">가격</label> 
		<input type="text" name="price" id="price" value = "<%=dto.getPrice()%>"><br><br> 
		<input type="submit" value="수정"> <input type="reset" value="취소">
	</form>
	<hr>
	<a href="pdList.jsp">상품 목록</a>
</body>
</html>