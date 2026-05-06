package com.caiohudak.cadasro_de_professores.controller.docs;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.caiohudak.cadastro_de_professores.dto.ClassesDTO;
import com.caiohudak.cadastro_de_professores.dto.ProfessorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ClassesControllerDocs {

	@Operation(summary = "Find A Classe", description = "Find a specific classe by your Id", tags = "Classes", responses = {
			@ApiResponse(description = "Success",
					responseCode = "200",
					content = @Content(schema = @Schema(implementation = ProfessorDTO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)			
	})
	ClassesDTO findById(Long id);
	
	@Operation(summary = "Finding All Classes", description = "Finds All Classes", tags = "Classes", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class)))
			}),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)	
	})
	ResponseEntity<PagedModel<EntityModel<ClassesDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size,
			@RequestParam(value = "direction", defaultValue = "asc") String direction);
	
	@Operation(summary = "Adds a new Classe",
			description = "Adds a new Classe by passing in a JASON, XML or YML representation of the classe.",
			tags = {"Classes"},
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(schema = @Schema(implementation = ProfessorDTO.class))
					),		
					@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	ClassesDTO create(ClassesDTO classes);
	
	@Operation(summary = "Updates a Classe's specific information", description = "Updates a classe's information by passing in a JSON, XML or YML representation of the updated classe", tags = "Classes", responses = {
			@ApiResponse(description = "Success",
					responseCode = "200",
					content = @Content(schema = @Schema(implementation = ProfessorDTO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)			
	})
	ClassesDTO update(ClassesDTO classes);
	
	@Operation(summary = "Deletes a classe",
			description = "Deletes a specific classe by their ID",
			tags = {"Classes"},
			responses = {
			@ApiResponse(
					description = "No Content",
					responseCode = "204", content = @Content),
			@ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)	})
	ResponseEntity<?> delete(Long id);
	
}
