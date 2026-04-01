package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiohudak.cadastro_de_professores.dto.DisciplinaDTO;
import com.caiohudak.cadastro_de_professores.services.DisciplinaServices;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/disciplina")
@Tag(name = "Disciplina", description = "Endpoints for Managing disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaServices service;
	
	@Override
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public DisciplinaDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@Override
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public ResponseEntity<PagedModel<EntityModel<DisciplinaDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam)

}
