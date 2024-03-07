package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	// 필드
	@Autowired
	private GuestbookDao guestbookDao;

	//리스트 exeList --> 전체 연락처 리스트를 조회하는 기능
	public List<GuestbookVo> exeList() {
		System.out.println("GuestbookService.exeList()");

		List<GuestbookVo> guestbookList = guestbookDao.guestbookSelect();

		return guestbookList;
	}

	// 수정폼 -->exeDeleteForm
	public GuestbookVo exeDeleteForm(int no) {
		System.out.println("GuestbookService.exeDeleteForm()");

		// 비지니스로직X

		GuestbookVo guestbookVo = guestbookDao.guestbookSelectOne(no);

		return guestbookVo;

	}

	// 수정폼2 -->exeDeleteForm2
	public Map<String, Object> exeModifyForm2(int gno) {
		System.out.println("GuestbookService.exeModifyForm2()");

		Map<String, Object> pMap = guestbookDao.guestbookSelectOne2(gno);

		return pMap;

	}

	//삭제 exeDelete --> 메서드는 지정된 번호의 연락처를 삭제하는 기능
	public int exeDelete(int no, String password) {
		System.out.println("GuestbookService.exeDelete()");

		// map 
		Map<String, String> gMap = new HashMap<String, String>();
		gMap.put("no", String.valueOf(no));
		gMap.put("password", password);

		int count = guestbookDao.guestbookDelete(gMap);

		return count;
	}

	// 등록  exeWrite --> 전화번호부에 새로운 연락처를 등록하는 기능
	public int exeWrite(GuestbookVo guestbookVo) {
		System.out.println("BoardService.exeWrite()");

		int count = guestbookDao.guestbookInsert(guestbookVo);

		return count;
	}

}