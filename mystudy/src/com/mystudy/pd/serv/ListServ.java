package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

/**
 * Servlet implementation class ListServ
 */
@WebServlet("/ListServ")
public class ListServ extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//registerPd.html ���� [��ǰ���] Ŭ��, get���
		//insertServlet���� ������ ��� get���
		response.setContentType("text/html;charset=euc-kr");
		
		//1 �Ķ���� �޾ƿ���
		//=> ����
		
		//2 db�۾�
		PdDAO dao = new PdDAO();
		List<PdDTO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3 ��� ���
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>��ǰ ��� ������</title></head>");
		out.print("<body><h1>��ǰ���</h1>");
		out.print("<table border = '1' style = 'width: 500px'>");
		out.print("<tr><th>��ȣ</th><th>��ǰ��</th><th>����</th><th>�����</th></tr>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat df = new DecimalFormat("#,###");
		//�ݺ� ����
		for(int i=0 ; i<list.size() ; i++) {
			PdDTO dto = list.get(i);
			
			out.print("<tr>");
			out.print("<td>" + dto.getNo() + "</td>");
			out.print("<td><a href = '/mystudy/detailServ?no="+dto.getNo()+"'>" + dto.getPdName() + "</a></td>");
			out.print("<td style = 'text-align:right'>" + df.format(dto.getPrice()) + "</td>");
			out.print("<td>" + sdf.format(dto.getRegdate()) + "</td>");
			out.print("</tr>");
			
		}
		//�ݺ� ��
		out.print("</table>");
		out.print("<a href = '/mystudy/servTest/registerPd.html'>��ǰ ���</a>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
