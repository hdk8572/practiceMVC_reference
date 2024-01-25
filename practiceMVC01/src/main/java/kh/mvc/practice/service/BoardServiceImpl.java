package kh.mvc.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.mvc.practice.dao.BoardDao;
import kh.mvc.practice.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> selectList() {
		return boardDao.selectList();
	}
	
	@Override
	public BoardVo selectOne(int idx) {
		return boardDao.selectOne(idx);
	}

	@Override
	public int boardInsert(BoardVo vo) {
		return boardDao.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVo vo) {
		return boardDao.boardUpdate(vo);
	}

	@Override
	public int boardDelete(int idx) {
		return boardDao.boardDelete(idx);
	}

	@Override
	public int boardCount(int idx) {
		return boardDao.boardCount(idx);
	}
}
