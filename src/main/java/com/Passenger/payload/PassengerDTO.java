package com.Passenger.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Data
@Schema(
        name = "PassengerDTO",
        description = "Schema representing passenger information for the Bus Ticket Booking system"
)
public class PassengerDTO {

    @Schema(
            description = "Id of Passenger",example = "1"
    )
    private Long passengerId;

    @Schema(
            description = "Name of the Passenger",example="John"
    )

    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min=3,max=30,message = "The length of the customer name should be between 3 and 30")
    private String firstName;

    @Schema(
            description = "LastName of Passenger",example = "Deo"
    )

    @NotEmpty(message = "lastName cannot be a null or empty")
    private String lastName;

    @Schema(

            description = "Email address of the passenger",example = "john@gmail.com"
    )

    @NotEmpty(message="Email address cannot be null or empty")
    @Email(message="Email address should be valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the passenger",example = "9077123658"
    )

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phoneNumber;

    @Schema(

            description = "Birth Date of Passenger", example = "1999/05/31"
    )
    private Date dateOfBirth;

    @Schema(

            description = "Gender of Passenger",example = "Male,Female,Non-Binary"
    )
    @Pattern(regexp = "^(Male|Female|Non-Binary)$", message = "Gender should be either Male, Female, or Non-Binary")
    private String gender;

    @Schema(

            description = "Address of Passenger",example = "123 Main Street"
    )
    @NotEmpty(message = "Address cannot be null or empty")
    private String address;


    // Constructors, getters, setters can be generated using Lombok or manually added as needed

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
