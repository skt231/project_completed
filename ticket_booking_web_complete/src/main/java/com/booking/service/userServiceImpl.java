package com.booking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.userController;
import com.booking.dao.userDao;
import com.booking.dto.userDto;

@Service
public class userServiceImpl implements userService {
	private static final Logger logger = LoggerFactory.getLogger(userController.class);
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addUser(userDto user) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		dao.createUser(user);

	}

	@Override
	public userDto getUserById(int id) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		return dao.readUserById(id);
	}

	@Override
	public void updateUser(userDto user) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		dao.deleteUser(id);
	}

	@Override
	public List<userDto> getAllUsers() throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		List<userDto> dtos = dao.listAll();
		System.out.println(dtos);
		return dtos;
	}

	@Override
	public userDto loginUser(String username, String password) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		userDto user = dao.getUserByUsername(username);

		if (user != null) {
			if (username.equals(user.getUsername())) {
				if (password.equals(user.getPassword())) {
					// 비밀번호가 일치하면 사용자 정보 반환
					return user;
				}
			}
		}

		// 사용자가 없거나 비밀번호가 일치하지 않을 경우 null 반환
		return null;
	}

	@Override
	public userDto getUserByUsername(String username) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		return dao.getUserByUsername(username);
	}

	@Override
	public void getAuthority(String username,String authority) throws Exception {
		userDao dao = sqlSession.getMapper(userDao.class);
		  logger.info("getAuthority - username: {}, authority: {}", username, authority);
		dao.getAuthority(username,authority);
	}

}
