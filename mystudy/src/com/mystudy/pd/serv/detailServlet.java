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
		//ListServlet 에서 상품명 클릭해서 get으로 넘어옴
		//한글인코딩
		response.setContentType("text/html;charset = euc-kr");
		//1. 파라미터 세팅
		//http://localhost:9090/mystudy/detailServlet?no=5
		String no = request.getParameter("no");
		
		//2. db처리
		PdDAO dao = new PdDAO();
		PdDTO dto = null;
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		DecimalFormat df = new DecimalFormat("#,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//3. 출력
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>제품 상세 정보</title>");
		out.print("<script type = 'text/javascript'>");
		out.print("function pdDel(){");
		out.print("	if(confirm('삭제하시겠습니까?')){");		   
		out.print("		location.href = '/mystudy/delServ?no="
					+ no +"';");
		out.print("	}");
		out.print("}");
		out.print("</script>");
		out.print("</head>");
		out.print("<body><h1>상품 상세보기</h1>");
		out.print("<p>번호: " + no + "</p>");
		out.print("<p>상품명: " + dto.getPdName()+ "</p>");
		out.print("<p>가격: " + df.format(dto.getPrice())+ "</p>");
		out.print("<p>등록일: " + sdf.format(dto.getRegdate()) + "</p>");
		out.print("<a href = '/mystudy/ListServlet'>목록</a> |");
		out.print("<a href = '/mystudy/editServlet?no=" + no + "'>수정</a> |");
		out.print("<a href = '#' onclick = 'pdDel()'>삭제</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
