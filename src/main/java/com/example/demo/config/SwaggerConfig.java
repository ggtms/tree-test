package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author txl
 * @description
 * @date 2020/12/7 18:56
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    /**
     * 配置了Swagger的Docket的Bean实例
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    /**
     * 配置Swagger信息
     * @return
     */
    //可查看ApiInfo源码，里面有默认配置的信息
    private ApiInfo apiInfo(){
        //配置作者信息
        Contact contact = new Contact("春泥","https://www.chunni.com","xxxx@qq.com");
        //配置Swagger信息
        return new ApiInfo("春泥的Swagger文档",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
