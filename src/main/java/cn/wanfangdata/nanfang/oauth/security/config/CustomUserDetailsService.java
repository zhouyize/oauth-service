/**
 *
 */
package cn.wanfangdata.nanfang.oauth.security.config;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.wanfangdata.nanfang.oauth.domain.User;
import cn.wanfangdata.nanfang.oauth.domain.spec.UserSpecifications;
import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;
import cn.wanfangdata.nanfang.oauth.repo.UserRepository;
import cn.wanfangdata.nanfang.oauth.security.CustomUserDetails;


/**
 * @author Neil Wang Apr 5, 2017
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			final User user = userRepo.findOne(UserSpecifications.equalAccount(username));
			if (user != null && !EntityStatus.CLOSED.equals(user.getStatus())) {
				final List<UserAuthority> listUa = new LinkedList<>();
				if(user.getUserType() != null) {
					final UserAuthority ua = new UserAuthority(user.getUserType().name());
					listUa.add(ua);
//					if(user.getUserType().equals(UserType.ROLE_IP_PASS)) {
//						UserAuthority uaUser = new UserAuthority(UserType.ROLE_USER.name());
//						listUa.add(uaUser);
//					}
				}
				return new CustomUserDetails(
						username, 
						user.getPassword(), 
						listUa);
			}
		}
		
		throw new UsernameNotFoundException(String.format("User %s is invalid!", username));
	}

}
