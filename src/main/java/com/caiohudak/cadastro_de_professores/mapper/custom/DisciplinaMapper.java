package com.caiohudak.cadastro_de_professores.mapper.custom;

import org.springframework.stereotype.Service;

import com.caiohudak.cadastro_de_professores.dto.DisciplinaDTO;
import com.caiohudak.cadastro_de_professores.entity.Disciplina;

@Service
public class DisciplinaMapper {
	
	public DisciplinaDTO convertEntityToDTO(Disciplina disciplina) {
		DisciplinaDTO dto = new DisciplinaDTO();
		dto.setId(disciplina.getId());
		dto.setCodigo(disciplina.getCodigo());
		dto.setTurno(disciplina.getTurno());
		dto.setUnidade(disciplina.getUnidade());
		return dto;
	}
	
	public Disciplina convertDTOtoEntity(DisciplinaDTO disciplina) {
		Disciplina entity = new Disciplina();
		entity.setId(disciplina.getId());
		entity.setCodigo(disciplina.getCodigo());
		entity.setTurno(disciplina.getTurno());
		entity.setUnidade(disciplina.getUnidade());
		return entity;
	}

}
