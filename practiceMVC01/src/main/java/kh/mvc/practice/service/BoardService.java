package kh.mvc.practice.service;

import java.util.List;

import kh.mvc.practice.vo.BoardVo;

public interface BoardService {

	public List<BoardVo> selectList();
	public BoardVo selectOne(int idx);
	public int boardInsert(BoardVo vo);
	public int boardUpdate(BoardVo vo);
	public int boardDelete(int idx);
	public int boardCount(int idx);
	
	
}
