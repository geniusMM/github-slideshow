<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = "SS_85_ok.jsp" method = "post">
		상호: <input type = "text" name = "sh"><br>
		업종: <label><input type = "radio" name = "what" value = "korean">한식</label>
		<label><input type = "radio" name = "what" value = "western">양식</label>
		<label><input type = "radio" name = "what" value = "jjokbari">일식</label><br>
		지역:<select name = "locate">
			<option value = "서울">서울</option>
			<option value = "경기">경기</option>
			<option value = "인천">인천</option>
		</select><br>
		<input type = "checkbox" value = "park" name = "cb"> 주차 
		<input type = "checkbox" value = "coupon" name = "cb"> 쿠폰 
		<input type = "checkbox" value = "sisik" name = "cb"> 시식평 <br>
		
		위치: <input type = "text" name = "wi"><br>
		<input type = "submit" name = "ok" value = "확인">
	</form>
</body>
</html>