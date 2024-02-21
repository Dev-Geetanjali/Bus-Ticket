package com.Passenger;

import com.Passenger.payload.PassengerContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
///this is for @ConfigurationProperties - to read value from application.properties file
@EnableConfigurationProperties(value={PassengerContactInfoDto.class})
// This is for auditing doing whenever something post is created in database or update in database
@EnableJpaAuditing(auditorAwareRef ="auditAwareImpl" )
// documentation swagger
@OpenAPIDefinition(
		info=@Info(
				title = "Passenger microservice REST API Documentation",
				description = " RESTful API Documentation for managing passenger information",
				version = "v1",
				contact=@Contact(
						name = "Geetanjali",
						email="geetanjalijadhav853@gmail.com",
						//url since I don't have any url that's why not mentioning
						url="https://www.eazybytes.com"
				),
				license = @License(
						name ="Apache 2.0",
					  //  url
						url="https://www.eazybytes.com"
				)
				),
		           externalDocs =@ExternalDocumentation(
				   description = "RESTful API Documentation for managing passenger information",

				   // url
						url=   "https://www.eazybytes.com"

		)
)
public class PassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerApplication.class, args);
	}

}
