package com.caiohudak.cadastro_de_professores.services;

import static com.caiohudak.cadastro_de_professores.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import com.caiohudak.cadastro_de_professores.dto.DisciplinaDTO;
import com.caiohudak.cadastro_de_professores.entity.Disciplina;
import com.caiohudak.cadastro_de_professores.mapper.custom.DisciplinaMapper;
import com.caiohudak.cadastro_de_professores.repository.DisciplinaRepository;

import controller.DisciplinaController;

@Service
public class DisciplinaServices {

	@Autowired
	DisciplinaRepository repository;
	
	@Autowired
	DisciplinaMapper converter;
	
	@Autowired
	PagedResourcesAssembler<DisciplinaDTO> assembler;
	
	private Logger logger = LoggerFactory.getLogger(DisciplinaServices.class.getName());
	
	public PagedModel<EntityModel<DisciplinaDTO>> findAll(Pageable pageable){
		logger.info("Encontrando todas as disciplinas");
		var disciplinas = repository.findAll(pageable);
		
		var disciplinasWithLinks = disciplinas.map(disciplina -> {var dto = parseObject(disciplina, DisciplinaDTO.class);
		addHateoasLinks(dto);
		return dto;});
		
		Link findAllLink = WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(DisciplinaController.class)
				.findAll(pageable.getPageNumber(), pageable.getPageSize(), String.valueOf(pageable.getSort()))).withSelfRel();
		
		return assembler.toModel(disciplinasWithLinks, findAllLink);	
				
	}
	
	public DisciplinaDTO findById(Long id) {
		logger.info("Encontrando uma Disciplina!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nenhum dado encontrado para esse ID!"));
		
		var dto = parseObject(entity, DisciplinaDTO.class);
		addHateoasLinks(dto);
		return dto;
	}
	
	public DisciplinaDTO create(DisciplinaDTO disciplina) {
		if (disciplina==null) throw new RequiredObjectIsNullException();
		logger.info("Criando uma disciplina");
		var entity = parseObject(disciplina, Disciplina.class);
		var dto = parseObject(repository.save(entity), DisciplinaDTO.class);
		addHateoasLinks(dto);
		return dto;
	}
	
	public DisciplinaDTO update(DisciplinaDTO disciplina) {
		if (disciplina==null) throw new RequiredObjectIsNullException();
		logger.info("Atualizando uma disciplina");
		Disciplina entity = repository.findById(disciplina.getId()).orElsehrow(()-> new ResourceNotFoundException("Nenhum dado encontrado para esse ID!"));
		
		entity.setCodigo(disciplina.getCodigo());
		entity.setTurno(disciplina.getTurno());
		entity.setUnidade(disciplina.getUnidade());
		
		var dto = parseObject(repository.save(entity), DisciplinaDTO.class);
		addHateoasLinks(dto);
		return dto;
	}
	
	public void delete(Long id) {
		logger.info("Deletando uma disciplina!");
		
		Disciplina entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nenhum dado encontrado para esse ID!"));
		
		repository.delete(entity);
	}
	
	private void addHateoasLinks (DisciplinaDTO dto) {
		dto.add(linkTo(methodOn(DisciplinaController.class).findById(dto.getId())).withSelfRel().withType("GET"));
		dto.add(linkTo(methodOn(DisciplinaController.class).findAll(0, 12, "asc")).withRel("findAll").withType("GET"));
		dto.add(linkTo(methodOn(DisciplinaController.class).create(dto)).withRel("create").withType("POST"));
		dto.add(linkTo(methodOn(DisciplinaController.class).update(dto)).withRel("update").withType("PUT"));
		dto.add(linkTo(methodOn(DisciplinaController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
	}
}
