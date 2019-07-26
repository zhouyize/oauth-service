/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import cn.wanfangdata.nanfang.oauth.domain.SysCollege;
import cn.wanfangdata.nanfang.oauth.domain.User;
import cn.wanfangdata.nanfang.oauth.domain.spec.UserSpecifications;
import cn.wanfangdata.nanfang.oauth.repo.CollegeRepository;
import cn.wanfangdata.nanfang.oauth.repo.UserRepository;
import cn.wanfangdata.nanfang.oauth.rest.dto.CollegeDTO;
import cn.wanfangdata.nanfang.oauth.rest.dto.UserDTO;
import cn.wanfangdata.nanfang.oauth.rest.dto.assemble.CollegeDTOAssemble;
import cn.wanfangdata.nanfang.oauth.rest.dto.assemble.UserDTOAssemble;
import cn.wanfangdata.nanfang.oauth.rest.dto.data.Paging;
import cn.wanfangdata.nanfang.oauth.rest.dto.data.PagingData;
import cn.wanfangdata.nanfang.oauth.rest.input.InUserSearch;


/**
 * @author Neil Wang
 * 2017年10月10日
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired 
	UserDTOAssemble userDTOAssemble;
	
	@Autowired
	private CollegeDTOAssemble collegeDTOAssemble;

	@Autowired
	private CollegeRepository collegeRepository;
	
	/**
	 * Query user
	 * @param InUserSearch
	 * @return
	 */
	public PagingData<UserDTO> queryUser(final Integer viewIndex, final Integer viewSize, final InUserSearch inUserSearch) {
		final Pageable pageable = new PageRequest(viewIndex - 1, viewSize, new Sort(Sort.Direction.DESC, "createdStamp"));
		Page<User> users = userRepo.findAll(UserSpecifications.userSearchCriteria(inUserSearch), pageable);
        final Paging paging = new Paging();
        paging.setViewIndex(viewIndex);
        paging.setViewSize(viewSize);
        paging.setTotalSize(users.getTotalElements());
        final PagingData<UserDTO> output = new PagingData<>();
        output.setList(userDTOAssemble.toDTOList(users.getContent()));
        output.setPaging(paging);
		return output;
	}
	
	public List<CollegeDTO> getAllColleges() {
		
		List<CollegeDTO> colleges = new ArrayList<>();
		collegeRepository.findAll().forEach(col -> {
			colleges.add(collegeDTOAssemble.toDTO(col));
		});
		return colleges;
	}

}
