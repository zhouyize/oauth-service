/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.rest.dto;

/**
 * @author Neil Wang
 * 2017年9月29日
 */
public class KeyValue {
	private String code;
	private String value;
	
	/**
	 * @param code
	 * @param value
	 */
	public KeyValue(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}
	public KeyValue(){
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
