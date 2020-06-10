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
	//test02.jsp 에서 post방식으로 서브밋 됨
	
	//요청 파라미터에 대한 한글 인코딩 처리=>입력값이 한글이라서 한글로 인코딩한다
	//메서드를 post로 보냈을 때만 한글로 인코딩함
	//매번 해야됨
	request.setCharacterEncoding("euc-kr");
	

	//요청 파라미터 읽어오기(사용자가 입력한 값)
	String name = request.getParameter("name");//매개변수랑 name, 대소문자 맞춰야함
	String address = request.getParameter("address");
	String agree = request.getParameter("agree");
	String[] pet = request.getParameterValues("pet");
	
	String petStr = "";
	if(pet != null){//checkbox 선택 안하면 null, 그래서 꼭 null체크 해야함
		for(int i=0 ; i<pet.length ; i++){
			petStr += pet[i]+" ";
		}
	}
	
%>
<h1>요청 파라미터 값</h1>
<p>이름: <%=name%></p>
<p>주소: <%=address%></p>
<p>동의여부: <%=agree%></p>
<p>동물: <%=petStr%></p><!-- <= 표현식, 출력하라는 뜻 -->
</body>
</html>












