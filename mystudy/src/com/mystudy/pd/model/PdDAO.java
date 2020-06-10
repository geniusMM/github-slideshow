package com.mystudy.pd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mystydy.db.ConnectionPoolMgr;

public class PdDAO {
	private ConnectionPoolMgr pool;
	
	public PdDAO() {
		pool = new ConnectionPoolMgr();
	}
	
	public int insertPd(PdDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			//1,2
			con = pool.getConnection();
			
			//3
			String sql = "insert into pd(no, pdname, price)" + 
					" values(pd_seq.nextval, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			
			//4
			int cnt = ps.executeUpdate();
			System.out.println("상품 등록결과 cnt = " + cnt + ", 매개변수 dto = " + dto);
			return cnt;
			
		}finally {
			try {
				pool.dbClose(ps, con);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<PdDTO> selectAll() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<PdDTO> list = new ArrayList<PdDTO>();//다형성 이용
		
		try {
			//1, 2
			con = pool.getConnection();
			
			String sql = "select * from pd order by no desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String pdname = rs.getString("pdname");
				int price = rs.getInt("price");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				PdDTO dto = new PdDTO(no, pdname, price, regdate);
				list.add(dto);
			}
			System.out.println("상품 목록 결과 list.size = "+list.size());
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}//selectAll
	
	
	public PdDTO selectByNo(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PdDTO dto = new PdDTO();
		try {
			//1,2
			con = pool.getConnection();
			
			//3
			String sql = "select * from pd where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4
			rs = ps.executeQuery();
			if(rs.next()) {
				String pdName = rs.getString("pdname");
				int price = rs.getInt("price");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				dto.setNo(no);
				dto.setPdName(pdName);
				dto.setPrice(price);
				dto.setRegdate(regdate);
			
			}
			System.out.println("상세보기 결과 dto = " + dto + ", 매개변수 no =" + no);
			
			return dto;
		}finally {
			pool.dbClose(rs, ps, con);
		}
		
	}//selectByNo
	
	
	public int updatePd(PdDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "update pd" + 
					" set pdname = ?, price = ?" + 
					" where no = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getNo());
			
			int cnt = ps.executeUpdate();
			System.out.println("상품 수정 결과, cnt = " + cnt + ", 매개변수 =" + dto);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
		
	}
	
	public int deletePd(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "delete from pd" + 
					" where no = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			int cnt = ps.executeUpdate();
			System.out.println("삭제결과 :"+cnt + "삭제 대상 no: " + no);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
}












