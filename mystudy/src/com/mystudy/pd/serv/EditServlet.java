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
 		//detailServlet���� ���� Ŭ���ϰ� doGet���� �Ѿ��
 		response.setContentType("text/html;charset=euc-kr");
 		
 		//�Ķ���� �޾ƿ���
 		String no = request.getParameter("no");
 		
 		PdDAO dao = new PdDAO();
 		PdDTO dto = new PdDTO();
 		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
 		
 		//��� ���
 		PrintWriter out = response.getWriter();
 		out.print("<h1>��ǰ ����!!</h1>");
 		out.print("<form name='frmedit' method=post action=/mystudy/editOk?no="+no+">");
 		out.print("<input type = 'hidden' name = 'no' value = '" + no + "'><br>");
 		out.print("��ǰ��<input type = 'text' name = 'pdName' value = '" + dto.getPdName() + "'><br>");
 		out.print("����<input type = 'text' name = 'pdPrice' value = '" + dto.getPrice() + "'><br>");
 		out.print("<input type='submit' value='����'>");
 		out.print("<input type='reset' value='���'>");
 		out.print("</form>");
 		out.print("<hr>"); 
 		out.print("<a href='/mystudy/ListServ'>��ǰ ���</a>"); 
 		
 		
 		
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
