package net.codefusionhub.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot API Documentation",
				description = "Spring Boot API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Krishna Ghodke",
						email = "krushnaghodke90@gmail.com",
						url = "https://krishnaghodke.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://krishnaghodke.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot API Documentation",
				url = "https://krishnaghodke.com"
		)
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
