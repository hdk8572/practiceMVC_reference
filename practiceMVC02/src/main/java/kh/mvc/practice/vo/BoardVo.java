package kh.mvc.practice.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardVo {

	private int idx;
	private String title;
	private String content;
	private String writer;
	private String indate;
	private int count;
	
}
