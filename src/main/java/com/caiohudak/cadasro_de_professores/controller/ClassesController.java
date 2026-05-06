package com.caiohudak.cadasro_de_professores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caiohudak.cadasro_de_professores.controller.docs.ClassesControllerDocs;
import com.caiohudak.cadastro_de_professores.dto.ClassesDTO;
import com.caiohudak.cadastro_de_professores.services.ClassesServices;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("classes")
@Tag(name = "Classes", description = "Endpoint for Managing Classes")
public class ClassesController implements ClassesControllerDocs{
	
	@Autowired
	private ClassesServices service;
	
	@Override
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public ClassesDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@Override
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public ResponseEntity<PagedModel<EntityModel<ClassesDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size,
			@RequestParam(value = "direction", defaultValue = "asc") String direction){
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "classes"));
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@Override
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public ClassesDTO create(@RequesBody ClassesDTO classes) {
		return service.create(classes);
	}
	
	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public ClassesDTO update(@RequestBody ClassesDTO classes) {
		return service.update((classes));
	}
	
	@Override
	@DeleteMapping(value = "{id}")
	public ResponseEntity <?> delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
