/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums;

import cn.wanfangdata.nanfang.oauth.enums.CommonEnum;
import cn.wanfangdata.nanfang.oauth.enums.annotation.CommonListEnum;

/**
 * @author Neil Wang
 * 2017年9月7日
 */
@CommonListEnum(type = "EntityStatusEnum", desc = "实体状态枚举值")
public enum EntityStatus implements CommonEnum{
	ACTIVATING("待激活"), ACTIVATED("已激活"), CLOSED("关闭");
	
	private String value;
	
	private EntityStatus(String value) {
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
