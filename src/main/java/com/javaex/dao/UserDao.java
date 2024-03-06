package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	/***************************************************************************
	 * 로그인 관련 userSelectByIdPw
	 ****************************************************************************/
	public UserVo userSelectByIdPw(UserVo userVo) {

		System.out.println("UserDao.userSelectByIdPw");

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);

		System.out.println(authUser);

		return authUser;
		//return sqlSession.selectOne("user.selectByIdPw", userVo);
	}

	/*********************************************************************************
	 * 회원가입 관련 userInsert, userInsert2
	 **********************************************************************************/
	// 회원정보등록등록
	public int userInsert(UserVo userVo) {

		int count = sqlSession.insert("user.userInsert", userVo);

		return count;
		//return sqlSession.insert("user.userInsert", userVo);
	}

	// 회원정보등록2
	public int userInsert2(Map<String, String> pMap) {
		System.out.println("userDao.userInsert2()");
		System.out.println(pMap);

		int count = sqlSession.insert("user.userInsert2", pMap);

		return count;
		//return sqlSession.insert("user.userInsert2", pMap);
	}
	
	/******************************************************************************************
	 * 수정관련 userSelectOne, usermodify
	 ******************************************************************************************/

	// 회원정보 수정폼
	public UserVo userSelectOne(int no) {
		System.out.println("UserDao.userSelectOne");

		UserVo userVo = sqlSession.selectOne("user.selectOne", no);
		System.out.println(userVo);
		return userVo;
	}

	// 회원정보수정
	public int userModify(UserVo userVo) {
		System.out.println("userDao.userModify()");

		int count = sqlSession.update("user.userUpdate", userVo);

		return count;
		//return sqlSession.update("user.userUpdate", userVo);
	}
	
	/******************************************************************************************
	 * 삭제 userDelete
	 ******************************************************************************************/

	// 삭제
	public int userDelete(int no) {

		int count = sqlSession.delete("user.delete", no);

		return count;
		//return sqlSession.delete("user.delete", no);
	}

}
