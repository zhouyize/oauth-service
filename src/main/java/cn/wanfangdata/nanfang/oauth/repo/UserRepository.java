/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wanfangdata.nanfang.oauth.domain.User;



/**
 * @author Neil Wang
 * 2017年10月9日
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, String> {
	public List<User> findAllByAccount(String account);
}
