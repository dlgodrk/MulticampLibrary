package biz.user.service;

import java.util.List;

import biz.user.vo.UserVO;

public interface UserService {
	   UserVO login(String id,String pw);
	   int addUser(UserVO user) throws Exception;
	   UserVO getUser(String userid);
	   List<UserVO> getUserList();
	   int updateUser(UserVO user);
	   int removeUser(String userid);
	   List<UserVO> searchUser(String condition,String keyword);
	   List<UserVO> getUserListByName();
	   List<UserVO> getUserListById();
}