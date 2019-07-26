package cn.wanfangdata.nanfang.oauth.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  
@ConfigurationProperties(prefix="codlin")
public class CodlinProps {
	private String isopath;
	private String coverpath;
	private String openofficeIp;
	private String videoPath;

	private String saveisopath;
	public String getIsopath() {
		return isopath;
	}

	public void setIsopath(String isopath) {
		this.isopath = isopath;
	}

	public String getCoverpath() {
		return coverpath;
	}

	public void setCoverpath(String coverpath) {
		this.coverpath = coverpath;
	}

	public String getOpenofficeIp() {
		return openofficeIp;
	}

	public void setOpenofficeIp(String openofficeIp) {
		this.openofficeIp = openofficeIp;
	}


	/**
	 * @return the saveisopath
	 */
	public String getSaveisopath() {
		return saveisopath;
	}

	/**
	 * @param saveisopath the saveisopath to set
	 */
	public void setSaveisopath(String saveisopath) {
		this.saveisopath = saveisopath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

}
