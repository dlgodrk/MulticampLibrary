package biz.user.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	private String userid;
	private String username;
	private String userpwd;
	private String email;
	private String phone;
	private String address;
	private String userdate;
	
	public UserVO() {	}

	public UserVO(String userid, String username, String userpwd, String email, String phone, String address,String userdate) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userdate = userdate;
	}

	public String getUserdate() {
		return userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", userdate=" + userdate + "]";
	}

	

	
}
/*
 * userid varchar2(15) primary key, username varchar2(20), userpwd varchar2(10),
 * email varchar2(50), phone varchar2(15), address varchar2(100)
 */