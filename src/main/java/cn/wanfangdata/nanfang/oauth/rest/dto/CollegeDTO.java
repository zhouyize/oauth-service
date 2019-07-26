package cn.wanfangdata.nanfang.oauth.rest.dto;

import java.util.Date;

import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;

public class CollegeDTO {
	private String code;
	private String name;
	private String englishName;
	private EntityStatus status;
	private String schoolCode;
	
	public CollegeDTO(String code ,String name ,String englishName ,EntityStatus status ,String schoolCode ) {
		super();
		this.code = code;
		this.englishName = englishName;
		this.name = name;
		this.status = status;
		this.schoolCode = schoolCode;
				
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public EntityStatus getStatus() {
		return status;
	}
	public void setStatus(EntityStatus status) {
		this.status = status;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	
}
