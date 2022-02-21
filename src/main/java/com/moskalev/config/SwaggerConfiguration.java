package com.moskalev.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
/***/
@Configuration
@OpenAPIDefinition(info = @Info(title = "Shop For You",
        version = "1.0.0",
        description = "OnlineMarket"))
public class SwaggerConfiguration {
}
