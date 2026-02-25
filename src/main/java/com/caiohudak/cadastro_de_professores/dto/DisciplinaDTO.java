package com.caiohudak.cadastro_de_professores.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class DisciplinaDTO extends RepresentationModel<DisciplinaDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String unidade;
	private Character turno;
	
	public DisciplinaDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Character getTurno() {
		return turno;
	}

	public void setTurno(Character turno) {
		this.turno = turno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigo, id, turno, unidade);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinaDTO other = (DisciplinaDTO) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(id, other.id)
				&& Objects.equals(turno, other.turno) && Objects.equals(unidade, other.unidade);
	}

}
