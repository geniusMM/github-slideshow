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
		��ȣ: <input type = "text" name = "sh"><br>
		����: <label><input type = "radio" name = "what" value = "korean">�ѽ�</label>
		<label><input type = "radio" name = "what" value = "western">���</label>
		<label><input type = "radio" name = "what" value = "jjokbari">�Ͻ�</label><br>
		����:<select name = "locate">
			<option value = "����">����</option>
			<option value = "���">���</option>
			<option value = "��õ">��õ</option>
		</select><br>
		<input type = "checkbox" value = "park" name = "cb"> ���� 
		<input type = "checkbox" value = "coupon" name = "cb"> ���� 
		<input type = "checkbox" value = "sisik" name = "cb"> �ý��� <br>
		
		��ġ: <input type = "text" name = "wi"><br>
		<input type = "submit" name = "ok" value = "Ȯ��">
	</form>
</body>
</html>