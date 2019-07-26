/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.domain.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import cn.wanfangdata.nanfang.oauth.domain.User;
import cn.wanfangdata.nanfang.oauth.domain.User_;
import cn.wanfangdata.nanfang.oauth.enums.EntityStatus;
import cn.wanfangdata.nanfang.oauth.enums.UserType;
import cn.wanfangdata.nanfang.oauth.rest.input.InUserSearch;



/**
 * @author Neil Wang 2017年9月12日
 */
public class UserSpecifications {

	private UserSpecifications() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * Specification for the field account
	 * 
	 * @param account
	 * @return
	 */
//	public static Specification<User> equalAccount(final String account) {
//		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(User_.account), account);
//	}
	/**
	 * Specification for the field account
	 * 
	 * @param name
	 * @return
	 */
	public static Specification<User> equalName(final String name) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(User_.fullName), name);
	}
	
	public static Specification<User> equalAccount(final String account) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(User_.account), account);
	}
	
	public static Specification<User> equalStatus(final EntityStatus status) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(User_.status), status);
	}	
	public static Specification<User> equalUserType(final UserType userType) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(User_.userType), userType);
	}	
	
	
	public static Specification<User> userSearchCriteria(final InUserSearch inUserSearch ) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(!StringUtils.isEmpty(inUserSearch.getFullName())) {
				predicates.add(builder.like(root.get(User_.fullName), inUserSearch.getFullName()));
			}
			if(!StringUtils.isEmpty(inUserSearch.getAccount())) {
				predicates.add(builder.like(root.get(User_.account), inUserSearch.getAccount()));
			}
			if(inUserSearch.getStatus()!=null) {
				predicates.add(builder.equal(root.get(User_.status), inUserSearch.getStatus()));
			}
			if(inUserSearch.getUserType()!=null) {
				predicates.add(builder.equal(root.get(User_.userType), inUserSearch.getUserType()));
			}
			return builder.and(predicates.toArray(new Predicate[] {}));
		};
	}
	
	
}
