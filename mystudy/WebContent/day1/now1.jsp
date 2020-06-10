<%@page contentType="text/html;charset=euc-kr"%>
<%@page import = "java.util.Date"%>
<!--page지시자(디렉티브)-페이지에 대한 정보 설정-->

<%
	//스크립트릿 - jsp 코드를 넣는 곳
	Date d = new Date();
	String str = d.toLocaleString();

	out.print("<h1>현재 날짜: " + str + "</h1>");//브라우저에 출력하라는 명령
	//out - 내장 객체(별도의 선언이나 객체 생성과정 없이 사용 가능)

	//한줄 주석
	/*여러줄
	주석*/
%>

<!DOCTYPE HTML>
<HTML>
 <HEAD>
  <TITLE> now1.jsp </TITLE>
 </HEAD>
<script type = "text/javascript">
	//자바 스크립트 영역
</script>
 <BODY>
 <!-- html 영역-->
 <h2>★HI LITE★ 집가고싶어ㅠㅠㅠ집에 보내줘ㅠㅠ</h2>
 <p>ㅇㅇㅇ <%=str%> 입니다.</p>
 <!-- 표현식 - out.print()와 동일 (=은 출력하라는 뜻)-->

 <%-- jps 주석 --%>
 <!-- localhost:9090/testsite/now1.jsp -->
 </BODY>
</HTML>
