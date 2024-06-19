package makersharks.example.user.Management.security.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public OpenAPI openAPI(){
        String schemeName = "bearerScheme";

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(schemeName)
                )
                .components(new Components()
                        .addSecuritySchemes(schemeName,new SecurityScheme()
                                .name(schemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .bearerFormat("JWT")
                                .scheme("bearer")
                        )
                )
                .info(new Info()
                        .title("User Management System")
                        .description("The User Management System is a Spring Boot application designed to " +
                                "handle user registration, authentication, and secure access to protected resources. " +
                                "It leverages JWT (JSON Web Tokens) for stateless authentication and implements security " +
                                "best practices to ensure that user data is handled securely.")
                        .version("v1.0.0")
                        .contact(new Contact().name("Saurav Kumar").email("saurav24021998@gmail.com"))
                        .license(new License().name("Apache"))
                );

    }

}
