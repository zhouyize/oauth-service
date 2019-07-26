/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.wanfangdata.nanfang.oauth.enums.Gender;
import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;
import cn.wanfangdata.nanfang.oauth.enums.UserType;


/**
 * @author Neil Wang
 * 2017年10月9日
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity{
	@Id
	@Column(length = 50)
	private String account;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private UserType userType;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable=false)
	private EntityStatus status;
	
	@Column(length = 50)
	private String fullName;
	
	@Column(length = 255)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 20)
	private String mobile;
	
	@Column(length = 255)
	private String collegeCode;
	
	@Column(length = 255)
	private String collegeName;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	User() {
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}

	public String getAccount() {
		return account;
	}

	public UserType getUserType() {
		return userType;
	}

	public EntityStatus getStatus() {
		return status;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	
}
