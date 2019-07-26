/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.domain;

import cn.wanfangdata.nanfang.oauth.constant.Constants;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Wang
 * Apr 7, 2017
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4896502475476419699L;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdStamp;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdatedStamp;
	
	@Column(length = 255)
	protected String createdBy;
	
	@Column(length = 255)
	protected String updatedBy;
	
	@PrePersist
	protected void prePersist() {
		this.lastUpdatedStamp = new Date(System.currentTimeMillis());
		this.createdStamp = this.lastUpdatedStamp;
		if(StringUtils.isEmpty(this.createdBy)) {
			this.createdBy = Constants.DEFAULT_USER;
		}
	}

	@PreUpdate
	protected void onUpdate() {
		lastUpdatedStamp = new Date(System.currentTimeMillis());
		if(StringUtils.isEmpty(this.updatedBy)) {
			this.updatedBy = Constants.DEFAULT_USER;
		}
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(final String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

}
