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


//@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//detailServlet에서 수정 클릭하고 doGet으로 넘어옴
 		response.setContentType("text/html;charset=euc-kr");
 		
 		//파라미터 받아오기
 		String no = request.getParameter("no");
 		
 		PdDAO dao = new PdDAO();
 		PdDTO dto = new PdDTO();
 		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
 		
 		//결과 출력
 		PrintWriter out = response.getWriter();
 		out.print("<h1>상품 수정!!</h1>");
 		out.print("<form name='frmedit' method=post action=/mystudy/editOk?no="+no+">");
 		out.print("<input type = 'hidden' name = 'no' value = '" + no + "'><br>");
 		out.print("상품명<input type = 'text' name = 'pdName' value = '" + dto.getPdName() + "'><br>");
 		out.print("가격<input type = 'text' name = 'pdPrice' value = '" + dto.getPrice() + "'><br>");
 		out.print("<input type='submit' value='수정'>");
 		out.print("<input type='reset' value='취소'>");
 		out.print("</form>");
 		out.print("<hr>"); 
 		out.print("<a href='/mystudy/ListServ'>상품 목록</a>"); 
 		
 		
 		
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
