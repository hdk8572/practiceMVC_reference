package kh.mvc.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kh.mvc.practice.service.BoardService;
import kh.mvc.practice.vo.BoardVo;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("boardList.do")
	public String selectList(Model model) {
		List<BoardVo> list = boardService.selectList();
		model.addAttribute("list", list);
		return "boardList";
	}
	
	@GetMapping("boardContent.do/{idx}")
	public String boardContent(@PathVariable("idx") int idx, Model model) {
		BoardVo vo = boardService.selectOne(idx);
		boardService.boardCount(idx);
		model.addAttribute("vo", vo);
		return "boardContent";
	}
	
	@GetMapping("boardForm.do")
	public String boardForm() {
		return "boardForm";
	}
	
	@PostMapping("boardInsert.do")
	public String boardInsert(BoardVo vo) {
		boardService.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		BoardVo vo = boardService.selectOne(idx);
		model.addAttribute("vo", vo);
		return "boardUpdate";
	}
	
	@PostMapping("boardUpdate.do")
	public String boardUpdate(BoardVo vo) {
		boardService.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		boardService.boardDelete(idx);
		return "redirect:/boardList.do";
	}
}
