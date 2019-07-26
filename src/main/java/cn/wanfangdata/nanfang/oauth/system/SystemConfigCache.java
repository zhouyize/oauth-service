package cn.wanfangdata.nanfang.oauth.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;


/**
 * @author Neil Wang 2017-11-15
 */
@Component
public class SystemConfigCache {
	@Value("${server.port}")
	private String port;
	@Value("${server.contextPath}")
	private String contextPath;

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the contextPath
	 */
	public String getContextPath() {
		return contextPath;
	}

	/**
	 * @param contextPath the contextPath to set
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}
