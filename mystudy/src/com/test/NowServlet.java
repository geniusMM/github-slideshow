package com.test;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/NowServ")
public class NowServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
			throws ServletException, IOException{

		response.setContentType("text/html;charset=euc-kr");

		Date d = new Date();
		String s = d.toLocaleString();

		PrintWriter out = response.getWriter();
		out.print("<html><head><title>���� ����</title></head>");
		out.print("<body>");
		out.print("<h1>���� ���� - " + s + "</h1>");
		out.print("<p>���� ��¥ - " + d + "</p>");
		out.print("</body>");
		out.print("</html>");

		out.close();
	}
}
