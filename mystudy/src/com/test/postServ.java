package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/postServ")
public class postServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//postTest에서 submit 클릭, post 방식으로 넘어옴
		//콘텐트타입 지정
		response.setContentType("text/html;charset=euc-kr");
		
		//한글 인코딩
		request.setCharacterEncoding("euc-kr");
		
		//파라미터 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2 db처리 => 지금은 필요없음
		
		//3 출력
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>post 서블릿</title></head>");
		out.print("<body>");
		out.print("<h1>post - 요청 파라미터 값</h1>");
		out.print("<p>아이디: " + id + "</p>");
		out.print("<p>패스워드: " + pwd + "</p>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
