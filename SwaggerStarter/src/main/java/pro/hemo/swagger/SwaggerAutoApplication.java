package pro.hemo.swagger;


import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import pro.hemo.swagger.config.SwaggerProperty;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperty.class)
public class SwaggerAutoApplication {

    @Autowired
    private SwaggerProperty swaggerProperty;

    @Bean
    public Docket docket() {
        checkValid(swaggerProperty);
        Predicate<String>[] selector = new Predicate[]{};
        if (null != swaggerProperty.getPaths() && swaggerProperty.getPaths().length > 0) {
            selector = new Predicate[swaggerProperty.getPaths().length];
            for (int i = 0; i < selector.length; i++) {
                selector[i] = regex(swaggerProperty.getPaths()[i]);
            }
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerProperty.getGroupName())
                .apiInfo(apiInfo())
                .select()
                .paths(or(selector))
                .build();
    }

    private void checkValid(SwaggerProperty swaggerProperty) {
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperty.getTitle())
                .description(swaggerProperty.getDescription())
                .termsOfServiceUrl(swaggerProperty.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperty.getContactName(), swaggerProperty.getContactUrl(), swaggerProperty.getContactEmail()))
                .license(swaggerProperty.getLicense())
                .licenseUrl(swaggerProperty.getLicenseUrl())
                .version(swaggerProperty.getVersion())
                .build();
    }

}