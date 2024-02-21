package com.Passenger.payload;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix="passenger")
public record PassengerContactInfoDto(String message, Map<String,String> contactDetails, List<String> onCallSupport) {



    // we can initializa data only once in record class and they are final




}
