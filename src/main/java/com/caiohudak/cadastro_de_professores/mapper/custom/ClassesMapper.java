package com.caiohudak.cadastro_de_professores.mapper.custom;

import org.springframework.stereotype.Service;

import com.caiohudak.cadastro_de_professores.dto.ClassesDTO;
import com.caiohudak.cadastro_de_professores.entity.Classes;

@Service
public class ClassesMapper {

	public ClassesDTO convertEntityToDTO(Classes classe) {
		ClassesDTO dto = new ClassesDTO();
		dto.setId(classe.getId());
		dto.setNumeroAlunos(classe.getNumeroAlunos());
		dto.setNumeroSala(classe.getNumeroSala());
		dto.setAnoDaTurma(classe.getAnoDaTurma());
		return dto;
	}
	
	public Classes convertDTOToEntity(ClassesDTO classe) {
		Classes entity = new Classes();
		entity.setId(classe.getId());
		entity.setNumeroAlunos(classe.getNumeroAlunos());
		entity.setNumeroSala(classe.getNumeroSala());
		entity.setAnoDaTurma(classe.getAnoDaTurma());
		return entity;
	}
	
}
