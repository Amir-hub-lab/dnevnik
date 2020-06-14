package com.company.dnevnik.services.impl;

import com.company.dnevnik.entities.LearningProgram;
import com.company.dnevnik.repositories.LearningProgramRepository;
import com.company.dnevnik.services.LearningProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningProgramServiceImpl implements LearningProgramService{
    @Autowired
    LearningProgramRepository learningProgramRepository;

    @Override
    public List<LearningProgram> getAllLearningPrograms() {
        return learningProgramRepository.findAll();
    }

    @Override
    public LearningProgram getLearningProgramById(Long id) {
        Optional<LearningProgram> learningProgram = learningProgramRepository.findById(id);
        return learningProgram.orElse(new LearningProgram());
    }

    @Override
    public void updateLearningProgram(Long id, LearningProgram learningProgram) {

    }

    @Override
    public void saveLearningProgram(LearningProgram learningProgram) {
        learningProgramRepository.save(learningProgram);
    }

    @Override
    public void deleteLearningProgramById(Long id) {
        learningProgramRepository.deleteById(id);
    }
}
