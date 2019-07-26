/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.enums.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Neil Wang
 * 2017年9月29日
 */
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonListEnum {
	String type();
	String desc();
}
