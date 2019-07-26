/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.rest.dto;

/**
 * @author Neil Wang
 * Apr 10, 2017
 */
public class WrapperDTO<T> extends BaseWrapperDTO {
	private T data;
	
	public WrapperDTO(){
		super();
	}
	
	public WrapperDTO(T data){
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
