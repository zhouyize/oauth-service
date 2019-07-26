package cn.wanfangdata.nanfang.oauth.enums.rest.input;

import java.util.List;

import javax.validation.constraints.NotNull;

public class InEnumTypes {

	@NotNull
	private List<String> types;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
	
}
