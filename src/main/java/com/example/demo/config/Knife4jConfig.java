package com.example.demo.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

/**
 * @author txl
 * @description
 * @date 2020/12/7 18:56
 */
@EnableOpenApi
@Configuration
@EnableConfigurationProperties({SwaggerProperties.class})
public class Knife4jConfig {

    private static final Logger log = LoggerFactory.getLogger(Knife4jConfig.class);

    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Resource
    private SwaggerProperties swaggerProperties;

    @Autowired
    public Knife4jConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    /**
     * 配置了Swagger的Docket的Bean实例
     * @return
     */
    @Bean
    public Docket createRestApi() {
        Docket docket = (new Docket(DocumentationType.OAS_30))
                .apiInfo(apiInfo())
                .groupName(swaggerProperties.getGroupName())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .enable(swaggerProperties.isEnable())
                .extensions(openApiExtensionResolver.buildSettingExtensions());
        log.info("【Swagger配置】启用,请访问:http://ip:port/doc.html");
        return docket;
    }

    /**
     * 配置Swagger信息  //可查看ApiInfo源码，里面有默认配置的信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl(swaggerProperties.getUrl())
                .contact(new Contact(swaggerProperties.getContactName(),
                        swaggerProperties.getContactUrl(),
                        swaggerProperties.getContactEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

}
