package com.Passenger.controller;

import com.Passenger.constants.PassengerConstants;
import com.Passenger.payload.PassengerContactInfoDto;
import com.Passenger.payload.PassengerDTO;
import com.Passenger.payload.ResponseDto;
import com.Passenger.service.PassengerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Passenger in Bus Booking",
        description = "CRUD REST APIs in Bus Booking to CREATE,UPDATE,FETCH AND DELETE passenger details"
)
@RestController
@RequestMapping("/api/passengers")
@Validated
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @Value("${build.version}")
    private String buildVersion;


    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into Passenger Microservice "
    )
    @ApiResponses({
            @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    ),
    @ApiResponse(
            responseCode="500",
            description="HTTP status Internal Server Error"

    )})

    @GetMapping("/build-info")  //http://localhost:8080/api/passengers/build-info
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }


    @Autowired
    private Environment environment;

    @Operation(
            summary = "Get Java Version information",
            description = "Get Java Version information that is installed into Passenger Microservice "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP status Internal Server Error"

            )})


    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion(){
        return ResponseEntity.status(HttpStatus.OK).body("MAVEN_HOME");
    }

    @Autowired
    private PassengerContactInfoDto passengerContactInfoDto;

    @Operation(
            summary = "Get Contact Info ",
            description = "Contact Info details that can be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP status Internal Server Error"

            )})

    @GetMapping("/contact_info")
    public ResponseEntity<PassengerContactInfoDto>getContactInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(passengerContactInfoDto);
    }


    @GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        List<PassengerDTO> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Long passengerId) {
        PassengerDTO passenger = passengerService.getPassengerById(passengerId);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create a new passenger profile with the provided information "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping
    public ResponseEntity<ResponseDto> createPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
        // PassengerDTO createdPassenger = passengerService.createPassenger(passengerDTO);
        //  return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
        // Or

        passengerService.createPassenger(passengerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PassengerConstants.STATUS_201, PassengerConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Update Passenger",
            description = "Update the details of an existing passenger identified by the provided ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )

    @PutMapping("/{passengerId}")
    public ResponseEntity<PassengerDTO> updatePassenger(
            @PathVariable Long passengerId,
            @Valid @RequestBody PassengerDTO passengerDTO
    ) {
        PassengerDTO updatedPassenger = passengerService.updatePassenger(passengerId, passengerDTO);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete Passenger",
            description = "Deletes a passenger record based on the provided passenger ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Passenger successfully deleted. No content to return."
    )

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
