package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;

	// 회원가입
	public int exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");

		int count = boardDao.boardInsert(boardVo);

		return count;
	}

	// 회원가입2
	public int exeWrite2(String title, String writer, String content) {
		System.out.println("BoardService.exeWrite2()");

		// map 사용
		Map<String, String> boardMap = new HashMap<String, String>();
		boardMap.put("title", title);
		boardMap.put("writer", writer);
		boardMap.put("content", content);

		int count = boardDao.boardInsert2(boardMap);

		return count;
	}

	// 리스트
	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");

		List<BoardVo> boardList = boardDao.boardSelect();

		return boardList;
	}

	// 수정폼
	public BoardVo exeModifyForm(int bno) {
		System.out.println("PhonebookService.exeModifyForm()");

		// 비지니스로직X

		BoardVo boardVo = boardDao.boardSelectOne(bno);

		return boardVo;

	}

	// 수정폼2
	public Map<String, Object> exeModifyForm2(int bno) {
		System.out.println("BoardService.exeModifyForm2()");

		Map<String, Object> pMap = boardDao.boardSelectOne2(bno);

		return pMap;

	}

	// 수정
	public int exeModify(BoardVo boardVo) {
		System.out.println("BoardService.exeModify()");

		int count = boardDao.boardModify(boardVo);
		return count;
	}

	// 삭제
	public int exeDelete(int bno) {
		System.out.println("BoardService.exeDelete()");

		int count = boardDao.boardDelete(bno);

		return count;
	}

}
