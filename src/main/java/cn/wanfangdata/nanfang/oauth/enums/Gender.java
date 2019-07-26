/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums;

import cn.wanfangdata.nanfang.oauth.enums.annotation.CommonListEnum;

/**
 * @author Neil Wang
 * 2017年9月14日
 */
@CommonListEnum(type = "GenderEnum", desc = "性别枚举值")
public enum Gender implements CommonEnum {
	MALE("男"), FEMALE("女");
	
	private String value;
	private Gender(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see cn.wanfangdata.nanfang.berry.sharedkernel.enums.CommonEnum#getValue()
	 */
	@Override
	public String getValue() {
		return this.value;
	}
}
