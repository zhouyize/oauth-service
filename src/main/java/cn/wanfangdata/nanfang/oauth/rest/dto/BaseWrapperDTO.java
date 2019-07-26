/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.rest.dto;

/**
 * @author Neil Wang
 * Apr 10, 2017
 */
public abstract class BaseWrapperDTO {
	private String msg;
	private String msgCode;
	private boolean success = true;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
