package com.medicare;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@OpenAPIDefinition(
//        info = @Info(
//                title = "Medicare Backend",
//                version = "1.0.0",
//                description = "Its a ecommerce application for Medicine buying online",
//                termsOfService = "opensource ",
//                contact = @Contact(
//                        name = "Mr. Malay Sarkar",
//                        email = "malay.cse@gmail.com"
//                )
//
//        )
//)
public class MedicareBackendApplication  {
    public static void main(String[] args) {
        SpringApplication.run(MedicareBackendApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
