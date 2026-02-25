package com.caiohudak.cadastro_de_professores.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class ClassesDTO extends RepresentationModel<ClassesDTO> implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private int numeroSala;	
	private int numeroAlunos;
	private String anoDaTurma;
	
	public ClassesDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getNumeroAlunos() {
		return numeroAlunos;
	}

	public void setNumeroAlunos(int numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}

	public String getAnoDaTurma() {
		return anoDaTurma;
	}

	public void setAnoDaTurma(String anoDaTurma) {
		this.anoDaTurma = anoDaTurma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(anoDaTurma, id, numeroAlunos, numeroSala);
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
		ClassesDTO other = (ClassesDTO) obj;
		return Objects.equals(anoDaTurma, other.anoDaTurma) && Objects.equals(id, other.id)
				&& numeroAlunos == other.numeroAlunos && numeroSala == other.numeroSala;
	}
	
}
