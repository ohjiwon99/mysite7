package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller // 안될때 maven /update project/Source
@RequestMapping(value = "/guestbook")
public class GuestbookController {

	// 필드
	@Autowired
	private GuestbookService guestbookService;
	// 생성자

	// 메소드gs

	// 메소드 일반

	// 등록 리다이렉트 메인폼

	/************************************************************
	 * list --> list 메서드를 통해 전체리스트를 조회 //localhost:8881/guestbook(여기까지
	 * 공통주소)/guest/alist
	 **********************************************************/
	@RequestMapping(value = "/alist", method = { RequestMethod.GET, RequestMethod.POST })
	public String aList(Model model) {
		System.out.println("GuestbookController.alist");

		// 자동연결@Autowired
		List<GuestbookVo> guestbookList = guestbookService.exeList();

		model.addAttribute("gList", guestbookList);

		return "/guestbook/addList";
	}
	/*	@RequestMapping(value = "/addlistform", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestbookController.addlistform");

		// 자동연결@Autowired
		List<GuestbookVo> guestbookList = guestbookService.exeList();

		model.addAttribute("gList", guestbookList);

		return "/guestbook/addList";
	}*/

	// 게스트북삭제폼
	@RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("GuestbookController.deleteform");

		GuestbookVo guestbookVo = guestbookService.exeDeleteForm(no);

		model.addAttribute("gVo", guestbookVo);

		return "/guestbook/deleteForm";
	}

	// 게스트북삭제폼2
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/deleteform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@RequestParam(value = "bno") int bno, Model model) {
		System.out.println("GuestbookController.deleteform2()");
		System.out.println(bno);

		Map<String, Object> pMap = guestbookService.exeModifyForm2(bno);
		model.addAttribute("pMap", pMap);

		return "/board/modifyForm2";

	}

	
	
	
	
	
	
	
	
	
	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no, @RequestParam(value = "password") String password) {

		System.out.println("GuestbookController.delete()");

		// System.out.println(personId);

		guestbookService.exeDelete(no, password);

		// 리스트로 리다이렉트
		return "redirect:/guestbook/addlistform";

	}

	// 게스트북등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.write");

		System.out.println(guestbookVo.toString());

		// 서비스를 메모리에 올리고
		// 서비스의 메소드 사용
		guestbookService.exeWrite(guestbookVo);

		// 리스트로 리다이렉트
		return "redirect:/guestbook/addlistform";

	}

}
