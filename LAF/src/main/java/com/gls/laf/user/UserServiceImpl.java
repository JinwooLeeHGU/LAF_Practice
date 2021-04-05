package com.gls.laf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	@Override
	public int insertUser(UserVO vo) {
		return userDAO.insertUser(vo);
	}

}
