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
		//detailServlet���� ������ư ������ get������� �Ѿ��
		//�Ķ���Ͱ� no
		//http://localhost:9090/mystudy/deleteServlet?no=3
		response.setContentType("/text/html;charset=euc-kr");
		
		//1 �Ķ���� �ޱ�
		String no = request.getParameter("no"); 
		
		//2 dbó��
		PdDAO dao = new PdDAO();
		try {
			int cnt = dao.deletePd(Integer.parseInt(no));
			
			//3 ������
			if(cnt > 0) {
				System.out.println("���� ����!");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("���� ����!");
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
