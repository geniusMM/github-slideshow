package com.mystudy.pd.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;


//@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//detailServlet에서 삭제버튼 누르고 get방식으로 넘어옴
		//파라미터가 no
		//http://localhost:9090/mystudy/deleteServlet?no=3
		response.setContentType("/text/html;charset=euc-kr");
		
		//1 파라미터 받기
		String no = request.getParameter("no"); 
		
		//2 db처리
		PdDAO dao = new PdDAO();
		try {
			int cnt = dao.deletePd(Integer.parseInt(no));
			
			//3 결과출력
			if(cnt > 0) {
				System.out.println("삭제 성공!");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("삭제 실패!");
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
