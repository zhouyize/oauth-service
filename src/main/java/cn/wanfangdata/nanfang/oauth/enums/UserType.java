/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums;

import cn.wanfangdata.nanfang.oauth.enums.annotation.CommonListEnum;

/**
 * @author Neil Wang
 * 2017年9月14日
 */
@CommonListEnum(type = "UserTypeEnum", desc = "用户类别枚举值")
public enum UserType implements CommonEnum {
	ROLE_ADMIN("管理员"), ROLE_EXPERT("专家"), ROLE_CUST_SVC("客服"), ROLE_DELIVERY("送评人"), ROLE_FINANCE("财务"), ROLE_GRADUATE_SCHOOL_ADMIN("研究生院管理员") ;
	
	private String value;
	
	private UserType(String value) {
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
