package com.devs.tripshare.config.annotations.trips;

import com.devs.tripshare.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "List a specific trip", description = "This method returns a specific trip. Use the trip id.", tags = {"Trip"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json")),
                       @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class), mediaType = "application/json"))} )
public @interface GetTripByIdDocConfig {
}
