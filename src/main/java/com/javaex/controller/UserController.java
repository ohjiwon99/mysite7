package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	/***************************************************************************
	 * 로그인 관련 login,logout
	 ****************************************************************************/

	// 로그인폼
	@RequestMapping(value = "/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {

		System.out.println("UserController.loginform");

		return "/user/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {

		System.out.println("UserController.login");

		UserVo authUser = userService.exeLogin(userVo);

		session.setAttribute("authUser", authUser);

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {

		System.out.println("UserController.logout");

		session.invalidate();

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";

	}

	/*******************************************************************************************
	 * 회원가입 관련 join
	 ********************************************************************************************/

	// 회원가입폼
	@RequestMapping(value = "/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {

		System.out.println("UserController.joinform");

		return "/user/joinForm";
	}

	// 회원가입완료폼
	@RequestMapping(value = "/joinok", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinOk() {

		System.out.println("UserController.joinok");

		return "/user/joinOk";
	}

	// 회원가입
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {

		System.out.println("UserController.join");

		System.out.println(userVo.toString());

		userService.exeJoin(userVo);

		// 성공하면 리스트로 리다이렉트
		return "redirect:/user/joinok";

	}

	// 회원가입2
	@RequestMapping(value = "/join2", method = { RequestMethod.GET, RequestMethod.POST })
	public String join2(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw,
			@RequestParam(value = "name") String name, @RequestParam(value = "gender") String gender) {
		System.out.println("UserController.join2");

		userService.exeJoin2(id, pw, name, gender);

		// 성공하면 리스트로 리다이렉트
		return "redirect:/user/joinok";
	}

	/******************************************************************************************************
	 * 수정관련 modify
	 *****************************************************************************************************/

	// 수정폼
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm() {

		System.out.println("UserController.modifyform");

		return "/user/modifyForm";
	}

	// 회원정보수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo) {

		System.out.println("UserController.modify()");

		userService.exeModify(userVo);

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";
	}

	// 수정폼2
	@RequestMapping(value = "/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(HttpSession session, Model model) {

		System.out.println("UserController.modifyform2");

		UserVo loginUserInfo = (UserVo) session.getAttribute("authUser");
		int userNo = loginUserInfo.getNo();

		// mfVo -->modifyform
		UserVo mfVo = userService.exeMform(userNo);

		model.addAttribute("userVo", mfVo);

		System.out.println(mfVo);

		return "/user/modifyForm";
	}

	// 회원정보수정2
	@RequestMapping(value = "/modify2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify2(@RequestParam(value = "pw") String pw, @RequestParam(value = "name") String name,
			@RequestParam(value = "gender") String gender, HttpSession session) {

		System.out.println("UserController.modify");

		// moVo -->modify
		UserVo moVo = (UserVo) session.getAttribute("authUser");
		int num = moVo.getNo();

		UserVo userVo = new UserVo(num, pw, name, gender);

		System.out.println(userVo);

		userService.exeModify(userVo);

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";
	}

	/**************************************************************************************************
	 * 수정 delete
	 *************************************************************************************************/
	// 회원정보삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("UserController.delete()");

		userService.exeDelete(no);

		// 성공하면 메인으로 리다이렉트
		return "redirect:/main";

	}

}
