package com.pabi.pabiuser.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PATCH", "DELETE")
        .exposedHeaders("Authentication", "jwt-refresh-token", "content-disposition");
  }

//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    converters.add(new MappingJackson2HttpMessageConverter(customObjectMapper()));
//  }
//
//  @Bean
//  public ObjectMapper customObjectMapper() {
//    return new CustomObjectMapper();
//  }

//  @Override
//  public void addFormatters(FormatterRegistry registry) {
//    registry.addConverter(new GradeConverter());
//  }

//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//    String reportPath = uploadPath("./report");
//    registry.addResourceHandler("/report/**")
//        .addResourceLocations("file:/" + reportPath + "/");
//
//    registry.addResourceHandler("/**/*")
//        .addResourceLocations("classpath:/static/")
//        .resourceChain(true)
//        .addResolver(new PathResourceResolver() {
//          @Override
//          protected Resource getResource(String resourcePath, Resource location) throws IOException {
//            Resource requestedResource = location.createRelative(resourcePath);
//            return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
//                : new ClassPathResource("/templates/index.html");
//          }
//        });
//  }

//  private String uploadPath(String directory) {
//    Path uploadDirPath = Paths.get(directory);
//    return uploadDirPath.toFile().getAbsolutePath();
//  }

    /*

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(20);
    }
    */

}
