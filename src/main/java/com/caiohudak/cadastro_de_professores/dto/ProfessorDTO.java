package com.caiohudak.cadastro_de_professores.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.caiohudak.cadastro_de_professores.entity.Classes;
import com.caiohudak.cadastro_de_professores.entity.Disciplina;


public class ProfessorDTO extends RepresentationModel<ProfessorDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Date birthDate;
	private List<Disciplina> disciplina;
	private List<Classes> classes;
	
	public ProfessorDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(age, birthDate, classes, disciplina, firstName, id, lastName);
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
		ProfessorDTO other = (ProfessorDTO) obj;
		return age == other.age && Objects.equals(birthDate, other.birthDate) && Objects.equals(classes, other.classes)
				&& Objects.equals(disciplina, other.disciplina) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
	}

}
