package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.BoardMapper;

public class BoardMybatisDao {
	private Class<BoardMapper> cls = BoardMapper.class;
	private Map<String, Object> map = new HashMap<>();
	public int maxnum() {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).maxnum();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}
	public boolean insert(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).insert(board);
			return cnt > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}
	public int boardCount
	           (String boardid, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("column", column);
			map.put("find", find);
			return session.getMapper(cls).boardCount(map); //게시판 종류별 등록된 게시물 건수
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			MybatisConnection.close(session);
		}
		return 0;
	}	
	public List<Board> list (int pageInt, int limit, 
			String boardid, String column, String find) {
		//pageInt : 조회하고자 하는 페이지번호. 현재페이지
		//limit : 페이지당 보여지는 게시물 건수 
		//boardid : 게시판 종류. 1:공지사항, 2:자유게시판, 3:QnA
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid",boardid );
			map.put("start",(pageInt-1)*limit + 1 );
			map.put("end",pageInt*limit );
			map.put("column", column);
			map.put("find", find);
			return session.getMapper(cls).list(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);	
		}
		return null;
	}
	public Board selectOne(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}		
		return null;
	}
	//조회수 1 증가
	public void readcntAdd(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).readcntAdd(num);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}
	public boolean update(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt =session.getMapper(cls).update(board); 
			return cnt > 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}		
		return false;
	}
	public boolean delete(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt =session.getMapper(cls).delete(num); 
			return cnt > 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}
	public void grpStepAdd(int grp, int grpstep) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).grpStepAdd(grp,grpstep); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}
}