/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import cn.wanfangdata.nanfang.oauth.domain.BaseEntity;
import cn.wanfangdata.nanfang.oauth.domain.DomainEntity;
import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;

/**
 * @author Neil Wang
 * 学校实体对象
 * 2017年9月25日
 */
@Entity
@Table(name = "sys_school")
public class SysSchool extends BaseEntity implements DomainEntity<SysSchool>{
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
	
    @OneToMany(mappedBy = "school")
    @OrderBy("name ASC")
	private List<SysCollege> colleges;
	
	SysSchool() {
		
	}

	/**
	 * @param code
	 * @param name
	 * @param englishName
	 * @param status
	 */
	public SysSchool(String code, String name, String englishName, EntityStatus status) {
		super();
		this.code = code;
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
	 * Change the name/englishname/status
	 * @param name
	 * @param englishName
	 * @param status
	 */
	public void changeSchoolInfo(String name, String englishName, EntityStatus status) {
		this.name = name;
		this.englishName = englishName;
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see cn.wanfangdata.nanfang.berry.sharedkernel.domain.DomainEntity#sameIdentityAs(java.lang.Object)
	 */
	@Override
	public boolean sameIdentityAs(SysSchool other) {
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
		final SysSchool sysSchool = (SysSchool)obj;
		return sameIdentityAs(sysSchool);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysSchool [code=" + code + ", name=" + name + ", englishName=" + englishName + ", status=" + status
				+ "]";
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

	/**
	 * @return the colleges
	 */
	public List<SysCollege> getColleges() {
		return colleges;
	}

}
