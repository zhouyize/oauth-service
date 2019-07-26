/**
 *
 */
package cn.wanfangdata.nanfang.oauth.security.config;

import java.io.IOException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import cn.wanfangdata.nanfang.oauth.exception.ExceptionConstant;


/**
 * @author Neil Wang Apr 5, 2017
 */
@Configuration
public class WebSecurityConfig {

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public static class RestWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		private CustomUserDetailsService userDetailsService;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers(HttpMethod.OPTIONS);
		}

		@Override
		protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}

		@Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Override		
		public void configure(final HttpSecurity http) throws Exception {
			http.csrf().disable();
		}
	}


	@Configuration
	@EnableResourceServer
	public static class RestApiOAuth2ResourceConfig extends ResourceServerConfigurerAdapter {
		@Override
		public void configure(final ResourceServerSecurityConfigurer resources) {
			resources.resourceId("ApiResource");
		}

		@Override
		public void configure(final HttpSecurity http) throws Exception {
			http.authorizeRequests()
			
			.anyRequest().permitAll();
			
			http.csrf().disable();
		}
	}

	@Configuration
	@EnableAuthorizationServer
	public static class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private CustomUserDetailsService userDetailsService;

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private DataSource dataSource;

		@Autowired
		private MessageSource messageSource;

		@Override
		public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		}

		@Override
		public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.tokenStore(new JdbcTokenStore(dataSource))
			.authenticationManager(this.authenticationManager)
			.userDetailsService(this.userDetailsService);
			endpoints.exceptionTranslator(e -> {
				if(e instanceof OAuth2Exception) {
					final OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
					return ResponseEntity.status(oAuth2Exception.getHttpErrorCode())
							.body(new CustomOauthException(oAuth2Exception.getMessage()));
				} else {
					throw e;
				}
			});
		}
		

		@Override
		public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory().withClient("online").secret("onlineSecret")
					.authorizedGrantTypes("password", "refresh_token").scopes("read", "write", "trust")
					.resourceIds("ApiResource")
					.autoApprove(true) // 自动认证
//		            .redirectUris("http://192.168.4.4:7711/webthesis/api/thesis/getThesisList")    // 认证成功重定向URL
					.accessTokenValiditySeconds(3600 * 24 * 10);
		}

		@JsonSerialize(using = CustomOauthExceptionSerializer.class)
		public class CustomOauthException extends OAuth2Exception {
		    CustomOauthException() {
		        super("");
		    }
		    public CustomOauthException(final String msg) {
		        super(msg);
		    }
		}

		public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
		    public CustomOauthExceptionSerializer() {
		        super(CustomOauthException.class);
		    }

		    @Override
		    public void serialize(final CustomOauthException value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
		        gen.writeStartObject();
		        gen.writeStringField("msgCode", ExceptionConstant.USER_INVALID);
		        gen.writeStringField("msg", messageSource.getMessage(ExceptionConstant.USER_INVALID, new String[] {}, LocaleContextHolder.getLocale()));
		        if (value.getAdditionalInformation()!=null) {
		            for (final Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
		                final String key = entry.getKey();
		                final String add = entry.getValue();
		                gen.writeStringField(key, add);
		            }
		        }
		        gen.writeEndObject();
		    }
		}

	}
}
