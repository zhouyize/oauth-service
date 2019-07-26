package cn.wanfangdata.nanfang.oauth.rest.dto.assemble;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.wanfangdata.nanfang.oauth.domain.SysCollege;
import cn.wanfangdata.nanfang.oauth.rest.dto.CollegeDTO;



@Component
public class CollegeDTOAssemble {
	public CollegeDTO toDTO(final SysCollege college) {
		return new CollegeDTO(
				college.getCode(), 
				college.getName(),
				college.getEnglishName(),
				college.getStatus(),
				college.getSchool().getCode()
		);
	}
	
	public List<CollegeDTO> toDTOList(final List<SysCollege> colleges) {
		final List<CollegeDTO> collegeDtos = new ArrayList<>();
		colleges.forEach(college -> {
			CollegeDTO userDto = new CollegeDTO(
					college.getCode(), 
					college.getName(),
					college.getEnglishName(),
					college.getStatus(),
					college.getSchool().getCode()
			);
			collegeDtos.add(userDto);
		});
		return collegeDtos;
	}
}
