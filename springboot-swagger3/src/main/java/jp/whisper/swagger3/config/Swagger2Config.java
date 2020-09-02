package jp.whisper.swagger3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName Swagger2Config
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 19:12
 * @Version 1.0
 */
@Configuration
@EnableOpenApi
public class Swagger2Config{
    @Bean
    Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("jp.whisper.swagger3.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .description("interface description")
                        .title("swagger3_learnging")
                        .contact(new Contact("whisper", "https://github.com/inspireme", "cndone@gmail.com"))
                        .version("v1.0")
                        .license("Apache2.0")
                        .build());
    }
}
