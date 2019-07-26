/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.wanfangdata.nanfang.oauth.domain.DomainEntity;
import cn.wanfangdata.nanfang.oauth.domain.SysCollege;
import cn.wanfangdata.nanfang.oauth.domain.BaseEntity;
import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;


/**
 * @author Neil Wang
 * 学院实体对象
 * 2017年9月25日
 */
@Entity
@Table(name = "sys_college")
public class SysCollege extends BaseEntity implements DomainEntity<SysCollege>{
	@Id
	@Column(length = 255)
	private String code;
	
	@Column(length = 255, nullable=false)
	private String name;
	
	@Column(length = 255)
	private String englishName;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable=false)
	private EntityStatus status;
	
    @ManyToOne
    @JoinColumn(name = "school_code", nullable = false)
	private SysSchool school;
	
	SysCollege() {
		
	}
	
	/**
	 * @param code
	 * @param name
	 * @param englishName
	 * @param status
	 */
	public SysCollege(String code, String name, String englishName, EntityStatus status, SysSchool school) {
		super();
		this.code = code;
		this.name = name;
		this.englishName = englishName;
		this.status = status;
		this.school = school;
	}


	/* (non-Javadoc)
	 * @see cn.wanfangdata.nanfang.berry.sharedkernel.domain.DomainEntity#sameIdentityAs(java.lang.Object)
	 */
	@Override
	public boolean sameIdentityAs(SysCollege other) {
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		final SysCollege sysSchool = (SysCollege)obj;
		return sameIdentityAs(sysSchool);
	}
	
	public void changeCollege(String name , String englishName ,EntityStatus status) {
		this.name = name;
		this.englishName = englishName;
		this.status = status;
	}
	
	
	/**
	 * 
	 * @param operator
	 */
	public void createdBy(final String operator) {
		this.createdBy = operator;
	}
	
	/**
	 * 
	 * @param operator
	 */
	public void updatedBy(final String operator) {
		this.updatedBy = operator;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * @return the status
	 */
	public EntityStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysCollege [code=" + code + ", name=" + name + ", englishName=" + englishName + ", status=" + status
				+ "]";
	}

	/**
	 * @return the school
	 */
	public SysSchool getSchool() {
		return school;
	}

}
