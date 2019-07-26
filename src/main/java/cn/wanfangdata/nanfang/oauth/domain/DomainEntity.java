package cn.wanfangdata.nanfang.oauth.domain;

/**
 * An entity, as explained in the DDD book.
 *  
 */
public interface DomainEntity<T> {

  /**
   * Entities compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardles of other attributes.
   */
  boolean sameIdentityAs(T other);

}
