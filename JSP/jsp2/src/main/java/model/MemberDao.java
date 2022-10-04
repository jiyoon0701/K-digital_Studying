package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	// mem 내용을 db에 insert
	public boolean insert(Member mem) {
		// 1. Connection 객체
		Connection conn = DBConnection.getConnection();
		// 2. Statement 객체
		/*
		 * PreparedStatement : Statement의 하위 인터페이스 미리 sql 문장을 db에 전송 파라미터로 값을 전달 방식
		 */
		PreparedStatement pstmt = null;
		String sql = "insert into member" + " (id,pass,name,gender,tel,email,picture)" + " values (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId()); // 1 : 첫번째 ?
			pstmt.setString(2, mem.getPass()); // 2 : 두번째 ?
			pstmt.setString(3, mem.getName());
			pstmt.setInt(4, mem.getGender());
			pstmt.setString(5, mem.getTel());
			pstmt.setString(6, mem.getEmail());
			pstmt.setString(7, mem.getPicture());
			// executeUpdate() : select 외에 사용되는 메서드
			// 변경되는 레코드 갯수 리턴

			// sql문장실행. 회원정보가 db insert됨
			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// return구문 실행되도 실행됨.
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}

	public Member selectOne(String id) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * From member where id= ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// ResultSet executeQuery : select 구문 실행
			rs = pstmt.executeQuery();
			if (rs.next()) { // id에 해당하는 레코드 존재?
				Member mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getInt("gender"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setPicture(rs.getString("picture"));
				return mem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}

	public boolean update(Member member) {
		Connection conn = DBConnection.getConnection();
		String sql = "update member set name = ?, gender = ?, tel = ?, email = ?, picture = ? where id= ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getGender());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPicture());
			pstmt.setString(6, member.getId());

			int cnt = 0;
			cnt = pstmt.executeUpdate();
	
			if (cnt > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// return구문 실행되도 실행됨.
			DBConnection.close(conn, pstmt, null);
		}
		return false;
	}
	
	public boolean delete(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from member where id=?");
			pstmt.setString(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn,pstmt,null);
		}
		return false;
	}
	
	public List<Member> list() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getInt("gender"));
				m.setTel(rs.getString("tel"));
				m.setEmail(rs.getString("email"));
				m.setPicture(rs.getString("picture"));
				list.add(m); //list에 db의 정보 를 저장한 Member 객체 추가
			}
			return list; //member 테이블의 모든 정보를 저장
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn,pstmt,rs);
		}
		return null;
	}
	
	public boolean update(String id, String chgpass) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update member set  pass = ? where id=?");
			pstmt.setString(1, chgpass);
			pstmt.setString(2, id);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn,pstmt,null);
		}
		return false;
	}
}
