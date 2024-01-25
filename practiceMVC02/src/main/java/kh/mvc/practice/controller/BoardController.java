package kh.mvc.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.mvc.practice.service.BoardService;
import kh.mvc.practice.vo.BoardVo;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/boardList.do")
	public List<BoardVo> boardList() {
		List<BoardVo> list = boardService.selectList();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/boardInsert.do")
	public void boardInsert(BoardVo vo) {
		boardService.boardInsert(vo);
	}
	
	@ResponseBody
	@RequestMapping("/boardDelete.do")
	public void boardDelete(@RequestParam("idx") int idx) {
		boardService.boardDelete(idx);
	}
	
	@ResponseBody
	@RequestMapping("/boardUpdate.do")
	public void boardUpdate(BoardVo vo) {
		boardService.boardUpdate(vo);
	}
	
	@ResponseBody
	@RequestMapping("boardContent.do")
	public BoardVo boardContent(int idx) {
		BoardVo vo = boardService.selectOne(idx);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/boardCount.do")
	public BoardVo boardCount(int idx) {
		boardService.boardCount(idx);
		BoardVo vo = boardService.selectOne(idx);
		return vo;
	}
	
}
