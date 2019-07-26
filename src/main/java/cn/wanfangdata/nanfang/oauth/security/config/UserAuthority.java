/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.security.config;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Neil Wang
 * Apr 5, 2017
 */
public class UserAuthority implements GrantedAuthority{
	private String role;
	public UserAuthority(String role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return this.role;
	}

}
