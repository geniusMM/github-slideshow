<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>request 객체 연습</h1>
	<form action="test02_ok.jsp" method="post"><!-- form태그로 갈때, 링크로 이동 => get방식 -->
		이름: <input type="text" name="name"> 
		<br> 주소: <input type="text" name="address"> <br> 
			좋아하는 동물: <input type="checkbox" name="pet" value="dog">
			강아지 <input type="checkbox" name="pet" value="cat">
			고양이 <input type="checkbox" name="pet" value="pig">
			돼지 <br>동의합니다<input type="checkbox" name="agree"> <br>
			<br> <input type="submit" value="전송">
			<!-- submit 하면 test02_ok로 post방식으로 넘어옴 -->
	</form>
	<br>
	<a href="test03.jsp?no=7&name=홍길동">test03 페이지로 이동하기</a>
</body>
</html>
