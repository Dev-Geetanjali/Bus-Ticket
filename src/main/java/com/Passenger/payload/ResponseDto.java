package com.Passenger.payload;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Schema(
        name="ResponseDTO",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(

            description = "Status code in the response",example = "200"
    )
    private String status;

    @Schema(

            description = "Status message in the response",example = "Request processed successfully"
    )
    private String message;

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters (if necessary)
}
