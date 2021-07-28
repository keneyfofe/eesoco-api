package za.co.eesoco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket swaggerApiConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("za.co.eesoco"))
				.build();
				//.apiInfo(apiInfo);
	}
	
	// Swagger provides an apiInfo method we can use to pass additional details in our documentation
	
	/*private ApiInfo apiInfo() {
		return new ApiInfo("Swagger API Example By Essoco", "API reference Example By Easoco","1.0.0", "Public API");
		*/
		
	}


