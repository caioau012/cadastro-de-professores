package com.caiohudak.cadastro_de_professores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohudak.cadastro_de_professores.entity.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, Long>{

}
