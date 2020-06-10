package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;


//@WebServlet("/detailServlet")
public class detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ListServlet ���� ��ǰ�� Ŭ���ؼ� get���� �Ѿ��
		//�ѱ����ڵ�
		response.setContentType("text/html;charset = euc-kr");
		//1. �Ķ���� ����
		//http://localhost:9090/mystudy/detailServlet?no=5
		String no = request.getParameter("no");
		
		//2. dbó��
		PdDAO dao = new PdDAO();
		PdDTO dto = null;
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		DecimalFormat df = new DecimalFormat("#,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//3. ���
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>��ǰ �� ����</title>");
		out.print("<script type = 'text/javascript'>");
		out.print("function pdDel(){");
		out.print("	if(confirm('�����Ͻðڽ��ϱ�?')){");		   
		out.print("		location.href = '/mystudy/delServ?no="
					+ no +"';");
		out.print("	}");
		out.print("}");
		out.print("</script>");
		out.print("</head>");
		out.print("<body><h1>��ǰ �󼼺���</h1>");
		out.print("<p>��ȣ: " + no + "</p>");
		out.print("<p>��ǰ��: " + dto.getPdName()+ "</p>");
		out.print("<p>����: " + df.format(dto.getPrice())+ "</p>");
		out.print("<p>�����: " + sdf.format(dto.getRegdate()) + "</p>");
		out.print("<a href = '/mystudy/ListServlet'>���</a> |");
		out.print("<a href = '/mystudy/editServlet?no=" + no + "'>����</a> |");
		out.print("<a href = '#' onclick = 'pdDel()'>����</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
