package com.pabi.pabiuser.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

  private ApiInfo swaggerInfo() {
    return new ApiInfoBuilder().title("PA-BI User API DOCS")
        .description("파비 프로젝트 User 서비스 API 문서 입니다.").build();
  }

  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(swaggerInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.pabi.pabiuser.interfaces"))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false);
  }
}
