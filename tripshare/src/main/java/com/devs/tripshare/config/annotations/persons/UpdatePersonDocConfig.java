package com.devs.tripshare.config.annotations.persons;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.exceptions.FieldMessage;
import com.devs.tripshare.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
@Operation(summary = "change a specific person", description = "This method change a specific person. Use the person id.", tags = {"Person"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = PersonDto.class), mediaType = "application/json")),
                       @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(array = @ArraySchema(schema = @Schema(implementation = FieldMessage.class)), mediaType = "application/json")),
                       @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = StandardError.class), mediaType = "application/json"))} )
public @interface UpdatePersonDocConfig {
}
