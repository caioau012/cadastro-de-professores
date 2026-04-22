package com.caiohudak.cadastro_de_professores.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.caiohudak.cadastro_de_professores.dto.ClassesDTO;
import com.caiohudak.cadastro_de_professores.entity.Classes;
import com.caiohudak.cadastro_de_professores.exception.RequiredObjectIsNullException;
import com.caiohudak.cadastro_de_professores.exception.ResourceNotFoundException;
import com.caiohudak.cadastro_de_professores.mapper.custom.ClassesMapper;
import com.caiohudak.cadastro_de_professores.repository.ClassesRepository;

@Service
public class ClassesServices {
	
	@Autowired
	ClassesRepository repository;
	
	@Autowired
	ClassesMapper converter;
	
	@Autowired
	PagedResourcesAssembler<ClassesDTO> assembler;
	
	private Logger logger = LoggerFactory.getLogger(ClassesServices.class.getName());
	
	public PagedModel<EntityModel<ClassesDTO>> findAll(Pageable pageable){
		logger.info("Encontrando todas as classes!");
		var classes = repository.findAll(pageable);
		
		var classesWithLinks = classes.map(classe -> {var dto = parseObject(classe, ClassesDTO.class);
		addHateoasLinks(dto);
		return dto;});
		
		Link findAllLink = WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(ClasseController.class)
				.findAll(pageable.getPageNumber(), pageable.getPageSize(), String.valueOf(pageable.getSort()))).withSelfRel();
		
		return assembler.toModel(classesWithLinks, findAllLink);
	}
	
	public ClassesDTO findById(Long id) {
		logger.info("Encontrando uma Classe!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum dado encontrado para esse ID!"));
		
		var dto = parseObject(entity, ClassesDTO.class);
		addHateoasLinks(dto);
		return dto;
	}
	
	public ClassesDTO create(ClassesDTO classe) {
		if (classe==null) throw new RequiredObjectIsNullException();
		logger.info("Criando uma classe!");
		var entity = parseObject(classe, Classes.class);
		var dto = parseObject(repository.save(entity), ClassesDTO.class);
		addHateoasLinks(dto);
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
