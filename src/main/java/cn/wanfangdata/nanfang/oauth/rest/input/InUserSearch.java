package cn.wanfangdata.nanfang.oauth.rest.input;

import javax.validation.constraints.Size;

import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;
import cn.wanfangdata.nanfang.oauth.enums.UserType;



public class InUserSearch {
	@Size(max=50)
	private String fullName;
	@Size(max=50)
	private String account;
	private EntityStatus status;
	private UserType userType;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
