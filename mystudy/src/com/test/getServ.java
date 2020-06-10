package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getServ")
public class getServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getTest���� get������� �Ѿ��
		
		//���� ������ ���� ����Ʈ Ÿ�� ����
		response.setContentType("text/html;charset=euc-kr");
		
		//1 ��û �Ķ���� �о���� (get�̶� �ѱ� ���ڵ� ����)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2 dbó�� => ������ �ʿ� ����
		
		//3 ������
		//��� ��Ʈ�� ������
		//servlet�� ���� ��ü�� ����
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>get ����</title></head>");
		out.print("<body>");
		out.print("<h1>get - ��û �Ķ���� ��</h1>");
		out.print("<p>���̵�: " + id + "</p>");
		out.print("<p>�н�����: " + pwd + "</p>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
