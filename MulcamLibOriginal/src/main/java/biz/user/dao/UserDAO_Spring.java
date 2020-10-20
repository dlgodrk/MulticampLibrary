package biz.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import biz.user.vo.UserVO;

@Component("userspring")
public class UserDAO_Spring implements UserDAO{

	@Autowired
	JdbcTemplate template ;

	@Override
	public UserVO login(String id, String pw) {
		 System.out.println("Spring DAO ...");
		 String sql = "select * from userinfo where userid=? and userpwd = ?";
		 UserVO vo = null;
		 try {
		     vo = template.queryForObject(sql, new Object[] {id,pw} ,new UserRowMapper());
		 }catch (Exception e) {
			 
		 }
		 return vo;
	}

	@Override
	public int addUser(UserVO user) throws Exception {
		String sql = 
		"insert into userinfo (userid, username, userpwd, email, phone,address) "+
				" values (?, ?, ?, ?, ?, ?)";
		
		return template.update(sql,
				               user.getUserid(),
				               user.getUsername(),
				               user.getUserpwd(),
				               user.getEmail(),
				               user.getPhone(),
				               user.getAddress()
				               );
	}

	@Override
	public UserVO getUser(String userid) {
		 String sql = "select * from userinfo where userid = ?";
         UserVO vo = null;
		 try {
         vo = template.queryForObject(sql, 
                                      new Object[] {userid} ,
                                      new UserRowMapper());
         return vo;
		 }catch(Exception e){
			 return null;
		 }
	}

	@Override
	public List<UserVO> getUserList() {
		 System.out.println("Spring DAO ...");
		 String sql = "select * from userinfo order by userdate";
		return template.query(sql, new UserRowMapper());
	}
	
	@Override
	public List<UserVO> getUserListByName() {
		 System.out.println("Spring DAO ...");
		 String sql = "select * from userinfo order by username";
		return template.query(sql, new UserRowMapper());
	}

	@Override
	public List<UserVO> getUserListById() {
		 System.out.println("Spring DAO ...");
		 String sql = "select * from userinfo order by userid";
		return template.query(sql, new UserRowMapper());
	}
	@Override
	public int updateUser(UserVO user) {
		 String sql = "update userinfo set email=?,phone=?,address=? "
		 		+ " where  userid  = ? ";

		 return template.update(sql,
				                user.getEmail(),
				                user.getPhone(),
				                user.getAddress(),
	                            user.getUserid()
	               );	
	}

	@Override
	public int removeUser(String userid) {
		 String sql = "delete from userinfo where  userid  = ? ";
		return template.update(sql,userid);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "select * from userinfo where upper("+ condition+") like  '%'||?||'%'";
		
		System.out.println(sql);
		
		List<UserVO> list =template.query(sql,
	              new Object[]{keyword.toUpperCase()},
	              new UserRowMapper());
		
		System.out.println("----- "+list);
		return list;
	}

	

}


class UserRowMapper implements RowMapper<UserVO>{
	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO vo = new UserVO();
		vo.setAddress(rs.getString("address"));
		vo.setEmail(rs.getString("email"));
		vo.setPhone(rs.getString("phone"));
		vo.setUserid(rs.getString("userid"));
		vo.setUsername(rs.getString("username"));
		vo.setUserpwd(rs.getString("userpwd"));
		vo.setUserdate(rs.getDate("userdate").toString());
		return vo;
	}
}








