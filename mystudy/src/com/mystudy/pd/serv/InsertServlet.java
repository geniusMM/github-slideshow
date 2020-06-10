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


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//registerPd에서 post 방식에서 서브밋 해서 넘어옴
		//콘텐트 타입
		response.setContentType("text/html;charset=euc-kr");
		//1. 한글 인코딩
		request.setCharacterEncoding("euc-kr");
		//파라미터 받아오기
		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");
		
		//db처리
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));
		
		try {
			int cnt = dao.insertPd(dto);
			
			//3.
			if(cnt>0) {
				System.out.println("상품 추가 성공");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("상품 추가 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//결과출력
		PrintWriter out = response.getWriter();
		
		
	}

}
