<%@page contentType="text/html;charset=euc-kr"%>

<%!
	//����� - ��������� �޼��� ����
	//	  => �������� ��ȯ�Ǹ� Ŭ���� ������ ��
	//�������
	String id = "hong";

	//�޼���
	public int add(int a, int b){
		return a+b;
	}
%>
<!DOCTYPE HTML>
<HTML>
 <HEAD>
  <TITLE> test01.jsp </TITLE>
 </HEAD>

 <BODY>
  <%
  //��ũ��Ʈ�� - �ڹ� �ڵ� �ۼ�
  //=> �������� ��ȯ�Ǹ� service()�޼��� ������ ��
  //���⼭ �����ϴ� ������ ����������
  int num1 = 10, num2 = 20;
  String name = "��Ŭ������";

  int result = add(num1, num2);
  out.println("������� id = " + id + "<br>");
  out.println("�������� name = " + name + "<br>");
  out.println("�� ���� ��: " + result + "<br>");

  id = "kim";
  name = " ȫ�浿";
  %>

  <h1> �� ���� ��</h1>
  <p> id : <%=id%></p>
  <p> nm: <%=name%></p>
 </BODY>
</HTML>
