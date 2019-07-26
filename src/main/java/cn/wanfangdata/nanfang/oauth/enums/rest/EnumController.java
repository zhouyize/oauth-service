/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wanfangdata.nanfang.oauth.enums.rest.EnumService;
import cn.wanfangdata.nanfang.oauth.enums.rest.input.InEnumTypes;
import cn.wanfangdata.nanfang.oauth.rest.dto.KeyValue;
import cn.wanfangdata.nanfang.oauth.rest.dto.WrapperDTO;

/**
 * @author Neil Wang
 * 2017年9月29日
 */

@RestController
@RequestMapping("/enums")
public class EnumController {
	@Autowired
	private EnumService enumServices;

	/**
	 * Used to get all enums
	 * @return
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(value="/{type}",method=RequestMethod.GET)
	public ResponseEntity<?> getEnums(@PathVariable String type,@RequestParam(required=false) String locale){	
		WrapperDTO<List<KeyValue>> data = new WrapperDTO<List<KeyValue>>();
		List<KeyValue> list = enumServices.getEnumList(type);
		if(CollectionUtils.isEmpty(list)){
			data.setSuccess(false);
			data.setMsg("Enums you requested isn't common!");
			return ResponseEntity.badRequest().body(data);
		}else{
			data.setData(list);
			return ResponseEntity.ok(data);
		}
	}
	
	/**
	 * Used to get all enums
	 * @return
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> getGroupedEnums(@Valid @RequestBody final InEnumTypes types, @RequestParam(required=false) String locale){	
		
		Map<String, List<KeyValue>> enumMap = new HashMap<String, List<KeyValue>>();
		types.getTypes().forEach(type -> {
			List<KeyValue> list = enumServices.getEnumList(type);
			if(CollectionUtils.isNotEmpty(list)){
				enumMap.put(type, list);
			}
		});
		WrapperDTO<Map<String, List<KeyValue>>> data = new WrapperDTO<Map<String, List<KeyValue>>>();
		data.setData(enumMap);
		return ResponseEntity.ok(data);
	}
	
	/**
	 * Used to get all enum type and description
	 * @return
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(value="/desc",method=RequestMethod.GET)
	public ResponseEntity<?> getEnumsDesc(){	
		WrapperDTO<List<KeyValue>> data = new WrapperDTO<List<KeyValue>>();
		data.setData(enumServices.getEnumsDesc());
		data.setMsg("Berry Enum description.");
		return ResponseEntity.ok(data);
	}
}
