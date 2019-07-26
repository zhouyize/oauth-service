package cn.wanfangdata.nanfang.oauth.rest.dto;

import java.util.List;

import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;
import cn.wanfangdata.nanfang.oauth.enums.UserType;


public class UserDTO {

	private String account;

	private String name;

	private String mobile;

	private String email;

	private EntityStatus status;

	private UserType userType;
	
	public UserDTO(String account, String name, String mobile, String email, EntityStatus status, UserType userType) {
		super();
		this.account = account;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.status = status;
		this.userType = userType;
	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return mobile;
	}

	public void setPhone(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EntityStatus getStatus() {
		return status;
	}

	public void setStatus(EntityStatus status) {
		this.status = status;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
}
