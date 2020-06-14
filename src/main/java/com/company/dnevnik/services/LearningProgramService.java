package com.company.dnevnik.services;

import com.company.dnevnik.entities.LearningProgram;

import java.util.List;

public interface LearningProgramService {

    List<LearningProgram> getAllLearningPrograms();

    LearningProgram getLearningProgramById(Long id);

    void updateLearningProgram(Long id, LearningProgram learningProgram);

    void saveLearningProgram(LearningProgram learningProgram);

    void deleteLearningProgramById(Long id);
}
