package com.company.dnevnik.repositories;

import com.company.dnevnik.entities.LearningProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningProgramRepository extends JpaRepository<LearningProgram, Long>{
}
