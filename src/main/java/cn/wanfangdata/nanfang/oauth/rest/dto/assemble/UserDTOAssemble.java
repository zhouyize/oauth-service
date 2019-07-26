package cn.wanfangdata.nanfang.oauth.rest.dto.assemble;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.wanfangdata.nanfang.oauth.domain.User;
import cn.wanfangdata.nanfang.oauth.rest.dto.UserDTO;



@Component
public class UserDTOAssemble {
	public UserDTO toDTO(final User user) {
		return new UserDTO(
				user.getAccount(), 
				user.getFullName(),
				user.getMobile(),
				user.getEmail(),
				user.getStatus(),
				user.getUserType()
		);
	}
	
	public List<UserDTO> toDTOList(final List<User> users) {
		final List<UserDTO> userDtos = new ArrayList<>();
		users.forEach(user -> {
			UserDTO userDto = new UserDTO(
					user.getAccount(), 
					user.getFullName(),
					user.getMobile(),
					user.getEmail(),
					user.getStatus(),
					user.getUserType()
			);
			userDtos.add(userDto);
		});
		return userDtos;
	}
}
