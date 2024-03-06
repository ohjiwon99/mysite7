package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 필드
	@Autowired
	private UserDao userDao;

	
	/***************************************************************************
	 * 로그인 관련 exeLogin
	 ****************************************************************************/
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin");

		UserVo authUser = userDao.userSelectByIdPw(userVo);

		System.out.println(authUser);
		return authUser;

	}

	/*********************************************************************************
	 * 회원가입 관련 exeJoin
	 **********************************************************************************/
	// 회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("UserService.exeJoin()");

		int count = userDao.userInsert(userVo);

		return count;
	}

	// 회원가입2
	public int exeJoin2(String id, String pw, String name, String gender) {
		System.out.println("UserService.exeJoin2()");

		// map
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("id", id);
		userMap.put("pw", pw);
		userMap.put("name", name);
		userMap.put("gender", gender);

		int count = userDao.userInsert2(userMap);

		return count;
	}
	
	/******************************************************************************************
	 * 수정관련 modify
	 ******************************************************************************************/
	// 회원정보 수정폼
	public UserVo exeMform(int no) {
		System.out.println("UserService.exeMform");
		
		UserVo userVo = userDao.userSelectOne(no);
		
		return userVo;

	}

	// 회원정보수정
	public int exeModify(UserVo userVo) {
		System.out.println("UserService.exeModify()");

		int count = userDao.userModify(userVo);
		return count;
	}
	
	/******************************************************************************************
	 * 삭제 delete
	 ******************************************************************************************/
	// 삭제
	public int exeDelete(int no) {
		System.out.println("UserService.exeDelete()");

		int count = userDao.userDelete(no);

		return count;
	}

}
