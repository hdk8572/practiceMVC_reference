package kh.mvc.practice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.mvc.practice.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> selectList() {
		return sqlSession.selectList("Board.selectList");
	}
	
	public BoardVo selectOne(int idx) {
		return sqlSession.selectOne("Board.selectOne", idx);
	}
	
	public int boardInsert(BoardVo vo) {
		return sqlSession.insert("Board.boardInsert", vo);
	}
	
	public int boardUpdate(BoardVo vo) {
		return sqlSession.update("Board.boardUpdate", vo);
	}
	
	public int boardDelete(int idx) {
		return sqlSession.delete("Board.boardDelete", idx);
	}
	
	public int boardCount(int idx) {
		return sqlSession.update("Board.boardCount", idx);
	}
	 
}
