package ia.roadzen.platform.u20231b475.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import io.swagger.v3.oas.models.Operation;

@Configuration
public class OpenApiConfiguration {
    // Properties
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${documentation.application.description}")
    String applicationDescription;

    @Value("${documentation.application.version}")
    String applicationVersion;

    // Methods
    @Bean
    public OpenAPI openApiConfig() {
        // General configuration
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title(this.applicationName)
                        .description(this.applicationDescription)
                        .version(this.applicationVersion)
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")));

        return openApi;
    }

    @Bean
    public OperationCustomizer addGlobalHeaders() {
        return (Operation operation, HandlerMethod handlerMethod) -> {

            StringSchema languageSchema = new StringSchema();
            languageSchema.example("en");
            languageSchema.setDefault("en");

            Parameter acceptLanguageHeader = new Parameter()
                    .in("header")
                    .name("Accept-Language")
                    .description("Language for localized responses (e.g. en, es)")
                    .required(false)
                    .schema(languageSchema);

            // Lo agregamos a la operación actual
            operation.addParametersItem(acceptLanguageHeader);

            return operation;
        };
    }
}