package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;


//@WebServlet("/EditOkServlet")
public class EditOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//editservlet에서 post 넘어옴
		response.setContentType("text/html;charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		String no = request.getParameter("no");
		String pdName = request.getParameter("pdName");
		String pdPrice = request.getParameter("pdPrice");
		

		//db
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		dto.setNo(Integer.parseInt(no));
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(pdPrice));
		
		try {
			int cnt = dao.updatePd(dto);
			
			if(cnt>0){
				System.out.println("상품 수정 성공");
				response.sendRedirect("/mystudy/ListServ");
			}else {
			System.out.println("상품 수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}










