package com.Passenger.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PassengerConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
