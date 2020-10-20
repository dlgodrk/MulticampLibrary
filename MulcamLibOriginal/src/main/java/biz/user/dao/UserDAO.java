package biz.user.dao;

import java.util.List;

import biz.user.vo.UserVO;

public interface UserDAO {
	   UserVO login(String id,String pw);
	   int addUser(UserVO user) throws Exception;
	   UserVO getUser(String userid);
	   List<UserVO> getUserList();
	   List<UserVO> getUserListByName();
	   List<UserVO> getUserListById();
	   int updateUser(UserVO user) ;
	   int removeUser(String userid);
	   List<UserVO> searchUser(String condition,String keyword);
}