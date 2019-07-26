/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.wanfangdata.nanfang.oauth.enums.annotation.CommonListEnum;
import cn.wanfangdata.nanfang.oauth.rest.dto.KeyValue;
import cn.wanfangdata.nanfang.oauth.enums.CommonEnum;

/**
 * @author Neil Wang
 * 2017年9月29日
 */
@Service
public class EnumService {
	
	private static final Map<String, List<KeyValue>> map = new HashMap<>();
	private static final List<KeyValue> descList = new ArrayList<>();
	static{
		Reflections ref = new Reflections("cn.wanfangdata.nanfang.oauth");
		String type;
        for (Class<?> cl : ref.getTypesAnnotatedWith(CommonListEnum.class)) {        	
        	CommonListEnum dropdownlist = cl.getAnnotation(CommonListEnum.class);
        	List<KeyValue> list = new ArrayList<KeyValue>();
        	type = dropdownlist.type();
        	CommonEnum okchemEnum = null;
        	for (Object object : cl.getEnumConstants()) {
        		okchemEnum = (CommonEnum)object;
				list.add(new KeyValue(okchemEnum.name(), okchemEnum.getValue()));
			}
        	map.put(type.toLowerCase(), list);
        	descList.add(new KeyValue(type, dropdownlist.desc()));
        }
	}
	
	/**
	 * 
	 * @param enumType
	 * @return
	 */
	public List<KeyValue> getEnumList(String enumType) {
		Assert.notNull(enumType);
		List<KeyValue> list = map.get(enumType.toLowerCase());
		if (list == null) {
			list = new ArrayList<KeyValue>();
		}
		return list;
	}

	/**
	 * @param type
	 * @return
	 */
	public List<KeyValue> getEnumsDesc() {
		return descList;
	}
	
}

