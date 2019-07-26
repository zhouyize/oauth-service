package cn.wanfangdata.nanfang.oauth.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wanfangdata.nanfang.oauth.domain.SysCollege;


public interface CollegeRepository extends JpaRepository<SysCollege, String>, JpaSpecificationExecutor<SysCollege>, PagingAndSortingRepository<SysCollege, String>{

}

