/**
 * 
 */
package cn.wanfangdata.nanfang.oauth.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Neil Wang
 * 2017年9月12日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static List<ResponseMessage> responseMessageList = new ArrayList<>();

	static {
		responseMessageList.add(new ResponseMessageBuilder().code(500).message("500 - Internal Server Error").responseModel(new ModelRef("Error")).build());
		responseMessageList.add(new ResponseMessageBuilder().code(403).message("403 - Forbidden").build());
	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("restful-api")

		/**
		 * select() method returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints
		 * exposed by Swagger
		 **/

		.select()

		/**
		 * Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and
		 * PathSelectors. Using any() for both will make documentation for your entire API available through Swagger.
		 **/

		.apis(RequestHandlerSelectors.basePackage("cn.wanfangdata.nanfang.oauth")).paths(PathSelectors.any()).build().pathMapping("/").apiInfo(metadata())
				/**
				 * Instructing Swagger not to use default response messages.
				 */
				.useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, responseMessageList);
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Oauth Restful API").description("Oauth Restful API; all url starting with /**").version("1.00").build();
	}
}
