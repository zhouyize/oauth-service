package cn.wanfangdata.nanfang.oauth.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.wanfangdata.nanfang.oauth.application.UserService;
import cn.wanfangdata.nanfang.oauth.rest.dto.CollegeDTO;
import cn.wanfangdata.nanfang.oauth.rest.dto.UserDTO;
import cn.wanfangdata.nanfang.oauth.rest.dto.WrapperDTO;
import cn.wanfangdata.nanfang.oauth.rest.dto.data.PagingData;
import cn.wanfangdata.nanfang.oauth.rest.input.InUserSearch;
import cn.wanfangdata.nanfang.oauth.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "管理员接口，包括用户管理")
@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserService userService;
	

	/**
	 * Query user
	 * @param authentication
	 * @param viewIndex
	 * @param viewSize
	 * @param inUserSearch
	 * @return
	 */
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
//	})
	@ApiOperation(value = "用户查询", notes = "用户查询" )
	@RequestMapping(value = "/users/query", method = RequestMethod.POST)
	public ResponseEntity<WrapperDTO<PagingData<UserDTO>>> queryUsers(
			final Authentication authentication,
   		 	@RequestParam(value = "viewIndex", required = false, defaultValue="1") Integer viewIndex,
   		 	@RequestParam(value = "viewSize", required = false, defaultValue="10") Integer viewSize,
			@ApiParam(value = "用户查询条件", required = true) @Valid @RequestBody final InUserSearch inUserSearch
		) {
		//CustomUserDetails currentUser = (CustomUserDetails)authentication.getPrincipal();
		final WrapperDTO<PagingData<UserDTO>> data = new WrapperDTO<>(userService.queryUser(viewIndex, viewSize, inUserSearch ));
		return ResponseEntity.ok(data);
	}
	
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
//	})
	@ApiOperation(value = "学院查询", notes = "学院查询" )
    @RequestMapping(value = "/colleges", method = RequestMethod.GET)
    public ResponseEntity<WrapperDTO<List<CollegeDTO>>> colleges() {
        final WrapperDTO<List<CollegeDTO>> data = new WrapperDTO<>(userService.getAllColleges());
        return ResponseEntity.ok(data);
    }	
}
