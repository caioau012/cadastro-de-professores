package com.caiohudak.cadasro_de_professores.controller.docs;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.caiohudak.cadastro_de_professores.dto.DisciplinaDTO;
import com.caiohudak.cadastro_de_professores.dto.ProfessorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface DisciplinaControllerDocs {
	@Operation(summary = "Find A Disciplina", description = "Find a specific disciplina by your Id",  tags = "Disciplinas", responses = {
			@ApiResponse(description = "Success", 
					responseCode = "200", 
					content = @Content(schema = @Schema(implementation = ProfessorDTO.class)))		,
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	DisciplinaDTO findById(Long id);

	@Operation(summary = "Find All Disciplinas", description = "Finds All Disciplinas",  tags = "Disciplinas", responses = {
			@ApiResponse(description = "Success", 
					responseCode = "200", 
					content = {
							@Content(
									mediaType =MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class))
									) 
					}),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	ResponseEntity<PagedModel<EntityModel<DisciplinaDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "size", defaultValue = "12") Integer size, 
			@RequestParam(value = "direction", defaultValue = "asc") String direction);

	@Operation(summary = "Adds a new Disciplina",
		    description = "Adds a new Disciplina by passing in a JSON, XML or YML representation of the book.",
		    tags = {"Disciplinas"},
		    responses = {
		            @ApiResponse(
		                    description = "Success",
		                    responseCode = "200",
		                    content = @Content(schema = @Schema(implementation = ProfessorDTO.class))
		            ),
		            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
		    }
		)
	DisciplinaDTO create(DisciplinaDTO disciplina);

	@Operation(summary = "Updates a disciplina's information",
		    description = "Updates a disciplina's information by passing in a JSON, XML or YML representation of the updated book.",
		    tags = {"Disciplinas"},
		    responses = {
		            @ApiResponse(
		                    description = "Success",
		                    responseCode = "200",
		                    content = @Content(schema = @Schema(implementation = ProfessorDTO.class))
		            ),
		            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
		    }
		)
	DisciplinaDTO update(DisciplinaDTO disciplina);

    @Operation(summary = "Deletes a disciplina",
    description = "Deletes a specific disciplina by their ID",
    tags = {"Disciplinas"},
    responses = {
            @ApiResponse(
                    description = "No Content",
                    responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
    }
)
	ResponseEntity<?> delete(Long id);
}
