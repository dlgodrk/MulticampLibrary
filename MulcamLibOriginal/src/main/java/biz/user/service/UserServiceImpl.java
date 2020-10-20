package biz.user.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import biz.user.dao.UserDAO;
import biz.user.vo.UserVO;

@Service("userservice")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO dao;
	
	public UserServiceImpl() {}
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	@Override
	public UserVO login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	public int addUser(UserVO user) throws Exception {
		return dao.addUser(user);
	}

	@Override
	public UserVO getUser(String userid) {
		return dao.getUser(userid);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public int removeUser(String userid) {
		return dao.removeUser(userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		return dao.searchUser(condition, keyword);
	}
	@Override
	public List<UserVO> getUserListByName() {
		return dao.getUserListByName();
	}
	@Override
	public List<UserVO> getUserListById() {
		return dao.getUserListById();
	}

}
