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
		//registerPd���� post ��Ŀ��� ����� �ؼ� �Ѿ��
		//����Ʈ Ÿ��
		response.setContentType("text/html;charset=euc-kr");
		//1. �ѱ� ���ڵ�
		request.setCharacterEncoding("euc-kr");
		//�Ķ���� �޾ƿ���
		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");
		
		//dbó��
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));
		
		try {
			int cnt = dao.insertPd(dto);
			
			//3.
			if(cnt>0) {
				System.out.println("��ǰ �߰� ����");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("��ǰ �߰� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//������
		PrintWriter out = response.getWriter();
		
		
	}

}
