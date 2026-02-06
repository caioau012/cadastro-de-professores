package com.caiohudak.cadastro_de_professores.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero_sala", length = 2)
	private int numeroSala;
	
	@Column(name = "numero_alunos", length = 2)
	private int numeroAlunos;
	
	@Column(length = 10)
	private String anoDaTurma;
	
	public Classes() {
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
		return Objects.hash(anoDaTurma, id, numeroAlunos, numeroSala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classes other = (Classes) obj;
		return Objects.equals(anoDaTurma, other.anoDaTurma) && Objects.equals(id, other.id)
				&& numeroAlunos == other.numeroAlunos && numeroSala == other.numeroSala;
	}
	
}
